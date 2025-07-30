
class CircularNode {

    int data;
    CircularNode next;

    CircularNode(int data) {
        this.data = data;
    }
}

class CircularLinkedList {

    CircularNode head = null;

    void printCircularLL() {
        if(head == null){
            System.out.println("Circular Linked List is empty");
            return;
        }
        CircularNode temp = head;
        do{
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }while(temp != head);
        System.out.println("Null");
    }

    public void insAtBegin(int data) {
        CircularNode newnode = new CircularNode(data);
        if (this.head == null) {
            this.head = newnode;
            newnode.next = head;
            return;
        }
        CircularNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newnode;
        newnode.next = head;
        head = newnode;
    }

    public void insAtEnd(int data){
        CircularNode newnode = new CircularNode(data);
        if(head == null){
            newnode.next = head;
            head = newnode;
            return;
        }
        CircularNode temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        temp.next = newnode;
        newnode.next = head;
    }

    public void deleteAtFront(){
        if(head == null){
            System.out.println("Circular Linked List is empty");
            return;
        }
        if(head.next == head){
            head = null;
            return;
        }
        CircularNode temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        temp.next = head.next;
        head = temp.next;
    }

    public void delAtEnd(){
        if(head == null){
            System.out.println("cll is empty...");
            return;
        }
        if(head.next == head){
            head = null;
            return;
        }
        CircularNode temp = head;
        while(temp.next.next != head){
            temp = temp.next;
        }
        temp.next = head;
    }

}

public class CircularLL {

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.printCircularLL();
        cll.insAtBegin(10);
        cll.insAtEnd(20);
        cll.printCircularLL();
        cll.deleteAtFront();
        cll.printCircularLL();
        cll.delAtEnd();
        cll.printCircularLL();        
    }
}