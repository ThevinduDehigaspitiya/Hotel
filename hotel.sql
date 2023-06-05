-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.29 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for hotel
CREATE DATABASE IF NOT EXISTS `hotel` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hotel`;

-- Dumping structure for table hotel.bill
CREATE TABLE IF NOT EXISTS `bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `booking_id` int NOT NULL,
  `guest_id` int NOT NULL,
  `payment_type_id` int NOT NULL,
  `payment` double NOT NULL,
  `balance` double NOT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bill_booking1_idx` (`booking_id`),
  KEY `fk_bill_guest1_idx` (`guest_id`),
  KEY `fk_bill_payment_type1_idx` (`payment_type_id`),
  CONSTRAINT `fk_bill_booking1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`),
  CONSTRAINT `fk_bill_guest1` FOREIGN KEY (`guest_id`) REFERENCES `guest` (`id`),
  CONSTRAINT `fk_bill_payment_type1` FOREIGN KEY (`payment_type_id`) REFERENCES `payment_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel.bill: ~0 rows (approximately)

-- Dumping structure for table hotel.booking
CREATE TABLE IF NOT EXISTS `booking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `booking_date` date NOT NULL,
  `booking_time` varchar(10) NOT NULL,
  `arrival_date` date NOT NULL,
  `arrival_time` varchar(10) NOT NULL,
  `departure_date` date NOT NULL,
  `departure_time` varchar(10) NOT NULL,
  `num_guest` int NOT NULL,
  `rooms_id` int NOT NULL,
  `special_req` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_booking_rooms1_idx` (`rooms_id`),
  CONSTRAINT `fk_booking_rooms1` FOREIGN KEY (`rooms_id`) REFERENCES `rooms` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel.booking: ~0 rows (approximately)

-- Dumping structure for table hotel.category
CREATE TABLE IF NOT EXISTS `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel.category: ~0 rows (approximately)

-- Dumping structure for table hotel.city
CREATE TABLE IF NOT EXISTS `city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `city` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel.city: ~0 rows (approximately)

-- Dumping structure for table hotel.company
CREATE TABLE IF NOT EXISTS `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company` varchar(50) NOT NULL,
  `contact_no` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel.company: ~0 rows (approximately)

