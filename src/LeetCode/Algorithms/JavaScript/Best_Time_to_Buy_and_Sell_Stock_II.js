/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
	let result = 0;
	
	for (let i = 1; i < prices.length; i++) {
		if (prices[i] > prices[i - 1]) {
			result += prices[i] - prices[i - 1];
		}
	}
	
	return result;
};

let prices = [7, 1, 5, 3, 6, 4];

console.log(maxProfit(prices));