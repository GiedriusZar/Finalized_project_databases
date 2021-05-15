DROP TABLE IF EXISTS cart;
DROP TABLE IF EXISTS item;

CREATE TABLE item
(
    id         BIGSERIAL PRIMARY KEY NOT NULL,
    item_type  VARCHAR(255),
    item_name  VARCHAR(255),
    item_price INT                   NOT NULL,
    item_stock INT
);

CREATE TABLE cart
(
    id         BIGSERIAL PRIMARY KEY NOT NULL,
    owner      VARCHAR(255),
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE item OWNER TO shopcart;

ALTER TABLE cart OWNER TO shopcart;

INSERT INTO cart(owner, created_at)
VALUES ('Giedrius',
        '2021-05-12');

INSERT INTO item (item_type, item_name, item_price, item_stock)
VALUES ('FISHING', 'Worms', 2, 100);
INSERT INTO item (item_type, item_name, item_price, item_stock)
VALUES ('CLOTHES', 'Shoes', 35, 32);
INSERT INTO item (item_type, item_name, item_price, item_stock)
VALUES ('DRINKS', 'Whiskey Blue Label', 189, 10);
INSERT INTO item (item_type, item_name, item_price, item_stock)
VALUES ('GARDENING', 'Seeds', 2, 255);
INSERT INTO item (item_type, item_name, item_price, item_stock)
VALUES ('ELECTRICITY', 'Wires', 11, 58);
INSERT INTO item (item_type, item_name, item_price, item_stock)
VALUES ('ELECTRICITY', 'Light bulbs', 48, 19);
INSERT INTO item (item_type, item_name, item_price, item_stock)
VALUES ('FISHING', 'Fishing reel', 139, 7);
INSERT INTO item (item_type, item_name, item_price, item_stock)
VALUES ('CLOTHES', 'Pants', 35, 35);
INSERT INTO item (item_type, item_name, item_price, item_stock)
VALUES ('DRINKS', 'Whiskey Black Label', 39, 60);
INSERT INTO item (item_type, item_name, item_price, item_stock)
VALUES ('FURNITURE', 'Sofa', 225, 3);
INSERT INTO item (item_type, item_name, item_price, item_stock)
VALUES ('FURNITURE', 'Table', 48, 34);
INSERT INTO item (item_type, item_name, item_price, item_stock)
VALUES ('FURNITURE', 'Bed', 625, 10);
INSERT INTO item (item_type, item_name, item_price, item_stock)
VALUES ('FISHING', 'Platform', 299, 7);
INSERT INTO item (item_type, item_name, item_price, item_stock)
VALUES ('DRINKS', 'Apple juice', 3, 300);
INSERT INTO item (item_type, item_name, item_price, item_stock)
VALUES ('GARDENING', 'Shovel', 79, 16);
INSERT INTO item (item_type, item_name, item_price, item_stock)
VALUES ('GARDENING', 'Gloves', 1, 144);
