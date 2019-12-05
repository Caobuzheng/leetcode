import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=495 lang=java
 *
 * [495] 提莫攻击
 */

// @lc code=start
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        if (n == 0) return 0;

        int total = 0;
        // 这个就直接是公交车问题的呀。
        for(int i = 0; i < n - 1; ++i)
          total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        return total + duration;
    }
}
class So495 {
    public static void main(String[] args) {
        int[] timeSeries = {1,4};
        System.out.println(findPoisonedDuration(timeSeries, 2));
        int[] timeSeries2 = {1,2};
        System.out.println(findPoisonedDuration(timeSeries2, 2));
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        // Arrays.sort(timeSeries);
        int start = 0;
        int end = 0;
        int dd = 0;
        for(int i: timeSeries) {
            if(i>end) {
                dd += (end-start);
                end = i + duration;
                start = i;
            }else {
                end = Math.max(end, i+duration);
            }
        }
        dd +=(end-start);
        return dd;
    }
}
// @lc code=end

