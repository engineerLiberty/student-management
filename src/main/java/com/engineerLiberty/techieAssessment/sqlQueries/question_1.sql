-- Queries to find the second largest salary from the 'emp' table

-- Query 1: Selecting distinct salaries, ordering them in descending order,
-- skipping the highest salary, and fetching the second one.
SELECT DISTINCT(salary) FROM emp ORDER BY salary DESC LIMIT 1 OFFSET 1;

-- Query 2: Finding the maximum salary less than the overall maximum salary,
-- which gives the second highest salary.
SELECT MAX(salary) FROM emp WHERE salary < (SELECT MAX(salary) FROM emp);

-- Query 3: Selecting the top 2 distinct salaries in descending order
-- and ordering them to get the second highest.
SELECT salary FROM (SELECT DISTINCT salary FROM emp ORDER BY salary DESC LIMIT 2) AS emp ORDER BY salary LIMIT 1;

-- Query 4: Selecting the top 2 salaries (including duplicates), ordering them
-- in descending order, and fetching the second highest by ordering in ascending order.
SELECT DISTINCT salary FROM (SELECT salary FROM emp ORDER BY salary DESC LIMIT 2) AS emp ORDER BY salary LIMIT 1;

-- Query 5: Ordering the salaries in descending order, skipping the first (highest) salary,
-- and limiting to 1 to fetch the second highest salary.
SELECT salary FROM emp ORDER BY salary DESC OFFSET 1 LIMIT 1;
