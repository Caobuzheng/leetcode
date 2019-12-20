import java.util.*;

/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */

// @lc code=start
/*
// Definition for a Node.

*/
class Solution {
    // 递归啊递归。你可曾想起来我。
    Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        return help(node);
    }
    public Node help(Node node) {
        if(node == null) return null;
        if(map.containsKey(node)) {
            return map.get(node);
        }

        Node newNode = new Node();
        newNode.val = node.val;
        map.put(node, newNode);
        List<Node> neighbors = new LinkedList<>();
        for(Node nei: node.neighbors) {
            neighbors.add(help(nei));
        }
        newNode.neighbors = neighbors;
        return newNode;
    }
}

// @lc code=end

