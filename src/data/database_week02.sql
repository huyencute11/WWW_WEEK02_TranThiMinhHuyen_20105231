-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               8.0.34 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for dbweek02
CREATE DATABASE IF NOT EXISTS `dbweek02` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dbweek02`;


-- Dumping data for table dbweek02.customer: ~5 rows (approximately)
DELETE FROM `customer`;
INSERT INTO `customer` (`cust_id`, `address`, `cust_name`, `email`, `phone`) VALUES
	(1, 'Ho Chi Minh', 'Nguyen Thanh Trung', 'Trung@gmail.com', '0945786321'),
	(2, 'Go Vap, Ho Chi Minh', 'Le Van Minh', 'minhle@gmail.com', '0178963254'),
	(3, 'Phu Nhuan, Ho Chi Minh', 'Nguyen Van Anh', 'nguyenanh@gmail.com', '0387594863'),
	(4, 'Ho Van Hue, Phu Nhuan', 'Nguyen Thanh Tam', 'tam1999@gmail.com', '0896357159'),
	(5, '4 Nguyễn Văn Bảo, phường 1, Gò Vấp', 'Đỗ Quốc Tuấn', 'tuando@gmail.com', '0456897153'),
	(6, 'Phu Nhuan, Ho Chi Minh', 'Nguyen Quang Trung', 'QuangTrung@gmail.com', '0387594863'),
	(7, 'Phu Nhuan, Ho Chi Minh', 'Le Minh', 'Minh@gmail.com', '0387596523');

-- Dumping data for table dbweek02.employee: ~4 rows (approximately)
DELETE FROM `employee`;
INSERT INTO `employee` (`emp_id`, `address`, `dob`, `email`, `full_name`, `phone`, `status`) VALUES
	(1, 'Nguyen Van Bao, Go Vap', '2002-09-20', 'tuanh@gmail.com', 'Nguyen Tu Anh', '0984253756', 1),
	(2, 'Le Loi, Go Vap', '2002-11-04', 'nganle@gmail.com', 'Le Thanh Ngan', '0475689123', 1),
	(3, 'Ho Van Hue, Phu Nhuan', '2000-09-26', 'thanhtu2000@gmail.com', 'Nguyen Thanh Tu', '0389756321', 1),
	(4, 'Gò Vấp, Hồ Chí Minh', '2002-11-11', 'ttminhuyen1111@gmail.com', 'Trần Thị Minh Huyền', '0384601453', 1);

-- Dumping data for table dbweek02.order: ~6 rows (approximately)
DELETE FROM `order`;
INSERT INTO `order` (`order_id`, `order_date`, `cust_id`, `emp_id`) VALUES
	(1, '2023-09-14', 1, 3),
	(2, '2023-09-15', 2, 1),
	(3, '2023-09-16', 1, 2),
	(4, '2023-09-15', 3, 4),
	(5, '2023-09-21', 5, 1),
	(6, '2023-09-14', 5, 4);

-- Dumping data for table dbweek02.order_detail: ~1 rows (approximately)
DELETE FROM `order_detail`;
INSERT INTO `order_detail` (`note`, `price`, `quantity`, `order_id`, `product_id`) VALUES
	(NULL, 40000, 2, 1, 1),
	('ngon', 23000, 1, 1, 7),
	(NULL, 60000, 1, 2, 3),
	(NULL, 50000, 3, 2, 4);

-- Dumping data for table dbweek02.product: ~8 rows (approximately)
DELETE FROM `product`;
INSERT INTO `product` (`product_id`, `description`, `manufacturer_name`, `name`, `status`, `unit`) VALUES
	(1, 'Tốt cho sức khỏe', 'Việt Nam', 'Nước ép ổi', 1, NULL),
	(2, 'Tốt cho sức khỏe', 'Việt Nam', 'Nước ép cóc', 1, NULL),
	(3, 'Giusp đẹp da', 'Việt Nam', 'Nước ép lựu', 1, NULL),
	(4, 'Cải thiện làn da', 'Việt Nam', 'Nước ép dưa hấu', 1, NULL),
	(5, 'Làm mát ', 'Việt Nam', 'Nước bạc hà mix cà phê', 1, NULL),
	(6, 'Dịu nhẹ cơ thể', 'Việt Nam', 'Nước ép cam', 1, NULL),
	(7, 'Tỉnh táo', 'Việt Nam', 'Cà phê Sài Gòn', 1, NULL),
	(8, 'Sinh to bo rat tot cho suc khoe', 'Việt Nam', 'Sinh to bo', 1, 'sinh to'),
	(9, 'Sinh to bo rat tot cho suc khoe', 'Việt Nam', 'Sinh to bo', 1, 'sinh to'),
	(10, 'Sinh to bo rat tot cho suc khoe', 'Việt Nam', 'Sinh to bo', 1, 'sinh to');

-- Dumping data for table dbweek02.product_image: ~6 rows (approximately)
DELETE FROM `product_image`;
INSERT INTO `product_image` (`image_id`, `alternative`, `path`, `product_id`) VALUES
	(1, NULL, 'https://cdn.tgdd.vn/Files/2020/10/23/1301299/5-cach-lam-nuoc-ep-dua-hau-cuc-ngon-don-gian-tai-nha-202010231109233490.jpg', 1),
	(2, NULL, 'https://cdn.tgdd.vn/Files/2018/12/06/1136059/10-cong-dung-tuyet-voi-tu-nuoc-ep-cam-ban-nen-biet-201909031955386376.jpg', 2),
	(3, NULL, 'https://cdn.tgdd.vn/2021/05/CookRecipe/GalleryStep/thanh-pham-1045.jpg', 3),
	(4, NULL, 'https://media-cdn-v2.laodong.vn/Storage/NewsPortal/2021/1/4/867734/Oi.jpg', 4),
	(5, NULL, 'https://dvpmarket.com/resources/uploads/images/2018/11/Nuoc-ep-luu-do-tran-day-vitamin.jpg', 5),
	(6, NULL, 'https://i.pinimg.com/originals/8a/61/8e/8a618e9b39d38146e05df0982e3ffe42.jpg', 7);

-- Dumping data for table dbweek02.product_price: ~8 rows (approximately)
DELETE FROM `product_price`;
INSERT INTO `product_price` (`price_date_time`, `note`, `price`, `product_id`) VALUES
	('2023-08-23', NULL, 20000, 1),
	('2023-08-24', NULL, 25000, 5),
	('2023-08-25', NULL, 24000, 1),
	('2023-09-13', NULL, 30000, 3),
	('2023-09-13', NULL, 23000, 7),
	('2023-09-16', NULL, 25000, 6),
	('2023-09-18', NULL, 25000, 2),
	('2023-09-20', NULL, 25000, 4);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
