/**
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 * @param {number[][]} grid
 * @return {number}
 */
var countNegatives = function(grid) {
	let result = 0;
	
	for (let i = grid.length - 1; i >= 0; i--) {
		for (let j = grid[i].length - 1; j >= 0; j--) {
			if (grid[i][j] < 0) {
				result++;
			} else {
				break;
			}
		}
	}
	
	return result;
};

let grid = [[4, 3, 2, -1],
			[3, 2, 1, -1],
			[1, 1, -1, -2],
			[-1, -1, -2, -3]];

console.log(countNegatives(grid));