/*
 * @lc app=leetcode.cn id=805 lang=java
 *
 * [805] 数组的均值分割
 */

 import java.util.*;

// @lc code=start
class Solution {
    public boolean splitArraySameAverage(int[] A) {
        Solution805 s = new Solution805();
        return s.splitArraySameAverage(A);  
    }
}
class Solution805 {
    public static void main(String[] args) {
        // int[] A = {1,2,3};
        Solution805 s = new Solution805();
        System.out.println(s.splitArraySameAverage(new int[]{60,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30}));
        // System.out.println(s.splitArraySameAverage(new int[]{1,2,3}));
        // System.out.println(s.splitArraySameAverage(new int[]{1,2,3,4}));
        // System.out.println(s.splitArraySameAverage(new int[]{1,2,3,4,5,6,10}));
        // System.out.println(s.splitArraySameAverage(new int[]{1,2,3,4,5,6,7,8}));
    }

    boolean res;
    R avg;
    List<Integer> belows;
    List<Integer> highs;
    public boolean splitArraySameAverage(int[] A) {
        if(A.length <=1) return false;
        int sum = 0;
        int len = A.length;
        for(int i: A) {
            sum+=i;
        }

        avg = new R(sum, len);
        res = false;
        belows = new ArrayList<>();
        highs = new ArrayList<>();

        for(int i: A) {
            if(i*avg.b<avg.a) {
                belows.add(i);
            }else{
                highs.add(i);
            }
        }

        
        Collections.sort(belows);
        Collections.sort(highs);
        Collections.reverse(highs);

        dfs(new R(belows.get(0)), 1, 0);
        dfs(new R(highs.get(0)), 0, 1);
        return res;
    }
    void dfs(R r, int indexB, int indexH) {
        if(res) return;
        if(r.b > avg.b/2) return;
        if(r.equal(avg)) {
            res = true;
            return;
        }
        
        // bigger错了的
        if(r.bigger(avg)) {
            for(int i = indexB;i<belows.size(); i++) {
                dfs(r.copy().add(belows.get(i)), i+1, indexH);
            }
        }else {
            for(int i = indexH;i<highs.size(); i++) {
                dfs(r.copy().add(highs.get(i)), indexB, i+1);
            }
        }
    }
    
}

class R {
    int a;
    int b;
    public R(int a) {
        this.a = a;
        this.b = 1;
    }
    public R(int a, int b) {
        this.a = a;
        this.b = b;
    }
    boolean equal(R r) {
        return this.a * r.b == this.b * r.a;
    }

    R add(int num) {
        this.a += num;
        this.b++;
        return this;
    }

    R copy() {
        return new R(this.a, this.b);
    }

    boolean bigger(R r) {
        return this.a * r.b - r.a*this.b > 0;
    }
}
// @lc code=end

