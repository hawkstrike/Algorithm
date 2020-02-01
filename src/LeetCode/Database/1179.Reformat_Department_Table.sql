-- https://leetcode.com/problems/reformat-department-table/
/* Write your PL/SQL query statement below */
SELECT
	ID
	 , SUM(DECODE(MONTH, 'Jan', REVENUE)) AS Jan_Revenue
	 , SUM(DECODE(MONTH, 'Feb', REVENUE)) AS Feb_Revenue
	 , SUM(DECODE(MONTH, 'Mar', REVENUE)) AS Mar_Revenue
	 , SUM(DECODE(MONTH, 'Apr', REVENUE)) AS Apr_Revenue
	 , SUM(DECODE(MONTH, 'May', REVENUE)) AS May_Revenue
	 , SUM(DECODE(MONTH, 'Jun', REVENUE)) AS Jun_Revenue
	 , SUM(DECODE(MONTH, 'Jul', REVENUE)) AS Jul_Revenue
	 , SUM(DECODE(MONTH, 'Aug', REVENUE)) AS Aug_Revenue
	 , SUM(DECODE(MONTH, 'Sep', REVENUE)) AS Sep_Revenue
	 , SUM(DECODE(MONTH, 'Oct', REVENUE)) AS Oct_Revenue
	 , SUM(DECODE(MONTH, 'Nov', REVENUE)) AS Nov_Revenue
	 , SUM(DECODE(MONTH, 'Dec', REVENUE)) AS Dec_Revenue
FROM DEPARTMENT
GROUP BY ID
ORDER BY ID