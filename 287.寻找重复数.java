/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    // 本题还有个兔子洞解法，这个我之前绝对是看过的。兔子洞解法的复杂度应该是O(N)。
    // 我的解法是O(NlogN)

    // 兔子洞
    public static int findDuplicate(int[] nums) {
        return 0;
    }

    // 二分查找的方法。
    public static int findDuplicate2(int[] nums) {
        int l = 1;
        int r = nums.length;
        // 这样好理解一些。就是
        while(l<r) {
            int mid = (l + r) /2;
            int count = 0;
            for(int i: nums) {
                if(i>=l && i<=mid) {
                    count++;
                }
            }
            if(count > (mid-l +1)) {
                r = mid;
            }else {
                l = mid+1;
            }
        }
        return l;
    }
    
    public static void main(String[] args){
        int[] nums = {1,1}; // 1 && 5; mid = 3  1&& 3 mid = 2  1 && 2 mid = 1 l = mid
        System.out.println(findDuplicate(nums));
    }
}
// @lc code=end

