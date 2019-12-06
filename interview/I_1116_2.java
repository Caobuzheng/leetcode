/**
 * I_1116_2
 */
public class I_1116_2 {

    static int ans = 0;
    public int pathSum(TreeNode root, int sum) {
        ans = 0;
        help(root, sum, 0);
        return ans;
    }
/**
 * 
      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1
 */
    public int help(TreeNode node, int sum, int more) {
        if(node == null) return 0;
        int left = help(node.left, sum);
        int right = help(node.right, sum);
        int tSum = node.val + left + right;
        if(tSum == sum) ans++;
        return left+Math.max(left, right); 
    }
}