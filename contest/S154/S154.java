/**
 * S154_1
 */
import java.util.*;

public class S154 {
    public static void main(String[] args) {
        S154 s = new S154();
        int[] arr = {1,2};
        System.out.println(s.kConcatenationMaxSum(arr, 3));
    }

    static final int MOD = 1_000_000_007;
    public int kConcatenationMaxSum(int[] arr, int k) {
        long maxMid = 0L;
        long tmp = 0L;

        tmp = 0L;
        for(int i:arr) {
            tmp+=i;
            if(tmp <0) tmp = 0L;
            maxMid = Math.max(maxMid, tmp);
        }
        if(k == 1) return  Long.valueOf(maxMid%MOD).intValue();
        long sum1 = 0L;
        for(int i: arr) sum1+=i;
        long maxTail = 0L;
        tmp = 0L;
        for(int i = arr.length-1;i>=0;i--) {
            tmp += arr[i];
            maxTail = Math.max(maxTail, tmp);
        }
        tmp = 0L;
        long maxHead = 0L;
        for(int i:arr) {
            tmp+=i;
            maxHead = Math.max(maxHead, tmp);
        }
        Long ans = 0L;
        if(k>=2) {
            ans = (k-2) * sum1 + maxTail + maxHead;
        }
        ans = Math.max(ans, maxTail + maxHead);
        return Long.valueOf(Math.max(ans, maxMid)%MOD).intValue();
    }


    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> tmp = new LinkedList<>();
        char[] chars = s.toCharArray();
        // 用个list的比较好吧？
        for(char c: chars) {
            if(c == ')'){
                while(!stack.isEmpty()) {
                    char cc = stack.pop();
                    if(cc == '(') {
                        while(!tmp.isEmpty()){
                            stack.push(tmp.poll());
                        }
                        break;
                    }else {
                        tmp.add(cc);
                    }
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }

    public int maxNumberOfBalloons(String text) {
        //balloon
        int[] count = new int[26];
        for(char c: text.toCharArray()) {
            count[c-'a']++;
        }
        count['o' - 'a']/=2;
        count['l' - 'a']/=2;
        int min = Integer.MAX_VALUE;
        min = Math.min(min, count['b' - 'a']);
        min = Math.min(min, count['a' - 'a']);
        min = Math.min(min, count['l' - 'a']);
        min = Math.min(min, count['o' - 'a']);
        min = Math.min(min, count['n' - 'a']);
        return min;
    }
}