/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution {
    public static int calculate(String s) {
        // 我还是觉得split最适合我的
        int res = 0;
        if(s.indexOf('+')>0) {
            res = calculate(s, '+');
        }else if(s.indexOf('-')>0) {
            res = calculate(s, '-');
        }else if(s.indexOf('*')>0) {
            res = calculate(s, '*');
        }else if(s.indexOf('/')>0) {
            res = calculate(s, '/');
        } 
        else {
            return Integer.valueOf(s.trim());
        }
        return res;
    }
    // 栈是不对的！fuck！必须自己用stack才行的。
    private static int calculate(String s, char op) {
        int index = s.lastIndexOf(op);
        
        int a = calculate(s.substring(0, index));
        int b = calculate(s.substring(index+1));
        int res = 0;
        switch (op) {
            case '+':
                res = a+b;
                break;
            case '-':
                res = a-b;
                break;
            case '*':
                res = a*b;
                break;
            case '/':
                res = a/b;
                break;
            default:
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "00000000/1/2/3/4/5/6/7/8/9/10";
        System.out.println(calculate(s));
    }
}
// @lc code=end