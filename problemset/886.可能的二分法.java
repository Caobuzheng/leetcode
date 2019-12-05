/*
 * @lc app=leetcode.cn id=886 lang=java
 *
 * [886] 可能的二分法
 */

// @lc code=start
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        return Solution886.possibleBipartition(N, dislikes);
    }
}
class Solution886 {
    /**
     * 输入：N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
        输出：false
        输入：N = 4, dislikes = [[1,2],[1,3],[2,4]]
        输出：true
        解释：group1 [1,4], group2 [2,3]
        输入：N = 3, dislikes = [[1,2],[1,3],[2,3]]
        输出：false 
     * @param N
     * @param dislikes
     * @return
     */
    public static void main(String[] args) {
        int[][] dislikes = {{1,2},{1,3},{2,3}};
        System.out.println(possibleBipartition(3, dislikes));
    }

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] cicle = new int[N+1][N+1];
        for(int[] dislike: dislikes) {
            cicle[dislike[0]][dislike[1]] = 1;
            cicle[dislike[1]][dislike[0]] = 1;
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(dfs(cicle, i, j, i,j,0)) return false;
            }
        }
        return true;
    }
    private static boolean dfs(int[][] cicle, int x, int y, int ox, int oy, int count) {
        if(cicle[x][y] == 1) return false;
        if(count!= 0 && x==ox && y==oy) return true;
        boolean tag = false;
        cicle[x][y] = 0;
        for(int i = 0; i< cicle.length; i++) {
            if(cicle[y][i] == 1) {
                tag = tag || dfs(cicle, y, i, ox, oy,count+1) || dfs(cicle, y, i, x, y, 0);
            }
        }
        return tag;
    }
}
// @lc code=end

