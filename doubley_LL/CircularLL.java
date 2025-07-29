class CircularNode{
    int data;
    CircularNode next;

    CircularNode(int data) {
        this.data = data;
    }
}
class CircularLinkedList{
    CircularNode head = null; 

    void printCircularLL(){
        CircularNode temp = head;
        while(temp != head){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }  

    void insertAtFront(int data){
        CircularNode newnode = new CircularNode(data);
        if(head == null){
            this.head = newnode;
            newnode.next = head;
        }
    }
}


public class CircularLL{
    public static void main(String[] args) {
        
    }
}