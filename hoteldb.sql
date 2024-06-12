create database HotelDb;
use HotelDb;
CREATE TABLE `Client` (
  `Id` int PRIMARY KEY AUTO_INCREMENT,
  `Name` varchar(255),
  `LastName` varchar(255),
  `Country` varchar(255),
  `Phone` varchar(200),
  `Email` varchar(255)
);
CREATE TABLE `Room` (
  `Id` int PRIMARY KEY AUTO_INCREMENT,
  `RoomNumber` varchar(255),
  `RoomType` varchar(20),
  `NightCost` double,
  `State` varchar(255)
);
CREATE TABLE `Reservation` (
  `Id` int PRIMARY KEY AUTO_INCREMENT,
  `CheckInDate` datetime,
  `CheckOutDate` datetime,
  `State` varchar(255),
  `IdClient` int,
  `IdRoom` int
);

CREATE TABLE `Pay` (
  `Id` int PRIMARY KEY AUTO_INCREMENT,
  `Mount` double,
  `PaymentDate` datetime,
  `PaymentMethod` varchar(255),
  `IdReservation` int
);
ALTER TABLE `Reservation` ADD FOREIGN KEY (`IdClient`) REFERENCES `Client` (`Id`);
ALTER TABLE `Reservation` ADD FOREIGN KEY (`IdRoom`) REFERENCES `Room` (`Id`);
ALTER TABLE `Pay` ADD FOREIGN KEY (`IdReservation`) REFERENCES `Reservation` (`Id`);
