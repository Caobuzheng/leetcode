import java.util.Stack;

/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 *
 * https://leetcode-cn.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (46.48%)
 * Likes:    142
 * Dislikes: 0
 * Total Accepted:    9.5K
 * Total Submissions: 20.4K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 
 * 示例:
 * 
 * 
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * 
 * 
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        return DecodeString.decodeString(s);
    }
}
class DecodeString {
    // 怎么说，还是考虑怎么写的更好看把。
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
    public static String decodeString(String s) {
        // stack problem.
        // 看出来了，这个题就是麻烦，而不是多难
        Stack<Type> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(); 
        int more = 0;
        for(char c: s.toCharArray()) {
            // 3[a] 2[bc];
            if((c>='a' && c<='z') || (c>='A' && c<='Z'  )) {
                sb.append(c);
            }else if(c>='0' && c<='9') {
                if(sb.length() > 0 ) {
                    stack.push(new Type(sb.toString()));
                    sb = new StringBuilder();
                }
                more = more * 10 + c - '0';
            }else {
                if(more>0) {
                    stack.push(new Type(more));
                    more = 0;
                }else {
                    stack.push(new Type(sb.toString()));
                    sb = new StringBuilder();
                }

                if(c == '[') {
                    stack.push(new Type());
                }else {
                    boolean tag = false;
                    while(!stack.isEmpty() ){
                        if(stack.peek().type==3 && tag) break;
                        Type tmp = stack.pop();
                        if(tmp.type==1) {
                            sb.insert(0, tmp.str);
                        }else if(tmp.type == 2){
                            String str = sb.toString();
                            for(int i=0; i<tmp.val-1;i++) {
                                sb.append(str);
                            }
                        }else {
                            tag = true;
                        }
                    }
                    if(sb.length() > 0 ) {
                        stack.push(new Type(sb.toString()));
                        sb = new StringBuilder();
                    }
                }
            }
        }
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop().str);
        }
        return sb.toString();
    }
}
class Type{
    Integer type;
    String str;
    Integer val;
    public Type() {
        this.type = 3;
    }
    public Type(String str) {
        this.str = str;
        this.type = 1;
    }
    public Type(Integer val) {
        this.val = val;
        this.type = 2;
    }
}
// @lc code=end

