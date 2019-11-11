import java.util.*;
class Solution {
    
}
class Solution1102 {

    // public static void main(String[] args) {
    //     int[][] edges = {{0,1},{0,2},{1,3},{0,4},{1,5},{2,6},{1,7}};
    //     System.out.println(treeDiameter(edges));
    // }
    
    public static int treeDiameter(int[][] edges) {
        if(edges.length == 0) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: edges) {
            // add to the tree
            List<Integer> set0 = map.getOrDefault(edge[0], new LinkedList<>());
            set0.add(edge[1]);
            map.put(edge[0], set0);
             List<Integer> set1 = map.getOrDefault(edge[1], new LinkedList<>());
            set1.add(edge[0]);
            map.put(edge[1], set1);
        }

        return max;
    }
    public int getDeep(Map<Integer, List<Integer>>, int target, int myself) {
        List<Integer> list = map.get(target);
        if(list.size() == 1) return 1;
        return 
    }
}
