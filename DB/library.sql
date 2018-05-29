-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: May 29, 2018 at 09:01 PM
-- Server version: 10.2.14-MariaDB
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

DROP TABLE IF EXISTS `buku`;
CREATE TABLE IF NOT EXISTS `buku` (
  `id_buku` int(11) NOT NULL AUTO_INCREMENT,
  `judul_buku` varchar(255) NOT NULL,
  `id_kategori` int(11) NOT NULL,
  `id_penerbit` int(11) NOT NULL,
  `id_pengarang` int(11) NOT NULL,
  `tahun_terbit` date NOT NULL,
  `create_at` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id_buku`),
  KEY `id_kategori` (`id_kategori`),
  KEY `id_penerbit` (`id_penerbit`),
  KEY `id_pengarang` (`id_pengarang`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id_buku`, `judul_buku`, `id_kategori`, `id_penerbit`, `id_pengarang`, `tahun_terbit`, `create_at`) VALUES
(1, 'Be A Great Leader', 2, 1, 1, '2016-02-21', '2018-05-29 12:09:19'),
(2, 'Tanah Tabu', 1, 2, 2, '2009-01-01', '2018-05-29 10:12:15');

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

DROP TABLE IF EXISTS `kategori`;
CREATE TABLE IF NOT EXISTS `kategori` (
  `id_kategori` int(11) NOT NULL AUTO_INCREMENT,
  `nama_kategori` varchar(255) NOT NULL,
  PRIMARY KEY (`id_kategori`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`) VALUES
(1, 'Novel'),
(2, 'Motivate');

-- --------------------------------------------------------

--
-- Table structure for table `penerbit`
--

DROP TABLE IF EXISTS `penerbit`;
CREATE TABLE IF NOT EXISTS `penerbit` (
  `id_penerbit` int(11) NOT NULL AUTO_INCREMENT,
  `nama_penerbit` varchar(255) NOT NULL,
  `alama_penerbit` text NOT NULL,
  `tlp_penerbit` varchar(15) NOT NULL,
  `Create_at` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id_penerbit`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penerbit`
--

INSERT INTO `penerbit` (`id_penerbit`, `nama_penerbit`, `alama_penerbit`, `tlp_penerbit`, `Create_at`) VALUES
(1, ' PT. Elex Media Komputindo', ' Jl. Palmerah Selatan 22, Jakarta 10270', '0215483008', '2018-05-29 15:31:24'),
(2, 'PT Gramedia Pustaka Utama', 'Jl. Sudarsancakra 197 Maguwoharjo, Yogyakarta', '0274-885030', '2018-05-29 09:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `pengarang`
--

DROP TABLE IF EXISTS `pengarang`;
CREATE TABLE IF NOT EXISTS `pengarang` (
  `id_pengarang` int(11) NOT NULL AUTO_INCREMENT,
  `nama_pengarang` varchar(255) NOT NULL,
  PRIMARY KEY (`id_pengarang`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengarang`
--

INSERT INTO `pengarang` (`id_pengarang`, `nama_pengarang`) VALUES
(1, 'Erwin Tenggono'),
(2, 'Anindita Siswanto Thayf');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `username`, `password`) VALUES
(1, 'devry', '4f54ade971b54bc1009b9ce7a13211e8');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `buku`
--
ALTER TABLE `buku`
  ADD CONSTRAINT `buku_ibfk_1` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`),
  ADD CONSTRAINT `buku_ibfk_2` FOREIGN KEY (`id_penerbit`) REFERENCES `penerbit` (`id_penerbit`),
  ADD CONSTRAINT `buku_ibfk_3` FOREIGN KEY (`id_pengarang`) REFERENCES `pengarang` (`id_pengarang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
