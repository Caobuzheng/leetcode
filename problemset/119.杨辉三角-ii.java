/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        int n = 1;
        while(n++<=rowIndex) {
            int size = queue.size();
            int more = 0;
            for(int i=0;i<size;i++) {
                int c = queue.poll();
                queue.add(more + c);
                more = c;
            }
            queue.add(1);
        }
        return queue;
    }
}
// @lc code=end

