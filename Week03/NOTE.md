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