ALTER TABLE `PriceDB`.`currency` DROP PRIMARY KEY;

ALTER TABLE `PriceDB`.`pricerule` DROP PRIMARY KEY;

ALTER TABLE `PriceDB`.`shop` DROP PRIMARY KEY;

ALTER TABLE `PriceDB`.`pricerules` DROP PRIMARY KEY;

ALTER TABLE `PriceDB`.`shopbundle` DROP PRIMARY KEY;

ALTER TABLE `PriceDB`.`matching` DROP PRIMARY KEY;

ALTER TABLE `PriceDB`.`it4articles` DROP PRIMARY KEY;

ALTER TABLE `PriceDB`.`manufacturer` DROP PRIMARY KEY;

ALTER TABLE `PriceDB`.`product_type` DROP PRIMARY KEY;

ALTER TABLE `PriceDB`.`outputprice` DROP PRIMARY KEY;

ALTER TABLE `PriceDB`.`supplier` DROP PRIMARY KEY;

ALTER TABLE `PriceDB`.`supplierprice` DROP PRIMARY KEY;

DROP TABLE `PriceDB`.`supplier`;

DROP TABLE `PriceDB`.`shop`;

DROP TABLE `PriceDB`.`outputprice`;

DROP TABLE `PriceDB`.`matching`;

DROP TABLE `PriceDB`.`supplierprice`;

DROP TABLE `PriceDB`.`it4articles`;

DROP TABLE `PriceDB`.`currency`;

DROP TABLE `PriceDB`.`manufacturer`;

DROP TABLE `PriceDB`.`shopbundle`;

DROP TABLE `PriceDB`.`product_type`;

DROP TABLE `PriceDB`.`pricerules`;

DROP TABLE `PriceDB`.`pricerule`;



CREATE TABLE `PriceDB`.`supplier` (
	`Supplier_Id` BIGINT NOT NULL,
	`Supplier_Name` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`Supplier_Id`)
) ENGINE=InnoDB;

CREATE TABLE `PriceDB`.`shop` (
	`Shop_Id` BIGINT NOT NULL,
	`Shop_Name` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`Shop_Id`)
) ENGINE=InnoDB;

CREATE TABLE `PriceDB`.`outputprice` (
	`Id` BIGINT NOT NULL,
	`Shop_Id` BIGINT NOT NULL,
	`It4Profit_Article_Name` VARCHAR(100) NOT NULL,
	`It4Profit_Article_Price` DOUBLE,
	`Currency_Id` INT,
	PRIMARY KEY (`Id`)
) ENGINE=InnoDB;

CREATE TABLE `PriceDB`.`matching` (
	`Supplier_Id` BIGINT NOT NULL,
	`Supplier_Article_Name` VARCHAR(100) NOT NULL,
	`It4Prifit_Article_Name` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`It4Prifit_Article_Name`)
) ENGINE=InnoDB;

CREATE TABLE `PriceDB`.`supplierprice` (
	`Id` BIGINT NOT NULL,
	`Supplier_Id` BIGINT NOT NULL,
	`Supplier_Article_Name` VARCHAR(100) NOT NULL,
	`Supplier_Article_Description` VARCHAR(1024),
	`Supplier_Article_Price` DOUBLE,
	`Currency_Id` INT,
	PRIMARY KEY (`Id`)
) ENGINE=InnoDB;

CREATE TABLE `PriceDB`.`it4articles` (
	`It4Prifit_Article_Classcat` BIGINT,
	`It4Prifit_Article_Name` VARCHAR(100) NOT NULL,
	`It4Prifit_Article_Description` VARCHAR(1024),
	`Manufacturer_Id` BIGINT NOT NULL,
	`Product_Type_Id` BIGINT NOT NULL,
	`Fixed_Price` DOUBLE,
	`Fixed` BIT,
        `Quantity` INT,
        `Available_Status` INT,
	PRIMARY KEY (`It4Prifit_Article_Name`)
) ENGINE=InnoDB;

CREATE TABLE `PriceDB`.`currency` (
	`Currency_Id` INT NOT NULL,
	`Currency_Name` VARCHAR(50) NOT NULL,
	`Currency_Rate` DOUBLE,
	PRIMARY KEY (`Currency_Id`)
) ENGINE=InnoDB;

CREATE TABLE `PriceDB`.`manufacturer` (
	`Manufacturer_Id` BIGINT NOT NULL,
	`Manufacturer_Name` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`Manufacturer_Id`)
) ENGINE=InnoDB;

CREATE TABLE `PriceDB`.`shopbundle` (
	`Id` BIGINT NOT NULL,
	`Shop_Id` BIGINT NOT NULL,
	`Manufacturer_Id` BIGINT,
	`Product_Type_Id` BIGINT,
	PRIMARY KEY (`Id`)
) ENGINE=InnoDB;

CREATE TABLE `PriceDB`.`product_type` (
`Id` BIGINT NOT NULL,
	`Product_Type_Id` BIGINT NOT NULL,
	`Product_Type_Name` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`Id`)
) ENGINE=InnoDB;

CREATE TABLE `PriceDB`.`pricerules` (
	`Id` BIGINT NOT NULL,
	`Shop_Id` BIGINT NOT NULL,
	`Manufacturer_Id` BIGINT NOT NULL,
	`Product_Type_Id` BIGINT NOT NULL,
	`PriceRule` INT,
	PRIMARY KEY (`Id`)
) ENGINE=InnoDB;

CREATE TABLE `PriceDB`.`pricerule` (
	`PriceRule_Id` INT NOT NULL,
	`PriceRule_Name` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`PriceRule_Id`)
) ENGINE=InnoDB;