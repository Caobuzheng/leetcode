/*
 * @lc app=leetcode.cn id=540 lang=java
 *
 * [540] 有序数组中的单一元素
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        return Solution540.singleNonDuplicate(nums);
    }
}

class Solution540 {
    public static void main(String[] args) {
        // System.out.println(singleNonDuplicate(new int[]{1,1,2}));
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid == 0) {
                if (nums[mid] != nums[mid + 1])
                    return nums[mid];
                else {
                    l = mid+1;
                }
            } else if (mid == nums.length - 1) {
                if (nums[mid] != nums[mid - 1])
                    return nums[mid];
                else {
                    r = mid - 1;
                }
            } else {
                if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                    return nums[mid];
                }
                else {
                    int left = mid - l;
                    if(nums[mid] == nums[mid - 1]) {
                        left--;
                    }
                    if(left % 2==0) {
                        l = left+l+2;
                    }else {
                        r = left+l;
                    }
                }
            }
        }
        return -1;
    }
}
// @lc code=end
