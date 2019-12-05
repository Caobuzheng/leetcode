import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=884 lang=java
 *
 * [884] 两句话中的不常见单词
 */

// @lc code=start
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> ma = new HashMap<>();
        for(String str: A.split(" ")) {
            ma.put(str, ma.getOrDefault(str, 0)+1);
        }
        Map<String, Integer> mb = new HashMap<>();
        for(String str: B.split(" ")) {
            mb.put(str, mb.getOrDefault(str, 0)+1);
        }

        List<String> ans = new LinkedList<>();

        for(String str: ma.keySet()) {
            if(ma.get(str) == 1 && !mb.containsKey(str)) ans.add(str);
        }

        for(String str: mb.keySet()) {
            if(mb.get(str) == 1 && !ma.containsKey(str)) ans.add(str);
        }
        if(ans.isEmpty()) {
            String[] xx = {};
            return xx;
        }
        return ans.toArray(new String[1]);
    }
}
// @lc code=end

