import java.util.Map;

class Solution1121 {
    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        if(K ==1) return true;
        int max = 1;
        int last = 1;
        for(int i = 1;i<nums.length;i++) {
            if(nums[i] == nums[i-1]) last++;
            else {
                max = Math.max(last, max);
                last = 1;
            }
            Map<K,V> map = new HashMap();
            for(Map.Entry e : entry){
                e.getValue();
                e.getKey()
            }

        }
        if(nums.length/max >= K) {
            return true;
        }
        return false;
    }
}