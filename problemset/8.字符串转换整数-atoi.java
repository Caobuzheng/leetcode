/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 * AC
 * 
 */

// @lc code=start
// 思路的，就是遍历char[] 然后做各种判断，尤其是需要注意益处的判断。
class Solution {
    public int myAtoi(String str) {
        return MyAtoi.myAtoi(str);
    }
}
class MyAtoi{
    public static int myAtoi(String str) {
        int res = 0;
        boolean tag = false;
        boolean tagP = false;
        int max = Integer.MAX_VALUE / 10;
        // 
        // 先处理
        char[] chars = str.toLowerCase().trim().toCharArray();
        
        if(chars.length == 0) return res;
        if(chars[0] == '-' || chars[0] == '+') {
            if(chars[0]=='-') {
                tag = true;
            }
            chars[0] = '0';
        }
        for(char c: chars) {
            if(c >'9' || c<'0') {
                if(tag) {
                    return -res;
                }
                return res;
            }
            int tmp = c-'0';
                if(res >= max) {
                    // 感觉并不美观啊
                    if(tag) {
                        if(tmp>=8 || res > max) {
                            return Integer.MIN_VALUE;
                        }else {
                            return -res*10 - tmp;
                        }
                    }else {
                        if(tmp>7 || res > max) {
                            return Integer.MAX_VALUE;
                        }else {
                            return res * 10 + tmp;
                        }
                    }
                }
            res = res * 10 + tmp;
        }
        if(tag) {
            return -res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("0-1"));
    }
}
// @lc code=end

