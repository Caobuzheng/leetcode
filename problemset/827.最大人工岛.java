/*
 * @lc app=leetcode.cn id=827 lang=java
 *
 * [827] 最大人工岛
 */

 import java.util.*;
// @lc code=start
class Solution {
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] color = new int[m][n];
        int colorIndex = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && color[i][j]==0) {
                    bfs(grid, i, j, m, n, color, map, colorIndex);
                    colorIndex++;
                }
            }
        }
        int ans = 1;
        for(int max: map.values()) {
            ans = Math.max(max, ans);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    set.add(getColor(i-1, j, m, n, color));
                    set.add(getColor(i+1, j, m, n, color));
                    set.add(getColor(i, j-1, m, n, color));
                    set.add(getColor(i, j+1, m, n, color));
                    int tmp = 1;
                    for(int c: set) {
                        tmp+=map.getOrDefault(c, 0);
                    }
                    ans = Math.max(tmp, ans);
                }
            }
        }
        return ans;
    }

    int getColor(int x, int y, int m, int n, int[][] color) {
        if(x >= 0 && x < m && y >= 0 && y < n) {
            return color[x][y];
        }else {
            return 0;
        }
    }

    void bfs(int[][] grid, int x, int y, int m, int n, int[][] color, Map<Integer, Integer> map, int colorIndex) {
        if(x >= 0 && x < m && y >= 0 && y < n) {
            if(grid[x][y] == 1 && color[x][y] == 0) {
                map.put(colorIndex, map.getOrDefault(colorIndex, 0) + 1);
                color[x][y] = colorIndex;
                bfs(grid, x-1, y, m, n, color, map, colorIndex);
                bfs(grid, x+1, y, m, n, color, map, colorIndex);
                bfs(grid, x, y-1, m, n, color, map, colorIndex);
                bfs(grid, x, y+1, m, n, color, map, colorIndex);
            }
        }
    }
}
// @lc code=end

