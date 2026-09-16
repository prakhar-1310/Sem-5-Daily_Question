# Write your MySQL query statement below
Select V.customer_id, Count(V.customer_id) as count_no_trans
from Visits V
left join Transactions T
on T.visit_id=V.visit_id
where T.transaction_id is null
group by V.customer_id


-- Select *
-- from Visits V
-- left join Transactions T
-- on T.visit_id=V.visit_id
