import java.util.Stack;

public class ScoreOfParentheses855 {
    public static int scoreOfParentheses(String S) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        for(char c: S.toCharArray()) {
            if(c == '(') {
                if(i!=0) {
                    stack.push("" + i);
                }
                stack.push("(");
            }else {
                while(!stack.isEmpty() && !stack.peek().equals("(")) {
                    i+=Integer.valueOf(stack.pop());
                }
                String pop = stack.pop();
                if(i==0) {
                    i=1;
                }else {
                    i*=2;
                }    
                stack.push("" + i);
                i=0;
            }
        }
        while(!stack.isEmpty()) {
            i+=Integer.valueOf(stack.pop());
        }
        return i;
    }
    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("()"));
        System.out.println(scoreOfParentheses("(())"));
        System.out.println(scoreOfParentheses("()()"));
        System.out.println(scoreOfParentheses("(()(()))"));
    }
}