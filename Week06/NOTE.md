学习笔记
### Unique Paths II 单行数组解法有感
```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] f = new int[n];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) { //说明此时在障碍物上，所有计算归零，跳过后面步骤
                    f[j] = 0;
                    continue;
                }
                //obstacleGrid[i][j-1] == 0 不是必须的，因为之前的if判断已经将【i】【j-1】这个位置的计算记录做了更新，但依然加上它
                //是为了避免增加一次+=的操作。
                //我专门针对加与不加这个判断条件进行了试验，如果加，每次提交代码基本都是faster than 100%；
                // 如果不加，则表现不是很稳定，有时只有30%多，而有时候能干到100%
                if (j >= 1 && obstacleGrid[i][j-1] == 0) f[j] += f[j-1];
            }
        }
        return f[n-1];
    }
}
```

### 最长公共子序列（1143）一维数组解法
这里应该注意一个地方，如果text中包含多个重复的字母，普通的一维数组解法会有问题。

比如，text1：“abceeee”，text2：“ace”

在遍历数组时，如果在j的位置，两组中对比的字母相同时，数组的j就会被更新为原值加1。那么原值就会被覆盖。这样操作在上例中就会出现问题，因为在遍历中，text1中的“e”和text2中的“e”会多次被判为相同，那么每次都会及逆行数组原值加1的操作，从而使关于“e”的判定被重复累计到最终结果。

解决的办法：
在遍历中，每次把数组中的原值复制到一个临时变量，需要加1时，把1加到临时变量上，然后再赋值回数组对应的位置。