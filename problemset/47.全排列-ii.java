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
 * 之前速度比较慢。这回重新做虾
 * 重新做了一遍，还是16ms。
 */
// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return PermuteUnique.permuteUnique2(nums);
    }
}

class PermuteUnique {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> res = permuteUnique2(nums);
        /**
         * [
            [1,1,2],
            [1,2,1],
            [2,1,1]
           ]
         */
        System.out.println(res.size());
    }

    static List<List<Integer>> res;
    static Map<Integer, Integer> map;
    public static List<List<Integer>> permuteUnique2(int[] nums) {
        res = new LinkedList<>();
        map = new HashMap<>();
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0) +1);
        }
        permuteHelp(nums, 0);
        return res;
    }
    static void  permuteHelp(int[] nums, int index) {
        if(index == nums.length) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for(int i: map.keySet()) {
            int c = map.get(i);
            if(c > 0 ) {
                map.put(i, c-1);
                nums[index] = i;
                permuteHelp(nums, index+1);
                map.put(i, c);
            }else {
                continue;
            }
        }
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

