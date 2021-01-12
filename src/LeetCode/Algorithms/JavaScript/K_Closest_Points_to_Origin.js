/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * @param {number[][]} points
 * @param {number} K
 * @return {number[][]}
 */
var kClosest = function(points, K) {
	const arr = new Array();
	
	points.map(function (point) {
		const distance = (point[0] * point[0]) + (point[1] * point[1]);
		
		arr.push(distance);
	});
	
	arr.sort((a, b) => {
		return a - b;
	});
	
	const max = arr.find(((value, index) => {
		if (index === K - 1) {
			return value;
		}
	}));
	
	const result = new Array();
	
	for (var i = 0; i < points.length && K > 0; i++) {
		const distance = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
		
		if (distance <= max) {
			result.push([points[i][0], points[i][1]]);
			K--;
		}
	}
	
	return result;
};

const points = [[1, 3], [-2, 2]];
const K = 1;

console.log(kClosest(points, K));