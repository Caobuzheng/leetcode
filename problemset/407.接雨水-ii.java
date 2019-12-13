/*
 * @lc app=leetcode.cn id=407 lang=java
 *
 * [407] 接雨水 II
 */

// @lc code=start
class Solution {
    public static int trapRainWater(int[][] heightMap) {
        // 错了的。这个完全是不对了的。
        // 110的整数奥。 就是可以4次的奥。
        // 感觉深度是比较靠谱的。
        
        int m = heightMap.length;
        if(m<=2) return 0;
        int n = heightMap[0].length;
        if(n<=2) return 0;
        // 完蛋，果然是碰到Hard的就不想写。
        // 必须写！
        int[][] mnL = new int[m][n];
        int[][] mnR = new int[m][n];
        // 这个是挺烦的
        int[][] nmU = new int[n][m];
        int[][] nmD = new int[n][m];

        for(int i = 0; i< m;i++) {
            mnL[i][0] = heightMap[i][0];
            for(int j = 1; j<n-1;j++) {
                mnL[i][j] = Math.max(heightMap[i][j], mnL[i][j-1]);
            }
            mnR[i][n-1] = heightMap[i][n-1];
            for(int j = n-2; j>=0;j--){
                mnR[i][j] = Math.max(heightMap[i][j], mnL[i][j+1]);
            }
        }
        for(int i = 0; i< n;i++) {
            nmU[i][0] = heightMap[0][i];
            for(int j = 1; j<m-1;j++) {
                nmU[i][j] = Math.max(heightMap[j][i], nmU[i][j-1]);
            }
            System.out.println("");
            nmD[i][m-1] = heightMap[m-1][i];
            for(int j = m-2; j>=0;j--){
                nmD[i][j] = Math.max(heightMap[j][j], nmD[i][j+1]);
            }
        }
        int ans = 0;
        for(int i = 1;i<m-1;i++) {
            for(int j = 1;j<n-1;j++) {
                int l = mnL[i][j-1];
                int r = mnR[i][j+1];
                int u = nmU[j][i-1];
                int d = nmD[j][i+1];
                int min = Math.min(Math.min(Math.min(l, r),u),d);
                if(min > heightMap[i][j]) {
                    ans += (min-heightMap[i][j]);
                }
            }
        }
        return ans;
    }
}

// @lc code=end

