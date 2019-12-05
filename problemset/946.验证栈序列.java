/*
 * @lc app=leetcode.cn id=946 lang=java
 *
 * [946] 验证栈序列
 */
import java.util.*;
// @lc code=start
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        return So946.validateStackSequences(pushed, popped);
    }
}
class So946 {
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        System.out.println(validateStackSequences(pushed, popped));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        int index = 0;
        for(int i:popped) {
            if(!set.contains(i)) {
                while (index<pushed.length) {
                    if(pushed[index] != i) {
                        stack.push(pushed[index]);
                        set.add(pushed[index]);
                        index++;
                    }else {
                        index++;
                        break;
                    }
                }
            }else {
                if(stack.isEmpty() || stack.peek() != i) {
                    return false;
                }else {
                    stack.pop();
                    set.remove(i);
                }
            }
        }
        return true;
    }
}
// @lc code=end

