-- https://leetcode.com/problems/customers-who-never-order/
SELECT
	A.NAME AS CUSTOMERS
FROM CUSTOMERS A, ORDERS B
WHERE A.ID = B.CUSTOMERID(+)
	AND B.CUSTOMERID IS NULL