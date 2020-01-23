/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 */
import java.util.*;
// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        return Solution316.removeDuplicateLetters(s);
    }
}

class Solution316{
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));// acdb adbc。我错了的
    }
    public static String removeDuplicateLetters(String s) {
        boolean[] set = new boolean[26];
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i<chars.length;i++) {
            int c = chars[i] - 'a';
            set[c] = true;
            if(!map.containsKey(c)) {
                map.put(c, new LinkedList<>());
            }
            map.get(c).add(i);
        }
        StringBuilder sb = new  StringBuilder();
        boolean tag = true;
        while(tag) {
            tag = false;
            for(int i = 0; i<26;i++) {
                if(set[i]) {
                    tag = true;
                    boolean all = true;
                    int iIndex = map.get(i).peekFirst();
                    for(int j = 0;j<26;j++) {
                        if(set[j] && map.get(j).peekLast() < iIndex) {
                            all = false;
                            break;
                        }
                    }
                    if(all) {
                        sb.append((char) (i+'a'));
                        set[i] = false;
                        for(int j = 0;j<26;j++) {
                            if(set[j]) {
                                LinkedList<Integer> list = map.get(j);
                                while(list.peek()<iIndex) {
                                    list.poll();
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end

