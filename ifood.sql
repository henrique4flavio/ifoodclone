-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 10-Abr-2019 às 21:55
-- Versão do servidor: 10.1.36-MariaDB
-- versão do PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ifood`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `administrador`
--

CREATE TABLE `administrador` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `senha` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `administrador`
--

INSERT INTO `administrador` (`id`, `nome`, `email`, `senha`) VALUES
(1, 'jonathas', 'jonathas@gmail', '2302');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `senha` varchar(100) DEFAULT NULL,
  `cpf` varchar(100) DEFAULT NULL,
  `rua` varchar(100) DEFAULT NULL,
  `numero` varchar(100) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `email`, `senha`, `cpf`, `rua`, `numero`, `bairro`, `cep`) VALUES
(1, 'Jonathas Martins de Araujo', 'jonathas@gmail.com', 'Jonjon23', '02011102618', 'Rua Francisco Henriques', '368', 'null', '36030530'),
(2, 'Wanessa', 'wanessa@gmail.com', '1234', '02011102121', 'Rua Francisco Henriques', '268', 'Jardim de AlÃ¡', '36030530'),
(3, 'Flavio Henrique', 'flavio@gmail.com', '123', '02323123', 'Rua Francisco Henriques', '369', 'Jardim de AlÃ¡', '36030530');

-- --------------------------------------------------------

--
-- Estrutura da tabela `comida`
--

CREATE TABLE `comida` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `foto` varchar(100) DEFAULT NULL,
  `REST_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `comida`
--

INSERT INTO `comida` (`id`, `nome`, `descricao`, `preco`, `foto`, `REST_ID`) VALUES
(1, 'Hamburger', 'Pão + bife + batata + ovo', 10, NULL, 1),
(2, 'Porção de Batata Frita', 'porção média de batata', 5, NULL, 1),
(19, 'Pizza Media', 'pizza musarela', 20, 'imagens/comidas/-342828270.png', 27),
(20, 'Batata frita', 'batata media', 10, 'imagens/comidas/-1892220184.png', 27);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `data` varchar(100) DEFAULT NULL,
  `REST_ID` int(11) DEFAULT NULL,
  `CLIENTE_ID` int(11) DEFAULT NULL,
  `precoTotal` double DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pedido`
--

INSERT INTO `pedido` (`id`, `data`, `REST_ID`, `CLIENTE_ID`, `precoTotal`, `estado`) VALUES
(24, NULL, 27, 1, 0, 'Efetuado'),
(25, NULL, 27, 1, 0, 'Efetuado'),
(26, NULL, 27, 1, 30, 'Efetuado'),
(27, NULL, 27, 6, 30, 'Efetuado');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido_pedidocomida`
--

CREATE TABLE `pedido_pedidocomida` (
  `id` int(11) NOT NULL,
  `PEDIDO_ID` int(11) DEFAULT NULL,
  `COMIDA_ID` int(11) DEFAULT NULL,
  `quantidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pedido_pedidocomida`
--

INSERT INTO `pedido_pedidocomida` (`id`, `PEDIDO_ID`, `COMIDA_ID`, `quantidade`) VALUES
(7, 24, 20, 1),
(8, 24, 19, 1),
(9, 25, 19, 2),
(10, 25, 20, 1),
(11, 26, 20, 1),
(12, 26, 19, 1),
(13, 27, 20, 1),
(14, 27, 19, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `restaurante`
--

CREATE TABLE `restaurante` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `senha` varchar(100) DEFAULT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `foto` varchar(100) DEFAULT NULL,
  `horaDeAbrir` varchar(100) DEFAULT NULL,
  `horaDeFechar` varchar(100) DEFAULT NULL,
  `categoria` varchar(100) DEFAULT NULL,
  `valorDoFrete` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `restaurante`
--

INSERT INTO `restaurante` (`id`, `nome`, `email`, `senha`, `descricao`, `foto`, `horaDeAbrir`, `horaDeFechar`, `categoria`, `valorDoFrete`) VALUES
(1, 'Mc Donalds', 'mc@gmail.com', '123', 'Restaurante', '', NULL, NULL, 'Fast food', 7),
(2, 'Burger King', 'bk@gmail.com', '123', 'fast food', NULL, '12', '00', 'Fast food', 7),
(25, 'MR Tugas', '321', '123', '8888888888888888888888888888', 'imagens/restaurantes/-850906048.png', '08:08', NULL, 'Hamburgeria', 8),
(26, 'MR Tugas 2', 'mrtugas@gmail', '123', 'Pizzaria artezanal', 'imagens/restaurantes/2086457327.png', '12:12', NULL, 'Pizzaria', 10),
(27, 'MR Tugas 3', 'mrtugas5@gmail', '1234', '33333333', 'imagens/restaurantes/403421597.png', '03:33', NULL, 'Hamburgeria', 32);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `comida`
--
ALTER TABLE `comida`
  ADD PRIMARY KEY (`id`),
  ADD KEY `REST_ID` (`REST_ID`);

--
-- Indexes for table `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `REST_ID` (`REST_ID`),
  ADD KEY `CLIENTE_ID` (`CLIENTE_ID`);

--
-- Indexes for table `pedido_pedidocomida`
--
ALTER TABLE `pedido_pedidocomida`
  ADD PRIMARY KEY (`id`),
  ADD KEY `PEDIDO_ID` (`PEDIDO_ID`),
  ADD KEY `COMIDA_ID` (`COMIDA_ID`);

--
-- Indexes for table `restaurante`
--
ALTER TABLE `restaurante`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administrador`
--
ALTER TABLE `administrador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `comida`
--
ALTER TABLE `comida`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `pedido_pedidocomida`
--
ALTER TABLE `pedido_pedidocomida`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `restaurante`
--
ALTER TABLE `restaurante`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `comida`
--
ALTER TABLE `comida`
  ADD CONSTRAINT `comida_ibfk_1` FOREIGN KEY (`REST_ID`) REFERENCES `restaurante` (`id`);

--
-- Limitadores para a tabela `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`REST_ID`) REFERENCES `restaurante` (`id`),
  ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`CLIENTE_ID`) REFERENCES `cliente` (`id`);

--
-- Limitadores para a tabela `pedido_pedidocomida`
--
ALTER TABLE `pedido_pedidocomida`
  ADD CONSTRAINT `pedido_pedidocomida_ibfk_1` FOREIGN KEY (`PEDIDO_ID`) REFERENCES `pedido` (`id`),
  ADD CONSTRAINT `pedido_pedidocomida_ibfk_2` FOREIGN KEY (`COMIDA_ID`) REFERENCES `comida` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
