/**
 * https://leetcode.com/problems/last-stone-weight/
 * @param {number[]} stones
 * @return {number}
 */
var lastStoneWeight = function(stones) {
	if (stones.length === 0) {
		return 0;
	}
	
	while (stones.length > 1) {
		stones.sort((a, b) => b - a);
		
		const x = stones.shift() - stones.shift();
		
		stones.push(x);
	}
	
	return stones[0];
};

// const stones = [2, 7, 4, 1, 8, 1];
// const stones = [3, 7, 2];
const stones = [8, 10, 4];

console.log(lastStoneWeight(stones));