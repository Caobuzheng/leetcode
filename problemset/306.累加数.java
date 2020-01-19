import java.util.*;
/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 */

// @lc code=start
class Solution {
    public boolean isAdditiveNumber(String num) {
        return Solution306.isAdditiveNumber(num);
    }
}

class Solution306 {
    static boolean tag = false;
    public static boolean isAdditiveNumber(String num) {
        tag = false;
        for(int i = 1; i<num.length();i++) {
            for(int j = i+1; j<num.length();j++) {
                String tmpNum = num.substring(j);
                String a = num.substring(0, i);
                String b = num.substring(i, j);
                test(tmpNum, a, b);
                if(tag) return true;
            }
            
        }
        return tag;
    }

    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("199111992"));
    }

    static void test(String num, String a, String b) {
        if(tag) return;
        if(num.length() < a.length() || num.length() < b.length()) return;
        if(testNullOrZero(a) || testNullOrZero(b) || testNullOrZero(num) ) return;
        String next = sum(a, b);
        int nextIndex = getNextIndex(num, next);
        if(nextIndex >=0) {
            if(nextIndex == num.length()){
                tag = true;
                return;
            }else {
                test(num.substring(nextIndex), b, next);
            }
        }
    }

    static int getNextIndex(String num, String next) {
        if(num.length() < next.length()) return -1;
        for(int i = 0; i<next.length();i++) {
            if(num.charAt(i) != next.charAt(i)) return -1;
        }
        return next.length();
    }




    static boolean testNullOrZero(String s) {
        return s.isEmpty() || (s.length()!= 1 && s.startsWith("0"));
    }

    static String sum(String a, String b) {
        if(a.length()>b.length()) {
            return sum(b, a);
        }
        if(a.length() == 0) return b;
        int more = 0;
        StringBuilder sb = new StringBuilder();
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int index = 1;
        while(index<=charsA.length && index<=charsB.length) {
            int ca = charsA[charsA.length - index] - '0';
            int cb = charsB[charsB.length - index] - '0';
            int tmp = ca+cb+more;
            sb.append(tmp%10);
            more = tmp/10;
            index++;
        }

        while(index <= b.length()) {
            int cb = charsB[charsB.length - index] - '0';
            int tmp = cb+more;
            sb.append(tmp%10);
            more = tmp/10;
            index++;
        }
        if(more != 0) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

