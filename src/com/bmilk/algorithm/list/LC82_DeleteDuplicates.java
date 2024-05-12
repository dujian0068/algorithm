package com.bmilk.algorithm.list;

public class LC82_DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {

        Integer delNum = null;
        ListNode pre = new ListNode();
        ListNode p = pre;

        ListNode pH = head;
        while (pH != null){
            if(null == pH.next){
                p.next = pH;
                break;
            }

            if(pH.val == pH.next.val){
                delNum = pH.val;
            }else {
                p.next = pH;
                pH = pH.next;
                p = p.next;
                p.next = null;
            }
            while (pH != null){
                if(null != delNum && pH.val == delNum){
                    pH = pH.next;
                }else {
                    break;
                }
            }

        }

        return pre.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
