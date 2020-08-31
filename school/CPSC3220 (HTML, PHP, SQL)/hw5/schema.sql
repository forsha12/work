DROP SCHEMA IF EXISTS SuperStore;
CREATE SCHEMA SuperStore;
USE SuperStore;
-- I changed the data type on weight to allow for decimal points.


CREATE TABLE SuperStore.customer (
	customer_id INT NOT NULL AUTO_INCREMENT,
	first_name varchar(100) NOT NULL,
	last_name varchar(100) NOT NULL,
	email varchar(320) NOT NULL,
	phone varchar(100) NULL,
	address_id INT NOT NULL,
	CONSTRAINT customer_PK PRIMARY KEY (customer_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci;

CREATE TABLE SuperStore.`order` (
	order_id INT NOT NULL AUTO_INCREMENT,
	customer_id INT NOT NULL,
	address_id INT NOT NULL,
	CONSTRAINT order_PK PRIMARY KEY (order_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci;

CREATE TABLE SuperStore.product (
	product_id INT NOT NULL AUTO_INCREMENT,
	product_name varchar(100) NOT NULL,
	description varchar(100) NULL,
	weight DECIMAL(10,2) NULL,
	base_cost DECIMAL(13,2) NOT NULL,
	CONSTRAINT NewTable_PK PRIMARY KEY (product_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci;

-- added semicolon after this script
CREATE TABLE `order_item` (
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` decimal(13,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE SuperStore.address (
	address_id INT NOT NULL AUTO_INCREMENT,
	street varchar(100) NOT NULL,
	city varchar(100) NOT NULL,
	state varchar(100) NOT NULL,
	zip varchar(5) NOT NULL,
	CONSTRAINT address_PK PRIMARY KEY (address_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci;

CREATE TABLE SuperStore.warehouse (
	warehouse_id INT NOT NULL AUTO_INCREMENT,
	name varchar(100) NOT NULL,
	address_id INT NOT NULL,
	CONSTRAINT warehouse_PK PRIMARY KEY (warehouse_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci;


CREATE TABLE SuperStore.product_warehouse (
	product_id INT NOT NULL,
	warehouse_id INT NOT NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci;

ALTER TABLE SuperStore.customer ADD CONSTRAINT customer_FK FOREIGN KEY (address_id) REFERENCES SuperStore.address(address_id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE SuperStore.`order` ADD CONSTRAINT order_FK FOREIGN KEY (customer_id) REFERENCES SuperStore.customer(customer_id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE SuperStore.`order` ADD CONSTRAINT order_FK_1 FOREIGN KEY (address_id) REFERENCES SuperStore.address(address_id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE SuperStore.order_item ADD CONSTRAINT order_item_FK FOREIGN KEY (order_id) REFERENCES SuperStore.`order`(order_id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE SuperStore.order_item ADD CONSTRAINT order_item_FK_1 FOREIGN KEY (product_id) REFERENCES SuperStore.product(product_id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE SuperStore.warehouse ADD CONSTRAINT warehouse_FK FOREIGN KEY (address_id) REFERENCES SuperStore.address(address_id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE SuperStore.product_warehouse ADD CONSTRAINT product_warehouse_FK FOREIGN KEY (product_id) REFERENCES SuperStore.product(product_id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE SuperStore.product_warehouse ADD CONSTRAINT product_warehouse_FK_1 FOREIGN KEY (warehouse_id) REFERENCES SuperStore.warehouse(warehouse_id) ON DELETE CASCADE ON UPDATE CASCADE;
