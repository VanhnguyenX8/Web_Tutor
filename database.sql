-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.27-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for web_gia_su
CREATE DATABASE IF NOT EXISTS `web_gia_su` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `web_gia_su`;

-- Dumping structure for table web_gia_su.accout
CREATE TABLE IF NOT EXISTS `accout` (
  `username` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `POSITION` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Data exporting was unselected.

-- Dumping structure for table web_gia_su.dangki
CREATE TABLE IF NOT EXISTS `dangki` (
  `idDK` varchar(20) NOT NULL,
  `thoigian` date DEFAULT NULL,
  `trangthai` varchar(50) DEFAULT NULL,
  `mota` varchar(255) DEFAULT NULL,
  `idLH` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idDK`),
  KEY `idLH` (`idLH`),
  CONSTRAINT `dangki_ibfk_1` FOREIGN KEY (`idLH`) REFERENCES `lophoc` (`idLH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Data exporting was unselected.

-- Dumping structure for table web_gia_su.giasu
CREATE TABLE IF NOT EXISTS `giasu` (
  `idGS` varchar(20) NOT NULL,
  `tenGS` varchar(100) DEFAULT NULL,
  `gioitinh` varchar(10) DEFAULT NULL,
  `diachi` varchar(255) DEFAULT NULL,
  `sdt` varchar(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `stk` varchar(30) DEFAULT NULL,
  `idMH` varchar(20) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idGS`),
  KEY `idMH` (`idMH`),
  KEY `username` (`username`),
  CONSTRAINT `giasu_ibfk_1` FOREIGN KEY (`idMH`) REFERENCES `monhoc` (`idMH`),
  CONSTRAINT `giasu_ibfk_2` FOREIGN KEY (`username`) REFERENCES `accout` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Data exporting was unselected.

-- Dumping structure for table web_gia_su.hocsinh
CREATE TABLE IF NOT EXISTS `hocsinh` (
  `idHS` varchar(20) NOT NULL,
  `tenHS` varchar(100) DEFAULT NULL,
  `gioitinh` varchar(10) DEFAULT NULL,
  `diachi` varchar(255) DEFAULT NULL,
  `sdt` varchar(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `stk` varchar(30) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idHS`),
  KEY `username` (`username`),
  CONSTRAINT `hocsinh_ibfk_1` FOREIGN KEY (`username`) REFERENCES `accout` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Data exporting was unselected.

-- Dumping structure for table web_gia_su.lophoc
CREATE TABLE IF NOT EXISTS `lophoc` (
  `idLH` varchar(20) NOT NULL,
  `tenLH` varchar(50) DEFAULT NULL,
  `lichhoc` datetime DEFAULT NULL,
  `hocphi` float DEFAULT NULL,
  `mota` varchar(255) DEFAULT NULL,
  `idGS` varchar(20) DEFAULT NULL,
  `idHS` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idLH`),
  KEY `idGS` (`idGS`),
  KEY `idHS` (`idHS`),
  CONSTRAINT `lophoc_ibfk_1` FOREIGN KEY (`idGS`) REFERENCES `giasu` (`idGS`),
  CONSTRAINT `lophoc_ibfk_2` FOREIGN KEY (`idHS`) REFERENCES `hocsinh` (`idHS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Data exporting was unselected.

-- Dumping structure for table web_gia_su.monhoc
CREATE TABLE IF NOT EXISTS `monhoc` (
  `idMH` varchar(20) NOT NULL,
  `tenMH` varchar(100) DEFAULT NULL,
  `mota` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idMH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Data exporting was unselected.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
