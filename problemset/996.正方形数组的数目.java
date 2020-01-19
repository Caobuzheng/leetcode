import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=996 lang=java
 *
 * [996] 正方形数组的数目
 */

// @lc code=start
class Solution {
    public int numSquarefulPerms(int[] A) {
        return Solutiion996.numSquarefulPerms(A);
    }
}
class Solutiion996 {
    public static void main(String[] args) {
        System.out.println(numSquarefulPerms(new int[]{2,2,2}));
    }
    static int ans;
    static int[] a;
    static int[] tmp;
    static int bad = -1;
    public static int numSquarefulPerms(int[] A) {
        if(A.length <= 1) return 0;
        ans = 0;
        a = Arrays.copyOf(A, A.length);
        Arrays.sort(a);
        tmp = new int[A.length];
        dfs(0);
        return ans;
    }

    static void dfs(int index) {
        if(index == a.length) {
            ans++;
            return;
        }
        for(int i = 0; i< a.length;) {
            if(a[i] == bad) {
                i++;
                continue;
            }
            int mem = a[i];
            a[i] = bad;
            if(index == 0 || test(tmp[index-1] + mem)) {
                tmp[index] = mem;
                dfs(index+1);
            }
            a[i] = mem;
            while(i<a.length-1 && a[i] == a[i+1]) {
                i++;
            }
            i++;
        }
    }
    static boolean test(int sum) {
        int l = 0;
        int r = sum;
        while(l<=r) {
            int mid = (l+r) /2;
            long x = (long) mid * mid; // 这里需要注意了的
            if(x == sum) {
                return true;
            }else if(x<sum) {
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return false;
    }
}
// @lc code=end

