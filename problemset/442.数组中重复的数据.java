/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] 数组中重复的数据
 */
import java.util.*;
// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        return Solution442.findDuplicates(nums);
    }
}
class Solution442 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        for(int i: findDuplicates(nums)) {
            System.out.println(i);
        }
    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        for(int i: nums) {
            int ab = Math.abs(i);
            if(nums[ab-1] < 0) {
                ans.add(ab);
            }else {
                nums[ab-1] = -nums[ab-1];
            }
        }
        return ans;
    }

}

// @lc code=end

