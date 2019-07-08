package com.learning.samples.datastructure.model;

public class ReverseList {
    public Node reverse(Node head) {

        Node p = null, q = null, r = null ;
        Init: p = head; q = p.next;
        while (q != null) {
            if (q.next != null) {
                Oper: r = q.next; q.next = p ;
            }
            p = q ;
            q = r ;
        }
        return p ;
    }
}
