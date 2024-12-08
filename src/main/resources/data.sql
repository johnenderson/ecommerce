-- tb_products
INSERT INTO tb_products (product_id, product_name, price)
    VALUES
        (1, 'Computer', 4500.50),
        (2, 'Smartphone', 2000.00),
        (3, 'Mouse', 200.00)
    ON CONFLICT (product_id) DO NOTHING;

-- tb_tags
INSERT INTO tb_tags (tag_id, name)
    VALUES
        (1, 'Eletronics'),
        (2, 'Home'),
        (3, 'Apple')
    ON CONFLICT (tag_id) DO NOTHING;

-- tb_product_tags
INSERT INTO tb_product_tags (product_id, tag_id)
    VALUES
        (1, 1),
        (2, 3),
        (2, 1),
        (3, 1)
    ON CONFLICT (product_id, tag_id) DO NOTHING;