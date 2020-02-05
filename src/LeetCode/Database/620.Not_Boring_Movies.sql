-- https://leetcode.com/problems/not-boring-movies/
SELECT
	*
FROM CINEMA
WHERE DESCRIPTION != 'boring'
  AND MOD(ID, 2) = 1
ORDER BY RATING DESC