/**
 * Solution5248
 */
public class Solution5248 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        // 2,4,5,6,7,10
        // 0 1 2 3 4 5 ？why5？
        System.out.println(numberOfSubarrays(nums, 3)); // 2
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        int end = 0;
        int left = 0;
        while(end<nums.length) {
            if(nums[end]%2 != 0) break;
            end++;
        }
        left = end + 1;
        while(end<nums.length) {
            int right = 0;
            for(;end< nums.length && k>=0; end++) {
                if(nums[end]%2 != 0) k--;
                if(k == 0) right++;
            }
            ans = ans + right * left;
            left = right;
        }
        return ans;
    }
}