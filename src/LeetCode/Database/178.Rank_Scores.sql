-- https://leetcode.com/problems/rank-scores/
SELECT
	SCORE
	 , DENSE_RANK() OVER (ORDER BY SCORE DESC) AS RANK
FROM SCORES