# Write your MySQL query statement below
select S.student_id, S.student_name, sub.subject_name, count(E.subject_name) as attended_exams from Students S
cross join Subjects Sub
left join Examinations E
on S.student_id = E.student_id AND Sub.subject_name = E.subject_name
group by S.student_id, sub.subject_name, S.student_name
order by S.student_id, sub.subject_name