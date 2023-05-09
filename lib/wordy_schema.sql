-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 06, 2023 at 01:16 AM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wordy_schema`
--

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
CREATE TABLE IF NOT EXISTS `game` (
  `gameID` int NOT NULL,
  `gameWinner` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`gameID`)
) ENGINE=InnoDB;

-- --------------------------------------------------------

--
-- Table structure for table `round`
--

DROP TABLE IF EXISTS `round`;
CREATE TABLE IF NOT EXISTS `round` (
  `gameID` int NOT NULL,
  `roundNum` int NOT NULL,
  `roundWin` varchar(45) DEFAULT NULL,
  `longestWord` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`gameID`)
) ENGINE=InnoDB;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `isOnline` bit(1) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=6;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `username`, `password`, `isOnline`) VALUES
(1, 'admin', 'pass', b'0'),
(2, 'zeph', 'zeph', b'1'),
(3, 'darren', 'darren', b'0'),
(4, 'david', 'joshua', b'0'),
(5, 'ariel', '12345', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `word`
--

DROP TABLE IF EXISTS `word`;
CREATE TABLE IF NOT EXISTS `word` (
  `gameID` int NOT NULL,
  `roundNum` int NOT NULL,
  `userID` int NOT NULL,
  `words` varchar(45) DEFAULT NULL
) ENGINE=InnoDB;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
