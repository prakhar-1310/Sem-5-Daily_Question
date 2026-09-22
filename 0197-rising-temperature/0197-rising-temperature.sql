# Write your MySQL query statement below
select id from
(
    select id, recordDate, lag(recordDate, 1) over(order by recordDate asc) as prevDate,
    temperature, lag(temperature, 1) over(order by recordDate asc) as prevTem
    from Weather
) as t
where DateDiff(recordDate,prevDate)=1 and prevTem<temperature