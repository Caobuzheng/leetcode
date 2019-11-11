/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        if(nums.length < 1) return ans;
        Arrays.sort(nums);
        int[] tmp = new int[nums.length];
        dfs(nums,0,-1,tmp,ans);
        return ans;
    }
    private void dfs(int[] nums, int index, int lastIndex,int[] tmp, List<List<Integer>> ans) {
        if(index > tmp.length) return;
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<index;i++) {
            list.add(tmp[i]);
        }
        ans.add(list);
        for(int i = lastIndex + 1; i<nums.length; i++) {
            tmp[index] = nums[i];
            dfs(nums, index+1,i,tmp,ans);
        }
    }
}
// @lc code=end

