//Given a non-empty array of integers, return the k most frequent elements.
//
// Example 1:
//
//
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
//
//
//
// Example 2:
//
//
//Input: nums = [1], k = 1
//Output: [1]
//
//
// Note:
//
//
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is t
//he array's size.
// It's guaranteed that the answer is unique, in other words the set of the top
//k frequent elements is unique.
// You can return the answer in any order.
//
// Related Topics Hash Table Heap


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /*    Success:
        Runtime:8 ms, faster than 93.87% of Java online submissions.
        Memory Usage:41.8 MB, less than 83.72% of Java online submissions.*/
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        List<Integer>[] lists = new List[nums.length+1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (lists[freq] == null) {
                lists[freq] = new ArrayList<>();
            }
            lists[freq].add(key);
        }
        int[] res = new int[k];
        int count = 0;
        for (int freq = lists.length - 1; freq > 0; --freq) {
            if (lists[freq] == null) {
                continue;
            }
            if (lists[freq].size() <= (k - count)) {
                for (int j = 0; j < lists[freq].size(); ++j) {
                    res[count+j] = lists[freq].get(j);
                }
                count = count + lists[freq].size();
            }
            else {
                for (int j = 0; j < (k - count); ++j) {
                    res[count + j] = lists[freq].get(j);
                }
                break;
            }
        }
        return res;
    }
/*    Success:
    Runtime:21 ms, faster than 14.18% of Java online submissions.
    Memory Usage:48.4 MB, less than 5.05% of Java online submissions.*/
/*    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(c);
        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        for (int i = k-1; i >= 0; --i) {
            res[i] = pq.poll();
        }
        return res;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
