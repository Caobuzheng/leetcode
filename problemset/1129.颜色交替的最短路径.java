/*
 * @lc app=leetcode.cn id=1129 lang=java
 *
 * [1129] 颜色交替的最短路径
 */
import java.util.*;

// @lc code=start
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        return Solution1129.shortestAlternatingPaths(n, red_edges, blue_edges);
    }
}

class Solution1129 {
    static int[] blue;
    static int[] red;
    static Map<Integer, Set<Integer>> blueMap;
    static Map<Integer, Set<Integer>> redMap;
    public static int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        blue = new int[n];
        Arrays.fill(blue, Integer.MAX_VALUE);
        red = new int[n];
        Arrays.fill(red, Integer.MAX_VALUE);


        // 可能有平行边，也可能有自闭环。
        blueMap = new HashMap<>();
        redMap = new HashMap<>();
        for(int[] edge: blue_edges) {
            int in = edge[0];
            int out = edge[1];
            if(!blueMap.containsKey(in)) {
                blueMap.put(in, new HashSet<>());
            }
            blueMap.get(in).add(out);
        }
        for(int[] edge: red_edges) {
            int in = edge[0];
            int out = edge[1];
            if(!redMap.containsKey(in)) {
                redMap.put(in, new HashSet<>());
            }
            redMap.get(in).add(out);
        }
        // 红蓝红蓝交替的。
        // 再来个蓝红蓝红交替的。
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        return ans;
    }

    int help(int n, boolean isBlue, int out) {
        // 不论颜色，先到这个点的哈。
        // 这个题，我感觉我会做。
        // 那个red_edges 是干啥的啊。
        // 修改那个MAP，我还是喜欢由低向上的。
        int[] color;
        Map<Integer, Set<Integer>> map;
        if(isBlue) {
            color = blue;
            map = 
        }else {
            color = red;
        }
        if(color[out] != Integer.MAX_VALUE) return color[out];
        


        return -1;
    }
}
// @lc code=end

