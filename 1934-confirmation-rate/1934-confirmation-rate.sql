# Write your MySQL query statement below
select S.user_id, ROUND(COALESCE(SUM(C.action = 'confirmed') / COUNT(C.time_stamp),0),2)
as confirmation_rate
from Signups S
left join Confirmations C
on S.user_id = C.user_id
group by S.user_id