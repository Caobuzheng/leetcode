/**
 * S156_3
 */
public class S156_3 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcd", 2));
    }
    public static String removeDuplicates(String s, int k) {
        while(true) {
            String next = next(s, k);
            if(s.length() == next.length()) return next;
            s = next;
        }
    }
    public static String next(String s, int k) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char c = chars[0];
        for(int i = 1; i<chars.length;i++) {
            if(count>=k) {
                count = 0;
            }
            if(chars[i] != c) {
                for(int j =0;j<count;j++) sb.append(c);
                count = 1;
                c = chars[i];
            }else {
                count++;
            }
        }
        if(count<k) for(int j =0;j<count;j++) sb.append(c);
        return sb.toString();
    }
}