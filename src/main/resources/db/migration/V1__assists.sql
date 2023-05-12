-- abc_tech.assistances definition

CREATE TABLE `assistances` (
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `description` varchar(255) NOT NULL,
                               `name` varchar(150) NOT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO assistance (name, description) VALUES ('Troca de aparelho', 'Troca de aparelho decodificador de sinal');
INSERT INTO assistance (name, description) VALUES ('Troca de cabo interno', 'Troca de cabo interno');
INSERT INTO assistance (name, description) VALUES ('Troca de fiação interna', 'Substituição de fiação interna da residêcia');
INSERT INTO assistance (name, description) VALUES ('Manutenção em fogão', 'Reparo sem necessidade de compra de peças');
INSERT INTO assistance (name, description) VALUES ('Manutenção em geladeira', 'Reparo sem necessidade de compra de peças');
INSERT INTO assistance (name, description) VALUES ('Manutenção em maquina de lavar', 'Reparo sem necessidade de compra de peças');
INSERT INTO assistance (name, description) VALUES ('Ar-condicionado', 'Instalação/Manutenção de sistemas de energia solar');
INSERT INTO assistance (name, description) VALUES ('Segurança Elétrica','Instalação/Manutenção de sistemas de segurança elétrica');
INSERT INTO assistance (name, description) VALUES ('Troca de Correias','Troca de correias da máquina de lavar roupa');
INSERT INTO assistance (name, description) VALUES ('Troca de lampada','Substituição de lampadas queimadas');
INSERT INTO assistance (name, description) VALUES ('Manutenção em chuveiro', 'Reparo sem necessidade de compra de peças');
INSERT INTO assistance (name, description) VALUES ('Segurança Elétrica','Instalação/Manutenção de sistemas de segurança elétrica');
INSERT INTO assistance (name, description) VALUES ('Redes','Instalação/Munutenção de sistemas de redes de dados');
INSERT INTO assistance (name, description) VALUES ('Manutenção em portão', 'Reparo sem necessidade de compra de peças');
INSERT INTO assistance (name, description) VALUES ('Manutenção em micro-ondas', 'Reparo sem necessidade de compra de peças');
