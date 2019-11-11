import java.util.*;

class Solution1065 {
    public static void main(String[] args) {
        String text = "ababa";
        String[] words = {"aba","ab"};
        System.out.println(indexPairs(text, words));
    }
    public static int[][] indexPairs(String text, String[] words) {
        List<int[]> list = new ArrayList<>();
        /**
         * 1 <= text.length <= 100
            1 <= words.length <= 20
            1 <= words[i].length <= 50
         */
        for(String word: words) {
            for(int i=0;i< text.length()-word.length() + 1;i++) {
                int j=0;
                for(; j<word.length();j ++) {
                    if(text.charAt(i+j) != word.charAt(j)) break;
                }
                if(j==word.length()) {
                    int[] tmp = {i, i+j-1};
                    list.add(tmp);
                }
            }
        }
        int[][] res = new int[list.size()][2];
        for(int i=0;i<list.size();i++) res[i] = list.get(i);
        Arrays.sort(res,(a1,a2) -> {
            if(a1[0] == a2[0]) {
                return a1[1] - a2[1];
            }else {
                return a1[0] - a2[0];
            }
        });
        return res;
    }
}