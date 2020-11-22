INSERT INTO client (client_id,name, description, contract_detail, url, remark)
VALUES (1,'Jack n Jones', 'Jack n Jones Desc', 'contract detail-Jack n Jones', 'www.jnj.com', 'remark-Jack n Jones');
INSERT INTO client (client_id,name, description, contract_detail, url, remark)
VALUES (2,'Zara', 'Zara Desc', 'contract detail-Zara', 'www.zara.com', 'remark-Zara');
INSERT INTO client (client_id,name, description, contract_detail, url, remark)
VALUES (3,'Peter England', 'Peter England', 'contract detail-Peter England', 'www.pe.com', 'remark-Peter England');


INSERT INTO category (category_id,name, description, remark)
VALUES (1,'Pants', 'Pants Desc', 'remark-Pants');
INSERT INTO category (category_id,name, description, remark)
VALUES (2,'Socks', 'Socks Desc', 'remark-Socks');
INSERT INTO category (category_id,name, description, remark)
VALUES (3,'Caps', 'Caps Desc', 'remark-Caps');


INSERT INTO product (product_id, client_id,category_id,name, description, size, stock, color, price)
VALUES(1, 1, 1,'Skinny', 'Skinny Desc', 32, 2000, 'black', 2999);
INSERT INTO product (product_id, client_id,category_id,name, description, size, stock, color, price)
VALUES(2, 1, 3,'Monkey Cap', 'Monkey Cap Desc', 8, 5000, 'black', 599);
INSERT INTO product (product_id, client_id,category_id,name, description, size, stock, color, price)
VALUES(3, 1, 2,'Sports Socks', 'Sports Socks Desc', 10, 10000, 'grey', 199);

INSERT INTO product (product_id, client_id,category_id,name, description, size, stock, color, price)
VALUES(4, 2, 1,'bell bottom', 'Skinny Desc', 32, 2312, 'blue', 5999);
INSERT INTO product (product_id, client_id,category_id,name, description, size, stock, color, price)
VALUES(5, 2, 2,'Long socks', 'Long socks Desc', 9, 3423,'red', 999);
INSERT INTO product (product_id, client_id,category_id,name, description, size, stock, color, price)
VALUES(6, 2, 3,'Sports Cap', 'Sports Cap', 13, 6342,'green', 1299);

INSERT INTO product (product_id, client_id,category_id,name, description, size, stock, color, price)
VALUES(7, 3, 1,'normal bottom', 'Skinny Desc', 32, 2367,'blue', 6999);
INSERT INTO product (product_id, client_id,category_id,name, description, size, stock, color, price)
VALUES(8, 3, 2,'normal socks', 'Long socks Desc', 5, 8456,'red', 99);
INSERT INTO product (product_id, client_id,category_id,name, description, size, stock, color, price)
VALUES(9, 3, 3,'standard Cap', 'standard Cap', 12, 7453,'orange', 399);