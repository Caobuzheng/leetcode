/*
 * @lc app=leetcode.cn id=969 lang=java
 *
 * [969] 煎饼排序
 */

 import java.util.*;
// @lc code=start
class Solution {
    public List<Integer> pancakeSort(int[] A) {
        return So969.pancakeSort(A);
    }
}
class So969 {
    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new LinkedList<>();
        boolean tag = true;
        int index = A.length-1;
        while(tag && index>0) {
            tag = false;
            int max = A[0];
            int maxIndex = 0;
            for(int i=1;i<=index;i++) {
                if(A[i] > max) {
                    max = A[i];
                    maxIndex = i;
                }else {
                    tag = true;
                }
            }
            if(tag) {
                if(maxIndex != index) {
                    if(maxIndex >0) {
                        ans.add(maxIndex+1);
                        pancakeSwap(A, maxIndex);    
                    }
                    ans.add(index+1);
                    pancakeSwap(A, index);
                }
                index--;
            }
        }
        return ans;
    }
    static void pancakeSwap(int[] A, int index) {
        if(index == 0) return;
        int l = 0;
        int r = index;
        while(l<r) {
            int tmp = A[l];
            A[l++] = A[r];
            A[r--] = tmp;
        }
    }
}
// @lc code=end

