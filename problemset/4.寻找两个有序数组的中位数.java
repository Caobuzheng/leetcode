/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (36.13%)
 * Likes:    1635
 * Dislikes: 0
 * Total Accepted:    102.2K
 * Total Submissions: 282.7K
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * 则中位数是 2.0
 * 
 * 
 * 示例 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 * 
 * 
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return FindMedianSortedArrays.findMedianSortedArrays(nums1, nums2);
    }
}
class FindMedianSortedArrays{
    // 复杂度要求O(log(m+n))
    // 方法：递归法
    // 分治
    // 然后看了官方的题解，果然没那么简单的。
    // https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-shu-b/
    //
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
       
    }

}
// @lc code=end

