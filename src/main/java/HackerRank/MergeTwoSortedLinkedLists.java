package HackerRank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MergeTwoSortedLinkedLists {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SinglyLinkedList list1 = new SinglyLinkedList();

        list1.insertNode(1);
        list1.insertNode(2);
        list1.insertNode(3);

        SinglyLinkedList list2 = new SinglyLinkedList();

        list2.insertNode(3);;
        list2.insertNode(4);;

        SinglyLinkedListNode list3 = mergeLists(list1.head, list2.head);

        printSinglyLinkedList(list3, " ");
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode newHead = new SinglyLinkedListNode(0);
        SinglyLinkedListNode tail = newHead;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        if (head1 == null)
            tail.next = head2;
        else tail.next = head1;

        return newHead.next;
    }
}
