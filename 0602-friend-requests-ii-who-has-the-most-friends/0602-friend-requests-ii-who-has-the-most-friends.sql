# Write your MySQL query statement below
select id , count(id) as num from
(
    select requester_id as id from 
    RequestAccepted

    union All

    select accepter_id as id from 
    RequestAccepted
) as t
group by id
order by count(id) desc
limit 1