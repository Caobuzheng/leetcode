/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3) return 0;
        int ans = 0;
        List<Map<Integer, Integer>> dp = new ArrayList<>(A.length);
        // 直接初始化。
        for(int i = 0;i<A.length;i++) {
            dp.add(new HashMap<>());
        }
        dp.get(1).put(A[1]-A[0], 0);
        for(int i = 2;i<A.length;i++) {
            int j = i-1;
            int c = A[i] - A[j];
            int n = dp.get(j).getOrDefault(c, -1) + 1;
            ans += n;
            dp.get(i).put(c, n);
        }
        return ans;
    }
}
// @lc code=end

