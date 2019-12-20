/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        return So42.trap2(height);
    }
}
class So42{
    public static void main(String[] args) {
        System.out.println(trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    public static int trap2(int[] height) {
        int[] maxR = new int[height.length];
        int max = 0;
        for(int i = 1;i<=height.length;i++) {
            max = Math.max(height[height.length-i], max);
            maxR[height.length-i] = max;
        }

        int[] maxL =  new int[height.length];
        max = 0;
        for(int i =0;i<height.length;i++) {
            max = Math.max(height[i], max);
            maxL[i] = max;
        }
        int d = 0;
        for(int i = 1;i<height.length-1;i++) {
            int mL = maxL[i-1];
            int mR = maxR[i+1];
            int min = Math.min(mL, mR);
            if(height[i]<min) d+= (min-height[i]);
        }
        return d;
    }
    public static int trap(int[] height) {
        int[] maxs = new int[height.length];
        int max = 0;
        for(int i = 1;i<=height.length;i++) {
            max = Math.max(height[height.length-i], max);
            maxs[height.length-i] = max;
        }
        int d = 0;
        for(int i = 0; i< height.length;) {
            int l = height[i];
            if(i<height.length-1 && maxs[i+1] >= l) {
                int j = i+1;
                for(;j<height.length && height[j] < l;j++) {
                    int r = height[j];
                    int cc = (l-r);
                    d+=(l - r);
                }
                i = j;
            }else {
                i++;
            }
        }
        return d;
    }
}
// @lc code=end

