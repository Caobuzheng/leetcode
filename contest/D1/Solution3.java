import java.util.Arrays;

class Solution1066{
    public static void main(String[] args) {
        
    }

    public static int assignBikes(int[][] workers, int[][] bikes) {
        int ans = 0;
        int[][] mht = new int[workers.length][bikes.length+1];
        for(int i = 0; i< workers.length; i++) {
            for(int j = 0; j< bikes.length; j++) {
                mht[i][j] = Math.abs(bikes[j][0] - workers[i][0]) + Math.abs(bikes[j][1] - workers[i][1]);
                mht[i][bikes.length] += mht[i][j];
            }
        }
        // 果然还是不对。因为不一定是这个的。
        Arrays.sort(mht, (o1, o2) -> o2[bikes.length] - o1[bikes.length]);
        boolean[] bikesGet = new boolean[bikes.length];
        for(int i = 0; i<workers.length; i++) {
            int min = 2000;
            int index = -1;
            for(int j = 0; j< bikes.length; j++) {
                if(mht[i][j] < min && !bikesGet[j]) {
                    min = mht[i][j];
                    index = j;
                }
            }
            ans += min;
            bikesGet[index] = true;
        }
        return ans;
    }
    // 还是必须回溯的？
}