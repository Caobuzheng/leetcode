import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        LinkedList<Node> list = new LinkedList<>();
        LinkedList<Node> nextLevel = new LinkedList<>();
        List<Integer> thisLevelVals = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()){
            Node tmp = list.poll();
            thisLevelVals.add(tmp.val);
            if(tmp.children != null && tmp.children.size() > 0) {
                nextLevel.addAll(tmp.children);
            }
            if(list.isEmpty()) {
                res.add(thisLevelVals);
                if(!nextLevel.isEmpty()){
                    list = nextLevel;
                    nextLevel = new LinkedList<>();
                    thisLevelVals = new LinkedList<>();
                }
            }
        }
        return res;

    }
}
// @lc code=end

