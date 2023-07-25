package com.lulu.tools.list;

/**
 * 链表节点
 */
@SuppressWarnings("unused")
public class ListNode {
    public int val;
    public ListNode pre;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val, ListNode pre, ListNode next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode cur = this;
        StringBuilder builder = new StringBuilder();
        while (cur != null) {
            builder.append(cur.val).append(" ");
            cur = cur.next;
        }
        return "ListNode{" + builder + "}";
    }
}
