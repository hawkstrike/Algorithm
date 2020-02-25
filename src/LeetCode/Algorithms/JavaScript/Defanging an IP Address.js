/**
 * https://leetcode.com/problems/defanging-an-ip-address/
 * @param {string} address
 * @return {string}
 */
var defangIPaddr = function(address) {
	return address.replace(/\./gi, '[.]');
};

let address = '255.100.50.0';

console.log(defangIPaddr(address));