//Given a positive integer num, write a function which returns True if num is a
//perfect square else False.
//
// Follow up: Do not use any built-in library function such as sqrt.
//
//
// Example 1:
// Input: num = 16
//Output: true
// Example 2:
// Input: num = 14
//Output: false
//
//
// Constraints:
//
//
// 1 <= num <= 2^31 - 1
//
// Related Topics Math Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /*    Success:
        Runtime:0 ms, faster than 100.00% of Java online submissions.
        Memory Usage:38.3 MB, less than 5.02% of Java online submissions.*/
    public boolean isPerfectSquare(int num) {
        int s = 1;
        int e = num;
        long square;
        int mid;
        while (s + 1 < e) {
            mid = s + (e - s)/2;
            square = (long) mid * mid;
            if (square == num) return true;
            else if (square < num) s = mid;
            else e = mid;
        }
        if (s == 1) return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
