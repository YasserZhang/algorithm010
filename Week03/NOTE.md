学习笔记

#### On Climbing Stairs
通常可以用DP来解答，第一次看到用线性代数的方法来做。但是官方给出的答案在解释如何用非齐次线性递推转为齐次线性递推的方法来实现矩阵快速幂这一块个人觉得有点画蛇添足。其实在推导出斐波那契数列可以是一个简单2维矩阵的n次方后，接下来完全可以用二分法来解释如何实现n次方的O（logn）解。如果这样解释，会更方便理解。

#### 递归模板
```
// Java
public void recur(int level, int param) { 
  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 
  process(level, param); 
  // drill down 
  recur( level: level + 1, newParam); 
  // restore current status 
 
}
```

####BFS vs. DFS
尝试分别用BFS和DFS解同一道题，结果总是DFS远快于BFS。虽然没有做更深入的研究，但我觉得这主要是因为BFS需要在堆中新开一个queue导致其运行速度不如DFS。
而DFS可以在栈内搞定所有运算。

#### Divide and Conquer
```python
# Python
def divide_conquer(problem, param1, param2, ...): 
  # recursion terminator 
  if problem is None: 
	print_result 
	return 
  # prepare data 
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 
  # conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …
  # process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
	
  # revert the current level states
```

#### Backtracking
心得：  
一般回溯方法可以用于求某个集合的所有排列方式或者所有子集。  
当我们穷举出所有情况以后，我们会发现这么一个特点：
在任何一种情况（或者说子集）中，集合中的每一个元素，其实就两种状态：要么它存在于这种情况（子集）中；要么它不存在。
顺着这个思路，我们用递归遍历所有元素，对每个元素，我们先考虑它存在的场景(add)，然后再考虑它不存在时的场景（reverse）。这样即可穷举所有情况。