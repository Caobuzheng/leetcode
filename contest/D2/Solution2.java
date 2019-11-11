import java.util.*;
class Solution1086 {
    public static void main(String[] args) {
        int[][] items = [];
    }
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int[] item: items) {
            if(!map.containsKey(item[0])) {
                map.put(item[0], new PriorityQueue<Integer>(5, (o1, o2)-> o2[1] - o1[1]));
            }
            map.get(item[0]).add(item[1]);
        }
        int[][] ans = new int[map.size()][2];
        int index = 0;
        for(int i: map.keySet()) {
            int tmpSum = 0;
            List<Integer> list = map.get(i);
            for(int j = 0; j<5;j++) {
                tmpSum += list.get(j);
            }
            ans[index][0] = i;
            ans[index][1] = tmpSum/5;
            index++;
        }
        return ans;
    }
}