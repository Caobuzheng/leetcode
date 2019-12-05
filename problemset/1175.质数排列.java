/*
 * @lc app=leetcode.cn id=1175 lang=java
 *
 * [1175] 质数排列
 */

// @lc code=start
class Solution {
    public int numPrimeArrangements(int n) {
        //n = 5
        // 输出：12
        // 解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是
        // 235 C42？
        return Solution1175.numPrimeArrangements(n);
    }
}
class Solution1175 {
    public static void main(String[] args) {
        System.out.println(numPrimeArrangements(1));//3
        System.out.println(numPrimeArrangements(2));//3
        System.out.println(numPrimeArrangements(3));//3
        System.out.println(numPrimeArrangements(4));//3
        System.out.println(numPrimeArrangements(5));//12
        System.out.println(numPrimeArrangements(100));// 682289015
    }
    static final int MOD = 1_000_000_007;
    public static int numPrimeArrangements(int n) {
         boolean[] su = new boolean[n+1];
         int count = 0;

         for(int i = 2;i<=n;i++) {
             if(!su[i]) {
                 count++;
                 int tmp = i+i;
                 while(tmp <= n){
                    su[tmp] = true;
                    tmp+=i;
                 }
             }
        }
        long res = 1L;
        for(int i = 2;i<=count;i++) {
            res = (res * i)%MOD;
        }

        for(int i = 2;i<=n-count;i++) {
            res = (res*i)%MOD;
        }

        return new Long(res).intValue();
    }
}
// @lc code=end

