/**
 * https://leetcode.com/problems/edit-distance/
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function(word1, word2) {
	const [M, N] = [word1.length, word2.length];
	let previous = [...Array(N + 1)].map((value, index) => index);
	
	for (let i = 1; i <= M; i++) {
		let curr = [...previous];
		
		curr[0] = i;
		for (let j = 1; j <= N; j++) {
			curr[j] = Math.min(
				previous[j - 1] + Number(word1[i - 1] != word2[j - 1])
				, previous[j] + 1
				, curr[j - 1] + 1
			);
		}
		
		[previous, curr] = [curr, previous];
	}
	
	return previous[N];
};

const word1 = 'horse';
const word2 = 'ros';

console.log(minDistance(word1, word2));