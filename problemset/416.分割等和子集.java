import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/*
 * Accepted
 * 105/105 cases passed (44 ms)
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 *
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/description/
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        return Solution416.canPartition(nums);
    }
}
class Solution416 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        int[] nums2 = {1, 2, 3, 5};
        System.out.println(canPartition(nums));
        System.out.println(canPartition(nums2));
    }

    static boolean finded = false;
    public static boolean canPartition(int[] nums) {
        finded = false;
        int sum = Arrays.stream(nums).sum();
        if((sum&1) == 1) return false;
        Arrays.sort(nums);
        canMatch(nums, nums.length-1, sum/2);
        return finded;
    }

    public static void canMatch(int[] nums, int index, int target) {
        if(finded) return;
        if(target == 0) {
            finded = true;
        }
        // 这个是ac了。
        for(int i = index; i>=0 && nums[i] <=target; i--) {
            canMatch(nums, i - 1, target - nums[i]);
        }
    }

}
// @lc code=end

