# Write your MySQL query statement below
select P.product_name as product_name, sum(O.unit) as unit
from Orders O
left join Products P
on P.product_id = O.product_id
where O.order_date between '2020-02-01' and '2020-02-29'
group by product_name
having unit>=100