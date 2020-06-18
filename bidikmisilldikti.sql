-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 18 Jun 2020 pada 08.07
-- Versi server: 10.4.8-MariaDB
-- Versi PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bidikmisilldikti`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `bidikmisi`
--

CREATE TABLE `bidikmisi` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `nim` varchar(30) NOT NULL,
  `angkatan` varchar(30) NOT NULL,
  `jenjang` varchar(20) NOT NULL,
  `fakultas` varchar(100) NOT NULL,
  `tempatlahir` varchar(200) NOT NULL,
  `totalipk` varchar(20) NOT NULL,
  `semestertempuh` varchar(20) NOT NULL,
  `gender` int(1) NOT NULL,
  `statusbidikmisi` int(11) NOT NULL,
  `tahunmundur` int(30) NOT NULL,
  `alasanmundur` varchar(300) NOT NULL,
  `statusdana` int(30) NOT NULL,
  `jumlahdana` varchar(300) NOT NULL,
  `universitas` int(11) NOT NULL,
  `semester1` varchar(20) NOT NULL,
  `semester2` varchar(20) NOT NULL,
  `semester3` varchar(100) NOT NULL,
  `semester4` varchar(10) NOT NULL,
  `semester5` varchar(10) NOT NULL,
  `semester6` varchar(10) NOT NULL,
  `semester7` varchar(10) NOT NULL,
  `semester8` varchar(10) NOT NULL,
  `jumlahprestasi` varchar(10) NOT NULL,
  `namaprestasi` varchar(300) NOT NULL,
  `juaraprestasi` varchar(300) NOT NULL,
  `bidangprestasi` varchar(300) NOT NULL,
  `tingkatprestasi` varchar(300) NOT NULL,
  `jumlahorganisasi` varchar(20) NOT NULL,
  `namaorganisasi` varchar(300) NOT NULL,
  `jabatanorganisasi` varchar(300) NOT NULL,
  `statusorganisasi` varchar(300) NOT NULL,
  `periodeorganisasi` varchar(300) NOT NULL,
  `birth` date DEFAULT NULL,
  `picture` varchar(100) NOT NULL DEFAULT '''http://192.168.2.188/bidikmisilldikti/mhs_picture/mhs_logo.png''',
  `love` enum('true','false') NOT NULL DEFAULT 'false'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `bidikmisi`
--

INSERT INTO `bidikmisi` (`id`, `name`, `nim`, `angkatan`, `jenjang`, `fakultas`, `tempatlahir`, `totalipk`, `semestertempuh`, `gender`, `statusbidikmisi`, `tahunmundur`, `alasanmundur`, `statusdana`, `jumlahdana`, `universitas`, `semester1`, `semester2`, `semester3`, `semester4`, `semester5`, `semester6`, `semester7`, `semester8`, `jumlahprestasi`, `namaprestasi`, `juaraprestasi`, `bidangprestasi`, `tingkatprestasi`, `jumlahorganisasi`, `namaorganisasi`, `jabatanorganisasi`, `statusorganisasi`, `periodeorganisasi`, `birth`, `picture`, `love`) VALUES
(2673, 'bagas', 'a', '2019', 's1', 'TI', 'sem', '2', '7', 1, 1, 0, '', 1, '1', 4, '4', '2', '', '', '', '', '', '', '2', '2', '', '', '', '', '', '', '', '', NULL, '\'http://192.168.2.188/bidikmisilldikti/mhs_picture/mhs_logo.png\'', 'false'),
(2674, 'dany', 'a', '20', 's1', 'ti', 'semarang', '2', '8', 1, 1, 2019, '', 1, '', 5, '3', '2', '2', '2', '2', '2', '', '', '2', '', '', '', '', '', '', '', '', '', NULL, '\'http://192.168.2.188/bidikmisilldikti/mhs_picture/mhs_logo.png\'', 'false');

-- --------------------------------------------------------

--
-- Struktur dari tabel `loginadmin`
--

CREATE TABLE `loginadmin` (
  `iduser` int(11) NOT NULL,
  `kampus` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `username` varchar(150) CHARACTER SET latin1 NOT NULL,
  `password` varchar(150) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data untuk tabel `loginadmin`
--

INSERT INTO `loginadmin` (`iduser`, `kampus`, `username`, `password`) VALUES
(4, 'admin', 'admin', 'admin'),
(5, 'unika', 'unika', 'unika');

-- --------------------------------------------------------

--
-- Struktur dari tabel `loginivet`
--

CREATE TABLE `loginivet` (
  `iduser` int(11) NOT NULL,
  `kampus` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `username` varchar(150) CHARACTER SET latin1 NOT NULL,
  `password` varchar(150) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data untuk tabel `loginivet`
--

INSERT INTO `loginivet` (`iduser`, `kampus`, `username`, `password`) VALUES
(4, 'ivet', 'ivet', 'ivet');

-- --------------------------------------------------------

--
-- Struktur dari tabel `logins`
--

CREATE TABLE `logins` (
  `iduser` int(11) NOT NULL,
  `kampus` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `username` varchar(150) CHARACTER SET latin1 NOT NULL,
  `password` varchar(150) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data untuk tabel `logins`
--

INSERT INTO `logins` (`iduser`, `kampus`, `username`, `password`) VALUES
(3, 'udinus', 'bagas', 'bagas');

-- --------------------------------------------------------

--
-- Struktur dari tabel `loginudinus`
--

CREATE TABLE `loginudinus` (
  `iduser` int(11) NOT NULL,
  `kampus` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `username` varchar(150) CHARACTER SET latin1 NOT NULL,
  `password` varchar(150) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data untuk tabel `loginudinus`
--

INSERT INTO `loginudinus` (`iduser`, `kampus`, `username`, `password`) VALUES
(4, 'udinus', 'udinus', 'udinus');

-- --------------------------------------------------------

--
-- Struktur dari tabel `loginunika`
--

CREATE TABLE `loginunika` (
  `iduser` int(11) NOT NULL,
  `kampus` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `username` varchar(150) CHARACTER SET latin1 NOT NULL,
  `password` varchar(150) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data untuk tabel `loginunika`
--

INSERT INTO `loginunika` (`iduser`, `kampus`, `username`, `password`) VALUES
(4, 'Unika', 'unika', 'unika');

-- --------------------------------------------------------

--
-- Struktur dari tabel `loginunimus`
--

CREATE TABLE `loginunimus` (
  `iduser` int(11) NOT NULL,
  `kampus` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `username` varchar(150) CHARACTER SET latin1 NOT NULL,
  `password` varchar(150) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data untuk tabel `loginunimus`
--

INSERT INTO `loginunimus` (`iduser`, `kampus`, `username`, `password`) VALUES
(4, 'unimus', 'unimus', 'unimus');

-- --------------------------------------------------------

--
-- Struktur dari tabel `loginunisbank`
--

CREATE TABLE `loginunisbank` (
  `iduser` int(11) NOT NULL,
  `kampus` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `username` varchar(150) CHARACTER SET latin1 NOT NULL,
  `password` varchar(150) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data untuk tabel `loginunisbank`
--

INSERT INTO `loginunisbank` (`iduser`, `kampus`, `username`, `password`) VALUES
(4, 'unisbank', 'unisbank', 'unisbank');

-- --------------------------------------------------------

--
-- Struktur dari tabel `loginunissula`
--

CREATE TABLE `loginunissula` (
  `iduser` int(11) NOT NULL,
  `kampus` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `username` varchar(150) CHARACTER SET latin1 NOT NULL,
  `password` varchar(150) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data untuk tabel `loginunissula`
--

INSERT INTO `loginunissula` (`iduser`, `kampus`, `username`, `password`) VALUES
(4, 'unissula', 'unissula', 'unissula');

-- --------------------------------------------------------

--
-- Struktur dari tabel `loginuntag`
--

CREATE TABLE `loginuntag` (
  `iduser` int(11) NOT NULL,
  `kampus` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `username` varchar(150) CHARACTER SET latin1 NOT NULL,
  `password` varchar(150) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data untuk tabel `loginuntag`
--

INSERT INTO `loginuntag` (`iduser`, `kampus`, `username`, `password`) VALUES
(4, 'Untag', 'untag', 'untag');

-- --------------------------------------------------------

--
-- Struktur dari tabel `loginunwahas`
--

CREATE TABLE `loginunwahas` (
  `iduser` int(11) NOT NULL,
  `kampus` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `username` varchar(150) CHARACTER SET latin1 NOT NULL,
  `password` varchar(150) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data untuk tabel `loginunwahas`
--

INSERT INTO `loginunwahas` (`iduser`, `kampus`, `username`, `password`) VALUES
(4, 'unwahas', 'unwahas', 'unwahas');

-- --------------------------------------------------------

--
-- Struktur dari tabel `loginupgris`
--

CREATE TABLE `loginupgris` (
  `iduser` int(11) NOT NULL,
  `kampus` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `username` varchar(150) CHARACTER SET latin1 NOT NULL,
  `password` varchar(150) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data untuk tabel `loginupgris`
--

INSERT INTO `loginupgris` (`iduser`, `kampus`, `username`, `password`) VALUES
(5, 'upgris', 'upgris', 'upgris');

-- --------------------------------------------------------

--
-- Struktur dari tabel `loginusm`
--

CREATE TABLE `loginusm` (
  `iduser` int(11) NOT NULL,
  `kampus` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `username` varchar(150) CHARACTER SET latin1 NOT NULL,
  `password` varchar(150) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data untuk tabel `loginusm`
--

INSERT INTO `loginusm` (`iduser`, `kampus`, `username`, `password`) VALUES
(4, 'usm', 'usm', 'usm');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pets`
--

