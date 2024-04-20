CREATE TABLE users (
    id UUID PRIMARY KEY,
    username VARCHAR,
    email_address VARCHAR,
    password VARCHAR
);

CREATE TABLE merchants (
    id UUID PRIMARY KEY,
    merchant_name VARCHAR,
    merchant_location VARCHAR,
    open_merchants BOOLEAN
);

CREATE TABLE products (
    id UUID PRIMARY KEY,
    product_name VARCHAR,
    price DECIMAL,
    merchant_id UUID,
    FOREIGN KEY (merchant_id) REFERENCES merchants(id)
);

CREATE TABLE orders (
    id UUID PRIMARY KEY,
    order_time TIMESTAMP,
    destination_address VARCHAR,
    user_id UUID,
    completed BOOLEAN,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE order_detail (
    id UUID PRIMARY KEY,
    order_id UUID,
    product_id UUID,
    quantity INTEGER,
    total_price DECIMAL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);
