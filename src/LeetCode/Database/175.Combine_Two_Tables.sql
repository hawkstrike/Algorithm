-- https://leetcode.com/problems/combine-two-tables/
SELECT
	A.FirstName
	, A.LastName
	, B.City
	, B.State
FROM Person A, Address B
WHERE A.PersonId = B.PersonId(+);