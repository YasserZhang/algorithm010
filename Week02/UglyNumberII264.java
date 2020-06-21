//Write a program to find the n-th ugly number.
//
// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
//
// Example:
//
//
//Input: n = 10
//Output: 12
//Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ug
//ly numbers.
//
// Note:
//
//
// 1 is typically treated as an ugly number.
// n does not exceed 1690.
// Related Topics Math Dynamic Programming Heap


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    解题要点：
    1. 下一个丑数必定是前面某个丑数再乘以2，3，或5。所以这是可化解为子问题的动态规划题。
    2. 那么那某个丑数到底是哪个呢？我们可以为2，3，和5分别取一个指针，即a,b,c。
    那么，下一个丑数num[i]应该会有以下特性：
    num[a]*2 <= num[i] < num[a+1]*2;
    num[b]*3 <= num[i] < num[b+1]*3;
    num[c]*5 <= num[i] < num[c+1]*5;
    也就是说，下一个丑数必定在上述的范围，然后根据要点1，我们再从num[a]*2, num[b]*3, num[c]*5中取出最小值，即为下一个丑数。
     */
/*    Success:
    Runtime:4 ms, faster than 52.47% of Java online submissions.
    Memory Usage:39.6 MB, less than 12.58% of Java online submissions.*/
    //DP + pointers
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] u = new int[n];
        u[0] = 1;
        for (int i = 1; i < n; ++i) {
            u[i] = Math.min(Math.min(u[a]*2, u[b]*3), u[c]*5);
            if (u[i] == u[a]*2) a++;
            if (u[i] == u[b]*3) b++;
            if (u[i] == u[c]*5) c++;
        }
        return u[n-1];
    }


    //brute force
/*    Compile Error:
    Time Limit Exceeded
    stdout:
            null*/
/*    public int nthUglyNumber(int n) {
        if (n <= 1) {
            return 1;
        }
        int count = 1;
        int num = 1;
        while (count < n) {
            int temp = ++num;
            while (temp % 2 == 0 || temp % 3 == 0 || temp % 5 == 0) {
                if (temp % 2 == 0) {
                    temp = temp/2;
                }
                if (temp % 3 == 0) {
                    temp = temp / 3;
                }
                if (temp % 5 == 0) {
                    temp = temp / 5;
                }
            }
            if (temp == 1) {
                ++count;
            }
        }
        return num;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
