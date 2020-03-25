/**
 * https://leetcode.com/problems/replace-words/
 * @param {string[]} dict
 * @param {string} sentence
 * @return {string}
 */
var replaceWords = function(dict, sentence) {
	let result = '';
	
	for (let word of sentence.split(' ')) {
		let prefix = '';
		
		for (let i = 1; i <= word.length; i++) {
			prefix = word.substring(0, i);
			
			if (dict.includes(prefix)) {
				break;
			}
		}
		
		if (result.length > 0) {
			result += ' ';
		}
		
		result += prefix;
	}
	
	return result;
};

let dict = ['cat', 'bat', 'rat'];
let sentence = 'the cattle was rattled by the battery';

console.log(replaceWords(dict, sentence));