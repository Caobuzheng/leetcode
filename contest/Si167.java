import java.util.*;

class Si167{
    public static void main(String[] args) {
        int[][] gird = {{0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,1,1,1,1,0,0,0,1,1},{1,1,1,1,1,0,0,1,0,0,1,1,0,1,0,1,1,0,1,0,0,1,0,0,1,0,1,1,1,0,1,0,0,0},{1,0,0,1,0,0,1,0,0,1,0,0,1,1,1,0,0,1,0,1,1,1,1,0,0,0,0,0,0,1,1,1,0,0},{0,0,1,0,0,1,0,1,0,0,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,0,0,1,0,0,1,1,0,0},{1,1,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0},{0,1,0,1,0,0,0,1,0,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,1,1,1,0,0,0,0,1,1},{0,0,0,0,0,0,0,0,0,1,1,0,0,1,0,1,1,0,1,1,1,0,0,1,1,1,1,1,0,1,0,0,1,0},{1,0,0,1,0,0,0,0,1,1,0,0,1,0,1,0,0,0,0,1,0,1,1,0,0,1,0,0,1,0,0,1,0,1},{1,1,1,0,0,1,0,0,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,0,0,1,0,0,0,1,0,0,1,0}};
        System.out.println(shortestPath(gird, 283));
    }

    public static int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] mem = new int[m][n][k+1];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++) {
                for(int kk = 0;kk<=k;kk++) {
                    mem[i][j][kk] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] gos = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        mem[0][0][k] = 0;
        queue.add(new int[]{0,0,k});
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for(int i = 0;i<size;i++) {
                int[] xy = queue.poll();
                
                if(xy[0] == m-1 && xy[1] == n-1) return count-1;
                for(int[] go: gos) {
                    int x = xy[0] + go[0];
                    int y = xy[1] + go[1];
                    if(x<0 || x >= m || y<0 || y >= n) {
                        continue;
                    }
                    int more = xy[2];
                    if(more ==0 && grid[x][y] == 1) {
                        continue;
                    }

                    if(grid[x][y] == 1) {
                        more--;
                    }

                    boolean flag = false;
                    for(int kk = k; kk>=more && !flag; kk--) {
                        if(mem[x][y][kk] <= count){
                            flag = true;
                        }
                    }
                    if(flag) continue;
                    // 8 8 274
                    // 8 9 273
                    mem[x][y][more] = count;
                    queue.add(new int[]{x,y,more});
                }
            }
        }
        return -1;
    }







    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int max = Math.min(m,n);
        int ans = 0;
        for(int c = 1; c<max;c++) {
            int tmp = 0;
            for(int i = 0;i<m-c;i++){
                for(int j = 0;j<n-c;j++) {
                    int sum = 0;
                    for(int ii = i;ii<i+c;ii++) {
                        for(int jj=j;jj<j+c;jj++) {
                            sum+=mat[ii][jj];
                        }
                    }
                    if(sum<=threshold) tmp++;
                }
            }
            if(tmp==0) break;
            ans+=tmp;
        }
        return ans;
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new LinkedList<>();
        int lenHigh = 0;
        int lenLow = 0;
        int tmp = high;
        while(tmp !=0) {
            lenHigh++;
            tmp/=10;
        }
        tmp = low;
        int min = 1;
        while(tmp != 0) {
            lenLow++;
            tmp/=10;
        }

        for(int i = lenLow;i<=lenHigh;i++) {
            for(int j = min;j<=9-i+1;j++) {
                int c = 0;
                for(int k = 0;k<i;k++) {
                    c = c*10+(k+j);
                }
                if(c>=low && c<=high) {
                    ans.add(c);
                }
            }
        }
        return ans;
    }
}