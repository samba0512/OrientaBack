-- phpMyAdmin SQL Dump
-- version 4.6.6deb5ubuntu0.5
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Ven 16 Avril 2021 à 10:37
-- Version du serveur :  5.7.33-0ubuntu0.18.04.1
-- Version de PHP :  7.2.24-0ubuntu0.18.04.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `RestApiOrienta`
--

-- --------------------------------------------------------

--
-- Structure de la table `agent`
--

CREATE TABLE `agent` (
  `id` int(11) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `cover_path` varchar(255) DEFAULT NULL,
  `etat` int(11) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `profil_path` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `agent`
--

INSERT INTO `agent` (`id`, `adresse`, `cover_path`, `etat`, `firstname`, `lastname`, `profil_path`, `telephone`, `user_id`) VALUES
(1, 'dakar', '/test', 1, 'Fama', 'sow', '/user', '771450031', 22),
(2, 'dakar', '/test', 1, 'orbit', 'turner', '/user', '771458966', 21),
(5, 'Fatick', '/test', 1, 'Ngor', 'SECK', '/Admin', '771448569', 24),
(6, 'Fatick', '/test', 1, 'Fallou', 'DIOP', '/Admin', '771448569', 25),
(7, 'Fatick', '/test', 1, 'Fatou', 'Fall', '/Admin', '771448569', 26),
(8, 'Fatick', '/test', 1, 'Mohamed', 'NDIAYE', '/Admin', '771448569', 27),
(9, 'Fatick', '/test', 1, 'Moussa', 'DIALLO', '/Admin', '771448569', 28),
(10, 'Tattaguine', '/test', 1, 'Ngor', 'Seck', '/admin', '771445878', 33),
(11, 'Parcelles Assainies', '/test', 1, 'Fama', 'Sow', '/test', '771450031', 70);

-- --------------------------------------------------------

--
-- Structure de la table `demande`
--

CREATE TABLE `demande` (
  `id` int(11) NOT NULL,
  `etat` int(11) NOT NULL,
  `matricule` varchar(255) DEFAULT NULL,
  `universite_id` int(11) DEFAULT NULL,
  `entretien_id` int(11) DEFAULT NULL,
  `etudiant_id` int(11) DEFAULT NULL,
  `formation_id` int(11) DEFAULT NULL,
  `paiement_id` int(11) DEFAULT NULL,
  `dossier_etudiant_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `demande`
--

INSERT INTO `demande` (`id`, `etat`, `matricule`, `universite_id`, `entretien_id`, `etudiant_id`, `formation_id`, `paiement_id`, `dossier_etudiant_id`) VALUES
(1, 1, 'DS587FS', 1, 1, 7, 2, 9, 13),
(2, 0, 'DS587DE', 4, 3, 14, 6, 11, 12),
(4, 1, 'DS587PS', 5, 7, 9, 7, 5, 10),
(5, 1, 'DS587FO', 6, 2, 6, 3, 7, 9),
(6, 1, 'DS587FD', 6, 4, 10, 7, 8, 8),
(7, 0, 'DS587UI', 5, 10, 13, 3, 3, 7),
(8, 1, 'DS587HU', 9, 5, 20, 1, 3, 6),
(9, 0, 'DS587IS', 2, 11, 4, 4, 9, 5),
(10, 1, 'DS587OP', 8, 12, 1, 1, 3, 4),
(11, 1, 'DS587LO', 4, 13, 2, 1, 10, 3),
(12, 1, 'DS587PO', 3, 8, 3, 6, 3, 2),
(13, 1, 'DS587MO', 1, 9, 5, 4, 9, 1),
(14, 1, 'DS58794HU', 6, 14, 22, 3, 8, 14),
(15, 1, 'DSERT855', 9, 15, 23, 1, 6, 15),
(16, 1, 'DSER987', 1, 16, 24, 5, 3, 16),
(17, 1, 'DSTR654', 1, 17, 25, 1, 11, 17),
(18, 1, 'DS857TY', 1, 18, 26, 4, 4, 18),
(19, 1, 'DSEZ98745', 1, 19, 27, 6, 9, 19),
(20, 0, 'DSEZ2145', 1, 20, 28, 3, 12, 20),
(21, 1, 'DSU874OI', 1, 21, 29, 1, 11, 21),
(22, 0, '10:53:03.345', NULL, NULL, 32, NULL, NULL, 24),
(23, 0, '13:07:34.883', NULL, NULL, 34, NULL, NULL, 25),
(24, 0, '13:11:31.933', NULL, NULL, 35, NULL, NULL, 26),
(25, 0, '13:14:41.780', NULL, NULL, 36, NULL, NULL, 27),
(26, 0, '13:16:01.739', NULL, NULL, 37, NULL, NULL, 28),
(27, 0, '13:17:50.872', NULL, NULL, 38, NULL, NULL, 29),
(28, 0, '13:32:13.794', NULL, NULL, 39, NULL, NULL, 30),
(29, 1, 'DS996655', NULL, NULL, NULL, 2, NULL, NULL),
(30, 0, 'MDES29', NULL, NULL, 41, 1, NULL, 32),
(31, 0, 'MDES30', NULL, NULL, 42, NULL, NULL, 33);

-- --------------------------------------------------------

--
-- Structure de la table `domaine_formation`
--

CREATE TABLE `domaine_formation` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `etat` int(11) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `domaine_formation`
--

INSERT INTO `domaine_formation` (`id`, `description`, `etat`, `libelle`) VALUES
(1, 'Administration base de donnees', 1, 'informatique'),
(2, 'Vendre ses produits', 1, 'Marketing'),
(3, 'Droit des affaires', 1, 'Droit'),
(4, 'chimieeeee', 1, 'Chimie'),
(5, 'Biologie', 1, 'SVT'),
(6, 'geomat', 1, 'Geomatique'),
(7, 'Administration base de donnees', 1, 'informatique'),
(8, 'Administration base de donnees', 1, 'informatique'),
(9, 'jfnjnrfj', 1, 'nbjfbrj');

-- --------------------------------------------------------

--
-- Structure de la table `dossier_etudiant`
--

CREATE TABLE `dossier_etudiant` (
  `id` int(11) NOT NULL,
  `autres_infos` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `etudiant_id` int(11) DEFAULT NULL,
  `etat_dossier_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `dossier_etudiant`
--

INSERT INTO `dossier_etudiant` (`id`, `autres_infos`, `numero`, `etudiant_id`, `etat_dossier_id`) VALUES
(1, 'bachelier', 'DS5124', 2, 1),
(2, 'licence', 'DS5125', 1, 1),
(3, 'master', 'DS5126', 7, 4),
(4, 'bachelier', 'DS5127', 12, 4),
(5, 'bachelier', 'DS5128', 4, 4),
(6, 'licence', 'DS5129', 20, 1),
(7, 'bachelier', 'DS5130', 5, 4),
(8, 'bachelier', 'DS5131', 3, 4),
(9, 'master', 'DS5132', 8, 4),
(10, 'bachelier', 'DS5133', 14, 4),
(12, 'bachelier', 'DS5135', 13, 4),
(13, 'bachelier', 'DS5136', 6, 1),
(14, 'Licence', 'DS987HJ', 22, 4),
(15, 'Master ', 'DS857HU', 23, 4),
(16, 'Licence', 'DS8974FR', 24, 4),
(17, 'Licence', 'DS874SD', 25, 4),
(18, 'Master', 'DS8954GH', 26, 4),
(19, 'Licence', 'DS897456', 27, 4),
(20, 'Master', 'DS5895FT', 28, 4),
(21, 'Licence', 'DS859658', 29, 5),
(22, 'Autres Informations', '10:21:24.831', 30, 6),
(23, 'Autres Informations', '10:29:16.141', 31, 6),
(24, 'Autres Informations', '10:53:03.285', 32, 5),
(25, 'Autres Informations', 'DS3255\r\n', 34, 5),
(26, 'Autres Informations', 'DS263333', 35, 5),
(27, 'Autres Informations', 'DSJJJJJ', 36, 5),
(28, 'Autres Informations', 'DS58865', 37, 6),
(29, 'Autres Informations', '13:17:50.802', 38, 6),
(30, 'Autres Informations', 'DSE29', 39, 6),
(31, 'AUTRESGHSH', 'DSE30', 40, 6),
(32, NULL, 'DSE31', 41, 6),
(33, NULL, 'DSE32', 42, 6);

-- --------------------------------------------------------

--
-- Structure de la table `entretien`
--

CREATE TABLE `entretien` (
  `id` int(11) NOT NULL,
  `date_entretien` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `entretien`
--

INSERT INTO `entretien` (`id`, `date_entretien`) VALUES
(1, '10/12/2020'),
(2, '11/12/2020'),
(3, '12/12/2020'),
(4, '13/12/2020'),
(5, '14/12/2020'),
(6, '15/12/2020'),
(7, '16/12/2020'),
(8, '17/12/2020'),
(9, '18/12/2020'),
(10, '19/12/2020'),
(11, '20/12/2020'),
(12, '07/01/2021'),
(13, '07/01/2021'),
(14, '28/01/2021'),
(15, '29/01/2021'),
(16, '30/01/2021'),
(17, '31/01/2021'),
(18, '01/02/2021'),
(19, '02/02/2021'),
(20, '03/02/2021'),
(21, '05/02/2021');

-- --------------------------------------------------------

--
-- Structure de la table `etat_dossier`
--

CREATE TABLE `etat_dossier` (
  `id` int(11) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `etat_dossier`
--

INSERT INTO `etat_dossier` (`id`, `libelle`) VALUES
(1, 'Dossier accepté'),
(2, 'Dossier en attente de validation'),
(3, 'Dossier complet'),
(4, 'Dossier soumis à l\'université'),
(5, 'Dossier en attente de complément'),
(6, 'Dossier en cours de création');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `id` int(11) NOT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `etat` int(11) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `niveau` varchar(255) NOT NULL,
  `date_naissance` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `pays` varchar(255) NOT NULL,
  `numero_piece` varchar(255) NOT NULL,
  `type_piece_id` int(11) DEFAULT NULL,
  `lieu_naissance` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`id`, `created_at`, `etat`, `firstname`, `lastname`, `numero`, `telephone`, `user_id`, `niveau`, `date_naissance`, `adresse`, `pays`, `numero_piece`, `type_piece_id`, `lieu_naissance`) VALUES
(1, '07/12/2020', 1, 'Fama', 'Sow', 'pp265', '+221771450031', 1, 'Licence 2', '05/07/1997', 'parcelles', 'Senegal', '22510254852', 1, 'SL'),
(2, '10/12/2020', 1, 'Aissatou', 'Cisse', 'P255TS', '774856985', 2, 'Master 2', '05/07/1997', 'parcelles', 'Senegal', '85454', 2, 'Senegal'),
(3, '10/12/2020', 1, 'Mariama', 'Diouf', 'P325TS', '772569858', 3, 'Licence 1', '05/07/1997', 'parcelles', 'Senegal', '445154', 3, 'Senegal'),
(4, '10/12/2020', 1, 'Mor', 'Diop', 'P985TS', '769859632', 4, 'Licence 2', '05/07/1997', 'parcelles', 'Senegal', '1215151514', 1, 'Senegal'),
(5, '10/12/2020', 1, 'Orbit', 'Turner', 'P225TS', '768524678', 5, 'Master 1', '05/07/1997', 'parcelles', 'Senegal', '51515155', 2, 'Senegal'),
(6, '10/12/2020', 1, 'Coumba', 'Sy', 'P635TS', '772569878', 6, 'Licence 3', '05/07/1997', 'parcelles', 'Senegal', '114554', 3, 'Senegal'),
(7, '10/12/2020', 1, 'Mareme', 'Fall', 'P125TS', '775986354', 7, 'Licence 1', '05/07/1997', 'parcelles', 'Senegal', '445145154', 1, 'Senegal'),
(8, '10/12/2020', 1, 'Cheikh', 'Mbow', 'P255TS', '772569854', 8, 'Master 1', '05/07/1997', 'parcelles', 'Senegal', '151515', 3, 'Senegal'),
(9, '10/12/2020', 1, 'Moustapha', 'Dieye', 'P355TS', '782569412', 9, 'Licence 3', '05/07/1997', 'parcelles', 'Senegal', '15155151', 1, 'Senegal'),
(10, '10/12/2020', 1, 'ADN', 'Ndiaye', 'P675TS', '775963214', 10, 'Master 2', '05/07/1997', 'parcelles', 'Senegal', '1515154', 2, 'Senegal'),
(11, '10/12/2020', 1, 'Moussa', 'Akhyar', 'P145TS', '771598475', 11, 'Licence 2', '05/07/1997', 'parcelles', 'Senegal', '151284845', 3, 'Senegal'),
(12, '10/12/2020', 1, 'Emma', 'Edgar', 'P355TS', '771458961', 12, 'Licence 2', '05/07/1997', 'parcelles', 'Senegal', '1414144444', 1, 'Senegal'),
(13, '10/12/2020', 1, 'Papis', 'Ndoye', 'P365TS', '769854128', 13, 'Licence 3', '05/07/1997', 'parcelles', 'Senegal', '141414', 2, 'Senegal'),
(14, '10/12/2020', 1, 'Judith', 'Sagna', 'P475TS', '775841245', 14, 'Master 2', '05/07/1997', 'parcelles', 'Senegal', '25852', 1, 'Senegal'),
(19, '23/12/2020', 1, 'ndeye', 'ngom', 'pp15866', '+221771589646', 15, 'Licence 2', '05/07/1997', 'parcelles', 'Senegal', '25554855', 2, 'Senegal'),
(20, '2021-01-13', 1, 'Karaba', 'La sorciere', 'n001473P', '701254789', 31, 'Master 1', '05/07/1997', 'parcelles', 'Senegal', '414114', 2, 'Senegal'),
(21, '13/01/2021', 1, 'Ngor', 'Seck', 'PO258', '778965412', 33, 'Licence 1', '05/07/1997', 'parcelles', 'Senegal', '25655', 1, 'Senegal'),
(22, '28/01/2021', 1, 'Malick', 'Fall', 'PS8957TY', '778965652', 37, 'Licence 3', '05/07/1997', 'parcelles', 'Senegal', '22232', 1, 'Senegal'),
(23, '28/01/2021', 1, 'Ndeye', 'Ngom', 'PS987OP', '771587854', 38, 'Master 1', '05/07/1997', 'parcelles', 'Senegal', '2645122', 2, 'Senegal'),
(24, '28/01/2021', 1, 'Penda', 'Bocoum', 'PS5874YD', '778965412', 39, 'Licence 1', '05/07/1997', 'parcelles', 'Senegal', '987455', 3, 'Senegal'),
(25, '28/01/2021', 1, 'Aminata', 'Ba', 'PS657tR', '772589746', 40, 'Licence 2', '05/07/1997', 'parcelles', 'Senegal', '547712', 1, 'Senegal'),
(26, '28/01/2021', 1, 'Assane', 'Fall', 'PS111KJ', '778964787', 41, 'Master 2', '05/07/1997', 'parcelles', 'Senegal', '565215', 2, 'Senegal'),
(27, '28/01/2021', 1, 'Alioune', 'Diallo', 'PS888POI', '776987454', 42, 'Licence 3', '05/07/1997', 'parcelles', 'Senegal', '8745242', 3, 'Senegal'),
(28, '28/01/2021', 1, 'Baba', 'Bocoum', 'PS8974GH', '774856235', 43, 'Master 1', '05/07/1997', 'parcelles', 'Senegal', '15111', 2, 'Senegal'),
(29, '01/02/2021', 1, 'Diary', 'Sow', 'PSD987GH', '774895712', 44, 'Licence 1', '05/07/1997', 'parcelles', 'Senegal', '2551511', 2, 'Senegal'),
(30, '03/02/2021', 1, 'adn', 'ndiaye', 'CNI4867', '+221454549435', 49, 'Licence 3', '07/12/1985', 'dakar', 'sengal', '6983', 1, 'keur mor Ndiaye'),
(31, '04/02/2021', 1, 'Samba', 'diaw', 'CNI44444', '+221454569854', 50, 'Master 2', '04/02/1985', 'kaolack', 'senegal', '6000', 1, 'Dakar'),
(32, '04/02/2021', 1, 'Assane', 'diop', 'CNI4932', '+221454569859', 51, 'Licence 2', '04/02/1985', 'kaolack', 'senegal', '5000', 1, 'Dakar'),
(33, '03/02/2021', 1, 'coumba', 'sylla', 'CNI9877', '+221454549165', 52, 'Licence 3', '07/12/1985', 'dakar', 'senegal', '987456', 1, 'Parcelles'),
(34, '03/02/2021', 1, 'coumba', 'sylla', 'CNI9877', '+221454549165', 53, 'Licence 3', '07/12/1985', 'dakar', 'senegal', '987456', 1, 'Parcelles'),
(35, '03/02/2021', 1, 'coumba', 'ndjnhfuj', 'CNI92597', '+221454489165', 54, 'Licence 3', '07/12/1985', 'dakar', 'senegal', '989356', 1, 'Parcelles'),
(36, '03/02/2021', 1, 'jnjn', 'ndjnhfuj', 'CN597', '+2214544858165', 55, 'Licence 3', '07/12/1985', 'dakar', 'senegal', '9356', 1, 'Parcelles'),
(37, '03/02/2021', 1, 'jnbbjn', 'ndjnbnhfuj', 'CN59887', '+22144858165', 56, 'Licence 3', '07/12/1985', 'dakar', 'senegal', '1587', 1, 'Parcelles'),
(38, '03/02/2021', 1, 'jnnnnnnbbjn', 'ndjnbnjnjnnhfuj', '9887', '+221448165', 57, 'Licence 3', '07/12/1985', 'dakar', 'senegal', '3887', 1, 'Parcelles'),
(39, '03/02/2021', 1, 'njdbcfuhd', 'njcdbjcbd', '1111', '+221771458965', 58, 'Licence 3', '07/12/1985', 'dakar', 'senegal', '2658', 1, 'Parcelles'),
(40, '05/02/2021', 1, 'katy', 'cisse', '13:52:08.801', '+221771208965', 59, 'Licence 3', '07/12/1985', 'dakar', 'senegal', '20399', 1, 'Parcelles'),
(41, '31/03/2021', 1, 'ndiaye', 'khadija', '13:20:45.419', '771440160', 71, 'LICENCE', '18/06/1997', 'saint-louis', 'AO', '545555555', 1, 'saint-louis'),
(42, '08/04/2021', 1, 'ndiaye', 'Aida', 'PST254NA', '778596235', 75, 'BAC', '09/02/1999', 'Saint-louis', 'AR', '258415645', 1, 'Saint-louis');

-- --------------------------------------------------------

--
-- Structure de la table `fichiers_dossiers`
--

CREATE TABLE `fichiers_dossiers` (
  `id` int(11) NOT NULL,
  `etat` int(11) DEFAULT NULL,
  `files` tinyblob,
  `libelle` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `dossier_etudiant_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

CREATE TABLE `formation` (
  `id` int(11) NOT NULL,
  `etat` int(11) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `domaine_formation_id` int(11) DEFAULT NULL,
  `end_day` varchar(255) NOT NULL,
  `start_day` varchar(255) NOT NULL,
  `universite_id` int(11) DEFAULT NULL,
  `frais` int(11) NOT NULL,
  `niveau_id` int(11) DEFAULT NULL,
  `type_formations_id` int(11) DEFAULT NULL,
  `autre_infos` varchar(600) DEFAULT NULL,
  `description` varchar(8000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `formation`
--

INSERT INTO `formation` (`id`, `etat`, `libelle`, `domaine_formation_id`, `end_day`, `start_day`, `universite_id`, `frais`, `niveau_id`, `type_formations_id`, `autre_infos`, `description`) VALUES
(1, 1, 'Développement web et mobile', 1, '2021-02-25', '2021-02-12', 1, 10000, 1, 1, 'gbfbgng', 'Le développeur web mobile est un concepteur spécialisé en application mobile. Il développe des programmes informatiques destinés exclusivement à l’utilisation sur smartphone ou tablette. Apprenez en plus sur ce métier et découvrez les différentes formations en développement web mobile.'),
(2, 1, 'Développement mobile', 1, '26/01/2024', '26/01/2021', 3, 1000000, 2, 1, 'b b b b b ', 'bonjour'),
(3, 1, 'referent digital', 7, '26/01/2026', '26/01/2021', 4, 200000, 4, 2, 'vbvb b g', 'tesddf'),
(4, 1, 'community management', 7, '26/01/2022', '26/01/2021', 5, 150000, 4, 1, 'vfbbgbg', 'bgnhn'),
(5, 1, 'Administrateur base de données', 8, '26/01/2024', '26/01/2021', 6, 16800000, 3, 2, ' vgb v b ', 'ghghgh'),
(6, 1, 'Systeme d\'information', 1, '26/01/2026', '26/01/2021', 9, 1458555, 4, 1, ' bvgbgbgb', 'gbgngngn'),
(7, 1, 'administrateur Réseau', 1, '26/01/2024', '26/01/2021', 10, 15877411, 6, 2, 'fvffbgb', 'fbgvbgbngbn'),
(8, 1, 'Infographie', 1, '2021-02-04', '2021-02-12', 1, 1000000, 2, 1, 'vfvgfbfgb', 'nbgngngngn'),
(11, 1, 'Urbanisme', 5, '2021-03-12', '2021-03-20', 1, 150000, 7, NULL, NULL, 'description'),
(12, 1, 'Logistique', 6, '2021-03-12', '2021-03-11', 1, 150000, 2, NULL, NULL, 'hbbbbbbbb'),
(13, 1, 'Géologie', 4, '2021-04-01', '2021-03-10', 1, 15000, 3, NULL, NULL, 'hhghhjhjj'),
(14, 1, 'RAF', 3, '2021-03-25', '2021-03-26', 1, 15000, 5, NULL, NULL, 'hhbbhhjhb'),
(15, 1, 'Sécurité informatique', 1, '14/01/2020', '14/01/2023', 1, 1000000, 3, 1, 'Sécurite des données', 'Sécurite des données');

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `_from` int(11) NOT NULL,
  `_to` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `etat` int(11) NOT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `message`
--

INSERT INTO `message` (`id`, `_from`, `_to`, `content`, `etat`, `subject`, `user_id`) VALUES
(1, 1, 1, 'je vaux tester', 1, 'test', NULL),
(2, 1, 1, 'je vaux tester', 1, 'test2', NULL),
(3, 1, 1, 'je vaux tester', 1, 'test3', NULL),
(4, 1, 1, 'je vaux tester', 1, 'tes4t', NULL),
(5, 1, 1, 'je vaux tester', 1, 'test5', NULL),
(6, 1, 1, 'je vaux tester', 1, 'test6', NULL),
(7, 1, 1, 'je vaux tester', 1, 'test7', NULL),
(8, 1, 1, 'je vaux tester', 1, 'test8', NULL),
(9, 1, 1, 'je vaux tester', 1, 'test9', NULL),
(10, 1, 1, 'je vaux tester', 1, 'test10', NULL),
(11, 1, 1, 'je vaux tester', 1, 'test11', NULL),
(12, 1, 1, 'je vaux tester', 1, 'test12', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

CREATE TABLE `niveau` (
  `id` int(11) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `niveau`
--

INSERT INTO `niveau` (`id`, `libelle`) VALUES
(1, 'Licence 1'),
(2, 'Licence 2'),
(3, 'Licence 3'),
(4, 'Master 1'),
(5, 'Master 2'),
(6, 'Doctorat'),
(7, 'BAC ou équivalent');

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

CREATE TABLE `paiement` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `etat` int(11) NOT NULL,
  `montant` double DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `paiement`
--

INSERT INTO `paiement` (`id`, `description`, `etat`, `montant`, `numero`) VALUES
(1, 'Frais de dossier', 1, 50000, 'PA1587DK'),
(2, 'Frais de dossier', 1, 60000, 'PA2567DK'),
(3, 'Frais de dossier', 1, 55000, 'PA4587DK'),
(4, 'Frais de dossier', 1, 50000, 'PA1457DK'),
(5, 'Frais de dossier', 1, 54000, 'PA1558DK'),
(6, 'Frais de dossier', 1, 40000, 'PA1535DK'),
(7, 'Frais de dossier', 1, 100000, 'PA1237DK'),
(8, 'Frais de dossier', 1, 150000, 'PA1987DK'),
(9, 'Frais de dossier', 1, 740000, 'PA1147DK'),
(10, 'Frais de dossier', 1, 69000, 'PA1877DK'),
(11, 'Frais de dossier', 1, 54000, 'PA1987DK'),
(12, 'Frais de dossier', 1, 52000, 'PA1787DK');

-- --------------------------------------------------------

--
-- Structure de la table `parcours`
--

CREATE TABLE `parcours` (
  `id` int(11) NOT NULL,
  `nom_ecole` varchar(255) NOT NULL,
  `annee` varchar(255) NOT NULL,
  `domaine` varchar(255) NOT NULL,
  `niveau` varchar(255) NOT NULL,
  `pays` varchar(255) NOT NULL,
  `ville` varchar(255) NOT NULL,
  `etudiant_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `parcours`
--

INSERT INTO `parcours` (`id`, `nom_ecole`, `annee`, `domaine`, `niveau`, `pays`, `ville`, `etudiant_id`) VALUES
(1, 'nfnjbnvj', 'njbjb', 'jbjbvjg', 'njvjg', 'nvnv', 'njnj', NULL),
(5, 'SARAKH RADIA BOLEI', '2014bhbh', 'INFORMATIQUE', 'AES', 'SENEGAL', 'DAKAR', 5),
(6, 'SARAKH RADIA BOLEI', '2014bhbh', 'INFORMATIQUE', 'AES', 'SENEGAL', 'DAKAR', 4),
(7, 'jnjdhhe', '2024', 'Geomatique', 'BAC', 'American Samoa', 'uhuedghuegd', 20),
(8, 'fkrgor', '2020', 'Droit', 'AES', 'Austria', 'jnfjrjgnrn', 20),
(9, 'djfnhjdbhf', '2015', 'Marketing', 'DES', 'France', 'bhfhbgf', 20);

-- --------------------------------------------------------

--
-- Structure de la table `pays`
--

CREATE TABLE `pays` (
  `id` int(11) NOT NULL,
  `alpha_2_code` varchar(255) DEFAULT NULL,
  `alpha_3_code` varchar(255) DEFAULT NULL,
  `en_short_name` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `num_code` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `pays`
--

INSERT INTO `pays` (`id`, `alpha_2_code`, `alpha_3_code`, `en_short_name`, `nationality`, `num_code`) VALUES
(1, 'AF', 'AFG', 'Afghanistan', 'Afghan', 4),
(2, 'AX', 'ALA', 'Åland Islands', 'Åland Island', 248),
(3, 'AL', 'ALB', 'Albania', 'Albanian', 8),
(4, 'DZ', 'DZA', 'Algeria', 'Algerian', 12),
(5, 'AS', 'ASM', 'American Samoa', 'American Samoan', 16),
(6, 'AD', 'AND', 'Andorra', 'Andorran', 20),
(7, 'AO', 'AGO', 'Angola', 'Angolan', 24),
(8, 'AI', 'AIA', 'Anguilla', 'Anguillan', 660),
(9, 'AQ', 'ATA', 'Antarctica', 'Antarctic', 10),
(10, 'AG', 'ATG', 'Antigua and Barbuda', 'Antiguan or Barbudan', 28),
(11, 'AR', 'ARG', 'Argentina', 'Argentine', 32),
(12, 'AM', 'ARM', 'Armenia', 'Armenian', 51),
(13, 'AW', 'ABW', 'Aruba', 'Aruban', 533),
(14, 'AU', 'AUS', 'Australia', 'Australian', 36),
(15, 'AT', 'AUT', 'Austria', 'Austrian', 40),
(16, 'AZ', 'AZE', 'Azerbaijan', 'Azerbaijani, Azeri', 31),
(17, 'BS', 'BHS', 'Bahamas', 'Bahamian', 44),
(18, 'BH', 'BHR', 'Bahrain', 'Bahraini', 48),
(19, 'BD', 'BGD', 'Bangladesh', 'Bangladeshi', 50),
(20, 'BB', 'BRB', 'Barbados', 'Barbadian', 52),
(21, 'BY', 'BLR', 'Belarus', 'Belarusian', 112),
(22, 'BE', 'BEL', 'Belgium', 'Belgian', 56),
(23, 'BZ', 'BLZ', 'Belize', 'Belizean', 84),
(24, 'BJ', 'BEN', 'Benin', 'Beninese, Beninois', 204),
(25, 'BM', 'BMU', 'Bermuda', 'Bermudian, Bermudan', 60),
(26, 'BT', 'BTN', 'Bhutan', 'Bhutanese', 64),
(27, 'BO', 'BOL', 'Bolivia (Plurinational State of)', 'Bolivian', 68),
(28, 'BQ', 'BES', 'Bonaire, Sint Eustatius and Saba', 'Bonaire', 535),
(29, 'BA', 'BIH', 'Bosnia and Herzegovina', 'Bosnian or Herzegovinian', 70),
(30, 'BW', 'BWA', 'Botswana', 'Motswana, Botswanan', 72),
(31, 'BV', 'BVT', 'Bouvet Island', 'Bouvet Island', 74),
(32, 'BR', 'BRA', 'Brazil', 'Brazilian', 76),
(33, 'IO', 'IOT', 'British Indian Ocean Territory', 'BIOT', 86),
(34, 'BN', 'BRN', 'Brunei Darussalam', 'Bruneian', 96),
(35, 'BG', 'BGR', 'Bulgaria', 'Bulgarian', 100),
(36, 'BF', 'BFA', 'Burkina Faso', 'Burkinabé', 854),
(37, 'BI', 'BDI', 'Burundi', 'Burundian', 108),
(38, 'CV', 'CPV', 'Cabo Verde', 'Cabo Verdean', 132),
(39, 'KH', 'KHM', 'Cambodia', 'Cambodian', 116),
(40, 'CM', 'CMR', 'Cameroon', 'Cameroonian', 120),
(41, 'CA', 'CAN', 'Canada', 'Canadian', 124),
(42, 'KY', 'CYM', 'Cayman Islands', 'Caymanian', 136),
(43, 'CF', 'CAF', 'Central African Republic', 'Central African', 140),
(44, 'TD', 'TCD', 'Chad', 'Chadian', 148),
(45, 'CL', 'CHL', 'Chile', 'Chilean', 152),
(46, 'CN', 'CHN', 'China', 'Chinese', 156),
(47, 'CX', 'CXR', 'Christmas Island', 'Christmas Island', 162),
(48, 'CC', 'CCK', 'Cocos (Keeling) Islands', 'Cocos Island', 166),
(49, 'CO', 'COL', 'Colombia', 'Colombian', 170),
(50, 'KM', 'COM', 'Comoros', 'Comoran, Comorian', 174),
(51, 'CG', 'COG', 'Congo (Republic of the)', 'Congolese', 178),
(52, 'CD', 'COD', 'Congo (Democratic Republic of the)', 'Congolese', 180),
(53, 'CK', 'COK', 'Cook Islands', 'Cook Island', 184),
(54, 'CR', 'CRI', 'Costa Rica', 'Costa Rican', 188),
(55, 'CI', 'CIV', 'Côte d\'Ivoire', 'Ivorian', 384),
(56, 'HR', 'HRV', 'Croatia', 'Croatian', 191),
(57, 'CU', 'CUB', 'Cuba', 'Cuban', 192),
(58, 'CW', 'CUW', 'Curaçao', 'Curaçaoan', 531),
(59, 'CY', 'CYP', 'Cyprus', 'Cypriot', 196),
(60, 'CZ', 'CZE', 'Czech Republic', 'Czech', 203),
(61, 'DK', 'DNK', 'Denmark', 'Danish', 208),
(62, 'DJ', 'DJI', 'Djibouti', 'Djiboutian', 262),
(63, 'DM', 'DMA', 'Dominica', 'Dominican', 212),
(64, 'DO', 'DOM', 'Dominican Republic', 'Dominican', 214),
(65, 'EC', 'ECU', 'Ecuador', 'Ecuadorian', 218),
(66, 'EG', 'EGY', 'Egypt', 'Egyptian', 818),
(67, 'SV', 'SLV', 'El Salvador', 'Salvadoran', 222),
(68, 'GQ', 'GNQ', 'Equatorial Guinea', 'Equatorial Guinean, Equatoguinean', 226),
(69, 'ER', 'ERI', 'Eritrea', 'Eritrean', 232),
(70, 'EE', 'EST', 'Estonia', 'Estonian', 233),
(71, 'ET', 'ETH', 'Ethiopia', 'Ethiopian', 231),
(72, 'FK', 'FLK', 'Falkland Islands (Malvinas)', 'Falkland Island', 238),
(73, 'FO', 'FRO', 'Faroe Islands', 'Faroese', 234),
(74, 'FJ', 'FJI', 'Fiji', 'Fijian', 242),
(75, 'FI', 'FIN', 'Finland', 'Finnish', 246),
(76, 'FR', 'FRA', 'France', 'French', 250),
(77, 'GF', 'GUF', 'French Guiana', 'French Guianese', 254),
(78, 'PF', 'PYF', 'French Polynesia', 'French Polynesian', 258),
(79, 'TF', 'ATF', 'French Southern Territories', 'French Southern Territories', 260),
(80, 'GA', 'GAB', 'Gabon', 'Gabonese', 266),
(81, 'GM', 'GMB', 'Gambia', 'Gambian', 270),
(82, 'GE', 'GEO', 'Georgia', 'Georgian', 268),
(83, 'DE', 'DEU', 'Germany', 'German', 276),
(84, 'GH', 'GHA', 'Ghana', 'Ghanaian', 288),
(85, 'GI', 'GIB', 'Gibraltar', 'Gibraltar', 292),
(86, 'GR', 'GRC', 'Greece', 'Greek, Hellenic', 300),
(87, 'GL', 'GRL', 'Greenland', 'Greenlandic', 304),
(88, 'GD', 'GRD', 'Grenada', 'Grenadian', 308),
(89, 'GP', 'GLP', 'Guadeloupe', 'Guadeloupe', 312),
(90, 'GU', 'GUM', 'Guam', 'Guamanian, Guambat', 316),
(91, 'GT', 'GTM', 'Guatemala', 'Guatemalan', 320),
(92, 'GG', 'GGY', 'Guernsey', 'Channel Island', 831),
(93, 'GN', 'GIN', 'Guinea', 'Guinean', 324),
(94, 'GW', 'GNB', 'Guinea-Bissau', 'Bissau-Guinean', 624),
(95, 'GY', 'GUY', 'Guyana', 'Guyanese', 328),
(96, 'HT', 'HTI', 'Haiti', 'Haitian', 332),
(97, 'HM', 'HMD', 'Heard Island and McDonald Islands', 'Heard Island or McDonald Islands', 334),
(98, 'VA', 'VAT', 'Vatican City State', 'Vatican', 336),
(99, 'HN', 'HND', 'Honduras', 'Honduran', 340),
(100, 'HK', 'HKG', 'Hong Kong', 'Hong Kong, Hong Kongese', 344),
(101, 'HU', 'HUN', 'Hungary', 'Hungarian, Magyar', 348),
(102, 'IS', 'ISL', 'Iceland', 'Icelandic', 352),
(103, 'IN', 'IND', 'India', 'Indian', 356),
(104, 'ID', 'IDN', 'Indonesia', 'Indonesian', 360),
(105, 'IR', 'IRN', 'Iran', 'Iranian, Persian', 364),
(106, 'IQ', 'IRQ', 'Iraq', 'Iraqi', 368),
(107, 'IE', 'IRL', 'Ireland', 'Irish', 372),
(108, 'IM', 'IMN', 'Isle of Man', 'Manx', 833),
(109, 'IL', 'ISR', 'Israel', 'Israeli', 376),
(110, 'IT', 'ITA', 'Italy', 'Italian', 380),
(111, 'JM', 'JAM', 'Jamaica', 'Jamaican', 388),
(112, 'JP', 'JPN', 'Japan', 'Japanese', 392),
(113, 'JE', 'JEY', 'Jersey', 'Channel Island', 832),
(114, 'JO', 'JOR', 'Jordan', 'Jordanian', 400),
(115, 'KZ', 'KAZ', 'Kazakhstan', 'Kazakhstani, Kazakh', 398),
(116, 'KE', 'KEN', 'Kenya', 'Kenyan', 404),
(117, 'KI', 'KIR', 'Kiribati', 'I-Kiribati', 296),
(118, 'KP', 'PRK', 'Korea (Democratic People\'s Republic of)', 'North Korean', 408),
(119, 'KR', 'KOR', 'Korea (Republic of)', 'South Korean', 410),
(120, 'KW', 'KWT', 'Kuwait', 'Kuwaiti', 414),
(121, 'KG', 'KGZ', 'Kyrgyzstan', 'Kyrgyzstani, Kyrgyz, Kirgiz, Kirghiz', 417),
(122, 'LA', 'LAO', 'Lao People\'s Democratic Republic', 'Lao, Laotian', 418),
(123, 'LV', 'LVA', 'Latvia', 'Latvian', 428),
(124, 'LB', 'LBN', 'Lebanon', 'Lebanese', 422),
(125, 'LS', 'LSO', 'Lesotho', 'Basotho', 426),
(126, 'LR', 'LBR', 'Liberia', 'Liberian', 430),
(127, 'LY', 'LBY', 'Libya', 'Libyan', 434),
(128, 'LI', 'LIE', 'Liechtenstein', 'Liechtenstein', 438),
(129, 'LT', 'LTU', 'Lithuania', 'Lithuanian', 440),
(130, 'LU', 'LUX', 'Luxembourg', 'Luxembourg, Luxembourgish', 442),
(131, 'MO', 'MAC', 'Macao', 'Macanese, Chinese', 446),
(132, 'MK', 'MKD', 'Macedonia (the former Yugoslav Republic of)', 'Macedonian', 807),
(133, 'MG', 'MDG', 'Madagascar', 'Malagasy', 450),
(134, 'MW', 'MWI', 'Malawi', 'Malawian', 454),
(135, 'MY', 'MYS', 'Malaysia', 'Malaysian', 458),
(136, 'MV', 'MDV', 'Maldives', 'Maldivian', 462),
(137, 'ML', 'MLI', 'Mali', 'Malian, Malinese', 466),
(138, 'MT', 'MLT', 'Malta', 'Maltese', 470),
(139, 'MH', 'MHL', 'Marshall Islands', 'Marshallese', 584),
(140, 'MQ', 'MTQ', 'Martinique', 'Martiniquais, Martinican', 474),
(141, 'MR', 'MRT', 'Mauritania', 'Mauritanian', 478),
(142, 'MU', 'MUS', 'Mauritius', 'Mauritian', 480),
(143, 'YT', 'MYT', 'Mayotte', 'Mahoran', 175),
(144, 'MX', 'MEX', 'Mexico', 'Mexican', 484),
(145, 'FM', 'FSM', 'Micronesia (Federated States of)', 'Micronesian', 583),
(146, 'MD', 'MDA', 'Moldova (Republic of)', 'Moldovan', 498),
(147, 'MC', 'MCO', 'Monaco', 'Monégasque, Monacan', 492),
(148, 'MN', 'MNG', 'Mongolia', 'Mongolian', 496),
(149, 'ME', 'MNE', 'Montenegro', 'Montenegrin', 499),
(150, 'MS', 'MSR', 'Montserrat', 'Montserratian', 500),
(151, 'MA', 'MAR', 'Morocco', 'Moroccan', 504),
(152, 'MZ', 'MOZ', 'Mozambique', 'Mozambican', 508),
(153, 'MM', 'MMR', 'Myanmar', 'Burmese', 104),
(154, 'NA', 'NAM', 'Namibia', 'Namibian', 516),
(155, 'NR', 'NRU', 'Nauru', 'Nauruan', 520),
(156, 'NP', 'NPL', 'Nepal', 'Nepali, Nepalese', 524),
(157, 'NL', 'NLD', 'Netherlands', 'Dutch, Netherlandic', 528),
(158, 'NC', 'NCL', 'New Caledonia', 'New Caledonian', 540),
(159, 'NZ', 'NZL', 'New Zealand', 'New Zealand, NZ', 554),
(160, 'NI', 'NIC', 'Nicaragua', 'Nicaraguan', 558),
(161, 'NE', 'NER', 'Niger', 'Nigerien', 562),
(162, 'NG', 'NGA', 'Nigeria', 'Nigerian', 566),
(163, 'NU', 'NIU', 'Niue', 'Niuean', 570),
(164, 'NF', 'NFK', 'Norfolk Island', 'Norfolk Island', 574),
(165, 'MP', 'MNP', 'Northern Mariana Islands', 'Northern Marianan', 580),
(166, 'NO', 'NOR', 'Norway', 'Norwegian', 578),
(167, 'OM', 'OMN', 'Oman', 'Omani', 512),
(168, 'PK', 'PAK', 'Pakistan', 'Pakistani', 586),
(169, 'PW', 'PLW', 'Palau', 'Palauan', 585),
(170, 'PS', 'PSE', 'Palestine, State of', 'Palestinian', 275),
(171, 'PA', 'PAN', 'Panama', 'Panamanian', 591),
(172, 'PG', 'PNG', 'Papua New Guinea', 'Papua New Guinean, Papuan', 598),
(173, 'PY', 'PRY', 'Paraguay', 'Paraguayan', 600),
(174, 'PE', 'PER', 'Peru', 'Peruvian', 604),
(175, 'PH', 'PHL', 'Philippines', 'Philippine, Filipino', 608),
(176, 'PN', 'PCN', 'Pitcairn', 'Pitcairn Island', 612),
(177, 'PL', 'POL', 'Poland', 'Polish', 616),
(178, 'PT', 'PRT', 'Portugal', 'Portuguese', 620),
(179, 'PR', 'PRI', 'Puerto Rico', 'Puerto Rican', 630),
(180, 'QA', 'QAT', 'Qatar', 'Qatari', 634),
(181, 'RE', 'REU', 'Réunion', 'Réunionese, Réunionnais', 638),
(182, 'RO', 'ROU', 'Romania', 'Romanian', 642),
(183, 'RU', 'RUS', 'Russian Federation', 'Russian', 643),
(184, 'RW', 'RWA', 'Rwanda', 'Rwandan', 646),
(185, 'BL', 'BLM', 'Saint Barthélemy', 'Barthélemois', 652),
(186, 'SH', 'SHN', 'Saint Helena, Ascension and Tristan da Cunha', 'Saint Helenian', 654),
(187, 'KN', 'KNA', 'Saint Kitts and Nevis', 'Kittitian or Nevisian', 659),
(188, 'LC', 'LCA', 'Saint Lucia', 'Saint Lucian', 662),
(189, 'MF', 'MAF', 'Saint Martin (French part)', 'Saint-Martinoise', 663),
(190, 'PM', 'SPM', 'Saint Pierre and Miquelon', 'Saint-Pierrais or Miquelonnais', 666),
(191, 'VC', 'VCT', 'Saint Vincent and the Grenadines', 'Saint Vincentian, Vincentian', 670),
(192, 'WS', 'WSM', 'Samoa', 'Samoan', 882),
(193, 'SM', 'SMR', 'San Marino', 'Sammarinese', 674),
(194, 'ST', 'STP', 'Sao Tome and Principe', 'São Toméan', 678),
(195, 'SA', 'SAU', 'Saudi Arabia', 'Saudi, Saudi Arabian', 682),
(196, 'SN', 'SEN', 'Senegal', 'Senegalese', 686),
(197, 'RS', 'SRB', 'Serbia', 'Serbian', 688),
(198, 'SC', 'SYC', 'Seychelles', 'Seychellois', 690),
(199, 'SL', 'SLE', 'Sierra Leone', 'Sierra Leonean', 694),
(200, 'SG', 'SGP', 'Singapore', 'Singaporean', 702),
(201, 'SX', 'SXM', 'Sint Maarten (Dutch part)', 'Sint Maarten', 534),
(202, 'SK', 'SVK', 'Slovakia', 'Slovak', 703),
(203, 'SI', 'SVN', 'Slovenia', 'Slovenian, Slovene', 705),
(204, 'SB', 'SLB', 'Solomon Islands', 'Solomon Island', 90),
(205, 'SO', 'SOM', 'Somalia', 'Somali, Somalian', 706),
(206, 'ZA', 'ZAF', 'South Africa', 'South African', 710),
(207, 'GS', 'SGS', 'South Georgia and the South Sandwich Islands', 'South Georgia or South Sandwich Islands', 239),
(208, 'SS', 'SSD', 'South Sudan', 'South Sudanese', 728),
(209, 'ES', 'ESP', 'Spain', 'Spanish', 724),
(210, 'LK', 'LKA', 'Sri Lanka', 'Sri Lankan', 144),
(211, 'SD', 'SDN', 'Sudan', 'Sudanese', 729),
(212, 'SR', 'SUR', 'Suriname', 'Surinamese', 740),
(213, 'SJ', 'SJM', 'Svalbard and Jan Mayen', 'Svalbard', 744),
(214, 'SZ', 'SWZ', 'Swaziland', 'Swazi', 748),
(215, 'SE', 'SWE', 'Sweden', 'Swedish', 752),
(216, 'CH', 'CHE', 'Switzerland', 'Swiss', 756),
(217, 'SY', 'SYR', 'Syrian Arab Republic', 'Syrian', 760),
(218, 'TW', 'TWN', 'Taiwan, Province of China', 'Chinese, Taiwanese', 158),
(219, 'TJ', 'TJK', 'Tajikistan', 'Tajikistani', 762),
(220, 'TZ', 'TZA', 'Tanzania, United Republic of', 'Tanzanian', 834),
(221, 'TH', 'THA', 'Thailand', 'Thai', 764),
(222, 'TL', 'TLS', 'Timor-Leste', 'Timorese', 626),
(223, 'TG', 'TGO', 'Togo', 'Togolese', 768),
(224, 'TK', 'TKL', 'Tokelau', 'Tokelauan', 772),
(225, 'TO', 'TON', 'Tonga', 'Tongan', 776),
(226, 'TT', 'TTO', 'Trinidad and Tobago', 'Trinidadian or Tobagonian', 780),
(227, 'TN', 'TUN', 'Tunisia', 'Tunisian', 788),
(228, 'TR', 'TUR', 'Turkey', 'Turkish', 792),
(229, 'TM', 'TKM', 'Turkmenistan', 'Turkmen', 795),
(230, 'TC', 'TCA', 'Turks and Caicos Islands', 'Turks and Caicos Island', 796),
(231, 'TV', 'TUV', 'Tuvalu', 'Tuvaluan', 798),
(232, 'UG', 'UGA', 'Uganda', 'Ugandan', 800),
(233, 'UA', 'UKR', 'Ukraine', 'Ukrainian', 804),
(234, 'AE', 'ARE', 'United Arab Emirates', 'Emirati, Emirian, Emiri', 784),
(235, 'GB', 'GBR', 'United Kingdom of Great Britain and Northern Ireland', 'British, UK', 826),
(236, 'UM', 'UMI', 'United States Minor Outlying Islands', 'American', 581),
(237, 'US', 'USA', 'United States of America', 'American', 840),
(238, 'UY', 'URY', 'Uruguay', 'Uruguayan', 858),
(239, 'UZ', 'UZB', 'Uzbekistan', 'Uzbekistani, Uzbek', 860),
(240, 'VU', 'VUT', 'Vanuatu', 'Ni-Vanuatu, Vanuatuan', 548),
(241, 'VE', 'VEN', 'Venezuela (Bolivarian Republic of)', 'Venezuelan', 862),
(242, 'VN', 'VNM', 'Vietnam', 'Vietnamese', 704),
(243, 'VG', 'VGB', 'Virgin Islands (British)', 'British Virgin Island', 92),
(244, 'VI', 'VIR', 'Virgin Islands (U.S.)', 'U.S. Virgin Island', 850),
(245, 'WF', 'WLF', 'Wallis and Futuna', 'Wallis and Futuna, Wallisian or Futunan', 876),
(246, 'EH', 'ESH', 'Western Sahara', 'Sahrawi, Sahrawian, Sahraouian', 732),
(247, 'YE', 'YEM', 'Yemen', 'Yemeni', 887),
(248, 'ZM', 'ZMB', 'Zambia', 'Zambian', 894),
(249, 'ZW', 'ZWE', 'Zimbabwe', 'Zimbabwean', 716);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `etat` int(11) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `role`
--

INSERT INTO `role` (`id`, `description`, `etat`, `libelle`) VALUES
(1, 'administration', 1, 'ADMIN'),
(2, 'utilisateur', 0, 'ETUDIANT'),
(3, 'Universite', 3, 'UNIVERSITE'),
(4, 'super administrateur', 2, 'SUPER_ADMIN');

-- --------------------------------------------------------

--
-- Structure de la table `top_universite`
--

CREATE TABLE `top_universite` (
  `id` int(11) NOT NULL,
  `position` int(11) DEFAULT NULL,
  `universite_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `top_universite`
--

INSERT INTO `top_universite` (`id`, `position`, `universite_id`) VALUES
(1, 1, 6),
(2, 2, 2),
(3, 3, 10),
(4, 4, 1),
(5, 5, 3),
(6, 6, 4);

-- --------------------------------------------------------

--
-- Structure de la table `type_formations`
--

CREATE TABLE `type_formations` (
  `id` int(11) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `type_formations`
--

INSERT INTO `type_formations` (`id`, `libelle`) VALUES
(1, 'PLEIN TEMPS'),
(2, 'ALTERNANCE');

-- --------------------------------------------------------

--
-- Structure de la table `type_piece`
--

CREATE TABLE `type_piece` (
  `id` int(11) NOT NULL,
  `libelle` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `type_piece`
--

INSERT INTO `type_piece` (`id`, `libelle`) VALUES
(1, 'CARTE D\'IDENTITE'),
(2, 'PASSEPORT'),
(3, 'PERMIS DE CONDUIRE');

-- --------------------------------------------------------

--
-- Structure de la table `universite`
--

CREATE TABLE `universite` (
  `id` int(11) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `pays` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `autres_infos` varchar(255) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `langue` varchar(100) NOT NULL,
  `site_web` varchar(100) NOT NULL,
  `telephone` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `universite`
--

INSERT INTO `universite` (`id`, `adresse`, `nom`, `pays`, `user_id`, `autres_infos`, `description`, `langue`, `site_web`, `telephone`) VALUES
(1, 'Paris', 'Universite de Grenoble', 'France', 34, 'Universite d\'excellence', 'Universite offrant des formations top', 'français', 'grenoble.fr', '332544452152'),
(2, 'Bordeaux', 'Universite de Bordeaux', 'France', 35, 'Universite d\'excellence', 'Universite offrant des formations top', 'français', 'u-bordeaux.fr', '85458458'),
(3, 'Marseille', 'Aix-Marseille universite', 'France', 36, 'Universite d\'excellence', 'Universite offrant des formations top', 'français', 'marseille.fr', '151515155'),
(4, 'Strasbourg', 'Universite de Strasbourg', 'France', 63, 'Universite d\'excellence', 'Universite offrant des formations top', 'français', 'strasbourg.fr', '15151515'),
(5, 'Nancy', 'Universite de Lorraine', 'France', 64, 'Universite d\'excellence', 'Universite offrant des formations top', 'français', 'loraine.fr', '115151551'),
(6, 'Paris', 'Sorbonne', 'France', 65, 'Universite d\'excellence', 'Universite offrant des formations top', 'français', 'sorbonne.fr', '15151515'),
(7, 'Paris', 'Ecole normale Superieur', 'France', 66, 'Universite d\'excellence', 'Universite offrant des formations top', 'français', 'ens.fr', '151515'),
(8, 'Paris', 'American university of Paris', 'France', 67, 'Universite d\'excellence', 'Universite offrant des formations top', 'français', 'amop.fr', '5877551'),
(9, 'Paris', 'Universite PSL', 'France', 68, 'Universite d\'excellence', 'Universite offrant des formations top', 'français', 'psl.fr', '455152152'),
(10, 'Paris', 'Grenoble', 'France', 69, 'Universite d\'excellence', 'Universite offrant des formations top', 'français', 'Grenoble.com', '14444141'),
(13, 'Paris 76', 'Louis le Grand', 'senegal', 47, 'Universite d\'excellence', 'bchdbhbvcbchdbvc', 'français', 'louis.sn', '125155115'),
(14, 'bambey', 'universite de bambey', 'SN', 48, 'Universite d\'excellence', 'universire', 'français', 'bambey.sn', '2654465146'),
(19, 'Quebec', 'Université Quebec', 'TO', 73, 'jbjbdhbfhb', 'nujcndebcfhbhbfdhfb', 'français', 'quebec.fr', '9969858844'),
(20, 'Saint-Louis', 'Universite Saint-Louis', 'SN', 74, 'universite saint-louis', 'jbdzbcjnbchdvchdf', 'français', 'unisl.com', '339658745');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `etat` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `filename` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `created_at`, `email`, `etat`, `password`, `username`, `filename`) VALUES
(1, '25/11/2020', 'test@gmail.com', 1, '$2a$10$lXsk1nq8PALLLVZDsXYN5Od8dys4s9UyA6ySOFhRCBESBWjaJN2se', 'admin', 'fs.jpg'),
(2, '26/11/2020', 'test2@gmail.com', 0, '123', 'user1', 'aissatou.jpg'),
(3, '07/12/2020', 'cisse@gmail.com', 1, '$2a$10$OWJflh0OIo0PEjCCf5px.OhRa3xyHdi1enWoA/jmvK5ffQCiclo7y', 'aissatou', 'mariama_d.jpeg'),
(4, '07/12/2020', 'cisse@gmail.com', 1, '$2a$10$8kURycGi6X169ZM46Cofa.0PWgV4INbGvGjKjlTIpaOtealjMlnla', 'aissatou_2', 'mor.jpg'),
(5, '07/12/2020', 'djine@gmail.com', 1, '$2a$10$QMjLb5bUehN6lnSjdSC7r.lzJIKC22W7XTp8BFj9Rf/h9BgJlofJ6', 'moussa', 'orbit.jpeg'),
(6, '07/12/2020', 'D@gmail.com', 1, '$2a$10$4omwsSZYpp6LxHUtBekwDOMQXX31C/wAcwiYyZ4fBAng7pz6nJ.wa', 'mariam', ''),
(7, '07/12/2020', 'mbow@gmail.com', 1, '$2a$10$ubwaOJbC3wnUFPaOR6HdB.XcEdfXn3H4gDOJAvN5gI3WaypbZtfeK', 'cheikh', 'mareme.jpeg'),
(8, '07/12/2020', 'pis@gmail.com', 1, '$2a$10$AN/fNAWBSIdgCq146vF2JOunOmk45r4MvSWIsE7Mgj8oWXdxjk34a', 'papis', 'cheikh.jpeg'),
(9, '07/12/2020', 'mballo@gmail.com', 1, '$2a$10$0GSPhiru6WBHYaCCuLnul.udQmvpCVn4aqWiX3xPPLee6x2MLie8S', 'ousmane', 'moustaph.jpg'),
(10, '07/12/2020', 'niang@gmail.com', 1, '$2a$10$V2jzcJTwI/H2I6TO8vLCo.g4NB8ZYLGWOTVI7mwGVtkhGXVNfDuge', 'abdou', 'adn.jpg'),
(11, '08/12/2020', 'Mordiop@gmail.com', 1, '$2a$10$WMjO10/CE3KV7Cyyn07xb.yu4agTD8UN.dDGyGrwxcFM4Xk9edX96', 'mor', 'akhyar.jpg'),
(12, '08/12/2020', 'maremeFall@gmail.com', 1, '$2a$10$0Ya4GZNRmtCSmxKaSEpigu4R3j3PUVDhn1TPKEQu1VN/IrIQHPTTC', 'mareme', 'Emma.jpeg'),
(13, '08/12/2020', 'judith@gmail.com', 1, '$2a$10$kIt.DS4AE5GO8YbNLi5Qq.yD4uPKKsHOIhHKaC0GAgPbzn5TBxgp6', 'judith', NULL),
(14, '08/12/2020', 'Emma@gmail.com', 1, '$2a$10$CrvFUKo1Y.xCMymR0oEaf.r4CGozlgrtMBLIYOqYTmRvzcV4nrNw.', 'Emma', 'judith.jpeg'),
(15, '08/12/2020', 'penda@gmail.com', 1, '$2a$10$oxBkkb/hyUd/B.w3.R5jJu6aWikhTV9.6SjICV5KGp2ggfB01W/Fe', 'Penda', NULL),
(16, '08/12/2020', 'Momo@gmail.com', 1, '$2a$10$xpYM2xKz/mydbDk9p58TWuGkC3Pem5hY2ky8yPxSZKnUZrOxlHylq', 'momo', NULL),
(18, '23/12/2020', 'fama5@gmail.com', 1, '$2a$10$Z/o5FidYIthEK1/uonlJgOERVmAu.gwuoqol/tk..0rE5AktCVHhu', 'famasow', NULL),
(20, '24/12/2020', 'pablo5@gmail.com', 1, '$2a$10$WsXY4OHVegcPIqWkrRI9G.vi21oR5Mbu6jggZ3bBr536Mkhwyy9Um', 'pablo', NULL),
(21, '30/12/2020', 'orbit12@gmail.com', 1, '$2a$10$UO10wasCYtsaMO5H6GnMJeO4U3/.Z1fyR.XfKo8Pc1PFPBghm6vz.', 'orbitturner@gmail.com', NULL),
(22, '07/01/2020', 'aida5@gmail.com', 1, '$2a$10$.XgRt2Lb7eL1mS/7nHDBTOz6dzKxpX3qXF6kV12Bc.qkGfDfkKL1u', 'aida15', NULL),
(23, '07/01/2020', 'khady122@gmail.com', 1, '$2a$10$Nihc5c4pbzFr3PrW2v.6luebbLLRYH1sQ90D2ZWI2..fZzC1hwPgq', 'khady15', NULL),
(24, '07/01/2020', 'marie@gmail.com', 1, '$2a$10$yDjqbxOJKn6Vn06Cpz7O.O9FJRZ5lcEcZ/qmxikd.4qnaFXmuIGxS', 'marie15', NULL),
(25, '07/01/2020', 'lamine159@gmail.com', 1, '$2a$10$5g69q3qwyzaRBsIcLbb3ceQLN9P0UZiCVr6JnUgQiHcgih9jKSKoy', 'lamine24', NULL),
(26, '07/01/2020', 'mamadou25@gmail.com', 1, '$2a$10$T.qqvjtH8jnFaMLDEoSrCez4O0tOgtZvWNCigGnlfkYxTnxHB12aq', 'mamadou58', NULL),
(27, '07/01/2020', 'keita58@gmail.com', 1, '$2a$10$PkeHlcERCRj.UPMvH3g.7.248HquX8fr7KB96tyn1qlFH3Om0YbzC', 'keita26', NULL),
(28, '07/01/2020', 'ndiaye5@gmail.com', 1, '$2a$10$BklZ6v4XwZzZoj8uMKusv.KlE2CuN8YJJXoePoaG5XFBsrcMHuQy2', 'ndiaye98', NULL),
(29, '08/01/2020', 'cisse25@gmail.com', 1, '$2a$10$5tp.08SezyM8uVlJri2ao.FmoF726nPeMl80XoWrG5G.6ov4fe23y', 'cisse98', NULL),
(30, '12/01/2020', 'orienta15@gmail.com', 1, '$2a$10$TC/zhPSiBq1acyMopjC3B.x0cZJiOgN0.Lxa5Z/WRJiREheFWMhgm', 'Orienta12', NULL),
(31, '12/01/2020', 'karaba15@gmail.com', 1, '$2a$10$BwLbcB3KcNYg1zBi8YqZyuC6GHsCVG3CFE4WNcrx/GgbqEDYfzCY6', 'Karaba128', NULL),
(32, '12/01/2020', 'ngorseck15@gmail.com', 1, '$2a$10$VWetLGz2/2rQ88xEw/Ridet7MfRbBVIP8IEJmKsbLh.oYYWYZsqVu', 'Ngor128', NULL),
(33, '12/01/2020', 'ngorseckS15@gmail.com', 1, '$2a$10$A6Z9zhg0sTeJfK7zf.FUPOWEtwtgFNp07Vmjljtht32iWdPCauloC', 'Ngor18', NULL),
(34, '24/01/2020', 'Grenoble15@gmail.com', 1, '$2a$10$9j8nhR/WnDn8V9SOWD7idu.5nC2yALeg6BWyNYRUUX.38HDli8Hxu', 'Grenoble78', 'grenoble.jpg'),
(35, '24/01/2020', 'Bordeaux56@gmail.com', 1, '$2a$10$PgD0hXcEqKDrV.qFtgjA1OHsHH0GQiKT9ONDV3Xj.FcS0GZhlQ5Ky', 'Bordeaux78', 'bordeaux.jpg'),
(36, '24/01/2020', 'AixMarseille15@gmail.com', 1, '$2a$10$YDeHvmjbHuzk8YDy.a/H2e1VUck.LMn7gDfMbpWIvrs2bkYv2hv06', 'AixMarseille22', 'aix-marseille.jpg'),
(37, '28/01/2020', 'malick266@gmail.com', 1, '$2a$10$McAPIwtwLY.gM4Rf53bSY.adOBQ8qUzFeq35URkpu5ZruA3QQ9n3i', 'Malick128', NULL),
(38, '28/01/2020', 'ndeye58@gmail.com', 1, '$2a$10$S/UJxiS6Uyn9KfykptwW5urkmdatnMzywYFGP1Vbta5DKfTPaXHZS', 'Ndeye18', NULL),
(39, '28/01/2020', 'penda54@gmail.com', 1, '$2a$10$jTKltJewvTdAMZzJiijDIeARZIxCvL7cJeIEu9koveJjfbeP3yP8C', 'Penda12', NULL),
(40, '28/01/2020', 'amina85@gmail.com', 1, '$2a$10$eHI43EHWecr3cwfWZiyao.Xhucv41GfdBtkuJ1wL8WbdoU3AxypUy', 'Amina987', NULL),
(41, '28/01/2020', 'assane15@gmail.com', 1, '$2a$10$vB6tmRL/ph/tr.ql2ORP0OF1/RD0fp/BoXsbvOnIAODQAAI1lKyre', 'Assane566', NULL),
(42, '28/01/2020', 'alioune31@gmail.com', 1, '$2a$10$k1mS9mgnouvMddYBMdP9S.eQ2KNtdcXo.xCFvDdNQ76HnxSwOeTEy', 'Alioune66', NULL),
(43, '28/01/2020', 'baba195@gmail.com', 1, '$2a$10$rmxZ0X09otMJ1ecKPTBXeeZdfJHVGqOmzKmH4.ScR0Iu5s2bwrlZS', 'Baba963', NULL),
(44, '01/02/2020', 'diarys195@gmail.com', 1, '$2a$10$jZdQf1C6rQMi3U1iBRZmaeKTHz28fz2WGXM5kYRE3RrWSV01TmLHW', 'Diary973', NULL),
(47, '14/02/2020', 'louislegrand@gmail.com', 0, '@Grand9685', 'louis2586H', 'louis.jpg'),
(48, '14/02/2020', 'bambey@gmail.com', 0, '@Bambey589', 'Bambey256', 'uadb.jpeg'),
(49, '03/02/2021', 'adn88@gmail.com', 1, '@Adn58990', 'adn1589', NULL),
(50, '04/02/2021', 'samba88@gmail.com', 1, '@Samba987', 'samba158', NULL),
(51, '04/02/2021', 'Assane188@gmail.com', 1, '$2a$10$UVqxrto7TjioVOcOMeep9ubFBJMFqrfTSWmndhFijhniEOuXsWsFq', 'Assane180', NULL),
(52, '05/02/2021', 'coumbis88@gmail.com', 1, '$2a$10$auST98w4MmwytS/goRSCUu.xH7RyAfmKU3JHA/sMpWWQsW3yQaLpO', 'coumba9632', NULL),
(53, '05/02/2021', 'coumbis88@gmail.com', 1, '$2a$10$JxarhtHDQeXooMjLBTcxEu9UsD1xJdmJxMqbgPpwdyRtzHeltEjlu', 'coumba9632', NULL),
(54, '05/02/2021', 'coumbs8@gmail.com', 1, '$2a$10$R84EV36GfmraW.gTM919me3lvrThsAnVH.BBXa0ETfIlYTnq50KRu', 'coumba632', NULL),
(55, '05/02/2021', 'ghygyg58@gmail.com', 1, '$2a$10$Rkbbvh1PQa0bWFxPkRArheLGmnmKHNWeJMjB8pVNcsaDgwTjIA9.e', 'cgggg632', NULL),
(56, '05/02/2021', 'ghyg568@gmail.com', 1, '$2a$10$N2Aa84t4XY2CpQ5mDgpbV.zBbsr0WNarQgRa71VM7TN8kubd9oYmO', 'cg44g632', NULL),
(57, '05/02/2021', 'ghbhhbb568@gmail.com', 1, '$2a$10$10.Ag4cz9gq1duJh.qpDIOwBVuwbV2ExZnaPy7ek9HOhWrYvuPXoi', 'cg426032', NULL),
(58, '05/02/2021', 'hbdjhd89@gmail.com', 1, '$2a$10$YGErcVaHNrB0m6lb9ZzSWu5ow.8UK1dZygwzDKTIN4BmoVzkezF9S', 'bhbgdhcyd89', NULL),
(59, '05/02/2021', '255hhhh@gmail.com', 1, '$2a$10$KENg1X5t0xP7tscYzR5zRu9q0/eEwYFhDAJorvsxWV7C.fU7fO8/C', 'bhgbyhg369', NULL),
(62, '14/02/2020', 'jcnjncn@gmail.com', 0, '$2a$10$u4ulcLgFjWGQDShJlkxhBeOI8uNWkGkRcQ.VqpwFi3FDVrvl4c27q', 'nccnncn1', NULL),
(63, '10/02/2020', 'strasbourg195@gmail.com', 1, '$2a$10$tZyLpxug4.g/ZMbyJlD/KeWd2CECMSSIfsLi5t8zi7yuNg7RxHV5y', 'Strasbourg973', 'strasbourg.jpg'),
(64, '10/02/2020', 'lorraine195@gmail.com', 1, '$2a$10$ztllTMzYLP9yHQj6xOJVpey1pXIjoUQwcjjpFr4oU4puDOLnF4QWC', 'Lorraine973', 'univ-lorraine.jpg'),
(65, '10/02/2020', 'sorbonne195@gmail.com', 1, '$2a$10$xufICEmYLqFkJQivw4LbB.Tbm2xTeBxtLKwM0vXqRLsJQ3ruVjlwa', 'Sorbonne973', 'sorbonne.png'),
(66, '10/02/2020', 'ecolensup195@gmail.com', 1, '$2a$10$bKYrdfFJHwZt1cY7ORT3KOIKCuYn3MjznSL55TUscFKCI4vgBJvvu', 'Ensup973', 'ecolenormalsup.jpg'),
(67, '10/02/2020', 'americanup195@gmail.com', 1, '$2a$10$Tll6cd0YZv37piDiRRs6Gefo7Uc6DnsJ13RafOQJ.vr/fIcv9IzJO', 'Americanup973', 'Universite-du-Quebec-en-Abitibi-Temiscamingue-web-960.jpg'),
(68, '10/02/2020', 'psl195@gmail.com', 1, '$2a$10$Z2Wa8ADII5OInpwavA5TceOMeRqIlwGQ3oEOpreSGJUWeUDG7uXF.', 'Psl973', 'Logo_UGB_-_Sénégal.png'),
(69, '10/02/2020', 'greno195@gmail.com', 1, '$2a$10$1a7ziFr156p93yFtYEWCmOITvQr7U329jmKMXenfW70HwNT.Py14q', 'Greno973', 'Logo_de_l\'université_de_Thiès.jpg'),
(70, '03/03/2020', 'sofama15@gmail.com', 1, '$2a$10$HYn4K/ZscWSpgujphojmlOVGIwRgDd4m0VMX46pb.tDPnYsNJ.LfW', 'FamaS168', 'fs.jpg'),
(71, '31/03/2021', 'dija15@gmail.com', 1, '$2a$10$DBBQUfnknukK2l0aO4fQle1meyFV8Gdwg6bDGL/lXzHTh7I.eJC0W', 'dija15', NULL),
(72, '07/04/2021', 'cbhdbcf@gmail.com', 1, '$2a$10$X48lS4JDP6YwjM7PQiFpIeka.pBmMSnaVd77FnG.O9JFVvp9fvPW2', 'cbhdbvhcbd', 'Capture d’écran de 2020-11-17 09-43-36.png'),
(73, '07/04/2021', 'quebec@gmail.com', 1, '$2a$10$w.siHWW5uMOJhHBFr5cJgeCi5FtQqnG7cm6Le3wSRXKn78RfRMz/q', 'quebec123', 'Universite-du-Quebec-en-Abitibi-Temiscamingue-web-960.jpg'),
(74, '08/04/2021', 'unisl@gmail.com', 1, '$2a$10$iEBAmWDHZlI/qaJYIz9Y8OK5y0wd.6Conr9tRo8ySo3hq4MkIMa5.', 'universite', 'Universite-du-Quebec-en-Abitibi-Temiscamingue-web-960.jpg'),
(75, '08/04/2021', 'ndiayeaida@gmail.com', 1, '$2a$10$PTdUl4tbe1taY9ViFSNRJOhYiCS2BaayO8GN//bKXqu/ib.SXED.y', 'Aidaa589', 'fs.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `user_roles`
--

CREATE TABLE `user_roles` (
  `users_id` int(11) NOT NULL,
  `roles_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `user_roles`
--

INSERT INTO `user_roles` (`users_id`, `roles_id`) VALUES
(1, 1),
(2, 2),
(3, 1),
(15, 4),
(16, 4),
(18, 4),
(20, 2),
(21, 1),
(22, 1),
(23, 1),
(24, 1),
(25, 1),
(26, 1),
(27, 1),
(28, 1),
(29, 2),
(21, 4),
(30, 4),
(32, 1),
(33, 1),
(34, 3),
(35, 3),
(36, 3),
(37, 2),
(38, 2),
(39, 2),
(40, 2),
(41, 2),
(42, 2),
(43, 2),
(44, 2),
(49, 2),
(50, 2),
(51, 2),
(52, 2),
(53, 2),
(54, 2),
(55, 2),
(56, 2),
(57, 2),
(58, 2),
(59, 2),
(62, 4),
(63, 3),
(64, 3),
(65, 3),
(66, 3),
(67, 3),
(68, 3),
(69, 3),
(31, 2),
(70, 1),
(71, 2),
(72, 4),
(73, 4),
(74, 4),
(75, 2);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `agent`
--
ALTER TABLE `agent`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKneqbqf7p5lfvciwroct25kasc` (`user_id`);

--
-- Index pour la table `demande`
--
ALTER TABLE `demande`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkinkv61pg1uokjmypydvw34p6` (`universite_id`),
  ADD KEY `FK9tcc14bdi6y9vexydub2vj92x` (`entretien_id`),
  ADD KEY `FKde4xdairy25na95017owjmukj` (`etudiant_id`),
  ADD KEY `FK3nqyk8ko1i2ttpx3ygw04betl` (`formation_id`),
  ADD KEY `FKou7prxar9ij2bqh9tw4qvq1t7` (`paiement_id`),
  ADD KEY `FKohs53qiorlqc2703cf75yqbhv` (`dossier_etudiant_id`);

--
-- Index pour la table `domaine_formation`
--
ALTER TABLE `domaine_formation`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `dossier_etudiant`
--
ALTER TABLE `dossier_etudiant`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf4shn680gi74x5lmxk49e1pn` (`etudiant_id`),
  ADD KEY `FKpvx8wg5vv42frjr1nq98pi71v` (`etat_dossier_id`);

--
-- Index pour la table `entretien`
--
ALTER TABLE `entretien`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `etat_dossier`
--
ALTER TABLE `etat_dossier`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK95uv9fy15rj1o5f5mae0eoy8f` (`user_id`),
  ADD KEY `FKd7thne1spbd4w2xfsyr3k9qa4` (`type_piece_id`);

--
-- Index pour la table `fichiers_dossiers`
--
ALTER TABLE `fichiers_dossiers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf2sk7ku0gnefkfho2gm0jed5l` (`dossier_etudiant_id`);

--
-- Index pour la table `formation`
--
ALTER TABLE `formation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmlec293nghdu29k1yibioedjh` (`domaine_formation_id`),
  ADD KEY `FKpk6jvpx0x5eejv4kcwwqa09wc` (`universite_id`),
  ADD KEY `FK2qx01op7ect7ovesm9xk6v7qb` (`niveau_id`),
  ADD KEY `FKromq2vc7upmnqp7y66ax15w37` (`type_formations_id`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb3y6etti1cfougkdr0qiiemgv` (`user_id`);

--
-- Index pour la table `niveau`
--
ALTER TABLE `niveau`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `parcours`
--
ALTER TABLE `parcours`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK882fmp84voiah1463s0amywh8` (`etudiant_id`);

--
-- Index pour la table `pays`
--
ALTER TABLE `pays`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `top_universite`
--
ALTER TABLE `top_universite`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_l6b88odo8svdf3sf6wehj9qsl` (`position`),
  ADD KEY `FKph56mjfesq40tpsjoyyu491yg` (`universite_id`);

--
-- Index pour la table `type_formations`
--
ALTER TABLE `type_formations`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `type_piece`
--
ALTER TABLE `type_piece`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `universite`
--
ALTER TABLE `universite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmpxg68dkrptrjrcc2do2ukeba` (`user_id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user_roles`
--
ALTER TABLE `user_roles`
  ADD KEY `FKj9553ass9uctjrmh0gkqsmv0d` (`roles_id`),
  ADD KEY `FK7ecyobaa59vxkxckg6t355l86` (`users_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `agent`
--
ALTER TABLE `agent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT pour la table `demande`
--
ALTER TABLE `demande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT pour la table `domaine_formation`
--
ALTER TABLE `domaine_formation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `dossier_etudiant`
--
ALTER TABLE `dossier_etudiant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT pour la table `entretien`
--
ALTER TABLE `entretien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT pour la table `etat_dossier`
--
ALTER TABLE `etat_dossier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
--
-- AUTO_INCREMENT pour la table `fichiers_dossiers`
--
ALTER TABLE `fichiers_dossiers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `formation`
--
ALTER TABLE `formation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT pour la table `niveau`
--
ALTER TABLE `niveau`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `paiement`
--
ALTER TABLE `paiement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT pour la table `parcours`
--
ALTER TABLE `parcours`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `pays`
--
ALTER TABLE `pays`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=250;
--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `top_universite`
--
ALTER TABLE `top_universite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `type_formations`
--
ALTER TABLE `type_formations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `type_piece`
--
ALTER TABLE `type_piece`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `universite`
--
ALTER TABLE `universite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `agent`
--
ALTER TABLE `agent`
  ADD CONSTRAINT `FKneqbqf7p5lfvciwroct25kasc` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `demande`
--
ALTER TABLE `demande`
  ADD CONSTRAINT `FK3nqyk8ko1i2ttpx3ygw04betl` FOREIGN KEY (`formation_id`) REFERENCES `formation` (`id`),
  ADD CONSTRAINT `FK9tcc14bdi6y9vexydub2vj92x` FOREIGN KEY (`entretien_id`) REFERENCES `entretien` (`id`),
  ADD CONSTRAINT `FKde4xdairy25na95017owjmukj` FOREIGN KEY (`etudiant_id`) REFERENCES `etudiant` (`id`),
  ADD CONSTRAINT `FKkinkv61pg1uokjmypydvw34p6` FOREIGN KEY (`universite_id`) REFERENCES `universite` (`id`),
  ADD CONSTRAINT `FKohs53qiorlqc2703cf75yqbhv` FOREIGN KEY (`dossier_etudiant_id`) REFERENCES `dossier_etudiant` (`id`),
  ADD CONSTRAINT `FKou7prxar9ij2bqh9tw4qvq1t7` FOREIGN KEY (`paiement_id`) REFERENCES `paiement` (`id`);

--
-- Contraintes pour la table `dossier_etudiant`
--
ALTER TABLE `dossier_etudiant`
  ADD CONSTRAINT `FKf4shn680gi74x5lmxk49e1pn` FOREIGN KEY (`etudiant_id`) REFERENCES `etudiant` (`id`),
  ADD CONSTRAINT `FKpvx8wg5vv42frjr1nq98pi71v` FOREIGN KEY (`etat_dossier_id`) REFERENCES `etat_dossier` (`id`);

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `FK95uv9fy15rj1o5f5mae0eoy8f` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKd7thne1spbd4w2xfsyr3k9qa4` FOREIGN KEY (`type_piece_id`) REFERENCES `type_piece` (`id`);

--
-- Contraintes pour la table `fichiers_dossiers`
--
ALTER TABLE `fichiers_dossiers`
  ADD CONSTRAINT `FKf2sk7ku0gnefkfho2gm0jed5l` FOREIGN KEY (`dossier_etudiant_id`) REFERENCES `dossier_etudiant` (`id`);

--
-- Contraintes pour la table `formation`
--
ALTER TABLE `formation`
  ADD CONSTRAINT `FK2qx01op7ect7ovesm9xk6v7qb` FOREIGN KEY (`niveau_id`) REFERENCES `niveau` (`id`),
  ADD CONSTRAINT `FKmlec293nghdu29k1yibioedjh` FOREIGN KEY (`domaine_formation_id`) REFERENCES `domaine_formation` (`id`),
  ADD CONSTRAINT `FKpk6jvpx0x5eejv4kcwwqa09wc` FOREIGN KEY (`universite_id`) REFERENCES `universite` (`id`),
  ADD CONSTRAINT `FKromq2vc7upmnqp7y66ax15w37` FOREIGN KEY (`type_formations_id`) REFERENCES `type_formations` (`id`);

--
-- Contraintes pour la table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `FKb3y6etti1cfougkdr0qiiemgv` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `parcours`
--
ALTER TABLE `parcours`
  ADD CONSTRAINT `FK882fmp84voiah1463s0amywh8` FOREIGN KEY (`etudiant_id`) REFERENCES `etudiant` (`id`);

--
-- Contraintes pour la table `top_universite`
--
ALTER TABLE `top_universite`
  ADD CONSTRAINT `FKph56mjfesq40tpsjoyyu491yg` FOREIGN KEY (`universite_id`) REFERENCES `universite` (`id`);

--
-- Contraintes pour la table `universite`
--
ALTER TABLE `universite`
  ADD CONSTRAINT `FKmpxg68dkrptrjrcc2do2ukeba` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FK7ecyobaa59vxkxckg6t355l86` FOREIGN KEY (`users_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKj9553ass9uctjrmh0gkqsmv0d` FOREIGN KEY (`roles_id`) REFERENCES `role` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
