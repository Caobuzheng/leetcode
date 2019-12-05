/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 */
import java.util.*;
// @lc code=start
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        return Solution313.nthSuperUglyNumber(n, primes);
    }
}
class Solution313 {
    public static void main(String[] args) {
        int[] primes = {2,7,13,19};
        System.out.println(nthSuperUglyNumber(12, primes));
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1) return 1;
        PriorityQueue<Long> queue= new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        for(int i: primes) queue.add((long)i);
        Long tmp = queue.peek();
        while(set.size()<n-1) {
            tmp = queue.poll();
            if(!set.contains(tmp)) {
                set.add(tmp);
                for(int i: primes) queue.add(tmp*i);
            }
        }
        return tmp.intValue();
    }
}
// @lc code=end

