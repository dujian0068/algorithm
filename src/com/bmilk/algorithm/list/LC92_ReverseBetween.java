package com.bmilk.algorithm.list;

public class LC92_ReverseBetween {
    public static void main(String[] args) {
        LC92_ReverseBetween o = new LC92_ReverseBetween();
//        ListNode node5 = new ListNode(5);
//        ListNode node4 = new ListNode(4, node5);
//        ListNode node3 = new ListNode(3, node4);

        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1,node2);
        ListNode node = o.reverseBetween(node1, 1,2);
        while (null != node){
            System.out.println(node.val);
            node= node.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right ||null == head || null == head.next){
            return head;
        }
        ListNode node = new ListNode();
        node.next = head;
        head = node;
        ListNode pLeft = head;
        for (int i=1; i< left ; i++){
            pLeft = pLeft.next;
        }
        ListNode p1 = pLeft.next;
        ListNode p2 = p1.next;
        ListNode p3 = p2.next;
        p1.next = null;
        p2.next = p1;
        for (int i = left+1; i<right && null != p3; i++) {
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
            p2.next = p1;
        }
        pLeft.next.next = p3;
        pLeft.next = p2;
        return head.next;

    }

    private static class ListNode{
        private int val;
        private ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
