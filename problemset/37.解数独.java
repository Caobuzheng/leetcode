/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    // 就是写代码+回溯的
    public void solveSudoku(char[][] board) {
        int[] a = new int[9];
        int[] b = new int[9];
        int[] c = new int[9];
        for(int i = 0; i<9; i ++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    a[i] ++;
                    b[j] ++;
                    c[getZ(i, j)] ++;
                }
            }
        }
        PriorityQueue<Cell> queue = new PriorityQueue<>((c1,c2) -> c2.sum() - c1.sum());
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                Cell cell = new Cell(a[i], b[j], c[getZ(i, j)]);
                queue.add(cell);
            }
        }
    }
    // 还是需要递归的。get miss value。
    class Cell {
        int a;
        int b;
        int c;
        public Cell(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public int sum() {
            return a+b+c;
        }
    }
    
    
    public boolean test(char[][] board, int x, int y) {
        
    }
    
    public int getZcount(char[][] board, int x, int y) {
        
    }
    
    public int getZcount(char[][] board, int z) {
        for(int i=)
    }
    
    
    static int[][] zIndex = {{0,1,2},{3,4,5},{6,7,8}};
    public int getZ(int x, int y) {
        return zIndex[x/3][y/3];
    }
}
// @lc code=end

