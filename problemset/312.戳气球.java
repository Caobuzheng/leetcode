/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {
        return Solution312.maxCoins(nums);
    }
}
class Solution312 {
    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        System.out.println(maxCoins(nums));
    }
    static Map<String , Integer> map;
    public static int maxCoins(int[] nums) {
        map  = new HashMap<>();
        int max = help(nums);
        return max;
    }

    // 为啥我是要用回溯啊。
    // nums.length <= 500
    // 然后深度就会超时。
    // 难道还有贪心在里面？
    static int help(int[] nums) {
        String str = buildStr(nums);
        if(map.containsKey(str)) return map.get(str);
        int max = 0;
        for(int i = 0; i< nums.length;i++) {
            // 戳破i。
            int tmp = 0;
            if(nums.length == 1) {
                tmp = nums[0];
            }
            if(nums.length>1) {
                if(i==0) {
                    tmp += nums[0] * nums[1];
                }else if(i==nums.length-1){
                    tmp += nums[nums.length-1] * nums[nums.length-2];
                }else {
                    tmp += nums[i-1] * nums[i] * nums[i+1];
                }
                int[] newNums = new int[nums.length-1];

                for(int j = 0;j<i;j++) {
                    newNums[j] = nums[j];
                }
                for(int j = i+1;j<nums.length;j++) {
                    newNums[j-1] = nums[j];
                }
                tmp+=help(newNums);
            }
            max = Math.max(tmp, max);
        }
        return max;
    }

    static String buildStr(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int i: nums) {
            sb.append("_"+i);
        }
        return sb.toString();
    }

}

// @lc code=end

