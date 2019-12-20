/*
 * @lc app=leetcode.cn id=735 lang=java
 *
 * [735] 行星碰撞
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
    }

}
class So735 {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int ass: asteroids){
            if(stack.isEmpty()) stack.push(ass);
            else if (stack.peek() > 0) {
                while()
            }else {
                stack.push(ass);
            }
        }

        return null;
    }
}
// @lc code=end

