# Write your MySQL query statement below
select Customers.name as Customers from Customers
left join 
Orders
on Orders.customerId = Customers.id
where orders.id is null