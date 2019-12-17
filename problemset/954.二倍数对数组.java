/*
 * @lc app=leetcode.cn id=954 lang=java
 *
 * [954] 二倍数对数组
 */

// @lc code=start
class Solution {
    public boolean canReorderDoubled(int[] A) {
        if(A.length == 0) return true;
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> negList = new LinkedList<>();
        List<Integer> posList = new LinkedList<>();
        for(int i: A) {
            map.put(i, map.getOrDefault(i, 0) +1);
            if(i<0) negList.add(i);
            else posList.add(i);
        }
        int count = 0;
        Collections.reverse(negList);
        negList.addAll(posList);
        for(int i: negList) {
            if(count>= A.length/2) return true;
            if(map.get(i) > 0) {
                if(map.containsKey(i*2) && map.get(i*2)>0) {
                    map.put(i, map.get(i) - 1);
                    map.put(i*2, map.get(i*2) -1);
                    count++;
                }else {
                    return false;
                }
            }
        }
        return false;
    }
}
// @lc code=end