CREATE TABLE `pets` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `totalipk` varchar(20) NOT NULL,
  `semestertempuh` varchar(20) NOT NULL,
  `gender` int(1) NOT NULL,
  `statusbidikmisi` int(11) NOT NULL,
  `semester1` varchar(20) NOT NULL,
  `semester2` varchar(20) NOT NULL,
  `semester3` varchar(20) NOT NULL,
  `semester4` varchar(20) NOT NULL,
  `semester5` varchar(20) NOT NULL,
  `semester6` varchar(20) NOT NULL,
  `semester7` varchar(20) NOT NULL,
  `semester8` varchar(20) NOT NULL,
  `birth` date DEFAULT NULL,
  `picture` varchar(100) NOT NULL DEFAULT '''http://192.168.1.103/demo_pets/pets_picture/pet_logo.png''',
  `love` enum('true','false') NOT NULL DEFAULT 'false'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pets`
--

INSERT INTO `pets` (`id`, `name`, `totalipk`, `semestertempuh`, `gender`, `statusbidikmisi`, `semester1`, `semester2`, `semester3`, `semester4`, `semester5`, `semester6`, `semester7`, `semester8`, `birth`, `picture`, `love`) VALUES
(15, 'bagas', '3.6', '3.4', 1, 2, '4', '3', '', '', '', '', '', '', '2020-01-15', '\'http://192.168.1.103/demo_pets/pets_picture/pet_logo.png\'', 'false'),
(16, 'Bag', '3.8', '7', 2, 2, '7', '3', '', '', '', '', '', '', '2020-01-02', '\'http://192.168.1.103/demo_pets/pets_picture/pet_logo.png\'', 'true'),
(19, 'Yu', '3.7', '7', 2, 1, '3.6', '3.6', '', '', '', '', '', '', '2020-01-04', '\'http://192.168.1.103/demo_pets/pets_picture/pet_logo.png\'', 'false'),
(20, 'Bag', '3.8', '8', 0, 0, '2.6', '2.8', '2.9', '3', '3', '3', '4', '3', '2020-01-04', '/bidikmisilldikti/mhs_picture/20.jpeg', 'false');

-- --------------------------------------------------------

--
-- Struktur dari tabel `unikaa`
--

CREATE TABLE `unikaa` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `nim` varchar(100) NOT NULL,
  `tempatlahir` varchar(100) NOT NULL,
  `angkatan` varchar(100) NOT NULL,
  `fakultas` varchar(100) NOT NULL,
  `jenjang` varchar(100) NOT NULL,
  `totalipk` varchar(20) NOT NULL,
  `semestertempuh` varchar(20) NOT NULL,
  `gender` int(1) NOT NULL,
  `statusbidikmisi` int(11) NOT NULL,
  `semester1` varchar(20) NOT NULL,
  `semester2` varchar(20) NOT NULL,
  `semester3` varchar(100) NOT NULL,
  `semester4` varchar(10) NOT NULL,
  `semester5` varchar(10) NOT NULL,
  `semester6` varchar(10) NOT NULL,
  `semester7` varchar(10) NOT NULL,
  `semester8` varchar(10) NOT NULL,
  `birth` date DEFAULT NULL,
  `dana` int(3) NOT NULL,
  `jumlahdana` varchar(30) NOT NULL,
  `jumlahprestasi` varchar(10) NOT NULL,
  `picture` varchar(100) NOT NULL DEFAULT '''http://192.168.1.103/demo_pets/pets_picture/pet_logo.png''',
  `love` enum('true','false') NOT NULL DEFAULT 'false'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `usm`
--

CREATE TABLE `usm` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `species` varchar(20) NOT NULL,
  `breed` varchar(20) NOT NULL,
  `gender` int(1) NOT NULL,
  `kategoriipk` int(1) NOT NULL,
  `semester1` varchar(20) NOT NULL,
  `semester2` varchar(20) NOT NULL,
  `birth` date DEFAULT NULL,
  `picture` varchar(100) NOT NULL DEFAULT '''http://192.168.1.103/demo_pets/pets_picture/pet_logo.png''',
  `love` enum('true','false') NOT NULL DEFAULT 'false'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `usm`
--

INSERT INTO `usm` (`id`, `name`, `species`, `breed`, `gender`, `kategoriipk`, `semester1`, `semester2`, `birth`, `picture`, `love`) VALUES
(31, 'Yu', '3.8', '5', 2, 1, '', '', '2020-01-15', '/demo_pets/pets_picture/31.jpeg', 'false'),
(32, 'Hilih', '3.8', '7', 2, 2, '', '', '2020-01-21', '/demo_pets/pets_picture/32.jpeg', 'false'),
(36, 'Bagas', '2', '7', 2, 2, '3.7', '3.8', '2020-01-10', '/demo_pets/pets_picture/36.jpeg', 'false'),
(37, 'Bagasdany', '2.9', '6', 2, 1, '3.9', '3.7', '2020-01-01', '/demo_pets/pets_picture/37.jpeg', 'false'),
(39, 'Bagashwjsj', '2.6', '6', 2, 2, '3.8', '3.5', '2020-01-01', '/demo_pets/pets_picture/39.jpeg', 'false'),
(40, 'Bagasyu', '3.6', '7', 2, 2, '3.7', '3.5', '2020-01-30', '/demo_pets/pets_picture/40.jpeg', 'false'),
(41, 'Kangen', '3.6', '7', 1, 1, '3.5', '3.7', '2020-01-01', '/demo_pets/pets_picture/41.jpeg', 'false'),
(42, 'Ya', '4', '7', 2, 2, '4', '4', '2020-01-02', '/demo_pets/pets_picture/42.jpeg', 'false');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `bidikmisi`
--
ALTER TABLE `bidikmisi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `universitas` (`universitas`);

