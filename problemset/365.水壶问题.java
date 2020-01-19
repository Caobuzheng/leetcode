/*
 * @lc app=leetcode.cn id=365 lang=java
 *
 * [365] 水壶问题
 */

import java.util.*;
// @lc code=start
import java.math.BigInteger;

class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        return Solution365.canMeasureWater(x, y, z);
    }
}

class Solution365 {
    public static void main(String[] args) {
        System.out.println(canMeasureWater(34, 5, 6));
    }
    static Set<String> set;
    static boolean tag;
    public static boolean canMeasureWater(int x, int y, int z) {
        // 我是真的读不懂这个题啊。
        if (x + y < z) return false;
        if (x == z || y == z || x + y == z) return true;
        return z % BigInteger.valueOf(x).gcd(BigInteger.valueOf(y)).intValue() == 0;
    }
    public static void help(int x, int y, int z, int a, int b) {
        if(tag) return;
        if(a == z || b == z || (a+b) == z) {
            tag = true;
            return;
        }
        String ab = "" +a+"_"+b;
        if(set.contains(ab)) return;
        set.add(ab);
        // 倒水。
        help(x,y,z,x,b);
        help(x,y,z,a,y);
        // a-to-b
        {
            if(a<=y-b){
                help(x,y,z,0,b+a);
            }else {
                help(x,y,z,a-y+b,y);
            }
        }
        {
            if(b<=x-a){
                help(x, y, z,b+a,0);
            }else {
                help(x, y, z, a, b-x+a);
            }
        }
    }
}
// @lc code=end

