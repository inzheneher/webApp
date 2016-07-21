CREATE TABLE Employees
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    age INT(11),
    name VARCHAR(255),
    salary FLOAT
);
CREATE TABLE goods
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    price DOUBLE,
    quantity INT(11),
    CONSTRAINT Goods_Purchase_goods_id_fk FOREIGN KEY (id) REFERENCES purchase (goods_id)
);
CREATE UNIQUE INDEX Goods_goods_id_uindex ON goods (id);
CREATE UNIQUE INDEX Goods_goods_name_uindex ON goods (name);
CREATE TABLE purchase
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id INT(11) NOT NULL,
    goods_id INT(11) NOT NULL,
    date DATE NOT NULL,
    price DOUBLE,
    quantity INT(11)
);
CREATE UNIQUE INDEX Purchase_goods_id_uindex ON purchase (goods_id);
CREATE UNIQUE INDEX Purchase_purchase_id_uindex ON purchase (id);
CREATE UNIQUE INDEX Purchase_user_id_uindex ON purchase (user_id);
CREATE TABLE user
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    pass VARCHAR(255) NOT NULL,
    role TINYINT(1) NOT NULL,
    CONSTRAINT User_Purchase_user_id_fk FOREIGN KEY (id) REFERENCES purchase (user_id)
);
CREATE UNIQUE INDEX User_user_id_uindex ON user (id);