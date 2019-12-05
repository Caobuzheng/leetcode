import java.util.*;


/*
// Definition for a Node.

*/
class DFS {
    // 133 克隆图
    /**
        节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
        节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
        节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
        节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
     */
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        help(map, node);
        return help(map, node);
    }
    private Node help(Map<Node, Node> map,Node old) {
        if(map.containsKey(old)) return map.get(old);
        Node node = new Node();
        map.put(old, node);
        node.val = old.val;
        List<Node> neighbors = new LinkedList<>();
        for(Node neighbor: old.neighbors) {
            neighbors.add(help(set, neighbor));
        }
        node.neighbors = neighbors;
        return node;
    }
}
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};