/**
 * Do14
 */
import java.util.*;
class Sea {
    public boolean hasShips(int[] topRight, int[] bottomLeft){
        return true;
    }
}
public class Do14 {

    public static void main(String[] args) {
        int[] topRight = {4, 4};
        int[] bottomLeft = {0, 0};
        Sea sea = new Sea();
        System.out.println(countShips(sea, topRight, bottomLeft));
    }

    public static int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        // 
        return help(sea, topRight, bottomLeft);
    }

    public  static int help(Sea sea, int[] topRight, int[] bottomLeft) {
        int b0 = bottomLeft[0];
        int b1 = bottomLeft[1];
        int t0 = topRight[0];
        int t1 = topRight[1];
        if( b0 > t0 || b1 > t1) return 0;
        if(!sea.hasShips(topRight, bottomLeft)) {
            return 0;
        } else {
            if( t0-b0 > t1-b1) {
                int t00 = (t0+b0) / 2 +1;
                int b00 = (t0+b0) / 2;
                int[] tnew = {t00, t1};
                int[] bnew = {b00, b1};
                return help(sea, topRight, bnew) + help(sea, tnew, bottomLeft);
            }else {
                int t11 = (t1+b1) / 2 +1;
                int b11 = (t1+b1) / 2;
                int[] tnew = {t0, t11};
                int[] bnew = {b0, b11};
                return countShips(sea, topRight, bnew) + countShips(sea, tnew, bottomLeft);
            }
        }
    }

    Map<Integer, Integer> val;
    Set<Integer> del;
    Map<Integer, List<Integer>> map;
    int[] values;
    int ans = 0;
    public  int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        val = new HashMap<>();
        del = new HashSet<>();
        map = new HashMap<>();
        values = value;
        for(int i = 0;i<parent.length;i++) {
            if(!map.containsKey(parent[i])) {
                map.put(parent[i], new LinkedList<>());
            }
            map.get(parent[i]).add(i);
        }
        getVal(0);
        getCount(0);
        return ans;
    }

    void getCount(int node) {
        if(val.get(node) != 0) {
            ans++;
            if(map.containsKey(node)) {
                for(int i: map.get(node)) getCount(i);
            }
        }
    }

    int getVal(int node) {
        if(node!= -1 && val.containsKey(node)) return val.get(node);
        int sum = node==-1?0:values[node];
        if(map.containsKey(node)) {
            List<Integer> list = map.get(node);
            for(int i: list) {
                sum+=getVal(i);
            }
        }
        val.put(node, sum);
        return sum;
    }

    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ans = new LinkedList<>();
        int l = toBeRemoved[0];
        int r = toBeRemoved[1];
        for(int[] interval: intervals) {
            if(interval[0] > l && interval[1] < r) {
                continue;
            }
            int a = interval[0];
            int b = interval[1];


            if(a > l && b< l) {
               List<Integer> list = new ArrayList<>(2);
               list.add(a);
               list.add(l);
               ans.add(list);
            }

            if(a<r && r>r){
               List<Integer> list = new ArrayList<>(2);
               list.add(r);
               list.add(b);
               ans.add(list);
            }

            if(b<=l || a>=r) {
                List<Integer> list = new ArrayList<>(2);
                list.add(a);
                list.add(b);
                ans.add(list);
            }
            
        }
        return ans;
    }
    
    public static String toHexspeak(String num) {
        String bad = "ERROR";
        long val = Long.valueOf(num);
        StringBuilder sb = new StringBuilder();
        while(val!=0){
            long c = val%16; // 这里我不明白了。
            if(c<10 && c >1) return bad;
            if(c>=10) sb.append((char)(c-10+'A'));
            if(c ==0) sb.append('O');
            if(c ==1) sb.append('I');
            val /= 16;
        } 
        return sb.reverse().toString();
    }
}