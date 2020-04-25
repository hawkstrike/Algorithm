/**
 * https://leetcode.com/problems/group-anagrams/
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
	/*let hashMap = new Map();
	
	for (let str of strs) {
		const arr = [...str].sort().join("");
		
		hashMap.has(arr) ? hashMap.get(arr).push(str) : hashMap.set(arr, [str]);
	}
	
	console.log(hashMap);*/
	
	let hashMap = new Map();
	
	for (let str of strs) {
		const arr = Array.from(str).sort().join("");
		
		if (!hashMap.has(arr)) {
			hashMap.set(arr, new Array());
		}
		
		hashMap.get(arr).push(str);
	}
	
	return [...hashMap.values()];
};

let strs = ['eat', 'tea', 'tan', 'ate', 'nat', 'bat'];

console.log(groupAnagrams(strs));