-- https://leetcode.com/problems/big-countries/
SELECT
	NAME
	 , POPULATION
	 , AREA
FROM WORLD
WHERE POPULATION > 25000000
	OR AREA > 3000000