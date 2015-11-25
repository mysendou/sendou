CREATE database test;
USE test;
CREATE TABLE products(
    id int(11) NOT NULL auto_increment,
    name varchar(255) NOT NULL,
    description varchar(1000) default NULL,
    price decimal(10,0) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;