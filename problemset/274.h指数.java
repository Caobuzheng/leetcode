import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=274 lang=java
 *
 * [274] H指数
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        return Solution274.hIndex(citations);
    }
}
class Solution274 {
    public static void main(String[] args) {
        int[] citations = {1,2};
        System.out.println(hIndex(citations));
    }
    /**
     * h 指数的定义: “h 代表“高引用次数”（high citations），
     * 一名科研人员的 h 指数是指他（她）的 （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。
     * （其余的 N - h 篇论文每篇被引用次数不多于 h 次。
     * 如果 h 有多种可能的值，h 指数是其中最大的那个。
     */
    public static int hIndex(int[] citations) {
        if(citations.length==0) return 0;
        if(citations.length==1) return citations[0]>0?1:0;
        Arrays.sort(citations);
        for(int i = citations.length-1;i>=0;i--) {
            int h = citations.length-i+1;
            int c = i==0?0:citations[i-1];
            int b = citations[i];
            for(int j = h; j>=0;j--) {
                if(c <= j && b>j) {
                    return j;
                }
            }
        }
        return 0;
    }
}
// @lc code=end

