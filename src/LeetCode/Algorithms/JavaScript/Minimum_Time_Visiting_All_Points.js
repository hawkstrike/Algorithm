/**
 * https://leetcode.com/problems/minimum-time-visiting-all-points/
 * @param {number[][]} points
 * @return {number}
 */
var minTimeToVisitAllPoints = function(points) {
	let result = 0;
	
	for (let i = 0; i < points.length - 1; i++) {
		let x = Math.abs(points[i + 1][0] - points[i][0]);
		let y = Math.abs(points[i + 1][1] - points[i][1]);
		
		result += Math.max(x, y);
	}
	
	return result;
};

let points = [[1, 1], [3, 4], [-1, 0]];

console.log(minTimeToVisitAllPoints(points));