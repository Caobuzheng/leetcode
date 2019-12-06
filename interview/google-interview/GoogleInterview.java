/**
 * GoogleInterview
 */
public class GoogleInterview {
    //花园里有 N 个花盆，每个花盆里都有一朵花。这 N 朵花会在 N 天内依次开放，每天有且仅有一朵花会开放并且会一直盛开下去。
    // 给定一个数组 flowers 包含从 1 到 N 的数字，每个数字表示在那一天开放的花所在的花盆编号。
    // 例如， flowers[i] = x 表示在第 i 天盛开的花在第 x 个花盆中，i 和 x 都在 1 到 N 的范围内。
    // 给你一个整数 k，请你输出在哪一天恰好有两朵盛开的花，他们中间间隔了 k 朵花并且都没有开放。
    // 如果不存在，输出 -1。
    public static void main(String[] args) {
        GoogleInterview g = new GoogleInterview();
        int[] bulbs = {6,5,8,9,7,1,10,2,3,4};
        System.err.println(g.kEmptySlots(bulbs, 2));
    }
    public int kEmptySlots(int[] bulbs, int k) {
        
        for(int i = 0; i< bulbs.length - k - 1; i++) {
            int time = Math.max(bulbs[i], bulbs[i+k+1]);
            int j = i+1;
            boolean tag = true;
            for(; j<i+k+1; j++) {
                if(bulbs[j]<time) {
                    tag = false;
                    break;
                }
            }
            if(tag) {
                return Math.max(bulbs[i], bulbs[i+k+1]);
            }
        }
        return -1;
    }
}
