/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] 不同的子序列
 */
import java.util.*;
// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        return Solution115.numDistinct(s, t);
    }
}

class Solution115 {
    public static int numDistinct(String s, String t) {
        // 明显是个二维的dp。
        return 0;
    }
}

class Sitt {

    public static void main(String[] args) {
        Sitt ss = new Sitt();
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        for(int i: ss.findSubstring(s, words)) {
            System.out.println(i);
        }
    }

    List<Integer> ans;
    boolean[] used;
    int count;
    boolean tt;
    char[] chars;
    String[] words;
    
    public List<Integer> findSubstring(String s, String[] words) {
        ans = new LinkedList<>();
        chars = s.toCharArray();
        this.words = words;
        int gos = 0;
        for(String word: words) {
            gos+=word.length();
        }
        if(gos == 0) {
            return ans;
        }
        for(int i =0; i<=chars.length-gos;i++) {
            used = new boolean[words.length];
            count = 0;
            tt = false;
            dfs(i);
            if(tt) ans.add(i);
        }
        return ans;
    }
    void dfs(int index) {
        if(count == words.length) {
            tt = true;
        }
        for(int i = 0; i < words.length; i++) {
            if(used[i]) continue;
            boolean tag = true;
            String word = words[i];
            for(int j = 0;j<word.length();j++) {
                if(word.charAt(j) != chars[j+index]) {
                    tag = false;
                    break;
                }
            }
            if(tag) {
                count++;
                used[i] = true;
                dfs(index + word.length());
                count--;
                used[i] = false;
            }
        }
    }
}
// @lc code=end

