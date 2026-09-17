# Write your MySQL query statement below
select R.contest_id, round(count(distinct R.user_id)/(select count(user_id) from Users)*100,2) as percentage
from Register R
group by R.contest_id
order by percentage desc, R.contest_id asc
