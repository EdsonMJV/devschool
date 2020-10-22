DROP TABLE IF EXISTS TB_CLIENTE;

-- CLIENTES --
CREATE TABLE TB_CLIENTE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nome VARCHAR(250) NOT NULL,
  usuario VARCHAR(50) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  saldo DECIMAL(10,2) DEFAULT 0.00,
  agencia INT DEFAULT NOT NULL,
  conta INT DEFAULT NOT NULL
);

INSERT INTO TB_CLIENTE (nome, usuario, cpf, saldo, agencia, conta) VALUES
  ('Sydney Matagal', 'symata', '60696996022', 1000000.00, 1, 123456),
  ('Daniella de Mercúrio', 'dademer', '60024193062', 1500000.00, 1, 987654),
  ('Pequeno Carlos Marrom', 'pcm', '23164303092', 2000000.00, 1, 951753);
 