CREATE TABLE Employees
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    age INT(11),
    name VARCHAR(255),
    salary FLOAT
);
CREATE TABLE User
(
    user_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(255) NOT NULL,
    user_pass VARCHAR(255) NOT NULL,
    user_role TINYINT(1) NOT NULL,
    CONSTRAINT User_Purchase_user_id_fk FOREIGN KEY (user_id) REFERENCES Purchase (user_id)
);
CREATE UNIQUE INDEX User_user_id_uindex ON User (user_id);
CREATE TABLE Goods
(
    goods_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    goods_name VARCHAR(255) NOT NULL,
    goods_description VARCHAR(255),
    goods_price DOUBLE,
    goods_quantity INT(11),
    CONSTRAINT Goods_Purchase_goods_id_fk FOREIGN KEY (goods_id) REFERENCES Purchase (goods_id)
);
CREATE UNIQUE INDEX Goods_goods_id_uindex ON Goods (goods_id);
CREATE UNIQUE INDEX Goods_goods_name_uindex ON Goods (goods_name);
CREATE TABLE Purchase
(
    purchase_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id INT(11) NOT NULL,
    goods_id INT(11) NOT NULL,
    purchase_date DATE NOT NULL,
    purchase_price DOUBLE,
    purchase_quantity INT(11)
);
CREATE UNIQUE INDEX Purchase_goods_id_uindex ON Purchase (goods_id);
CREATE UNIQUE INDEX Purchase_purchase_id_uindex ON Purchase (purchase_id);
CREATE UNIQUE INDEX Purchase_user_id_uindex ON Purchase (user_id);