public class MinAddToMakeValid {
    // https://leetcode-cn.com/contest/weekly-contest-106/problems/minimum-add-to-make-parentheses-valid/
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())"));
        System.out.println(minAddToMakeValid("((("));
        System.out.println(minAddToMakeValid("()"));
        System.out.println(minAddToMakeValid("()))(("));
        System.out.println(minAddToMakeValid(""));
    }
    public static int minAddToMakeValid(String S) {
        int bads = 0;
        int count = 0;
        for(char c: S.toCharArray()) {
            if(c == '(') {
                count++;
            }else if(c==')'){
                count--;
                if(count<0) {
                    count =0;
                    bads++;
                }
            }
        }
        return bads + count;
    }
}