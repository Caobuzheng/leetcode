import java.util.Arrays;

class Do15 {
    public static void main(String[] args) {
        System.out.println("abc".substring(1));
    }
    
    public static int minFallingPathSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i<n; i++) {
            dp[0][i] = arr[0][i];
        }
        for(int i = 1;i<m;i++) {
            dp[i][0] = dp[i-1][1] + arr[i][0];
            dp[i][n-1] = dp[i-1][n-2] + arr[i][n-1];

            for(int j = 0; j<n;j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = 0;k<n;k++) {
                    if(k == j) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k]);
                }
                dp[i][j] += arr[i][j];
            }
        }
        int min = dp[m-1][0];
        for(int i = 1;i<m;i++) {
            min = Math.min(min, dp[m-1][i]);
        }
        return min;
    }

    class CombinationIterator {
        int len;
        char[] now;
        char[] chars;
        String bad;
        public CombinationIterator(String characters, int combinationLength) {
            chars = characters.toCharArray();
            len = combinationLength;
            now = characters.substring(0, len).toCharArray();
            bad = characters.substring(characters.length() - len);
        }
        
        public String next() {
            return new String(now);
            if(hasNext()) {
                getNext();
            }
        }
        private void getNext() {
            int index = now.length -1;
            int count = 0;
            while(true) {
                if(now[index] == chars[chars.length -1 - count]) {
                    index --;
                    count ++;
                }else {
                    break;
                }
            }
            char c = now[index];
            int charIndex = 0;
            for(int i = 0; i<chars.length;i++) {
                if(chars[i] > c) {
                    charIndex = i;
                    break;
                }
            }
            for(int i = index; i<len;i++,charIndex++) {
                now[i] = chars[charIndex];
            }
        }

        public boolean hasNext() {
            return if(!new String(now).equals(bad));
        }
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1,o2)-> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        int n = intervals.length;
        for(int i = 1;i<intervals.length;i++) {
            for(int j = i-1;j>=0;j--) {
                int[] cd = intervals[i]; //28
                int[] ab = intervals[j]; // 36
                if(ab[0]<= cd[0] && ab[1] >= cd[1]) {
                    n--;
                    break;
                }
            }
        }
        return n;
    }
    public static int findSpecialInteger(int[] arr) {
        int n = arr.length/4;
        for(int i = 0; i< arr.length - n;i++) {
            if(arr[i] == arr[i+n]) {
                return arr[i];
            }
        }
        return -1;
    }
}