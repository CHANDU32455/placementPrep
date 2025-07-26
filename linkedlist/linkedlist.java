
class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class lkdList {

    Node head;

    // first method traversal
    void displayNodes() {
        if (head == null) {
            System.out.println("LL is empty...");
            return;
        }
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    // append at last
    void appendAtBegining(int data) {
        Node newnode = new Node(data);
        newnode.next = this.head;
        this.head = newnode;
    }

    void insAtEnd(int data) {
        Node newnode = new Node(data);
        if (this.head == null) {
            this.head = newnode;
            return;
        }
        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newnode;

    }

    int llLength() {
        Node temp = this.head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    void insertAtPos(int data, int reqpos) {
        Node newnode = new Node(data);
        Node temp = this.head;
        int pos = 1;
        if (reqpos == 1) {
            appendAtBegining(data);
            return;
        }
        if (reqpos > llLength() || pos < 1) {
            System.out.println("Invalid pos..");
            return;
        }
        while (temp != null && pos < reqpos-1) {
            temp = temp.next;
            pos++;
        }
        if(temp == null){
            System.out.println("out of range..");
            return;
        }
        newnode.next = temp.next;
        temp.next = newnode;

    }

    void deleteAtFront(){
        this.head = this.head.next;
    }
}

public class linkedlist {

    public static void main(String[] args) {
        lkdList ll = new lkdList();
        ll.appendAtBegining(10);
        ll.appendAtBegining(20);
        ll.displayNodes();

        ll.insAtEnd(30);
        ll.displayNodes();

        System.out.println("length of ll: " + ll.llLength());
        System.out.println("start counting pos from 0");
        ll.insertAtPos(40, 2);
        ll.displayNodes();

        ll.deleteAtFront();
        ll.displayNodes();
    }
}
