# Write your MySQL query statement below
select product_id, first_year, quantity, price
from (
    Select sale_id ,product_id, year as first_year, quantity, price, rank() over (
        Partition by product_id
        order by year
    ) as grade
    from Sales
) as t
where grade =1