--
-- Indeks untuk tabel `loginadmin`
--
ALTER TABLE `loginadmin`
  ADD PRIMARY KEY (`iduser`);

--
-- Indeks untuk tabel `loginivet`
--
ALTER TABLE `loginivet`
  ADD PRIMARY KEY (`iduser`);

--
-- Indeks untuk tabel `logins`
--
ALTER TABLE `logins`
  ADD PRIMARY KEY (`iduser`);

--
-- Indeks untuk tabel `loginudinus`
--
ALTER TABLE `loginudinus`
  ADD PRIMARY KEY (`iduser`);

--
-- Indeks untuk tabel `loginunika`
--
ALTER TABLE `loginunika`
  ADD PRIMARY KEY (`iduser`);

--
-- Indeks untuk tabel `loginunimus`
--
ALTER TABLE `loginunimus`
  ADD PRIMARY KEY (`iduser`);

--
-- Indeks untuk tabel `loginunisbank`
--
ALTER TABLE `loginunisbank`
  ADD PRIMARY KEY (`iduser`);

--
-- Indeks untuk tabel `loginunissula`
--
ALTER TABLE `loginunissula`
  ADD PRIMARY KEY (`iduser`);

--
-- Indeks untuk tabel `loginuntag`
--
ALTER TABLE `loginuntag`
  ADD PRIMARY KEY (`iduser`);

