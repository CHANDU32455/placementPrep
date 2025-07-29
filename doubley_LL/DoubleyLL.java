
import java.util.Scanner;

class DoubleyListNode {

    int data;
    DoubleyListNode prev;
    DoubleyListNode next;

    DoubleyListNode(int data) {
        this.data = data;
    }
}

class DoubleyLinkedList {

    DoubleyListNode head;

    DoubleyLinkedList() {
        this.head = null;
    }

    public void traverseWithNext() {
        System.out.println("\ntraversing with next...");
        if (this.head == null) {
            System.out.println("List is empty");
            return;
        }
        DoubleyListNode temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.print("Null");
    }

    public void traverseWithPrev() {
        System.out.println("\ntraversing with prev...");
        if (this.head == null) {
            System.out.println("LL is empty...");
            return;
        }
        DoubleyListNode temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.prev;
        }
        System.out.print("Null");
    }

    public int llSize() {
        DoubleyListNode temp = this.head;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }

    public void insertAtBegin(int data) {
        DoubleyListNode newnode = new DoubleyListNode(data);
        if (this.head != null) {
            newnode.next = this.head;
            this.head.prev = newnode;
        }
        this.head = newnode;
    }

    public void insAtEnd(int data) {
        DoubleyListNode newnode = new DoubleyListNode(data);
        if (this.head == null) {
            this.head = newnode;
            return;
        }
        DoubleyListNode temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        newnode.prev = temp;
        temp.next = newnode;
    }

    public void insAtPos(int data, int reqpos) {
        if (reqpos < 1 || reqpos > llSize() + 1) {
            System.out.println("invalid position...");
            return;
        }
        if (reqpos == 1) {
            insertAtBegin(data);
            return;
        }
        if (reqpos == llSize() + 1) {
            insAtEnd(data);
            return;
        }
        DoubleyListNode newnode = new DoubleyListNode(data);
        DoubleyListNode temp = this.head;
        int pos = 1;
        while (pos < reqpos - 1) {
            temp = temp.next;
            pos++;
        }
        newnode.next = temp.next;
        newnode.prev = temp;
        temp.next.prev = newnode;
        temp.next = newnode;
    }

    // deletion operations
    public void delAtFront() {
        if (this.head == null) {
            System.out.println("ll is empty to delete at front..");
            return;
        }
        if (this.head.next == null) {
            this.head = null;
            return;
        }
        this.head = this.head.next;
        this.head.prev = null;
    }

    public void delAtEnd() {
        if (this.head == null) {
            System.out.println("LinkedList is empty to delete at end...");
            return;
        }
        if (this.head.next == null) {
            this.head = null;
            return;
        }
        DoubleyListNode temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
    }

    public void delAtPos(int reqpos) {
        if (this.head == null) {
            System.out.println("ll is empty to delete at pos...");
            return;
        }
        if (reqpos < 1 || reqpos > llSize()) {
            System.out.println("invalid position...");
            return;
        }
        if (reqpos == 1) {
            delAtFront();
            return;
        }
        DoubleyListNode temp = this.head;
        int pos = 1;
        while (pos < reqpos - 1) {
            temp = temp.next;
            pos++;
        }
        temp.next = temp.next.next;
        if (temp.next != null) {
            temp.next.prev = temp;
        }
    }

    public void delfromLastPos(int reqpos) {
        if (this.head == null) {
            System.out.println("ll is empty..");
            return;
        }
        int size = llSize();
        int targetpos = size - 1 - reqpos;
        if (targetpos < 0 || reqpos < 0 || targetpos >= size) {
            System.out.println("Invalid position.");
            return;
        }
        if (targetpos == size - 1) {
            delAtEnd();
            return;
        }
        DoubleyListNode temp = this.head;
        // skip required positions..
        for(int i=0; i<targetpos; i++) {
            temp = temp.next;
        }
        temp.next.prev = temp;
        temp.next = temp.next.next;
    }
}

public class DoubleyLL {

    public static void main(String[] args) {
        DoubleyLinkedList dll = new DoubleyLinkedList();

        int choice = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. insert at begin\n2. insert at end\n3. insert at pos\n4. delete at front\n5. delete at end\n6. delete at pos\n7. traverse with next\n8. traverse with prev\n9. exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 0 ->
                    System.exit(0);
                case 1 -> {
                    System.out.print("Enter data to insert at begin: ");
                    int data = sc.nextInt();
                    dll.insertAtBegin(data);
                }
                case 2 -> {
                    System.out.print("Enter data to insert at end: ");
                    int data1 = sc.nextInt();
                    dll.insAtEnd(data1);
                }
                case 3 -> {
                    System.out.print("Enter data to insert: ");
                    int data2 = sc.nextInt();
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    dll.insAtPos(data2, pos);
                }
                case 4 ->
                    dll.delAtFront();
                case 5 ->
                    dll.delAtEnd();
                case 6 -> {
                    System.out.print("Enter position to delete: ");
                    int pos1 = sc.nextInt();
                    dll.delAtPos(pos1);
                }
                case 7 ->
                    dll.traverseWithNext();
                case 8 ->
                    dll.traverseWithPrev();
                case 9 -> {
                    System.out.println("Enter pos to delete from last: ");
                    int pos = sc.nextInt();
                    dll.delfromLastPos(pos);
                }
                default ->
                    System.out.println("Invalid choice...");
            }
        }
    }
}
