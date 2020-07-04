//Implement int sqrt(int x).
//
// Compute and return the square root of x, where x is guaranteed to be a non-ne
//gative integer.
//
// Since the return type is an integer, the decimal digits are truncated and onl
//y the integer part of the result is returned.
//
// Example 1:
//
//
//Input: 4
//Output: 2
//
//
// Example 2:
//
//
//Input: 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since
//             the decimal part is truncated, 2 is returned.
//
// Related Topics Math Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        long left = 1;
        long right = x / 2;
        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            // long mid = left + (right - left + 1) / 2;
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 因为一定存在，因此无需后处理
        return (int) left;
    }

    //官方 牛顿法
/*    Success:
    Runtime:2 ms, faster than 29.90% of Java online submissions.
    Memory Usage:38.8 MB, less than 5.94% of Java online submissions.*/
/*    public int mySqrt(int x) {
        if (x==0) {
            return 0;
        }
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) break;
            x0 = xi;
        }
        return (int)x0;
    }*/

    //官方
/*    Success:
    Runtime:2 ms, faster than 29.90% of Java online submissions.
    Memory Usage:37.1 MB, less than 24.01% of Java online submissions.*/
/*    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }*/

/*    Success:
    Runtime:2 ms, faster than 29.90% of Java online submissions.
    Memory Usage:38.8 MB, less than 7.05% of Java online submissions.*/
/*    public int mySqrt(int x) {
        int s = 1;
        int e = x;
        int mid;
        long square;
        while (s + 1 < e) {
            mid = s + (e - s) / 2;
            square = (long) mid * mid;
            if (square == x) {
                return mid;
            } else if (square < x) {
                s = mid;
            } else {
                e = mid;
            }
        }
        if (s*s <= x) return s;
        return e;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
