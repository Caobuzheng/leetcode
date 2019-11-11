import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (54.62%)
 * Likes:    170
 * Dislikes: 0
 * Total Accepted:    25.5K
 * Total Submissions: 46.6K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */
// 依旧是回溯，这个怎么说，我最好是每一类的算法题，都有一套自己的解题模板。这样的话，是不是以后看到啥样的题了，我就XX了的。
// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return PermuteUnique.permuteUnique(nums);
    }
}
class PermuteUnique {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> res = permuteUnique(nums);
        System.out.println(res.size());
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] tmp = new int[nums.length];
        helper(map, tmp, 0, res);
        return res;
    }
    private static void helper(Map<Integer, Integer> map, int[] tmp, int tmpIndex, List<List<Integer>> res) {
        if(tmpIndex == tmp.length) {
            List<Integer> list = Arrays.stream(tmp).boxed().collect(Collectors.toList());
            res.add(list);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue()>0) {
                tmp[tmpIndex] = entry.getKey();
                int count = entry.getValue();
                map.put(entry.getKey(), count-1);
                helper(map, tmp, tmpIndex+1, res);
                map.put(entry.getKey(), count);
            }
        }
    }
}
// @lc code=end

