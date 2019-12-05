import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
 */

// @lc code=start
class Solution {
    // 正确的解法是一个一个加入，然后旋转。太难了。不会写
    public TreeNode sortedListToBST(ListNode head) {
        return Solution109.sortedListToBST(head);
    }
}
class Solution109 {
    public static TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head=head.next; 
        }
        return helper(list, 0, list.size()-1);
    }
    private static TreeNode helper(List<Integer> list, int l, int r) {
        if(l>r) return null;
        int mid = (l+r) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = helper(list, l, mid-1);
        node.right = helper(list, mid+1, r);
        return node;
    }
}
// @lc code=end

