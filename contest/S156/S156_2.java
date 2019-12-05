/**
 * S156_2
 */
public class S156_2 {

    public static void main(String[] args) {
        // s = "abcd", t = "bcdf", cost = 3
        // "tyiraojpcfuttwblehv"
        // "stbtakjkampohttraky"
        // 119
        System.out.println(equalSubstring("abcd", "bcde", 4));
    }
    public static int equalSubstring(String s, String t, int maxCost) {
        int[] costs = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int max = 0;
        int l = 0;
        int r = 0;
        int sum = 0;
        while(r<costs.length && sum<=maxCost) {
            sum+=costs[r++];
        }
        
        
        while(l<=r && r<costs.length) {
            if(sum == maxCost) {
                max = Math.max(r-l, max);
            }else max = Math.max(r-l-1, max);
            sum-=costs[l++];
            while(r<costs.length && sum<=maxCost) {
                sum+=costs[r++];
            }
        }
        if(sum == maxCost) {
            max = Math.max(r-l, max);
        }else max = Math.max(r-l-1, max);
        return max;
    }
}