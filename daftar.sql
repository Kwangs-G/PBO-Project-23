-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 07, 2024 at 01:57 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `menu`
--

-- --------------------------------------------------------

--
-- Table structure for table `daftar`
--

CREATE TABLE `daftar` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `harga` int(15) DEFAULT NULL,
  `bahan` varchar(255) DEFAULT NULL,
  `pathGambar` varchar(255) DEFAULT NULL,
  `kategori` enum('Makanan','Minuman','Jajan') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `daftar`
--

INSERT INTO `daftar` (`id`, `nama`, `harga`, `bahan`, `pathGambar`, `kategori`) VALUES
(1, 'Nasi Goreng', 20000, 'Nasi, Daging, Bumbu', 'Images/makanan/Makanan1.jpeg', 'Makanan'),
(2, 'Nasi Goreng Spesial', 25000, 'Nasi, Daging, Bumbu, Telur', 'Images/makanan/Makanan2.jpeg', 'Makanan'),
(3, 'Ayam Goreng', 15000, 'Ayam Goreng, Nasi, Sayur', 'Images/makanan/Makanan3.jpeg', 'Makanan'),
(4, 'Pizza', 45000, 'Tepung, Saus Tomat, Keju', 'Images/makanan/Makanan4.jpeg', 'Makanan'),
(5, 'Kopi Latte', 10000, 'Air, Bubuk kopi, bobba', 'Images/minuman/Minuman1.png', 'Minuman'),
(6, 'Es Teh', 5000, 'Es, Teh', 'Images/minuman/Minuman2.jpeg', 'Minuman'),
(7, 'Pop Ice', 6000, 'Air, Bubuk Pop Ice', 'Images/minuman/Minuman3.jpeg', 'Minuman'),
(8, 'Kopi', 8000, 'Air, Bubuk kopi, Susu', 'Images/minuman/Minuman4.jpg', 'Minuman'),
(9, 'Es Krim', 6000, 'Susu, Krim, Sirup', 'Images/jajan/Jajan1.jpg', 'Jajan'),
(10, 'Mochi', 4000, 'Adonan Mochi, Selai', 'Images/jajan/Jajan2.jpg', 'Jajan'),
(11, 'Oreo', 3000, 'Cookies, Krim', 'Images/jajan/Jajan3.jpeg', 'Jajan'),
(12, 'Sosis Bakar', 12000, 'Sosis, Saus BBQ', 'Images/jajan/Jajan4.jpg', 'Jajan');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `daftar`
--
ALTER TABLE `daftar`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `daftar`
--
ALTER TABLE `daftar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
