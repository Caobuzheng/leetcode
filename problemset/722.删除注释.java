import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=722 lang=java
 *
 * [722] 删除注释
 *
 * https://leetcode-cn.com/problems/remove-comments/description/
 *
 * algorithms
 * Medium (25.58%)
 * Likes:    13
 * Dislikes: 0
 * Total Accepted:    877
 * Total Submissions: 3.3K
 *
 */

// @lc code=start
class Solution {
    public List<String> removeComments(String[] source) {
        return RemoveComments.removeComments(source);
    }
}
class RemoveComments {
    //我觉得这道题，嗯，没必要写
    public static List<String> removeComments(String[] source) {
        List<String> res = new LinkedList<>();
        // 行注释只处理一行的。如果是块注释，那么可能会出现跨行的情况。
        boolean open = false;
        for(String str: source) {
            // /*/ this is very bad
            if(open) {
                if(str.contains("\\*\\/")) {
                    // 未完成的。fuck。看到这道题，十分想放弃。
                }
            }
        }
        return res;
    }
}
// @lc code=end

