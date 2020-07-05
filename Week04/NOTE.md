学习笔记

### DFS 模板
```python
//递归
visited = set() 
def dfs(node, visited):
    if node in visited: # terminator
    	# already visited 
    	return 
	visited.add(node) 
	# process current node here. 
	...
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)

```

```python
//非递归
def DFS(self, tree): 
	if tree.root is None: 
		return [] 
	visited, stack = [], [tree.root]
	while stack: 
		node = stack.pop() 
		visited.add(node)
		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 
	# other processing work 
	...

```

### BFS 模板
```python
# Python
def BFS(graph, start, end):
    visited = set()
	queue = [] 
	queue.append([start]) 
	while queue: 
		node = queue.pop() 
		visited.add(node)
		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)
	# other processing work 
	...
```

### Binary Search
```python
# Python
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1

```

### 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

以下方法可以找到前一半有序数组的最后一位，其与另一半有序数组相连接。
```java

public class ATest {    
    
    private int findBreakPoint(int[] nums) {
        int l = 0;
        int r = nums.length;
        int mid = 0;
        while (l + 1 < r) {
            mid = (l + r) / 2;
            if (nums[l] <= nums[mid]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }
                    
    @Test
    public void findBreakPointTest() {
        int[] nums = new int[] {3,4,5,6,7,0,1,2};
        System.out.println(findBreakPoint(nums));
    }
//return 4
}
```

### 岛屿数量
为什么在找到一个“1”以后应该马上标记为“0”？  
如果这个岛屿只有零星几个“1”，没问题，在找到时标注和在while下标注差别不大。但是如果这是一个很大的岛屿，有一排接着一排的“1”，这时候就有差别了。同一个“1”会和至少4个“1”接壤。当我们遍历到它第一个“1”邻居时，我们就会发现它，然后把它丢到queue中；有可能当我们遍历到它的第二个邻居时又会再次发现它。如果第一发现时没有把它标注为“0”，那么在第二次发现时它又会被丢到queue中了。这样就会出现重复计算。
动画演示可以看一下这个链接：https://leetcode-cn.com/problems/number-of-islands/solution/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/