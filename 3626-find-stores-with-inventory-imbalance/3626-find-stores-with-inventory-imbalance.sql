WITH store_price AS (
    SELECT
        store_id,
        MIN(price) AS min_price,
        MAX(price) AS max_price
    FROM inventory
    GROUP BY store_id
)

SELECT
    s.store_id,
    s.store_name,
    s.location,

    MAX(CASE
        WHEN i.price = sp.max_price THEN i.product_name
    END) AS most_exp_product,

    MAX(CASE
        WHEN i.price = sp.min_price THEN i.product_name
    END) AS cheapest_product,

    ROUND(
        MAX(CASE
            WHEN i.price = sp.min_price THEN i.quantity
        END) /
        MAX(CASE
            WHEN i.price = sp.max_price THEN i.quantity
        END),
        2
    ) AS imbalance_ratio

FROM stores s
JOIN inventory i
    ON s.store_id = i.store_id
JOIN store_price sp
    ON i.store_id = sp.store_id

GROUP BY
    s.store_id,
    s.store_name,
    s.location

HAVING
    COUNT(DISTINCT i.product_name) >= 3
    AND MAX(CASE
        WHEN i.price = sp.max_price THEN i.quantity
    END)
    <
    MAX(CASE
        WHEN i.price = sp.min_price THEN i.quantity
    END)

ORDER BY
    imbalance_ratio DESC,
    s.store_name ASC;