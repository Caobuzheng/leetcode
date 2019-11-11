/**
 * Solution1110_1
 */
public class Solution1110_1 {

    public static void main(String[] args) {
        int[][] indices = {{1,1},{0,0}};
        System.out.println(oddCells(2, 2, indices));
    }
    public static int oddCells(int n, int m, int[][] indices) {
        // 这个就是个模拟就行了
        int[][] tags = new int[n][m];
        for(int[] idx: indices) {
            for(int j = 0; j<m; j++) {
                tags[idx [0]][j]++;
            }
            for(int i =0;i<n;i++) {
                tags[i][idx[1]]++;
            }
        }

        int ans = 0;
        for(int i=0; i<n;i++) {
            for(int j = 0; j<m; j++) {
                if(tags[i][j] % 2 == 1) ans++;
            }
        }
        return ans;
    }
}