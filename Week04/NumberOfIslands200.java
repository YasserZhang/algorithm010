//Given a 2d grid map of '1's (land) and '0's (water), count the number of islan
//ds. An island is surrounded by water and is formed by connecting adjacent lands
//horizontally or vertically. You may assume all four edges of the grid are all su
//rrounded by water.
//
// Example 1:
//
//
//Input:
//11110
//11010
//11000
//00000
//
//Output: 1
//
//
// Example 2:
//
//
//Input:
//11000
//11000
//00100
//00011
//
//Output: 3
// Related Topics Depth-first Search Breadth-first Search Union Find


import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*    Success:
        Runtime:2 ms, faster than 54.61% of Java online submissions.
        Memory Usage:41.8 MB, less than 79.20% of Java online submissions.*/
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int nr = grid.length;
        int nc = grid[0].length;
        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '0') continue;
                deque.push(i * nc + j);
                count++;
                dfs(grid, deque, nc, nr);
            }
        }
        return count;
    }

    private void dfs(char[][] grid, Deque<Integer> deque, int nc, int nr) {
        int index = deque.pop();
        int r = index/nc;
        int c = index%nc;
        if (c > 0 && grid[r][c-1]=='1') {
            grid[r][c-1] = '0';
            deque.push(nc* r + c - 1);
            dfs(grid, deque, nc, nr);
        }
        if (c < nc-1 && grid[r][c+1] == '1') {
            grid[r][c+1] = '0';
            deque.push(nc * r + c + 1);
            dfs(grid, deque, nc, nr);
        }
        if (r > 0 && grid[r-1][c] == '1') {
            grid[r-1][c] = '0';
            deque.push(nc*(r-1) + c);
            dfs(grid, deque, nc, nr);
        }
        if (r < nr-1 && grid[r+1][c] == '1') {
            grid[r+1][c] = '0';
            deque.push(nc*(r+1) + c);
            dfs(grid, deque, nc, nr);
        }
    }

    //BFS
    //官方
/*    Success:
    Runtime:4 ms, faster than 22.09% of Java online submissions.
    Memory Usage:41.8 MB, less than 83.27% of Java online submissions.*/
    /*public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    //grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        grid[row][col] = '0';
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }*/

    //发现“1”时立即改为“0”
/*    Success:
    Runtime:3 ms, faster than 31.76% of Java online submissions.
    Memory Usage:41.8 MB, less than 75.83% of Java online submissions.*/

    //如果在while下将“1”改为“0”
/*    Compile Error:
    Time Limit Exceeded
    stdout:
            null*/
/*    public int numIslands(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '0') continue;
                queue.add(new int[]{i, j});
                while(!queue.isEmpty()) {
                    int[] pos = queue.poll();
                    //grid[pos[0]][pos[1]] = '0';
                    checkIsland(pos, grid, queue);
                }
                count++;
            }
        }
        return count;
    }

    private void checkIsland(int[] pos, char[][]grid, Queue<int[]> queue) {
        if (pos[0] >= 1 && grid[pos[0]-1][pos[1]] == '1') {
            queue.add(new int[] {pos[0]-1, pos[1]});
            grid[pos[0]-1][pos[1]] = '0';
        }
        if (pos[0] < grid.length - 1 && grid[pos[0] + 1][pos[1]] == '1') {
            queue.add(new int[] {pos[0]+1, pos[1]});
            grid[pos[0]+1][pos[1]] = '0';
        }
        if (pos[1] >= 1 && grid[pos[0]][pos[1]-1] == '1') {
            queue.add(new int[] {pos[0], pos[1]-1});
            grid[pos[0]][pos[1]-1] = '0';
        }
        if (pos[1] < grid[0].length - 1 && grid[pos[0]][pos[1]+1] == '1') {
            queue.add(new int[] {pos[0], pos[1]+1});
            grid[pos[0]][pos[1]+1] = '0';
        }
    }*/

}
//leetcode submit region end(Prohibit modification and deletion)
