/**
 * https://leetcode.com/problems/jewels-and-stones/
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones = function(J, S) {
	return S.split('').reduce((a, c) => J.includes(c) ? a + 1 : a, 0);
};

let J = 'aA';
let S = 'aAAbbbb';

console.log(numJewelsInStones(J, S));