# Write your MySQL query statement below
select score, Dense_Rank() over (order by score Desc) as 'rank'
from Scores