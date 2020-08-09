//Given an unsorted array of integers, find the length of longest increasing sub
//sequence.
//
// Example:
//
//
//Input: [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the
//length is 4.
//
// Note:
//
//
// There may be more than one LIS combination, it is only necessary for you to r
//eturn the length.
// Your algorithm should run in O(n2) complexity.
//
//
// Follow up: Could you improve it to O(n log n) time complexity?
// Related Topics Binary Search Dynamic Programming
// 👍 4990 👎 111

import dp.DPTest;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

   /* public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        // tail 数组的定义：长度为 i + 1 的上升子序列的末尾最小是几
        int[] tail = new int[len];
        // 遍历第 1 个数，直接放在有序数组 tail 的开头
        tail[0] = nums[0];
        // end 表示有序数组 tail 的最后一个已经赋值元素的索引
        int end = 0;

        for (int i = 1; i < len; i++) {
            // 【逻辑 1】比 tail 数组实际有效的末尾的那个元素还大
            if (nums[i] > tail[end]) {
                // 直接添加在那个元素的后面，所以 end 先加 1
                tail[++end] = nums[i];
            } else {
                // 使用二分查找法，在有序数组 tail 中
                // 找到第 1 个大于等于 nums[i] 的元素，尝试让那个元素更小
                int left = 0;
                int right = end;
                while (left < right) {
                    // 选左中位数不是偶然，而是有原因的，原因请见 LeetCode 第 35 题题解
                    // int mid = left + (right - left) / 2;
                    int mid = left + ((right - left) >>> 1);
                    if (tail[mid] < nums[i]) {
                        // 中位数肯定不是要找的数，把它写在分支的前面
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                // 走到这里是因为 【逻辑 1】 的反面，因此一定能找到第 1 个大于等于 nums[i] 的元素
                // 因此，无需再单独判断
                tail[left] = nums[i];
            }
            // 调试方法
            printArray(nums[i], tail);
        }
        // 此时 end 是有序数组 tail 最后一个元素的索引
        // 题目要求返回的是长度，因此 +1 后返回
        end++;
        return end;
    }*/

    /*    Success:
        Runtime:0 ms, faster than 100.00% of Java online submissions.
        Memory Usage:37.6 MB, less than 59.04% of Java online submissions.*/
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int len = nums.length;
        int[] tail = new int[len];
        tail[0] = nums[0];
        int end = 0;
        for (int i = 1; i < len; ++i) {
            if (nums[i] > tail[end]) {
                tail[++end] = nums[i];
            } else {
                int left = 0;
                int right = end;
                int mid = 0;
                while (left <= right) {
                    mid = (left + right) >>> 1;
                    if (tail[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                tail[left] =nums[i];
            }
            //printArray(nums[i], tail);
        }
        return ++end;
    }

    public int binarySearch(int[] nums, int s, int e, int target) {
        int mid = 0;
        while (s < e) {
            mid = (s + e) >> 1;
            if (nums[mid] >= target) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }

        return mid;
    }

    private void printArray(int num, int[] tail) {
        System.out.print("当前数字：" + num);
        System.out.print("\t当前 tail 数组：");
        int len = tail.length;
        for (int i = 0; i < len; i++) {
            if (tail[i] == 0) {
                break;
            }
            System.out.print(tail[i] + ", ");
        }
        System.out.println();
    }


/*    Success:
    Runtime:12 ms, faster than 52.12% of Java online submissions.
    Memory Usage:37.6 MB, less than 56.65% of Java online submissions.*/
/*    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] f = new int[nums.length];
        f[0] = 1;
        int max = 1;
        for(int i = 1; i < f.length; ++i) {
            f[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) f[i] = Math.max(f[i], f[j] + 1);

            }
            max = Math.max(f[i], max);
        }
        return max;
    }*/
    //思路过于复杂，造成bug重重。
    //试图为每个升序子序列建一个链表，复杂度可想而知，写出来只是为了练习。
    //failed attempt:
    /*
    		Wrong Answer:
				input:[1,3,6,7,9,4,10,5,6]
				Output:7
				Expected:6
		[10,9,2,5,3,7,101,18]
[1,3,6,7,9,4,10,5,6]
[1,2,3,4,5,6,7,8]
[3,5,6,2,5,4,19,5,6,7,12]
     */
/*    class Node {
        int val;
        int depth = 1;
        Map<Integer, Node> nextNodes = new HashMap<>();
        Node (int val) {
            this.val = val;
        }
    }

    //Brute Force;
    public int lengthOfLIS(int[] nums) {
        Node[] nodes = new Node[nums.length];
        for (int i = 0; i < nodes.length; ++i) nodes[i] = new Node(nums[i]);
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            max = Math.max(helper(nums, nodes, i), max);
        }
        return max;
    }

    private int helper(int[] nums, Node[] nodes, int idx) {
        for (int i = idx + 1; i < nodes.length; ++i) {
            if (nums[i] > nodes[idx].val) {
                insert(nodes[idx], nodes[i]);
            }
        }
        return nodes[idx].depth;
    }
    private void insert(Node node1, Node node2) {
        if (node1.nextNodes.containsValue(node2)) return;
        boolean inserted = false;
        for (Node node : node1.nextNodes.values()) {
            if (node2.val > node.val) {
                insert(node, node2);
                inserted = true;
                node1.depth = Math.max(node1.depth, node.depth+1);
            }
        }
        if (!inserted) {
            node1.nextNodes.put(node2.val, node2);
            node1.depth = Math.max(node1.depth, node2.depth+1);
        }
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
