/*
 * @lc app=leetcode.cn id=640 lang=java
 *
 * [640] 求解方程
 */

// @lc code=start
class Solution {
    public String solveEquation(String equation) {
        return Solution640.solveEquation(equation);
    }
}
class Solution640 {
    public static void main(String[] args) {
        System.out.println(solveEquation("0x=0"));
    }
    public static String solveEquation(String equation) {
        String[] splits = equation.split("=");
        Lex lex1 = builtLex(splits[0]);
        Lex lex2 = builtLex(splits[1]);
        if(lex1.x == lex2.x && lex1.y == lex2.y) {
            return "Infinite solutions";
        }
        if(lex1.x == lex2.x && lex1.y != lex2.y) {
            return "No solution";
        }
        return "x=" + (lex2.y - lex1.y)/(lex1.x - lex2.x);
    }

    public static Lex builtLex(String str) {
        int x = 0;
        int y = 0;
        int more = 0;
        int tag = 1;
        for(int i = 0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c == 'x'){
                if(more == 0) {
                    if(i>0 && str.charAt(i-1) =='0') {
                        more = 0;
                    }else {
                        more = 1;
                    }
                }
                x += more*tag;
                more = 0;
            }
            else if(c=='-') {
                y += tag*more;
                more = 0;
                tag = -1;
            }else if(c=='+'){
                y += tag*more;
                more = 0;
                tag = 1;
            }else {
                more = more*10 + (c-'0');
            }
        }
        y+=tag*more;
        return new Lex(x, y);
    }
    
}
class Lex {
    int x;
    int y;

    public Lex() {
    }

    public Lex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Lex{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
// @lc code=end

