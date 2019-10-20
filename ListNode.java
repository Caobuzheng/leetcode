import java.util.LinkedList;
import java.util.List;

public class ListNode{
    ListNode next;
    int val;
    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode build(String str) {
        String[] array = str.split("->");
        if(array.length==0) return null;
        List<ListNode> list = new LinkedList<>();
        for(String s: array) {
            if(!s.toLowerCase().equals("null") && !s.equals("")) {
                list.add(new ListNode(Integer.valueOf(s)));
            }
        }
        if(list.size() == 0) {
            return null;
        }
        for(int i=0;i<list.size()-1;i++) {
            list.get(i).next = list.get(i+1);
        }
        return list.get(0);
    }

    public static String toString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while(node != null) {
            sb.append(node.val);
            sb.append("->");
            node = node.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}