-- Dumping structure for table hotel.country
CREATE TABLE IF NOT EXISTS `country` (
  `id` int NOT NULL AUTO_INCREMENT,
  `country` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel.country: ~0 rows (approximately)

-- Dumping structure for table hotel.department
CREATE TABLE IF NOT EXISTS `department` (
  `id` int NOT NULL AUTO_INCREMENT,
  `department` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel.department: ~1 rows (approximately)
INSERT INTO `department` (`id`, `department`) VALUES
	(1, 'A');

-- Dumping structure for table hotel.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `nic` varchar(15) NOT NULL,
  `gender_id` int NOT NULL,
  `dob` date NOT NULL,
  `contact_no` varchar(15) NOT NULL,
  `address` varchar(70) NOT NULL,
  `city_id` int NOT NULL,
  `department_id` int NOT NULL,
  `employee_type_id` int NOT NULL,
  `salary` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee_department1_idx` (`department_id`),
  KEY `fk_employee_employee_type1_idx` (`employee_type_id`),
  KEY `fk_employee_city1_idx` (`city_id`),
  KEY `fk_employee_gender1_idx` (`gender_id`),
  CONSTRAINT `fk_employee_city1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `fk_employee_department1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `fk_employee_employee_type1` FOREIGN KEY (`employee_type_id`) REFERENCES `employee_type` (`id`),
  CONSTRAINT `fk_employee_gender1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel.employee: ~0 rows (approximately)

-- Dumping structure for table hotel.employee_type
CREATE TABLE IF NOT EXISTS `employee_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel.employee_type: ~1 rows (approximately)
INSERT INTO `employee_type` (`id`, `type`) VALUES
	(1, 'Admin');

-- Dumping structure for table hotel.gender
CREATE TABLE IF NOT EXISTS `gender` (
  `id` int NOT NULL AUTO_INCREMENT,
  `gender` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel.gender: ~0 rows (approximately)

-- Dumping structure for table hotel.grn
CREATE TABLE IF NOT EXISTS `grn` (
  `id` int NOT NULL AUTO_INCREMENT,
  `supplier_id` int NOT NULL,
  `Date` date NOT NULL,
  `quantity` varchar(45) NOT NULL,
  `payment_type_id` int NOT NULL,
  `payment` double NOT NULL,
  `balance` double NOT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grn_supplier1_idx` (`supplier_id`),
  KEY `fk_grn_payment_type1_idx` (`payment_type_id`),
  CONSTRAINT `fk_grn_payment_type1` FOREIGN KEY (`payment_type_id`) REFERENCES `payment_type` (`id`),
  CONSTRAINT `fk_grn_supplier1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel.grn: ~0 rows (approximately)

-- Dumping structure for table hotel.guest
CREATE TABLE IF NOT EXISTS `guest` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `nic` varchar(15) NOT NULL,
  `gender_id` int NOT NULL,
  `contact_no` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(70) NOT NULL,
  `city_id` int NOT NULL,
  `country_id` int NOT NULL,
  `booking_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_guest_city1_idx` (`city_id`),
  KEY `fk_guest_country1_idx` (`country_id`),
  KEY `fk_guest_gender1_idx` (`gender_id`),
  KEY `fk_guest_booking1_idx` (`booking_id`),
  CONSTRAINT `fk_guest_booking1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`),
  CONSTRAINT `fk_guest_city1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `fk_guest_country1` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  CONSTRAINT `fk_guest_gender1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel.guest: ~0 rows (approximately)

-- Dumping structure for table hotel.payment_type
CREATE TABLE IF NOT EXISTS `payment_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel.payment_type: ~0 rows (approximately)

-- Dumping structure for table hotel.rooms
CREATE TABLE IF NOT EXISTS `rooms` (
  `id` int NOT NULL AUTO_INCREMENT,
  `room_no` varchar(5) NOT NULL,
  `bed_count` varchar(45) NOT NULL,
  `type_id` int NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'Unbook',
  PRIMARY KEY (`id`),
  KEY `fk_rooms_rooms_type_idx` (`type_id`),
  CONSTRAINT `fk_rooms_rooms_type` FOREIGN KEY (`type_id`) REFERENCES `rooms_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel.rooms: ~0 rows (approximately)

-- Dumping structure for table hotel.rooms_type
CREATE TABLE IF NOT EXISTS `rooms_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel.rooms_type: ~0 rows (approximately)

-- Dumping structure for table hotel.stock
CREATE TABLE IF NOT EXISTS `stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `item` varchar(50) NOT NULL,
  `Category_id` int NOT NULL,
  `quantity` varchar(45) NOT NULL,
  `supplier_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_stock_Category1_idx` (`Category_id`),
  KEY `fk_stock_supplier1_idx` (`supplier_id`),
  CONSTRAINT `fk_stock_Category1` FOREIGN KEY (`Category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_stock_supplier1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel.stock: ~0 rows (approximately)

-- Dumping structure for table hotel.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(70) NOT NULL,
  `company_id` int NOT NULL,
  `contact_no` varchar(15) NOT NULL,
  `email` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_supplier_company1_idx` (`company_id`),
  CONSTRAINT `fk_supplier_company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel.supplier: ~0 rows (approximately)

-- Dumping structure for table hotel.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `department_id` int NOT NULL,
  `type_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_admin_department1_idx` (`department_id`),
  KEY `fk_admin_employee_type1_idx` (`type_id`),
  CONSTRAINT `fk_admin_department1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `fk_admin_employee_type1` FOREIGN KEY (`type_id`) REFERENCES `employee_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table hotel.user: ~2 rows (approximately)
INSERT INTO `user` (`id`, `username`, `password`, `department_id`, `type_id`) VALUES
	(1, 'Thevindu', '123', 1, 1),
	(2, 'Praveen', '456', 1, 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
