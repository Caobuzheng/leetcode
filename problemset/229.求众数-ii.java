/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 求众数 II
 */

// @lc code=start
class Solution {
    // 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素
    // 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)
    // 输入: [1,1,1,3,3,2,2,2]
    // 输出: [1,2]
    public List<Integer> majorityElement(int[] nums) {
        // 可能是1个，也可能是2个，也可能是3个。
        // 如果是sort，那么时间复杂度就上去了
        // 那么就是多指针？最多是3个指针，但是这个指针怎么改变，有点难的呀。
    }
}
// @lc code=end

