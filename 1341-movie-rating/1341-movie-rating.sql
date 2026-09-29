# Write your MySQL query statement below
select name as results
from (
    select M.user_id, U.name as name from MovieRating M
    join Users U
    on U.user_id = M.user_id
    group by M.user_id
    order by count(M.movie_id) desc, U.name ASC
    limit 1
) as t

union All

select title as results
from 
(
    select Mr.movie_id, M.title as title from MovieRating Mr
    join Movies M
    on M.movie_id = Mr.movie_id
    WHERE Mr.created_at BETWEEN '2020-02-01' AND '2020-02-29'
    group by Mr.movie_id
    order by Avg(Mr.rating) desc, M.title ASC
    limit 1
) as t