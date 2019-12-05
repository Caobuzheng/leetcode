import java.util.Stack;

/**
 * Stack_learn
 */

public class Stack_learn {
    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }
    // 150.逆波兰表达式求值
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str: tokens) {
            if(str.equals("*")){
                int b = stack.pop();
                int a = stack.pop(); 
                stack.push(a*b);
            } else if(str.equals("/")) {
                int b = stack.pop();
                int a = stack.pop(); 
                stack.push(a/b);
            } else if(str.equals("+")) {
                int b = stack.pop();
                int a = stack.pop(); 
                stack.push(a+b);
            }else if(str.equals("-")) {
                int b = stack.pop();
                int a = stack.pop(); 
                stack.push(a-b);
            }else {
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.isEmpty()?0:stack.peek();
    }
}