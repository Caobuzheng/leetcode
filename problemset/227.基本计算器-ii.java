import java.util.Stack;

/*
 * AC 
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution {
    public static int calculate(String s) {
        return Solution227.calculate(s);
    }
}
class Solution227 {
    public static void main(String[] args) {
        System.out.println(calculate("1-1+1"));
    }
    static int index = 0;
    public static int calculate(String s) {
        index = 0;
        Stack<T> stack = new Stack<>(); 
        char[] chars = s.toCharArray();
        stack.push(new T(0,getNextNum(chars))); // 先将第一个数push到stack
        while(index<chars.length) {
            char c = chars[index];
            if(c == '*') {
                stack.push(new T(0, stack.pop().val * getNextNum(chars)));
            }else if(c == '/') {
                int c1 = stack.pop().val ;
                int c2 = getNextNum(chars);
                stack.push(new T(0, c1/c2));
            }else if(c == '-') {
                stack.push(new T(2));
                stack.push(new T(0, getNextNum(chars)));
            }else if(c == '+') {
                stack.push(new T(1));
                stack.push(new T(0, getNextNum(chars)));
            }else {
                char ccc = chars[index];
                index++;
            }
        }
        return clearStack(stack);
    }
    private static int clearStack(Stack<T> stack) {
        int res = 0;
        while(stack.size() > 1) {
            int tmp = stack.pop().val;
            if(stack.pop().type == 1) {
                res += tmp;
            }else {
                res -=tmp;
            }
        }
        return stack.isEmpty()?res:stack.pop().val + res;
    }

    private static int getNextNum(char[] chars) {
        while(index<chars.length && 
            (chars[index] ==' '
                || chars[index] == '+'
                || chars[index] == '-'
                || chars[index] == '*'
                || chars[index] == '/')) index++;
        char ccc = chars[index];
        int res = 0;
        while(index<chars.length &&chars[index] - '0' >= 0 && chars[index] - '0' <= 9) {
            res = res * 10 + chars[index] - '0';
            index++;
        }
        return res;
    }
}
class T {
    public int type; // 12 + / 0是个val
    public int val;
    public T(int type) {
        this.type = type;
    }
    public T(int type, int val) {
        this.type = type;
        this.val = val;
    }
}
// @lc code=end