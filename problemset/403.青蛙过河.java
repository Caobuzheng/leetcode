import java.util.*;

/*
 * @lc app=leetcode.cn id=403 lang=java
 *
 * [403] 青蛙过河
 */

// @lc code=start
class Solution {
    public boolean canCross(int[] stones) {
        return Solution403.canCross(stones);
    }
}
class Solution403 {
    
    public static void main(String[] args) {
        // ojbk
        int[] stones = {0,1,2,3,4,8,9,11};
        System.out.println(canCross(stones));
    }
    public static boolean canCross(int[] stones) {
        // Set<Integer>[] dp = new Set<Integer>[stones.length];
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for(int i=0;i<stones.length;i++) {
            dp.put(stones[i], new HashSet<>());
        }
        dp.get(stones[0]).add(1);

        for(int i = 0;i<stones.length;i++) {
            for(int jump: dp.get(stones[i]) ) {
                int jumpTo = stones[i]+jump;
                if(dp.containsKey(jumpTo)) {
                    Set<Integer> toSet = dp.get(jumpTo);
                    if(jump>1) {
                        toSet.add(jump-1);
                    }
                    toSet.add(jump);
                    toSet.add(jump+1);
                }
            }
        }
        return dp.get(stones[stones.length-1]).size() > 0;
    }
}
// @lc code=end

