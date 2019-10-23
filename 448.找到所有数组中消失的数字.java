import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 *
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 * algorithms
 * Easy (53.49%)
 * Likes:    215
 * Dislikes: 0
 * Total Accepted:    16.8K
 * Total Submissions: 31.3K
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 *
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 
 * 示例:
 * 
 * 
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 
 * 输出:
 * [5,6]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
      return FindDisappearedNumbers.findDisappearedNumbers(nums);
    }
}
class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = {};
        for(int i: findDisappearedNumbers(nums)) {
            System.out.println(i);
        }    
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new LinkedList<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != i+1) { // xixi , budui de 
                while(nums[i] != i+1 && nums[i] != nums[nums[i]-1]) {
                    swap(nums, nums[i]-1, i);
                }
            }
        }
        for(int i=0;i<nums.length; i++) {
            if(nums[i] != i+1) {
                res.add(i+1);
            }
        }
        return res;
    }
    private static void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
}
// @lc code=end

