-- Insertion dans la table "fidelity_card"
INSERT INTO fidelity_card (code, nb_points)
VALUES (1, 1000),
(2, 500),
(3, 200);

-- Insertion dans la table "actor"
INSERT INTO actor (num, name, first_name, VAT, mail, phone, adress, account_number, ref_fidelity_card)
VALUES (1, 'Somme', 'Aurelien', 'BE189', 'aurelien.somme@example.com', '1234567890', '123 Main St', '1234567890123456', 1),
(2, 'De Buck', 'Henry', 'BE921', 'henry.debuck@example.com', '9876543210', '456 Elm St', '9876543210987654', 2),
(3, 'George', 'Jorge', 'BE1212', 'GeorJor@exemple.com', '981273', '321 st main', '2133241231243', 3);

-- Insertion dans la table "flow"
INSERT INTO flow (id_flow, name, direction)
VALUES (1, 'ORDER', 'INPUT'),
(2, 'SALE', 'OUTPUT');

-- Insertion dans la table "affair"
INSERT INTO affair (id_affair, date_affair, delivery_date, is_done, discount, ref_actor, ref_flow)
VALUES (1, '2023-05-01', '2023-05-05', 1, 0.10, 1, 1),
(2, '2023-05-10', NULL, 0, NULL, 2, 2),
(3, '2023-06-02', '2023-06-03', 1, NULL, 3, 2);

-- Insertion dans la table "brand"
INSERT INTO brand (id_brand, name, CEO, creation_date, description)
VALUES (1, 'The Coca-Cola Company', 'James Quincey', '1892-01-01', 'Coca-Cola is a carbonated, sweetened soft drink and is the world''s best-selling soda. A popular nickname for Coca-Cola is Coke. The Coca-Cola Company claims that the beverage is sold in more than 200 countries. Coca-Cola was first made in Columbus, Georgia.'),
(2, 'Kelloggs', 'Steven Cahillane', '1906-02-16', 'The Kellogg Company, doing business as Kellogg''s, is an American multinational food manufacturing company headquartered in Battle Creek, Michigan, United States.'),
(3, 'Lays Chips', 'PepsiCo', '1932-02-02', 'Lay''s est le nom d''une marque commerciale de chips de pomme de terre et à l''origine celui de la société américaine qui créa cette marque en 1932. Les chips Lay''s sont vendues dans plus de 122 pays.');

-- Insertion dans la table "item"
INSERT INTO item (code, ref_brand, name, catalog_price, reduction_points, packaging, VAT, stock_quantity, threshold_limit, automatic_order, production_date, sale_date)
VALUES ('coca1', 1, 'Fanta', 1.14, 10, 'Can', 6.0, 150, 50, 1, null, '2023-05-10'),
('coca2', 1, 'CocaCola', 1.08, NULL, 'Can', 6.0, 200, 100, 1, null, '2023-02-01'),
('kellogs1', 2, 'Frosties', 3.55, 15, 'Box', 6.0, 80, 20, 0, null, '2023-06-15'),
('kellogs2', 2, 'Miel Pops', 2.80, null, 'Box', 6.0, 50, 20, 1, '2009-09-02', '2023-03-11'),
('lays1', 3, 'Paprika classique', 2.13, 10, 'Packet', 6.0, 300, 100, 0, '2015-07-22', '2023-08-12'),
('lays2', 3, 'Sel classique', 2.05, 10, 'Packet', 6.0, 200, 120, 0, '2015-07-22', '2023-08-12'),
('lays3', 3, 'Poivre/Sel', 2.33, 15, 'Packet', 6.0, 100, 20, 1, '2015-05-22', '2023-08-02');

-- Insertion dans la table "promotion"
INSERT INTO promotion (code, percent_rate)
VALUES (1, 25.0),
(2, 15.0);

-- Insertion dans la table "promotion_date"
INSERT INTO promotion_date (start_date, ref_promotion, ref_item, end_date)
VALUES ('2023-05-20', 2, 'coca1', '2023-06-20'),
('2023-06-20', 1, 'kellogs1', '2024-01-01'),
('2023-08-12', 2, 'lays2', '2023-08-15');

-- Insertion dans la table "detail_affair"
INSERT INTO detail_affair (quantity, real_price, VAT, ref_affair, ref_item)
VALUES (50, 45.58, 6.0, 1, 'coca1'),
(80, 75.55, 6.0, 1, 'coca2'),
(30, 100.20, 6.0, 1, 'kellogs1'),
(1, 2.80, 6.0, 2, 'kellogs2'),
(1, 1.14, 6.0, 2, 'coca1'),
(2, 4.40, 6.0, 3, 'lays1'),
(1, 1.14, 6.0, 3, 'coca1'),
(3, 5.70, 6.0, 3, 'kellogs2'),
(1, 1.50, 6.0, 3, 'coca2');

-- Insertion dans la table "batch"
INSERT INTO batch (code, expiration_date, ref_affair, ref_item)
VALUES ('batch1', '2023-08-08', 1, 'coca1'),
('batch2', '2023-10-30', 2, 'kellogs2'),
('batch3', '2023-08-17', 3, 'lays1');

commit;