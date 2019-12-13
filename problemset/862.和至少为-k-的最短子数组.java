import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=862 lang=java
 *
 * [862] 和至少为 K 的最短子数组
 */

// @lc code=start
class Solution {
    public int shortestSubarray(int[] A, int K) {
        return Solution862.shortestSubarray(A, K);
    }
}
/**
 * 1 <= A.length <= 50000
    -10 ^ 5 <= A[i] <= 10 ^ 5
    1 <= K <= 10 ^ 9
 */
class Solution862 {
    public static void main(String[] args) {
        int[] A = {17,85,93,-45,-21};
        System.out.println(shortestSubarray(A, 150));
    }
    // 错了的！是要连续的！
    public static int shortestSubarray(int[] A, int K) {
        int min = Integer.MAX_VALUE;
        // k是大于1的
        for(int i = 0; i<A.length;i++) {
            int sum = 0;
            int count = 0;
            for(int j = i;j<A.length;j++) {
                sum+=A[j];
                count++;
                if(sum<0 || sum>=K) {
                    if(sum>=K) {
                        min = Math.min(count, min);
                    }
                    break;
                }

            }
        }
        return min == Integer.MAX_VALUE?-1:min;
    }
}
// @lc code=end

