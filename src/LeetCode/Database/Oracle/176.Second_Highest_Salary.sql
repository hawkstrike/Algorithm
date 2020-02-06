-- https://leetcode.com/problems/second-highest-salary/
SELECT
	MAX(SALARY) AS SecondHighestSalary
FROM EMPLOYEE
WHERE SALARY NOT IN (SELECT MAX(SALARY) FROM EMPLOYEE)