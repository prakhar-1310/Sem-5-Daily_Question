# Write your MySQL query statement below
select Department, Employee, Salary from
(
    select D.name as Department, E.name as Employee, E.salary as Salary, 
    Rank() over(
        Partition by D.name
        order by E.salary DESC
    ) as grade
    from Employee E
    left join Department D
    on E.departmentId = D.id
)as t
where grade=1