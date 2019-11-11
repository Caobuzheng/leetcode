import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Accepted
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 *
 * https://leetcode-cn.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (67.03%)
 * Likes:    420
 * Dislikes: 0
 * Total Accepted:    41.8K
 * Total Submissions: 62.2K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return Solution39.combinationSum(candidates, target);
    }
}
class Solution39 {
    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        List<List<Integer>> res = combinationSum(candidates, 8);
        for(List<Integer> list :res) {
            System.out.println(list.stream().map(String::valueOf).reduce((t1,t2)->t1+","+t2).get());
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new LinkedList<>(), res);
        return res;
    }
    public static void helper(int[] candidates, int target, int lastIndex, LinkedList<Integer> list , List<List<Integer>> res) {
        if(target == 0) {
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(list);
            res.add(tmp);
        }
        if(target < candidates[0]) return;
        for(int i = lastIndex; i<candidates.length && candidates[i] <= target;i++ ){
            list.addLast(candidates[i]);
            helper(candidates, target-candidates[i], i, list, res);
            list.removeLast();
        }
    }
}
// @lc code=end

