-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2024 at 02:05 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eftappdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `activity`
--

CREATE TABLE `activity` (
  `activity_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `sub_category_id` int(11) NOT NULL,
  `specific_cat_id` int(11) NOT NULL,
  `calculation_metric` float NOT NULL,
  `emission_total` float NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime DEFAULT NULL
);

--
-- Dumping data for table `activity`
--

INSERT INTO `activity` (`activity_id`, `category_id`, `sub_category_id`, `specific_cat_id`, `calculation_metric`, `emission_total`, `date_created`, `date_updated`) VALUES
(1, 1, 1, 1, 100, 16.388, '2024-05-09', NULL),
(2, 2, 5, 13, 100, 16.388, '2024-05-09', NULL),
(3, 2, 5, 13, 101, 16.388, '2024-05-09', NULL),
(4, 1, 2, 3, 1000, 9.29, '2024-05-09', NULL),
(5, 1, 2, 3, 1000, 9.29, '2024-05-09', NULL),
(6, 1, 2, 3, 1000, 9.29, '2024-05-09', NULL),
(7, 1, 4, 10, 200, 0, '2024-05-09', NULL),
(8, 1, 4, 10, 200, 0, '2024-05-09', NULL),
(9, 1, 1, 2, 440, 74.6988, '2024-05-09', NULL),
(10, 1, 1, 2, 440, 74.6988, '2024-05-09', NULL),
(11, 1, 3, 8, 20, 4.4374, '2024-05-09', NULL),
(12, 2, 6, 14, 10, 0, '2024-05-09', NULL),
(13, 1, 1, 3, 10, 0, '2024-05-09', NULL),
(14, 1, 3, 1, 30, 0, '2024-05-09', NULL),
(15, 1, 1, 4, 20, 2.3794, '2024-05-09', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(50) NOT NULL
);

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_id`, `category_name`) VALUES
(1, 'Transportation'),
(2, 'Home-energy');

--
-- Table structure for table `specific_category`
--

CREATE TABLE `specific_category` (
  `specific_cat_id` int(11) NOT NULL,
  `sub_category_id` int(11) DEFAULT NULL,
  `specific_cat_name` varchar(50) NOT NULL
);

--
-- Dumping data for table `specific_category`
--

INSERT INTO `specific_category` (`specific_cat_id`, `sub_category_id`, `specific_cat_name`) VALUES
(1, 1, 'Gasoline'),
(2, 1, 'Diesel'),
(3, 1, 'Electric'),
(4, 1, 'Hybrid'),
(5, 2, 'Gasoline'),
(6, 2, 'Electric'),
(7, 3, 'Bus'),
(8, 3, 'Train'),
(9, 4, 'Cycling'),
(10, 4, 'Walking'),
(11, 5, 'LPG Powered Stove (Low temperature)'),
(12, 5, 'LPG Powered Stove (Medium temperature)'),
(13, 5, 'LPG Powered Stove (High temperature)'),
(14, 5, 'Diesel powered generator set'),
(15, 6, 'Solar Panel');

-- --------------------------------------------------------

--
-- Table structure for table `sub_category`
--

CREATE TABLE `sub_category` (
  `sub_category_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `sub_category_name` varchar(50) NOT NULL
);

--
-- Dumping data for table `sub_category`
--

INSERT INTO `sub_category` (`sub_category_id`, `category_id`, `sub_category_name`) VALUES
(1, 1, 'Car'),
(2, 1, 'Motorcycle'),
(3, 1, 'Public Transportation'),
(4, 1, 'Non-emission'),
(5, 2, 'Natural Gas and Propane consumption'),
(6, 2, 'Renewable Energy');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `activity`
--
ALTER TABLE `activity`
  ADD PRIMARY KEY (`activity_id`),
  ADD KEY `category_id` (`category_id`),
  ADD KEY `sub_category_id` (`sub_category_id`),
  ADD KEY `specific_cat_id` (`specific_cat_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `specific_category`
--
ALTER TABLE `specific_category`
  ADD PRIMARY KEY (`specific_cat_id`),
  ADD KEY `sub_category_id` (`sub_category_id`);

--
-- Indexes for table `sub_category`
--
ALTER TABLE `sub_category`
  ADD PRIMARY KEY (`sub_category_id`),
  ADD KEY `category_id` (`category_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `activity`
--
ALTER TABLE `activity`
  MODIFY `activity_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `activity`
--
ALTER TABLE `activity`
  ADD CONSTRAINT `activity_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  ADD CONSTRAINT `activity_ibfk_2` FOREIGN KEY (`sub_category_id`) REFERENCES `sub_category` (`sub_category_id`),
  ADD CONSTRAINT `activity_ibfk_3` FOREIGN KEY (`specific_cat_id`) REFERENCES `specific_category` (`specific_cat_id`);

--
-- Constraints for table `specific_category`
--
ALTER TABLE `specific_category`
  ADD CONSTRAINT `specific_category_ibfk_1` FOREIGN KEY (`sub_category_id`) REFERENCES `sub_category` (`sub_category_id`);

--
-- Constraints for table `sub_category`
--
ALTER TABLE `sub_category`
  ADD CONSTRAINT `sub_category_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
