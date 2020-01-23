/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
         List<List<String>> result = new ArrayList<>();
         if(s==null || s.length()==0) return result;
         helper(s.toCharArray(), 0, new ArrayList<>(), result);
         return result;
     }
 
     // this may be not one;
     public void helper(char[] chars,  int index, List<String> legency, List<List<String>> result) {
         if(index>=chars.length) {
             result.add(legency);
             return;
         }
         int i = index;
         StringBuilder sb = new StringBuilder();
         for(;i<chars.length;i++) {
             sb.append(chars[i]);
             if(isValid(chars, index, i)) {
                 List<String> newLegency = new ArrayList<>(legency);
                 newLegency.add(sb.toString());
                 helper(chars, i + 1, newLegency, result);
             }
         }
     }
     private boolean isValid(char[] chars, int start, int end) {
         // 这么不太好的吧。有更好的办法么
         while(start<end) {
             if(! (chars[start++] == chars[end--])) return false;
         }
         return true;
     }
 }
// @lc code=end

