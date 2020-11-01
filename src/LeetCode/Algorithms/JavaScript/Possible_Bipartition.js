/**
 * https://leetcode.com/problems/possible-bipartition/
 * @param {number} N
 * @param {number[][]} dislikes
 * @return {boolean}
 */
var possibleBipartition = function(N, dislikes) {
	let graph = new Array(N + 1);
	let person = new Array(N + 1).fill(-1);
	
	for (let i = 1; i <= N; i++) {
		graph[i] = new Array();
	}
	
	for (let dislike of dislikes) {
		const [x, y] = dislike;
		
		graph[x].push(y);
		graph[y].push(x);
	}
	
	for (let i = 1; i <= N; i++) {
		if (person[i] === -1 && !dfs(graph, person, i, 1)) {
			return false;
		}
	}
	
	return true;
};

const dfs = (graph, person, curr, p) => {
	if (person[curr] !== -1) {
		return person[curr] == p;
	}
	
	person[curr] = p;
	
	for (let i = 0; i < graph[curr].length; i++) {
		if (!dfs(graph, person, graph[curr][i], 1 - p)) {
			return false;
		}
	}
	
	return true;
};

const N = 4;
const dislikes = [[1, 2], [1, 3], [2, 4]];

console.log(possibleBipartition(N, dislikes));