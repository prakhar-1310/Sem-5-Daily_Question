# Write your MySQL query statement below
select A1.machine_id, round((sum(A2.timestamp)-sum(A1.timestamp))/count(distinct A1.process_id), 3)
as processing_time
from Activity A1
join Activity A2
on A1.machine_id = A2.machine_id and A1.process_id = A2.process_id and A1.activity_type="start" and A2.activity_type="end"
group by A1.machine_id