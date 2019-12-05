import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 */

// @lc code=start
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        return Solution313.nthSuperUglyNumber(n, primes);
    }
}
class Solution313 {
    public static void main(String[] args) {
        int[] primes = {2,3,5};
        int n = 2;
        System.out.println(nthSuperUglyNumber(n, primes));
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        if(n<=1) return n;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i: primes) queue.add(i);
        while(--n>1) {
            // 啥？
            int tmp = queue.poll();
            System.out.println(tmp);
            for(int i: primes) queue.add(tmp*i);
        }
        return queue.poll();
    }
}
// @lc code=end

