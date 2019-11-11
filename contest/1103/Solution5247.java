/**
 * Solution5247
 */
import java.util.*;

public class Solution5247 {

    /**
     * 输入：s1 = "xx", s2 = "xy"
        输出：-1
        s1 = "x xyyxyxyxx", s2 = "xyy xyxxxyx"
        4
     */
    public static void main(String[] args) {
        // xxyyxyxyxx
        // xyyxyxxxyx
        System.err.println(numKLenSubstrNoRepeats("havefunonleetcode", 5));
    }
    public static int numKLenSubstrNoRepeats(String S, int K) {
        if(S.length()<K) return 0;
        Map<Character, Integer> map = new HashMap<>();

        char[] chars = S.toCharArray();
        for(int i=0;i<K-1;i++) {
            map.put(chars[i], map.getOrDefault(chars[i],0) +1);
        }
        int ans = 0;
        for(int i = 0; i<chars.length-K;i++) {
            map.put(chars[i+K-1], map.getOrDefault(chars[i+K-1],0) +1);
            if(map.size() == K) ans++;
            int c = map.get(chars[i]);
            if(c==1){
                map.remove(chars[i]);
            }else{
                map.put(chars[i], c-1);
            }
        }
        return ans;
    }

    public static int minimumSwap(String s1, String s2) {
        int ans = 0;
        if(s1.length() != s2.length()) return -1;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        for(int i = 0; i< chars1.length; i++) {
            if(chars1[i] != chars2[i]) {
                if(chars1[i] == 'x') {
                    x1++;
                    y2++;
                }
                else {
                    y1++;
                    x2++;
                }
            }
        }
        if((x1 + x2)%2 != 0
            && (y1+y2) %2 != 0
        ) return -1;
        int dx1 = Math.min(x1, y2) / 2;
        int dy1 = Math.min(y1, x2) / 2;
        int ox1 = (x1 - dx1*2);
        ans = ans + dx1+dy1+ 2* ox1 ; 
        return ans;
    }
}