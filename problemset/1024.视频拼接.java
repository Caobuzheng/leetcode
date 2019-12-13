/*
 * @lc app=leetcode.cn id=1024 lang=java
 *
 * [1024] 视频拼接
 */
import java.util.*;
// @lc code=start
class Solution {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (o1,o2) -> o1[0]-o2[0]);
        int end = 0;
        int count = 0;
        while(end < T) {
            int next = end;
            for(int[] clip: clips) {
                if(clip[0] <= end) {
                    next = Math.max(clip[1], next);
                }else break;
            }
            if(next == end) break;
            count++;
            end = next;
        }
        if(end < T) return -1;
        return count;
    }
}
// @lc code=end

