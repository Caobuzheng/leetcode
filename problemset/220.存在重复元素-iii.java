
/*
 * @lc app=leetcode.cn id=220 lang=java
 *
 * [220] 存在重复元素 III
 */
import java.util.*;

// @lc code=start
class Solution {
    private long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }

    // 这个是桶排序。有点意思了的。
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (t < 0)
            return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            // check if bucket m is empty, each bucket may contain at most one element
            if (d.containsKey(m))
                return true;
            // check the nei***or buckets for almost duplicate
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            // now bucket m is empty and no almost duplicate in nei***or buckets
            d.put(m, (long) nums[i]);
            if (i >= k)
                d.remove(getID(nums[i - k], w));
        }
        return false;
    }

}

class Solution220 {
    public static void main(String[] args) {
        int[] nums = { -1, 2147483647 };
        int k = 1;
        int t = 2147483647;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }
    public static boolean withTreeSet(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // Find the successor of current element
            Integer s = set.ceiling(nums[i]);
            if (s != null && s <= nums[i] + t)
                return true;

            // Find the predecessor of current element
            Integer g = set.floor(nums[i]);
            if (g != null && nums[i] <= g + t)
                return true;

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        k = k + 1;
        if (k >= nums.length) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                if ((long) nums[i] - nums[i - 1] <= t) {
                    return true;
                }
            }
            return false;
        }
        long[] queue = new long[k];
        for (int i = 0; i < k - 1 && i < nums.length; i++) {
            queue[i] = nums[i];
        }
        int old = k - 1;
        for (int i = k - 1; i < nums.length; i++) {
            queue[old] = nums[i];
            Arrays.sort(queue);
            old = 0;
            for (int j = 1; j < queue.length; j++) {
                if (queue[j] == nums[i - k + 1])
                    old = j;
                if ((long) (queue[j] - queue[j - 1]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end
