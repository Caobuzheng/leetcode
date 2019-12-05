import java.util.*;

/*
 * @lc app=leetcode.cn id=1186 lang=java
 *
 * [1186] 删除一次得到子数组最大和
 */

// @lc code=start
class Solution {
    public int maximumSum(int[] arr) {
        So1186 s = new So1186();
        return s.maximumSum(arr);
    }
}
class So1186 {
    public static void main(String[] args) {
        So1186 s = new So1186();
        int[] arr = {1, -2, 0, 3};
        int[] arr2 = {1,-2,-2,3};
        int[] arr3 = {-1,-1,-1,-1};
        int[] arr4 = {1,-4,-5,-2,5,0,-1,2};
        // System.out.println(s.maximumSum(arr));
        // System.out.println(s.maximumSum(arr2));
        // System.out.println(s.maximumSum(arr3));
        System.out.println(s.maximumSum(arr4));
    }
    LinkedList<Integer> queue;
    Stack<Integer> stack;
    int sum;
    int max;
    public int maximumSum(int[] arr) {
        queue = new LinkedList<>();
        stack = new Stack<>();
        sum = arr[0];
        max = sum;
        queue.add(arr[0]);
        stack.push(arr[0]);
        for(int i = 1; i<arr.length;i++) {
            add(arr[i]);
            int tmpSum = getNoe();
            max = Math.max(max, tmpSum);
            if(tmpSum<0) {
                del();
            }
        }
        return max;
    }

    int getNoe() {
        int tmp = sum;
        int i = stack.peek();
        if(i<0) {
            tmp  = sum-i;
        }
        // 1,-4,-5,-2,5,0,-1,2
        return tmp;
    }
    void add(int i) {
        queue.add(i);
        if(i <= stack.peek()) stack.push(i);
        sum+=i;
    }
    void del() {
        int tmp = getNoe();
        int ttt= queue.size();
        while(getNoe() <0 && queue.size()>1) {
            // 我没懂的了。
            int i = queue.poll();
            int mmm = stack.peek();
            if(i == stack.peek()) {
                stack.pop();
            }
            int peek = queue.peek();
            // 1已经不在了的。
            if(stack.isEmpty() || peek <= stack.peek()) stack.push(peek);
            sum-=i;
            max = Math.max(max, sum);
        }
    }
}
// @lc code=end

