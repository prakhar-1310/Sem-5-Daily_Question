# Write your MySQL query statement below
select id, 
CASE 
when id%2=0 then p 
else ifnull(f, student)
End as Student
from 
(
    select id, student, lag (Student, 1) over (order by id) as p,
    lead(Student,1) over (order by id) as f
    from Seat
) as t
order by id