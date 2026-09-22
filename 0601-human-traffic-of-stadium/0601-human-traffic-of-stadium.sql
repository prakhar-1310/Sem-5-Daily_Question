# Write your MySQL query statement below
select id, visit_date, people
from(
    select id, visit_date, people,
    lag (id, 1) over (order by id) as prev1,
    lag (id, 2) over (order by id) as prev2,
    lag (people, 1) over (order by id) as peop1,
    lag (people, 2) over (order by id) as peop2,
    lead (id, 1) over (order by id) as for1,
    lead (id, 2) over (order by id) as for2,
    lead (people, 1) over (order by id) as peo1,
    lead (people, 2) over (order by id) as peo2
    from Stadium
) as t
where 
(id+1=for1 and id+2=for2 and people>=100 and peo1>=100 and peo2>=100)
or
(id-1=prev1 and id-2=prev2 and people>=100 and peop1>=100 and peop2>=100)
or
(id+1=for1 and id-1=prev1 and people>=100 and peo1>=100 and peop1>=100)
order by visit_date