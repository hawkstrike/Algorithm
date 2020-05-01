/**
 * https://leetcode.com/problems/min-stack/
 * initialize your data structure here.
 */
var MinStack = function() {
	this.min = Infinity;
	this.stack = new Array();
};

/**
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
	this.min = Math.min(this.min, x);
	this.stack.push({
		val: x
		, min : this.min
	});
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
	this.stack.pop();
	
	if (this.stack.length > 0) {
		this.min = this.stack[this.stack.length - 1].min;
	} else {
		this.min = Infinity;
	}
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
	return this.stack[this.stack.length - 1].val;
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
	return this.min;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */