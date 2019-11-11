import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1130 lang=java
 *
 * [1130] 叶值的最小代价生成树
 */

// @lc code=start
class Solution {
    public static int mctFromLeafValues(int[] arr) {
        return MctFromLeafValues.mctFromLeafValues(arr);
    }
}
class MctFromLeafValues {
    public static void main(String[] args) {
        int[] arr = {6,2,4};
        System.out.println(mctFromLeafValues(arr));
    }
    // 这个题，解法的思路是有动态规划（必须优化，是个O(N3的)）
    // 还有个单调栈，这个我完全没思路。
    public static int mctFromLeafValues(int[] arr) {
        // 这个题，我之前就搞过，没搞出来。fuck u。
        // 12 + 24  24 + 8
        // 2，4，6.而且最大是15，不会有0
        // 7,12,8,10
        // 每个节点都有 0 个或是 2 个子节点
        int ans = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i: arr){
            queue.add(i);
        }
        while(queue.size()>=2){
            int min1 = queue.poll();
            int min2 = queue.peek();
            // 这里是6 * 4,这个怎么处理。
            int pp = min1*min2;
            ans+=pp;
        }
        return ans;
    }
}
// @lc code=end

