import java.util.Arrays;
import java.util.stream.Collector;

/*
 * ac 265/265 cases passed (2 ms)
 * Your runtime beats 50.77 % of java submissions
 * 
 * 
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        Solution31.nextPermutation(nums);
    }
}
class Solution31 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        test(nums);
        int[] nums2 = {4,3,2,1};
        test(nums2);
        int[] nums3 = {1,2,4,3,1}; // 这也不对的.也不对的哦
        test(nums3);
    }
    private static void test(int[] nums) {
        String str = Arrays.stream(nums).boxed().map(i->i.toString())
        .reduce((i1,i2) -> i1+","+i2).get();
        nextPermutation(nums);
        str = str + " -> " + Arrays.stream(nums).boxed().map(i->i.toString())
        .reduce((i1,i2) -> i1+","+i2).get();
        System.out.println(str);
    }

    public static void nextPermutation(int[] nums) {
        if(nums.length <=1) return;
        int max = nums[nums.length-1];
        int i= nums.length-2;
        for(;i>=0;i--){
            if(nums[i]<max) {
                break;
            } else {
                max = nums[i];
            }
        }
        // 下面sort的思路不是很好
        for(int j = nums.length-1;j>i && i>=0;j--) {
            if(nums[j] > nums[i]) {
                swap(nums,i,j);
                break;
            }
        }
        Arrays.sort(nums, i+1, nums.length);
    }
    private static void swap(int[] nums, int a ,int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}
// @lc code=end

