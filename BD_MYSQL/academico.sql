-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: academico
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `id` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `sigla` varchar(10) NOT NULL,
  `duracaoAnos` int NOT NULL,
  `curriculo` varchar(200) NOT NULL,
  `faculdade` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `curso_chk_1` CHECK ((`duracaoAnos` between 0 and 7))
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'Licenciatura em Engenharia Informatica','EngINFO',5,'Licenciatura em Engenharia Informatica - 2012','Faculdade de Engenharia');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disciplina` (
  `id` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `sigla` varchar(10) NOT NULL,
  `semestre` char(1) NOT NULL,
  `idCurso` tinyint unsigned NOT NULL,
  `anoCurricular` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_idCurso_3` (`idCurso`),
  CONSTRAINT `fk_idCurso_3` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`id`),
  CONSTRAINT `disciplina_chk_1` CHECK ((`anoCurricular` between 0 and 5))
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES (1,'Informatica','INFO','1',1,1),(2,'Fisica','F','1',1,1),(3,'Analise Matematica I ','AMI','1',1,1),(4,'Algebra Geometria Analitica','ALGA','1',1,1),(5,'Matematica Discreta','MDI','1',1,1),(6,'Introducao a Engenharia','IE','1',1,1),(7,'Matematica Discreta II','MD2','2',1,2),(8,'Introducao a Programacao','IP','2',1,2);
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudante`
--

DROP TABLE IF EXISTS `estudante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudante` (
  `id` int unsigned NOT NULL,
  `nome` varchar(100) NOT NULL,
  `sexo` char(1) NOT NULL,
  `morada` varchar(150) NOT NULL,
  `nomePai` varchar(100) NOT NULL,
  `nomeMae` varchar(100) NOT NULL,
  `nacionalidade` varchar(50) NOT NULL,
  `naturalidade` varchar(50) NOT NULL,
  `emailPessoal` varchar(40) NOT NULL,
  `emailInstitucional` varchar(40) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `dataNascimento` date NOT NULL,
  `idCurso` tinyint unsigned DEFAULT NULL,
  `anoIngresso` varchar(10) NOT NULL,
  `senha` varchar(12) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_idCurso` (`idCurso`),
  CONSTRAINT `fk_idCurso` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`id`),
  CONSTRAINT `estudante_chk_1` CHECK ((`id` between 0 and 99999999))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudante`
--

LOCK TABLES `estudante` WRITE;
/*!40000 ALTER TABLE `estudante` DISABLE KEYS */;
INSERT INTO `estudante` VALUES (20201122,'Alex Agostinho Massango','M','Luis Cabral','Estevao Agostingo Massango','Cacilda Amelia Cuna','Mocambicana','Cidade de Maputo','massango541@gmail.com','agostinho.massango@uem.ac.mz','844516700','1997-03-31',1,'2019','31031997'),(20202392,'Agostinho Massango','M','Luis Cabral','Estevao Agostingo Massango','Cacilda Amelia Cuna','Mocambicana','Cidade de Maputo','massango541@gmail.com','agostinho.massango@uem.ac.mz','844516700','2001-06-28',1,'2020','28062001');
/*!40000 ALTER TABLE `estudante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudante_disciplina`
--

DROP TABLE IF EXISTS `estudante_disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudante_disciplina` (
  `idEstudante` int unsigned DEFAULT NULL,
  `idDisciplina` tinyint unsigned DEFAULT NULL,
  `inscricao` int unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`inscricao`),
  KEY `fk_idEstudante_2` (`idEstudante`),
  KEY `fk_idDisciplina_2` (`idDisciplina`),
  CONSTRAINT `fk_idDisciplina_2` FOREIGN KEY (`idDisciplina`) REFERENCES `disciplina` (`id`),
  CONSTRAINT `fk_idEstudante_2` FOREIGN KEY (`idEstudante`) REFERENCES `estudante` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudante_disciplina`
--

LOCK TABLES `estudante_disciplina` WRITE;
/*!40000 ALTER TABLE `estudante_disciplina` DISABLE KEYS */;
INSERT INTO `estudante_disciplina` VALUES (20202392,1,1),(20202392,2,2),(20202392,3,3),(20202392,4,4),(20202392,5,5),(20202392,6,6),(20201122,7,7),(20201122,8,8),(20201122,3,9),(20201122,1,10),(20201122,2,11),(20201122,4,12);
/*!40000 ALTER TABLE `estudante_disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notas`
--

DROP TABLE IF EXISTS `notas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notas` (
  `idNotas` int unsigned NOT NULL,
  `t1` decimal(4,2) unsigned DEFAULT NULL,
  `t2` tinyint NOT NULL,
  PRIMARY KEY (`idNotas`),
  CONSTRAINT `notas_ibfk_1` FOREIGN KEY (`idNotas`) REFERENCES `estudante_disciplina` (`inscricao`),
  CONSTRAINT `notas_chk_1` CHECK ((`t1` between 0 and 20)),
  CONSTRAINT `notas_chk_2` CHECK ((`t2` between 0 and 20))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notas`
--

LOCK TABLES `notas` WRITE;
/*!40000 ALTER TABLE `notas` DISABLE KEYS */;
INSERT INTO `notas` VALUES (1,15.00,6),(2,12.00,16),(3,9.00,5),(4,9.00,18),(5,15.00,16),(6,11.00,13),(7,12.00,13),(8,12.00,19),(9,4.00,6),(10,20.00,5),(11,15.00,16),(12,16.00,18);
/*!40000 ALTER TABLE `notas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-25 20:51:49
