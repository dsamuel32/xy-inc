CREATE DATABASE IF NOT EXISTS `xy-inc` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `xy-inc`;


CREATE TABLE IF NOT EXISTS `PONTO_INTERESSE` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `COORDENADA_X` bigint(20) NOT NULL,
  `COORDENADA_Y` bigint(20) NOT NULL,
  `NOME` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

INSERT INTO `PONTO_INTERESSE` (`id`, `COORDENADA_X`, `COORDENADA_Y`, `NOME`) VALUES
	(1, 27, 12, 'Lanchonete'),
	(2, 31, 18, 'Posto'),
	(3, 15, 12, 'Joalheria'),
	(4, 19, 21, 'Floricultura'),
	(5, 12, 8, 'Pub'),
	(6, 23, 6, 'Supermercado'),
	(7, 28, 2, 'Churrascaria');
