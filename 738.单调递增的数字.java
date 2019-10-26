// Accepted
// 302/302 cases passed (1 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 68 % of java submissions (33.5 MB)
/*
 * @lc app=leetcode.cn id=738 lang=java
 *
 * [738] 单调递增的数字
 *  
 * 
 * https://leetcode-cn.com/problems/monotone-increasing-digits/description/
 *
 * algorithms
 * Medium (40.42%)
 * Likes:    29
 * Dislikes: 0
 * Total Accepted:    2.1K
 * Total Submissions: 5.1K
 * Testcase Example:  '10'
 *
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * 
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * 
 * 示例 1:
 * 
 * 输入: N = 10
 * 输出: 9
 * 
 * 
 * 示例 2:
 * 
 * 输入: N = 1234
 * 输出: 1234
 * 
 * 
 * 示例 3:
 * 
 * 输入: N = 332
 * 输出: 299
 * 
 * 
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 * 
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int N) {
        return MonotoneIncreasingDigits.monotoneIncreasingDigits(N);
    }
}
class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        System.err.println(monotoneIncreasingDigits(10));
        System.err.println(monotoneIncreasingDigits(1234));
        System.err.println(monotoneIncreasingDigits(99991));
        System.err.println(monotoneIncreasingDigits(332));
        System.err.println(monotoneIncreasingDigits(325)); // 299. 
    }
    public static int monotoneIncreasingDigits(int N) {
        // type one, 1 and 0 like 10 or 100
        if(N<10) return N;
        char[] chars = String.valueOf(N).toCharArray();
        int[] nums = new int[chars.length];
        int index = nums.length;
        
        for(int i=0; i<chars.length; i++) {
            nums[i] = chars[i] - '0';
        }

        boolean tag = false;
        for(int i= nums.length-1; i>0; i--) {
            if(tag) {
                nums[i]--;
                tag = false;
            }
            if(nums[i] < nums[i-1]) {
                tag = true;
                index = i;
            }
        }
        if(tag) {
            nums[0]--;
        }
        int res = 0;
        for(int i=0; i<nums.length; i++) {
            if(i<index) {
                res = res * 10 + nums[i];
            }else {
                res = res * 10 + 9;
            }
        }
        return res;
    }
}
// @lc code=end