--
-- Indeks untuk tabel `loginunwahas`
--
ALTER TABLE `loginunwahas`
  ADD PRIMARY KEY (`iduser`);

--
-- Indeks untuk tabel `loginupgris`
--
ALTER TABLE `loginupgris`
  ADD PRIMARY KEY (`iduser`);

--
-- Indeks untuk tabel `loginusm`
--
ALTER TABLE `loginusm`
  ADD PRIMARY KEY (`iduser`);

--
-- Indeks untuk tabel `pets`
--
ALTER TABLE `pets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kategoriip` (`statusbidikmisi`);

--
-- Indeks untuk tabel `unikaa`
--
ALTER TABLE `unikaa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kategoriip` (`statusbidikmisi`);

--
-- Indeks untuk tabel `usm`
--
ALTER TABLE `usm`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `bidikmisi`
--
ALTER TABLE `bidikmisi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2675;

--
-- AUTO_INCREMENT untuk tabel `loginadmin`
--
ALTER TABLE `loginadmin`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `loginivet`
--
ALTER TABLE `loginivet`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `logins`
--
ALTER TABLE `logins`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `loginudinus`
--
ALTER TABLE `loginudinus`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `loginunika`
--
ALTER TABLE `loginunika`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `loginunimus`
--
ALTER TABLE `loginunimus`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `loginunisbank`
--
ALTER TABLE `loginunisbank`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `loginunissula`
--
ALTER TABLE `loginunissula`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `loginuntag`
--
ALTER TABLE `loginuntag`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `loginunwahas`
--
ALTER TABLE `loginunwahas`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `loginupgris`
--
ALTER TABLE `loginupgris`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `loginusm`
--
ALTER TABLE `loginusm`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `pets`
--
ALTER TABLE `pets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT untuk tabel `unikaa`
--
ALTER TABLE `unikaa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT untuk tabel `usm`
--
ALTER TABLE `usm`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `bidikmisi`
--
ALTER TABLE `bidikmisi`
  ADD CONSTRAINT `bidikmisi_ibfk_1` FOREIGN KEY (`universitas`) REFERENCES `loginadmin` (`iduser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
