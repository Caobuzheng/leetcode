/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 * Ac
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return SwapPairs.swapPairs(head, k);
    }
}
class SwapPairs{
    public static ListNode swapPairs(ListNode head, int pairs) {
        if(pairs <= 1) {
            return head;
        }

        ListNode index = new ListNode(0); // fack node
        ListNode res = index;
        index.next = head;
        ListNode[] arrays = new ListNode[pairs+1];
        while(hasNextN(index, pairs)) {
            index = swap(index, pairs, arrays);
        }
        // 不该输出这个的。
        return res.next;
    }
    // 看了下标准答案，就是把这个代码进行了个整合。不过我还是喜欢我的这个思路，虽然hasNextN的，多遍历了链表了一次
    public static boolean hasNextN(ListNode node, int pairs) {
        // 第一个node不进行计数
        ListNode tmp = node;
        int count = 0;
        while(tmp != null) {
            if(count++ >= pairs) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    public static ListNode swap(ListNode node ,int pairs, ListNode[] arrays) {
        ListNode index = node;
        for(int i = 0; i<=pairs; i++) {
            arrays[i] = index;
            index = index.next;
        }
        arrays[1].next = arrays[pairs].next;
        for(int i = pairs; i>1;i--){
            arrays[i].next = arrays[i-1];
        }
        arrays[0].next = arrays[pairs];
        return arrays[1]; // 不会数组越界，因为pairs大于1的。
    }
}
// @lc code=end

