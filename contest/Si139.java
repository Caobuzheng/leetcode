/**
 * Si139
 */
import java.util.*;
public class Si139 {
    public static void main(String[] args) {
        Si139 si = new Si139();
        int[][] matrix = {{0,1,0},{1,1,1},{0,1,0}};
        System.out.println(numSubmatrixSumTarget(matrix, 0));
        System.out.println(numSubmatrixSumTarget(new int[][]{{1, -1},{-1, 1}}, 0));
    }


    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        for(int x1 = 0;x1<m;x1++){
            for(int y1 = 0; y1<n;y1++) {
                int[][] vec = new int[m][n];
                for(int x2 = x1;x2<m;x2++) {
                    for(int y2 = y1; y2<n;y2++) {
                        int val = matrix[x2][y2];
                        if(y2>0 && x2 ==0) {
                            val+=vec[x2][y2-1];
                        }else if(x2>0 && y2 ==0) {
                            val+=vec[x2-1][y2];
                        }else if(x2>0 && y2 >0) {
                            val+=vec[x2][y2-1];
                            val+=vec[x2-1][y2];
                            val-=vec[x2-1][y2-1];
                        }
                        if(val == target) ans++;
                        vec[x2][y2] = val;
                    }
                }
            }
        }
        return ans;
    }

    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i<matrix.length;i++) {
            StringBuilder sb = new StringBuilder();
            int c = matrix[i][0];
            for(int j = 0; j< matrix[i].length;j++) {
                if(c == 0) {
                    sb.append(matrix[i][0]);
                }else {
                    sb.append(1-matrix[i][0]);
                }
            }
            String val = sb.toString();
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int max = 1;
        for(int vals : map.values()) {
            max = Math.max(max, vals);
        }
        return max;
    }

    public String gcdOfStrings(String str1, String str2) {
        if(str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        }
        for(int i = str1.length(); i>=1;i--) {
            if(str1.length() % i != 0 || str2.length() % i != 0) continue;
            String ss = str1.substring(0, i);
            if(check(str1, ss) && check(str2, ss)) return ss;
        }
        return "";
    }
    boolean check(String str, String ss) {
        String tmp = "";
        for(int i=0;i<str.length()/ss.length();i++) {
            tmp = tmp+ss;
        }
        return str.equals(tmp);
    }
}