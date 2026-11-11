-- Triggers de integridade entre tabelas dependentes
UPDATE usuario SET media_aprovacao = 10 WHERE media_aprovacao > 10;

-- Disciplina: sempre tem usuário; com dependentes, não muda de usuário
CREATE FUNCTION trg_fn_disciplina_dono() RETURNS TRIGGER
    LANGUAGE plpgsql AS $$
BEGIN
    IF NEW.id_usuario IS NULL THEN
        RAISE EXCEPTION 'Disciplina exige um usuário' USING ERRCODE = '23502';
END IF;
    IF TG_OP = 'UPDATE' AND NEW.id_usuario IS DISTINCT FROM OLD.id_usuario AND (
           EXISTS (SELECT 1 FROM horario   WHERE id_disciplina = OLD.id_disciplina)
        OR EXISTS (SELECT 1 FROM tarefa    WHERE id_disciplina = OLD.id_disciplina)
        OR EXISTS (SELECT 1 FROM avaliacao WHERE id_disciplina = OLD.id_disciplina)) THEN
        RAISE EXCEPTION 'Disciplina com dependentes não pode mudar de usuário' USING ERRCODE = '23514';
END IF;
RETURN NEW;
END $$;

CREATE TRIGGER trg_disciplina_dono
    BEFORE INSERT OR UPDATE OF id_usuario ON disciplina
    FOR EACH ROW EXECUTE FUNCTION trg_fn_disciplina_dono();

-- Horário, tarefa e avaliação: sempre têm disciplina; não mudam para disciplina de outro usuário
CREATE FUNCTION trg_fn_dependente_disciplina() RETURNS TRIGGER
    LANGUAGE plpgsql AS $$
BEGIN
    IF NEW.id_disciplina IS NULL THEN
        RAISE EXCEPTION '% exige uma disciplina', TG_TABLE_NAME USING ERRCODE = '23502';
END IF;
    IF TG_OP = 'UPDATE' AND NEW.id_disciplina IS DISTINCT FROM OLD.id_disciplina AND EXISTS (
           SELECT 1 FROM disciplina n, disciplina o
            WHERE n.id_disciplina = NEW.id_disciplina
              AND o.id_disciplina = OLD.id_disciplina
              AND n.id_usuario IS DISTINCT FROM o.id_usuario) THEN
        RAISE EXCEPTION '% não pode ir para disciplina de outro usuário', TG_TABLE_NAME
            USING ERRCODE = '23514';
END IF;
RETURN NEW;
END $$;

CREATE TRIGGER trg_horario_disciplina
    BEFORE INSERT OR UPDATE OF id_disciplina ON horario
    FOR EACH ROW EXECUTE FUNCTION trg_fn_dependente_disciplina();

CREATE TRIGGER trg_tarefa_disciplina
    BEFORE INSERT OR UPDATE OF id_disciplina ON tarefa
    FOR EACH ROW EXECUTE FUNCTION trg_fn_dependente_disciplina();

CREATE TRIGGER trg_avaliacao_disciplina
    BEFORE INSERT OR UPDATE OF id_disciplina ON avaliacao
    FOR EACH ROW EXECUTE FUNCTION trg_fn_dependente_disciplina();

-- Usuário e curso: um curso pertence a um único usuário
CREATE FUNCTION trg_fn_usuario_curso() RETURNS TRIGGER
    LANGUAGE plpgsql AS $$
BEGIN
    IF NEW.id_curso IS NOT NULL AND EXISTS (
           SELECT 1 FROM usuario
            WHERE id_curso = NEW.id_curso AND id_usuario <> NEW.id_usuario) THEN
        RAISE EXCEPTION 'Este curso já pertence a outro usuário' USING ERRCODE = '23505';
END IF;
RETURN NEW;
END $$;

CREATE TRIGGER trg_usuario_curso
    BEFORE INSERT OR UPDATE OF id_curso ON usuario
    FOR EACH ROW EXECUTE FUNCTION trg_fn_usuario_curso();

-- Código de verificação: não muda de usuário
CREATE FUNCTION trg_fn_codigo_usuario() RETURNS TRIGGER
    LANGUAGE plpgsql AS $$
BEGIN
    IF NEW.id_usuario IS DISTINCT FROM OLD.id_usuario THEN
        RAISE EXCEPTION 'Código de verificação não pode mudar de usuário' USING ERRCODE = '23514';
END IF;
RETURN NEW;
END $$;

CREATE TRIGGER trg_codigo_usuario
    BEFORE UPDATE OF id_usuario ON codigo_verificacao
    FOR EACH ROW EXECUTE FUNCTION trg_fn_codigo_usuario();
