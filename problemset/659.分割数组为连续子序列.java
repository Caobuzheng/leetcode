/*
 * @lc app=leetcode.cn id=659 lang=java
 *
 * [659] 分割数组为连续子序列
 */

// @lc code=start
class Solution {
    public boolean isPossible(int[] nums) {
        return Solution659.isPossible(nums);
    }
}
class Solution659 {
    public static void main(String[] args) {
        System.out.println(isPossible(new int[]{1,2,3,3,4,5}));
        System.out.println(isPossible(new int[]{1,2,3,4,4,5}) +"  "+ false);
        System.out.println(isPossible(new int[]{1,2,3,4,4,4}) +"  "+ true);
    }
    public static boolean isPossible(int[] nums) {
        if(nums.length<3) return false;
        int count = -1;
        int c = nums[0];
        // 这里就是有那么点绕了的。
        for(int i :nums) {

        }
        return true;
    }
    // check 每一个。也可能
}
// @lc code=end

