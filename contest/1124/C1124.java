import java.util.LinkedList;
import java.util.*;

/**
 * C1124
 * 又是hard的没做出来，这个还是挺难的。
 */

public class C1124 {
    public static void main(String[] args) {
        System.out.println(numWays(4, 2));
    }

    public static int numWays(int steps, int arrLen) {
        return 0;
    }


    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        char[] chars = searchWord.toCharArray();
        List<List<String>> ans = new LinkedList<>();
        PriorityQueue<String> queue = new PriorityQueue<>();
        for(String str : products) {
            queue.add(str);
        }
        for(int i = 0;i<chars.length;i++) {
            PriorityQueue<String> next = new PriorityQueue<>();
            List<String> tmp = new LinkedList<>();
            for(String str: queue) {
                if(str.charAt(i) == chars[i]) next.add(str);
            }
            for(int n=0; n<3; n++) {
                if(next.isEmpty()) break;
                tmp.add(next.poll());
            }
            next.addAll(tmp);
            ans.add(tmp);
            queue = next;
        }
        return ans;
    }


    public static int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0 ;
        int x = points[0][0];
        int y = points[0][1];
        for(int[] point: points) {
            int a = Math.abs(point[0] - x);
            int b = Math.abs(point[1] - y);
            sum+=Math.min(a, b);
            sum+=Math.abs(a-b);
            x = point[0];
            y = point[1];
        }
        return sum;
    }

    public static int countServers(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] ms = new int[m];
        int[] ns = new int[n];
        for(int i = 0; i<m;i++) {
            for(int j = 0; j<n;j++) {
                if(grid[i][j] == 1){
                    ms[i] ++;
                    ns[j] ++;
                }
            }
        }
        for(int i = 0; i<m;i++) {
            for(int j = 0;j<n;j++) {
                if(grid[i][j] == 1 && (ms[i] > 1 || ns[j] > 1)) ans++;
            }
        }
        return ans;
    }
}