/**
 * Solution1110_3
 */
public class Solution1110_3 {

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        System.out.println(closedIsland(grid));
    }

    public static int closedIsland(int[][] grid) {
        int ans = 0;
        int x = grid.length;
        if(x == 0) return 0;
        int y = grid[0].length;
        if(y == 0) return 0;
        for(int i = 0; i < x; i ++) {
            clean(grid, i, 0);
            clean(grid, i, y-1);
        }
        for(int i = 0; i< y; i++) {
            clean(grid, 0, i);
            clean(grid, x-1, i);
        }

        for(int i = 1;i<x-1; i++) {
            for(int j = 1;j<y-1;j++) {
                if(grid[i][j] == 0) {
                    ans++;
                    clean(grid, i, j);
                }
            }
        }
        return ans;
    }
    private static void clean(int[][] grid, int x , int y) {
        if(x < 0 || y < 0 || x >= grid.length || y>= grid[0].length
            || grid[x][y] == 1
        ) return;
        grid[x][y] = 1;
        clean(grid, x+1, y);
        clean(grid, x-1, y);
        clean(grid, x, y+1);
        clean(grid, x, y-1);
    }
}