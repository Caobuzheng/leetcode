/*
 * @lc app=leetcode.cn id=985 lang=java
 *
 * [985] 查询后的偶数和
 */

// @lc code=start
class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];
        int sum = 0;
        for(int i: A) {
            if(i%2 == 0) sum+=i;
        }
        int i = 0;
        for(int[] query: queries) {
            int index = query[1];
            int oldVal = A[index];
            int newVal = A[index] + query[0];
            A[index] = newVal;
            if(oldVal%2 == 0) {
                if(newVal %2 ==0) {
                    sum= sum - oldVal + newVal;
                }else {
                    sum = sum - oldVal;
                }
            }else {
                if(newVal % 2 ==0) {
                    sum += newVal;
                }
            }  
            ans[i++] = sum;
        }   
        return ans;
    }
}
// @lc code=end

