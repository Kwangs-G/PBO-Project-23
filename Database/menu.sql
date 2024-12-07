-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 07 Des 2024 pada 13.09
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

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
-- Struktur dari tabel `jajan`
--

CREATE TABLE `jajan` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `deskripsi` text NOT NULL,
  `harga` double NOT NULL,
  `gambar_path` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `jajan`
--

INSERT INTO `jajan` (`id`, `nama`, `deskripsi`, `harga`, `gambar_path`) VALUES
(1, 'Es Krim', 'Es krim dengan berbagai pilihan rasa segar.', 15000, 'Images/jajan/Jajan 1.jpg'),
(2, 'Moci', 'Moci dengan isian kacang merah dan taburan kelapa.', 20000, 'Images/jajan/Jajan 2.jpg'),
(3, 'Cookies Oreo', 'Cookies dengan campuran oreo yang renyah.', 25000, 'Images/jajan/Jajan 3.jpeg'),
(4, 'Sosis Bakar', 'Sosis bakar dengan bumbu kecap manis dan pedas.', 18000, 'Images/jajan/Jajan 4.jpg'),
(5, 'Sosis Non-Bakar', 'Sosis yang dimasak dengan cara digoreng, disajikan dengan saus sambal.', 16000, 'Images/jajan/Jajan 1.jpg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `makanan`
--

CREATE TABLE `makanan` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `deskripsi` text NOT NULL,
  `harga` double NOT NULL,
  `gambar_path` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `makanan`
--

INSERT INTO `makanan` (`id`, `nama`, `deskripsi`, `harga`, `gambar_path`) VALUES
(1, 'Nasi Goreng', 'Nasi goreng dengan bumbu rempah khas Indonesia.', 25000, 'Images/makanan/Makanan 1.jpeg'),
(2, 'Mie Ayam', 'Mie dengan potongan ayam dan saos khas.', 20000, 'Images/makanan/Makanan 2.jpeg'),
(3, 'Sate Ayam', 'Sate ayam dengan bumbu kacang.', 30000, 'Images/makanan/Makanan 3.jpeg'),
(4, 'Rendang', 'Daging sapi dimasak dengan bumbu khas Minang.', 45000, 'Images/makanan/Makanan 4.jpeg'),
(5, 'Bakso', 'Bakso sapi dengan kuah gurih.', 15000, 'Images/makanan/Makanan 1.jpeg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `minuman`
--

CREATE TABLE `minuman` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `deskripsi` text NOT NULL,
  `harga` double NOT NULL,
  `gambar_path` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `minuman`
--

INSERT INTO `minuman` (`id`, `nama`, `deskripsi`, `harga`, `gambar_path`) VALUES
(1, 'Boba Coklat', 'Minuman boba dengan coklat manis dan kenyal.', 22000, 'Images/minuman/Minuman 1.png'),
(2, 'Es Teh Lemon', 'Es teh dengan tambahan lemon segar.', 15000, 'Images/minuman/Minuman 2.jpeg'),
(3, 'Pop Ice', 'Minuman es serut dengan sirup rasa buah yang segar.', 18000, 'Images/minuman/Minuman 3.jpeg'),
(4, 'Americano', 'Kopi hitam tanpa susu yang kuat dan pekat.', 25000, 'Images/minuman/Minuman 4.jpg'),
(5, 'Jus Jeruk', 'Jus jeruk segar yang menyegarkan.', 17000, 'Images/minuman/Minuman 1.png');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `jajan`
--
ALTER TABLE `jajan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `makanan`
--
ALTER TABLE `makanan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `minuman`
--
ALTER TABLE `minuman`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `jajan`
--
ALTER TABLE `jajan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `makanan`
--
ALTER TABLE `makanan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `minuman`
--
ALTER TABLE `minuman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
