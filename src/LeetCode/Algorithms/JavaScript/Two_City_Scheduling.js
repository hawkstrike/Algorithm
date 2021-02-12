/**
 * https://leetcode.com/problems/two-city-scheduling/
 * @param {number[][]} costs
 * @return {number}
 */
var twoCitySchedCost = function(costs) {
	const length = costs.length;
	let result = 0;
	
	costs.sort((a, b) => (a[0] - a[1]) - (b[0] - b[1]));
	
	for (let i = 0; i < length; i++) {
		result += (i < length / 2) ? costs[i][0] : costs[i][1];
	}
	
	return result;
};

const costs = [[10, 20]
			, [30, 200]
			, [400, 50]
			, [30, 20]];

console.log(twoCitySchedCost(costs));