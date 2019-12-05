/*
 * @lc app=leetcode.cn id=1043 lang=java
 *
 * [1043] 分隔数组以得到最大和
 */

// @lc code=start
import java.util.*;
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        return So1043.maxSumAfterPartitioning(A, K);
    }
}
/**
 * 输入：A = [1,15,7,9,2,5,10], K = 3
输出：84
解释：A 变为 [15,15,15,9,10,10,10]

1 <= K <= A.length <= 500
0 <= A[i] <= 10^6
 */
class So1043 {
    public static int maxSumAfterPartitioning(int[] A, int K) {
        int sum = 0;
        // 为啥感觉就是选择topN的啊。
        // 感觉也是用队列的，不过得证明，那个贪心的方法是正确的。
        // 长度最多为K个的呀。
        // 我靠，这个是挺难的啦
        // 然后就是了的。
        return sum;
    }
}
// @lc code=end

