-- MySQL dump 10.13  Distrib 8.0.37, for Linux (x86_64)
--
-- Host: localhost    Database: mediClinicDB
-- ------------------------------------------------------
-- Server version	8.0.37-0ubuntu0.22.04.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `doctor_id` varchar(36) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `experience` int NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `license_number` int NOT NULL,
  `office_hours` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `specialty` enum('CARDIOLOGIA','DERMATOLOGIA','GINECOLOGIA','NEUROLOGIA','OFTALMOLOGIA','ONCOLOGÍA','ORTOPEDIA','PEDRIATRIA','PSIQUIATRIA') DEFAULT NULL,
  PRIMARY KEY (`doctor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_history`
--

DROP TABLE IF EXISTS `medical_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_history` (
  `medical_history_id` varchar(36) NOT NULL,
  `age` int NOT NULL,
  `alcohol_consumption` bit(1) DEFAULT NULL,
  `allergies` varchar(255) DEFAULT NULL,
  `blood_pressure` varchar(255) DEFAULT NULL,
  `breathing_frequency` int NOT NULL,
  `care_plan` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `civil_status` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `current_medication` varchar(255) DEFAULT NULL,
  `date_of_elaboration` date DEFAULT NULL,
  `diagnosis` varchar(255) DEFAULT NULL,
  `diet` bit(1) DEFAULT NULL,
  `doctors_notes` varchar(255) DEFAULT NULL,
  `drugs` bit(1) DEFAULT NULL,
  `emergency_contact_first_name` varchar(255) DEFAULT NULL,
  `emergency_contact_last_name` varchar(255) DEFAULT NULL,
  `emergency_contact_phone_number` varchar(255) DEFAULT NULL,
  `emergency_contact_relationship` varchar(255) DEFAULT NULL,
  `exercise` bit(1) DEFAULT NULL,
  `gender` varchar(10) NOT NULL,
  `heart_rate` int NOT NULL,
  `hospitalizations` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `occupation` varchar(255) DEFAULT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `previous_illnesses` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `surgeries` varchar(255) DEFAULT NULL,
  `symptoms` varchar(255) DEFAULT NULL,
  `temperature` float NOT NULL,
  `tobacco` bit(1) DEFAULT NULL,
  `patient_patient_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`medical_history_id`),
  UNIQUE KEY `UK15x55ledlg9fv9ivon9ofejnv` (`patient_patient_id`),
  CONSTRAINT `FK15o92gni8by8qht55nf24dk0n` FOREIGN KEY (`patient_patient_id`) REFERENCES `patient` (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_history`
--

LOCK TABLES `medical_history` WRITE;
/*!40000 ALTER TABLE `medical_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `patient_id` varchar(36) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` enum('FEMENINO','MASCULINO','OTRO') DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `medical_history_medical_history_id` varchar(36) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `UKpc93j03nigr23e6ekdx045n8d` (`medical_history_medical_history_id`),
  CONSTRAINT `FKnkn6w5u1nqlbs6984iag13utd` FOREIGN KEY (`medical_history_medical_history_id`) REFERENCES `medical_history` (`medical_history_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_doctor`
--

DROP TABLE IF EXISTS `patient_doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_doctor` (
  `patient_id` varchar(36) NOT NULL,
  `doctor_id` varchar(36) NOT NULL,
  KEY `FKn9ydvc6pvgp7id3s7q63ik6xj` (`doctor_id`),
  KEY `FKtmtnhw88h1tnjg6i8pa6i3qao` (`patient_id`),
  CONSTRAINT `FKn9ydvc6pvgp7id3s7q63ik6xj` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`),
  CONSTRAINT `FKtmtnhw88h1tnjg6i8pa6i3qao` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_doctor`
--

LOCK TABLES `patient_doctor` WRITE;
/*!40000 ALTER TABLE `patient_doctor` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient_doctor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-18 20:24:03
