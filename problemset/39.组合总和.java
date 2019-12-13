import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Accepted
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 * ac
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

    
    
    static List<List<Integer>> res;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new LinkedList<>();
        if(candidates.length == 0) return res;
        Arrays.sort(candidates);
        help(candidates, target, 0, new LinkedList<>());
        return res;
    }
    public static void help(int[] candidates, int target, int index, LinkedList<Integer> history) {
        if(target == 0) {
            res.add(new LinkedList<>(history));
        }else if(target < candidates[index]){
            return;
        }
        for(int i = index; i<candidates.length; i++) {
            if(candidates[i]>target) break;
            history.add(candidates[i]);
            help(candidates,target-candidates[i],i,history);
            history.pollLast();
        }
    }
}
// @lc code=end

