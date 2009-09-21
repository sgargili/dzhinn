create table `nixdb`.nixdata
(
	`Id` BIGINT NOT NULL,
	`Full_Name` TEXT,
	`Manufacturer` VARCHAR(255),
	`Article` VARCHAR(255),
        `Product_Type` VARCHAR(255),
        `Picture_URL` TEXT,
	`Groupe` VARCHAR(255),
	`Attribute` VARCHAR(255),
        `Attribute_Value` TEXT,
	PRIMARY KEY (`Id`)
) ENGINE=InnoDB;

create table `nixdb`.nixlinks
(
	`Id` BIGINT NOT NULL,
        `Product_Type` VARCHAR(255),
        `Product_URL` TEXT,
	PRIMARY KEY (`Id`)
) ENGINE=InnoDB;