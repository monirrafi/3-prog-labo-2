/*--
-- Base de données : `office`
--
CREATE DATABASE IF NOT EXISTS `office` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `office`;

--
-- Structure de la table `dept`
--

 TABLE `dept` (
  `deptno` int(11) NOT NULL,
  `dname` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `loc` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  CONSTRAINT `dept_deptno_FK` PRIMARY KEY(`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;*/
