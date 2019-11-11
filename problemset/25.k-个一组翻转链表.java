/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 *
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (54.64%)
 * Likes:    286
 * Dislikes: 0
 * Total Accepted:    24.4K
 * Total Submissions: 44.5K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 示例 :
 * 
 * 给定这个链表：1->2->3->4->5
 * 
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 
 * 说明 :
 * 
 * 
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
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

