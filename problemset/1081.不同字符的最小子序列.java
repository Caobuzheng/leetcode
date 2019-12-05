/*
 * @lc app=leetcode.cn id=1081 lang=java
 *
 * [1081] 不同字符的最小子序列
 */

// @lc code=start
import java.util.*;
class Solution {
    public String smallestSubsequence(String text) {
        return Solution1081.smallestSubsequence(text);
    }
}
class Solution1081 {
    public static void main(String[] args) {
        System.out.println(smallestSubsequence("cdadabcc") + "   " + "adbc");
        System.out.println(smallestSubsequence("ecbacba") + "   " + "eacb");
        System.out.println(smallestSubsequence("leetcode") + "   " + "letcod");
    }
    /**
     * 输入："cdadabcc"
        输出："adbc"
        肯定是错了的。啊呀呀
     * @param text
     * @return
     */
    public static String smallestSubsequence(String text) {
        Map<Character, LinkedList<Integer>> map = new HashMap<>();
        char[] chars = text.toCharArray();
        for(int i = 0; i< chars.length;i++) {
            if(!map.containsKey(chars[i])) map.put(chars[i], new LinkedList<>());
            map.get(chars[i]).addFirst(i);
        }
        List<Integer> list = new ArrayList<>();
        int max = -1;
        for(int i = 0;i<26;i++) {
            char c = (char) (i+ 'a');
            if(map.containsKey(c)) {
                int maxIndex = map.get(c).peek();
                //
                for(int index: map.get(c)){
                    if(index>max) {
                        maxIndex = index;
                    }
                }
                max = Math.max(max, maxIndex);
                // 比2大了，还要比1大。
                list.add(maxIndex);
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i: list){
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
// @lc code=end

