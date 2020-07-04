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