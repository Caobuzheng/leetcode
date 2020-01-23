/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i<numbers.length-1;i++) {
            int c = find(numbers, i+1, numbers.length-1, target - numbers[i]);
            if(c != -1) {
                return new int[]{i+1, c+1};
            }
        }
        return new int[]{};
    }
    private int find(int[] numbers, int l, int r, int target) {
        while(l<=r && r<numbers.length) {
            int mid = (l+r)/2;
            if(numbers[mid] == target) {
                return mid;
            }else if(numbers[mid] < target) {
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return -1;
    }
}
// @lc code=end


