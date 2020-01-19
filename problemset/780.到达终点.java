import java.util.*;

/*
 * @lc app=leetcode.cn id=780 lang=java
 *
 * [780] 到达终点
 */

// @lc code=start
class Solution {
    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        return Solution780.reachingPoints(sx, sy, tx, ty);
    }
}
class Solution780 {
    public static void main(String[] args) {
        System.out.println(reachingPoints(1, 1, 2, 2));
    }
    // 内存超了？？？
    static Set<String> set;
    static boolean tag;
    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        tag = false;
        set = new HashSet<>();
        // 那么就那个啥。自己用个queue来干的吧。费劲
        help(sx, sy, tx, ty);
        return tag;
    }
    static void help(int sx, int sy, int tx, int ty) {
        if(tag) return;
        if(sx == tx && sy == ty) {
            tag = true;
            return;
        }
        if(sx > tx || sy > ty) return;
        // String cmp = sx+"_"+sy;
        // if(set.contains(cmp)) return;
        // set.add(cmp);
        // 果然hard就Hard了哈。
        // 明明都是在变大的啊
        help(sx+sy, sy, tx, ty);
        help(sx, sx+sy, tx, ty);
    }
}
// @lc code=end

