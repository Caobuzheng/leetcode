/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 */

// @lc code=start
import java.util.*;

class Solution {

    // 大神答案，比我的快了20倍啊。
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        int min = Integer.MAX_VALUE; // nums数组最小值
        for (int value : nums) {
            if (value < min) {
                min = value;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - min + 1;
        }
        
        int max = Integer.MIN_VALUE;
        for (int value : nums) {
            if (value > max) {
                max = value;
            }
        }
        
        int[] BITree = new int[max + 1];
        BITree[0] = 0;
        int[] countArr = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int count = getSum(nums[i] - 1, BITree);
            countArr[i] = count;
            update(nums[i], BITree);
        }
        List<Integer> result = new ArrayList<>();
        for (int value : countArr) {
            result.add(value);
        }
        return result;
    }
    
    public static int getSum(int value, int[] BITree) { // 获得a[i]从1，value的和
        int sum = 0;
        while (value > 0) {
            sum += BITree[value];
            value -= (value & -value);
        }
        return sum;
    }

    public static void update(int value, int[] BITree) {
        while (value <= BITree.length - 1) {
            BITree[value] += 1;
            value += (value & -value);
        }
    }
}
class So315{
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>(nums.length);
        for(int i = nums.length-1;i>=0;i--) {
            int tmp = inserSort(nums, i);
            ans.add(tmp);
        }
        Collections.reverse(ans);
        return ans;
    }
    public static int inserSort(int[] nums, int index) {
        int tmp = nums[index];
        int l = index+1;
        int r = nums.length-1;
        while(l<=r) {
            int mid = (l+r)/2;
            if(nums[mid]<tmp){
                if(mid==nums.length-1 || nums[mid+1] > tmp) {
                    r = mid;
                    break;
                }else {
                    l = mid+1;
                }
            }else {
                r = mid-1;
            }
        }
        for(int i = index;i<r;i++) {
            nums[i] = nums[i+1];
        }
        nums[r] = tmp;
        return r-index;
    }
}
// @lc code=end

