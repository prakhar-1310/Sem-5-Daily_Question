CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    DECLARE offsetVar INT;
    set offsetVar = N-1;
  RETURN (
      # Write your MySQL query statement below.
      
      select (
        select distinct salary from Employee
        order by salary desc
        limit 1 offset offsetVar
      ) as 'getNthHighestSalary(2)'

  );
END