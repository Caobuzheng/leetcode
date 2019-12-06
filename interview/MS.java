/**
 * MS
 */
import java.util.*;
public class MS {

    public static void main(String[] args) {
        MS m = new MS();
        m.numSquares(16);
    }
    public int numSquares(int n) {
        if(n == 0) return 0;
        List<Integer> list = new ArrayList<>();
        for(int i =1 ; i<n ; i++) {
            int c = i*i;
            if(c<=n) list.add(c);
            else break;
        }
        
        int[] dp = new int[n+1];
        Collections.reverse(list);
        int max = list.get(0);
        for(int i = 0; i<=n; i++) {
            for(int mm : list) {
                if((i+mm) == 12) {
                    System.out.println("caonima");
                }
                if(i+mm <= n) {
                    if(dp[i+mm] == 0) dp[i+mm] = dp[i] + 1;
                    else dp[i+mm] = Math.min(dp[i] + 1,dp[i+mm]);
                }
            }
        }
        return dp[n];
    }
}