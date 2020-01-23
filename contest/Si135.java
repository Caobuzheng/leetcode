import java.util.*;
class Si135 {
    public static void main(String[] args) {
        Si135 s = new Si135();
        s.minScoreTriangulation(new int[]{3,7,4,5})；

    }

    public int minScoreTriangulation(int[] A) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2)-> o2[0] - o1[0]);
        int min = 0;
        for(int i = 0; i<A.length; i++) {
            queue.add(new int[]{A[i], i});
        }
        // 其实是可以有treeSet的。
        while(queue.size() >= 3) {
            // 我感觉从queue中比较简单。
            int[] t = queue.poll();
            int left = 0;
            int right = 0;
            A[t[1]] = 0;
            for(int i = t[1]-1; ;) {
                if(i<0){
                    i+=A.length;
                }
                if(A[i] != 0) {
                    left = A[i];
                    break;
                }
                i--;
            }
            for(int i = t[1] + 1;;) {
                if(i>=A.length){
                    i=0;
                }
                if(A[i] != 0) {
                    right = A[i];
                    break;
                }
                i++;
            }
            min += left * right * t[0];
        }
        return min;
    }

    public boolean isBoomerang(int[][] points) {
        // 情况1，有重叠的
        int[] p1 = points[0];
        int[] p2 = points[1];
        int[] p3 = points[2];
        if(p1[0] == p2[0] && p1[1] == p2[1]) return false;
        if(p1[0] == p3[0] && p1[1] == p3[1]) return false;
        if(p2[0] == p3[0] && p2[1] == p3[1]) return false;

        // 然后看斜率
        return (p2[1] - p1[1]) * (p3[0] - p1[0]) != (p3[1] - p1[1]) *  (p2[0] - p1[0]);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

   

    public TreeNode bstToGst(TreeNode root) {
        help(root, 0);
        return root;
    }

    int help(TreeNode node, int more) {
        if(node == null) return 0;
        int right = help(node.right, more);
        int left = help(node.left, right + node.val + more);
        int sum =  right+tmp+left;
        node.val = right + node.val + more;
        return sum;
    }
}