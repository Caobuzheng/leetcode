/*
 * @lc app=leetcode.cn id=1027 lang=java
 *
 * [1027] 最长等差数列
 */
import java.util.*;
// @lc code=start
class Solution {
    /**
     * 2 <= A.length <= 2000
        0 <= A[i] <= 10000
     */
    public int longestArithSeqLength(int[] A) {
        return So1027.longestArithSeqLength(A);
    }
}

class So1027{
    public static void main(String[] args) {
        int[] A = {20,1,15,3,10,5,8};
        int[] B= {9,4,7,2,10};
        int[] C= {9,9,9,9,10}; // 咋还是7了
        int[] D= {};
        System.out.println(longestArithSeqLength(A));
        System.out.println(longestArithSeqLength(B));
        System.out.println(longestArithSeqLength(C));
        System.out.println(longestArithSeqLength(D));
    }
    // 讲道理，我觉得我的答案是准确的。就是Map用的复杂了些。
    
    public static int longestArithSeqLength(int[] A) {
        if(A.length<=2) return A.length;
        int max = 2;
        // 最大的，不过也有可能是是负数的呀
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int i = 0;i<A.length;i++) {
            map.put(i, new HashMap<>());
        }            
        for(int i = 1; i<A.length;i++) {
            for(int j = i-1; j>=0;j--) {
                int diff = A[i] - A[j];
                if(map.get(j).containsKey(diff)) {
                    int mmax = Math.max(map.get(j).get(diff)+1, map.get(i).getOrDefault(diff, 2));
                    map.get(i).put(diff, mmax);
                    max = Math.max(max, mmax);
                }else {
                    if(!map.get(i).containsKey(diff)) map.get(i).put(diff, 2);
                }
            }
        }
        // [20,1,15,3,10,5,8] 4
        // [9,4,7,2,10] 3
        return max;
    }
}
// @lc code=end

