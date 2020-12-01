/**
 * https://leetcode.com/problems/course-schedule/
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
var canFinish = function(numCourses, prerequisites) {
	const degreeArr = new Array(numCourses).fill(0);
	const queue = [];
	
	for (const [course, prereq] of prerequisites) {
		degreeArr[course]++;
	}
	
	for (let i = 0; i < degreeArr.length; i++) {
		if (degreeArr[i] === 0) {
			queue.push(i);
		}
	}
	
	while (queue.length > 0) {
		const curr = queue.pop();
		
		for (const [course, prereq] of prerequisites) {
			if (curr === prereq) {
				degreeArr[course]--;
				
				if (degreeArr[course] === 0) {
					queue.push(course);
				}
			}
		}
		
		numCourses--;
	}
	
	return numCourses === 0;
};

const numCourses = 2;
const prerequisites = [[1, 0]];

console.log(canFinish(numCourses, prerequisites))