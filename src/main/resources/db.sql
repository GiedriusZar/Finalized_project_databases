CREATE TABLE item(
                     id BIGSERIAL PRIMARY KEY NOT NULL,
                     cart_id BIGINT NOT NULL,
                     item_type VARCHAR(255),
                     item_name VARCHAR(255),
                     item_price INT NOT NULL,
                     item_stock INT
);
CREATE TABLE cart(
                     id BIGSERIAL PRIMARY KEY NOT NULL,
                     created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
)