/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        return Solution60.getPermutation(n, k);
    }
}
class Solution60 {
    public static String getPermutation(int n, int k) {
        if(n==1) return "1";
        boolean[] tags = new boolean[10];
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (n-->0){
            int next = getNext(n);
            int i= (k-count-1) / next;
            count+=i*next;
            for(int j = 1; j<=9;j++) {
                if(!tags[j] && i-- <= 0){
                     tags[j] = true;
                     sb.append(j);
                     break;
                }
            }
        }
        return sb.toString();
    }
    private static int getNext(int k) {
        int sum = 1;
        while(k>1) {
            sum*=k;
            k--;
        }
        return sum;
    }
}
// @lc code=end

