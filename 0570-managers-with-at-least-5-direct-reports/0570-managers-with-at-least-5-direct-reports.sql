# Write your MySQL query statement below
Select E1.name from Employee E1
join Employee E2
on E1.id = E2.managerId
group by E1.id
having count(E1.id)>=5
