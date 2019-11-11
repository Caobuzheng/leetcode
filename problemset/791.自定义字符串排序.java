/*
 * @lc app=leetcode.cn id=791 lang=java
 *
 * [791] 自定义字符串排序
 */

// @lc code=start
class Solution {
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        // 只能是Object
        char[] chars = T.toCharArray();
        // api不熟悉了的又。
        // 那么就可以自己写个的了。
        
        // 插入排序的
        Character[] charactors = new Character[chars.length];
        for(int i = 0; i< chars.length; i++) {
            charactors[i] = chars[i];
        }
        Arrays.sort(charactors, (c1, c2) -> map.getOrDefault(c1, 0) - map.getOrDefault(c2, 0));
        for(int i = 0; i< chars.length; i++) {
            chars[i] = charactors[i];
        }
        return new String(chars);
    }
}
// @lc code=end

