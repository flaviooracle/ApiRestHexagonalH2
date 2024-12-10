-- Criação da tabela tb_pessoa
CREATE TABLE IF NOT EXISTS tb_pessoa (
    pessoaId BIGINT AUTO_INCREMENT PRIMARY KEY, -- Campo ID com auto incremento
    nome VARCHAR(30) NOT NULL,                  -- Campo nome com tamanho máximo de 30 caracteres
    idade BIGINT NOT NULL,                      -- Campo idade
    cpf VARCHAR(11) NOT NULL,                   -- Campo CPF com tamanho máximo de 11 caracteres
    createAt TIMESTAMP                          -- Campo createAt para armazenar data e hora
);

-- Bloco para popular a tabela tb_pessoa
BEGIN
    DECLARE cont INT = 1;
    DECLARE registros INT;

    -- Verifica se a tabela já possui registros
    SELECT COUNT(*) INTO registros FROM tb_pessoa;

    -- Se não houver registros, insere 300.000 registros
    IF registros = 0 THEN
        WHILE cont <= 30 DO
            INSERT INTO tb_pessoa (nome, idade, cpf, createAt)
            VALUES (
                'Pessoa ' || cont,              -- Nome fictício
                MOD(cont, 100) + 1,             -- Idade fictícia (1 a 100)
                LPAD(cont, 11, '0'),            -- CPF fictício (preenchido com zeros à esquerda)
                CURRENT_TIMESTAMP               -- Data e hora atual
            );
            cont = cont + 1;
        END WHILE;
    END IF;
END;
