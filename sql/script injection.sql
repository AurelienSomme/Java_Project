-- Insertion dans la table "fidelity_card"
INSERT INTO fidelity_card (code, nb_points)
VALUES (1, 1000),
(2, 500),
(3, 200);

-- Insertion dans la table "actor"
INSERT INTO actor (num, name, first_name, VAT, mail, phone, adress, account_number, ref_fidelity_card)
VALUES (1, 'John Doe', 'John', 'FR189', 'john.doe@example.com', '1234567890', '123 Main St', '1234567890123456', 1),
(2, 'Jane Smith', 'Jane', 'FR921', 'jane.smith@example.com', '9876543210', '456 Elm St', '9876543210987654', 2);

-- Insertion dans la table "flow"
INSERT INTO flow (id_flow, name, direction)
VALUES (1, 'ORDER', 'INPUT'),
(2, 'SALE', 'OUTPUT'),
(3, 'INVENTORY', 'INPUT');

-- Insertion dans la table "affair"
INSERT INTO affair (id_affair, date_affair, delivery_date, is_done, discount, ref_actor, ref_flow)
VALUES (1, '2023-05-01', '2023-05-05', 1, 0.10, 1, 1),
(2, '2023-05-10', NULL, 0, NULL, 2, 2);

-- Insertion dans la table "brand"
INSERT INTO brand (id_brand, name, CEO, creation_date, description)
VALUES (1, 'Acme Food', 'John Doe', '2020-01-01', 'A leading food brand specializing in various products.'),
(2, 'Healthy Delights', 'Jane Smith', '2018-05-01', 'A health-conscious brand offering nutritious food options.');

-- Insertion dans la table "item"
INSERT INTO item (code, ref_brand, name, catalog_price, reduction_points, packaging, VAT, stock_quantity, threshold_limit, automatic_order, production_date, sale_date)
VALUES ('ITEM001', 1, 'Canned Soup', 2.99, 10, 'Can', 5.5, 100, 20, 1, '2022-12-01', '2023-01-01'),
('ITEM002', 2, 'Organic Granola Bars', 3.49, NULL, 'Box', 2.1, 50, 10, 0, '2023-01-15', '2023-02-01');

-- Insertion dans la table "promotion"
INSERT INTO promotion (code, percent_rate)
VALUES (1, 20),
(2, 15);

-- Insertion dans la table "promotion_date"
INSERT INTO promotion_date (start_date, ref_promotion, ref_item, end_date)
VALUES ('2023-05-01', 1, 'ITEM001', '2023-05-10'),
('2023-05-05', 2, 'ITEM002', '2023-05-15');

-- Insertion dans la table "detail_affair"
INSERT INTO detail_affair (quantity, real_price, VAT, ref_affair, ref_item)
VALUES (5, 14.99, 5.5, 1, 'ITEM001'),
(10, 2.99, 2.1, 2, 'ITEM002');

-- Insertion dans la table "batch"
INSERT INTO batch (code, expiration_date, ref_affair, ref_item)
VALUES ('BATCH001', '2023-12-31', 1, 'ITEM001'),
('BATCH002', '2024-06-30', 2, 'ITEM002');

commit;