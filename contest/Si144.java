import java.util.*;
public class Si144 {
    // 这个题做过的！
    public static void main(String[] args) {
        
    }
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        LinkedList<TreeNode> roots = new LinkedList<>();
        roots.add(root);

        for(int i: to_delete) {
            int size = roots.size();
            for(int j=0;j<size;j++) {
                TreeNode node = roots.poll();
                if(node.val == i) {
                    if(node.left!=null) {
                        roots.add(node.left);
                        
                    }
                    if(node.right != null) {
                        roots.add(node.right);
                    }
                }else if(finded(node, i, roots)){
                    System.out.println(node.val);
                    roots.add(node);
                    break;
                }
            }
        }
        return roots;
    }

    boolean finded(TreeNode node, int target, LinkedList<TreeNode> roots) {
        if(node == null) return false;
        if(node.left != null && node.left.val == target) {
            TreeNode left = node.left;
            node.left = null;
            if(left.left != null) roots.add(left.left);
            if(left.right != null) roots.add(left.right);
            return true;
        }
        if(node.right != null && node.right.val == target) {
            TreeNode right = node.right;
            node.right = null;
            System.out.println(right.val);
            if(right.left != null) roots.add(right.left);
            if(right.right != null) roots.add(right.right);
            System.out.println("add rightright" + right.right.val+ " now last is" + roots.peekLast().val);
            return true;
        }
        return finded(node.left, target, roots) || finded(node.right, target, roots);
    }



    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] dp = new int[n];
        for(int[] booking: bookings) {
            dp[booking[0]-1] += booking[2];
            if(booking[1] < n)  dp[booking[1]] -= booking[2];
        }

        for(int i = 1;i<n;i++) {
            dp[i] += dp[i-1];
        }
        return dp;
    }
    public String defangIPaddr(String address) {
        String[] strs = address.split("\\.");
        return strs[0] +"[.]" + strs[1] +"[.]"+strs[2]+"[.]"+strs[3];
    }
}