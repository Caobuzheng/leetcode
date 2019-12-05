import java.util.Arrays;

class Solution1060 {
    /**
     * 输入：A = [4,7,9,10], K = 1
        输出：5
        解释：
        第一个缺失数字为 5 。
        数组中的数是独一无二的
     */
    public static void main(String[] args) {
        int[] nums = {1,2,4};
        System.out.println(missingElement(nums, 3));
    }
    public static int missingElement(int[] nums, int k) {
        // 是有序的，果然是可以二分。
        int start = nums[0];
        int index = 1;
        while(index<nums.length && k>0) {
            if(nums[index] != start+1) {
                int des = nums[index] - start -1;
                if(des >= k) {
                    return start + k;
                }else {
                    k-=des;
                }
            }
            start = nums[index];
            index++;
        }
        return start + k;
    }
}