/**
 * Si165
 */
import java.util.*;
public class Si165 {
    // 102名。终于全部ac了的。有个题是做了个n3的答案。
    // 又是记忆的深度奥。
    Map<String,Map<Integer, Integer>> map ;
    static final int max = 100;
    public int palindromePartition(String s, int k) {
        map = new HashMap<>();
        int ans = help(s, k);
        return ans;
    }
    int helpp(String s) {
        char[] chars = s.toCharArray(); 
        int min = chars.length;
        if(chars.length % 2 == 1) {
            int count = 0;
            int mid = (0+chars.length) /2 ;
            for(int i = 0; i<mid;i++) {
                if(chars[i] != chars[chars.length-i-1]) count++;
            }
            min = Math.min(min, count);
        }else {
            int count = 0;
            for(int i = 0; i< (0+chars.length) /2;i++) {
                if(chars[i] != chars[chars.length-i-1]) count++;
            }
            min = Math.min(min, count);
        }
        return min;
    } 
    int help(String s, int k) {
        if(k == 0) return max;
        if(map.containsKey(s) && map.get(s).containsKey(k)) {
            return map.get(s).get(k);
        }
        int ans = max;
        if(k > s.length()){
        }
        else if(k == 1) {
            ans = helpp(s);
        }
        else if(k == s.length()) {
            ans = 0;
        }else {
            for(int i = 1;i<s.length(); i++) {
                int count = helpp(s.substring(0, i));
                // more 不对的了。
                int more = help(s.substring(i), k-1);
                ans = Math.min(ans, count + more);
            }
        }
        if(!map.containsKey(s)) {
            map.put(s, new HashMap<>());
        }
        map.get(s).put(k, ans);
        // System.out.println(s+"  " + k +  "  "+ ans);
        return ans;
    }

    /**
     * 1 <= arr.length <= 300
        1 <= arr[0].length <= 300
        0 <= arr[i][j] <= 1
     * @param matrix
     * @return
     */
    public static int countSquares(int[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        if(n == 0) return 0;
        if(m == 1 || n == 1) {
            for(int[] i: matrix) {
                for(int j:i) if(j==1) ans++;
            }
            return ans;
        }
        int[][] gos = {{-1, 0}, {0, -1}, {-1, -1},{0, 0}};
        int[][] next = new int[m-1][n-1];
        for(int i = 0;i < m;i++) {
            for(int j = 0;j<n;j++) {
                if(i<m-1 && j <n-1){
                    next[i][j] = 1;
                }
                if(matrix[i][j] == 1) ans++;
                else {
                    // 这个是错了的。
                    for(int[] go: gos) {
                        int x = i+go[0];
                        int y = j+go[1];
                        if(x>=0 && y>=0 && x<m-1 && y<n-1) {
                            next[x][y] = 0;
                        }
                    }
                }
            }
        }
        ans +=countSquares(next);
        return ans;
    }

    public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ans = new ArrayList<>();
        int l = 0;
        int r = cheeseSlices;
        while(l<r) {
            // mid *2 - r = l
            int mid = (l+r) /2;  // 这个有个写法
            if(mid*2== tomatoSlices - cheeseSlices*2) {
                ans.add(mid);
                ans.add(cheeseSlices - mid);
                return ans;
            }else if(mid*2 > tomatoSlices - cheeseSlices*2) {
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return ans;
    }

    public String tictactoe(int[][] moves) {
        String[][] qi = new String[3][3];
        for(int i = 0; i< moves.length; i++) {
            int[] move = moves[i];
            String c = i%2==0?"A":"B";
            qi[move[0]][move[1]] = c;
            if(test(qi, move[0], move[1])) return c;
        }
        if(moves.length == 9) return "Draw";
        return "Pending";
    }
    boolean test(String[][] qi, int x, int y) {
        int countx = 0;
        int county = 0;
        int countxy = 0;
        int countyx = 0;
        for(int i =0;i<3;i++) {
            if(qi[i][y].equals(qi[x][y])) countx++;
            if(qi[x][i].equals(qi[x][y])) county++;
            if(qi[i][i].equals(qi[x][y])) countxy++;
            if(qi[i][3-i-1].equals(qi[x][y])) countyx++;
        }
        if(countx==3 || county==3 || countxy == 3|| countyx ==3) return true;
        return false;
    }
}