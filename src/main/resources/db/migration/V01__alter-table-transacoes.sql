CREATE TABLE `transacoes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `preco` decimal(19,2) DEFAULT NULL,
  `quantidade` int DEFAULT NULL,
  `ticker` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`));
