/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == ')' || c == ']' || c == '}') {
                if(stack.isEmpty()) return false;
                char t = stack.pop();
                if(c==')' && t != '(') return false;
                if(c==']' && t != '[') return false;
                if(c=='}' && t != '{') return false;
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

