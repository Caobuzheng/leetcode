class Solution1105 {
    public static void main(String[] args) {
        Solution1105 s = new Solution1105();
        int[] nums = {10,100,101,101};
        System.out.println(s.isMajorityElement(nums, 101));
    }
    public boolean isMajorityElement(int[] nums, int target) {
        if(nums.length == 0 || nums[nums.length/2] != target) return false;
        int r = findR(nums, target, 0, nums.length-1);
        int l = findL(nums, target, 0, nums.length-1);
        return r-l+1>nums.length/2;
    }
    int findL(int[] nums, int target, int l, int r) {
        int mid = (l+r) / 2;
        if(nums[mid] > target) {
            return findL(nums, target, l, mid-1);
        }else if(nums[mid] < target) {
            return findL(nums, target, mid+1, r);
        }else {
            if(mid == l || nums[mid] > nums[mid-1]) {
                return mid;
            }else {
                return findL(nums, target, l, mid-1);
            }
        }
    }
    int findR(int[] nums, int target, int l, int r) {
        int mid = (l+r) / 2;
        if(nums[mid] > target) {
            return findR(nums, target, l, mid-1);
        }else if(nums[mid] < target) {
            return findR(nums, target, mid+1, r);
        }else {
            if(mid == r || nums[mid] < nums[mid+1]) {
                return mid;
            }else {
                return findR(nums, target, mid+1, r);
            }
        }
    }
}