public class BalancedString {
    public static void main(String[] args) {
        // 我理解错了的。 该是一个string进行切掉
        System.out.println(balancedStringWrong("WWEQERQWQWWRWWERQWEQ")); // 3 out is 4
    }

    public static int balancedString(String s) {
        int ans = 0;
        // 前半部分可以借鉴。后半部分不太行。
        return ans;
    }

    public static int balancedStringWrong(String s) {
        int ans = 0;
        int avg = s.length()/4;
        int[] counts = {avg, avg, avg, avg};
        for(char c: s.toCharArray()) {
            if(c == 'Q') counts[0]--;
            if(c == 'W') counts[1]--;
            if(c == 'E') counts[2]--;
            if(c == 'R') counts[3]--;
        }
        // 8 ge
        for(int i: counts) {
            ans += Math.abs(i);
        }
        System.out.println(ans);
        return ans/2;
    }
}