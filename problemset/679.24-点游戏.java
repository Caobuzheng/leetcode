/*
 * @lc app=leetcode.cn id=679 lang=java
 *
 * [679] 24 点游戏
 */
import java.util.*;
// @lc code=start
class Solution {
    public boolean judgePoint24(int[] nums) {
        return Solution679.judgePoint24(nums);  
    }
}

class Solution679 {
    
    public static void main(String[] args) {
        // 这个题是真的难。
        int[] num = {1,9,1,2}; // 
        System.out.println(judgePoint24(num));
    }
    static boolean result;
    static Number[] numbers;
    public static boolean judgePoint24(int[] nums) {
        result = false;
        numbers = new Number[4];
        for(int i=0;i<nums.length;i++) {
            numbers[i] = new Number(nums[i]);
        }

        for(int i = 0;i<4;i++) {
            Set<Number> set = new HashSet<>();
            boolean[] used = new boolean[4];
            used[i] = true;
            set.add(numbers[i]);
            Set<Number> dfsSet = dfs(used, set);
            for(Number c: dfsSet) {
                if(c.is24()){
                    return true;
                }
            }
        }

        return false;
    }

    // 少了一种情况的。
    static Set<Number> dfs(boolean[] used, Set<Number> set) {
        Set<Number> ret = new HashSet<>();
        for(int i = 0; i<4;i++) {
            if(used[i]) continue;
            used[i] = true;
            Set<Number> lSet = getLeft(numbers[i], set);
            Set<Number> rSet = getRight(numbers[i], set);
            lSet.addAll(rSet);
            lSet.addAll(dfs(used, lSet));
            ret.addAll(lSet);
            used[i] = false;
        }

        for(int i= 0;i<4;i++) {
            if(used[i]) continue;
            for(int j = 0;j<4;j++) {
                if(j==i || used[j]) continue;
                used[i] = true;
                used[j] = true;
                // 这个就复杂了的。
                // 还好的啦。
                

                used[i] = false;
                used[j] = false;
            }
        }

        return ret;
    }

    static Set<Number> getLeft(Number a, Set<Number> set) {
        Set<Number> ret = new HashSet<>();
        for(Number b: set) {
            ret.addAll(getSet(a, b));
        }
        return ret;
    }

    static Set<Number> getRight(Number b, Set<Number> set) {
        Set<Number> ret = new HashSet<>();
        for(Number a: set) {
            ret.addAll(getSet(a, b));
        }
        return ret;
    }

    static Set<Number> getSet(Number a, Number b){
        Set<Number> set = new HashSet<>();
        set.add(a.plus(b));
        set.add(a.sub(b));
        set.add(a.mul(b));
        if(!b.isZero()) {
            set.add(a.devide(b));
        }
        return set;
    }
}

class Number {
    int l;
    int r;
    double hashD;
    public Number(int l) {
        this.l = l;
        this.r = 1;
        this.hashD = l;
    }
    public Number(int l, int r) {
        this.l = l;
        this.r = r;
        this.hashD = (double)l/r;
    }

    // int toInt()

    Number plus(Number o) {
        int r = this.r * o.r;
        int l = this.l * r + o.l * r;
        return new Number(l, r);
    }
    Number sub(Number o) {
        int r = this.r * o.r;
        int l = this.l * r - o.l * r;
        return new Number(l, r);
    }

    Number devide(Number o) {
        int l = this.l * o.r;
        int r = this.r * o.l;
        return new Number(l, r);
    }

    Number mul(Number o) {
        int l = this.l * o.l;
        int r = this.r * o.r;
        return new Number(l, r);
    }

    boolean isZero() {
        return  l == 0;
    }

    boolean is24() {
        if(l%r != 0) return false;
        return l/r == 24;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return  Double.compare(number.hashD, hashD) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashD);
    }
}
// @lc code=end

