import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=390 lang=java
 
给定一个从1 到 n 排序的整数列表。
首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。
我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
返回长度为 n 的列表中，最后剩下的数字。
输出:
1 2 3 4 5 6 7 8 9 10
2 4 6 8 10
4 8
8
这个是稍微复杂了的些。还是看两部比较好的。
嗯。
 * [390] 消除游戏
 */

// @lc code=start
class Solution {
    public int lastRemaining(int n) {
        return Solution390.ac(n);
    }
}
class Solution390 {
    public static void main(String[] args) {
        System.out.println(ac(9));
        System.out.println(ac(8));
    }
    public static int ac(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1;i<=n;i++) list.add(n);
        return 0;
    }
}
// @lc code=end

