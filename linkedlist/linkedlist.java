
import static java.lang.System.exit;


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
            System.out.println("empyt linkedlist dude.....");
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
        if(this.head == null){
            System.out.println("LL is empty..");
        }else{
            this.head = this.head.next;
        }
    }
    void deleteAtEnd(){
        if(this.head == null){
            System.out.println("LL is empty..");
            return;
        }
        if(head.next == null){
            this.head = null;
            return;
        }
        Node temp = this.head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next = null;
    }

    /**
     * Problem 2: Odd-Even Linked List Rearrangement  
Objective:  
Write a program to rearrange nodes in a linked list so that all nodes at odd positions come first, followed by nodes at even positions.  

Example:  
Input: 1 -> 2 -> 3 -> 4 -> 5  
Output: 1 -> 3 -> 5 -> 2 -> 4  

     */

    public void oddEvenLinkedList() {
        if (this.head == null || this.head.next == null) {
            return;
        }
        Node odd = this.head;
        Node even = this.head.next;
        Node evenStart = even;
        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenStart;
        if (even != null) {
            even.next = null;
        }
        displayNodes();
    }

    public int searchNodeData(int data){
        int pos = 1;
        Node temp = this.head;
        while(temp!=null){
            if(temp.data == data){
                System.out.println("Data Found at pos.. "+ pos);
                return pos;
            }else{
                pos+=1;
                temp = temp.next;
            }
        }
        return 0;
    }
    public void delateAtPos(int reqpos){
        Node temp = this.head;
        int pos = 1;
        if(temp == null){
            System.out.println("LL is empty..");
            return;
        }
        if(reqpos > llLength() || reqpos < 1){
            System.out.println("Invalid pos..");
            return;
        }
        if(reqpos == 1){
            deleteAtFront();
            return;
        }
        while(temp!=null){
            if(pos == reqpos-1){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    public void SumOfAllNodes(){
        if(this.head == null){
            System.out.println("LL is empty..");
            return;
        }
        Node temp = this.head;
        int sum = 0;
        while(temp!=null){
            sum += temp.data;
            temp = temp.next;
        }
        System.out.println("Sum of all nodes: "+ sum);
    }
    public int countOfSpecificElement(int ele){
        if(this.head == null){
            System.out.println("LL is empty..");
            return 0;
        }
        int count = 0;
        Node temp = this.head;
        while(temp != null){
            if(temp.data == ele){
                count++;
            }
            temp = temp.next;
        }
        return count;
    }

    public int absOddSumEvenSum(){
        if(this.head == null){
            System.out.println("LL is empty..");
            return 0;
        }
        int pos = 0, evensum = 0, oddsum = 0;
        Node temp = this.head;
        while(temp != null){
            if(pos%2 == 0){
                evensum += temp.data;
            }else{
                oddsum += temp.data;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println("even sum: "+ evensum);
        System.out.println("odd sum: "+ oddsum);
        return Math.abs(oddsum-evensum);
    }

    public void reversingALinkeddList(){
        
    }
}

public class linkedlist {

    public static void main(String[] args) {
        lkdList ll = new lkdList();
        /**
         * ll.appendAtBegining(10);
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

        ll.deleteAtEnd();
        ll.displayNodes();

        ll.deleteAtEnd();
        ll.displayNodes();
        
        ll.deleteAtEnd();
        ll.deleteAtEnd(); //  no more to delete by now.. so ,..   LL is empty..
        ll.displayNodes(); // empyt linkedlist dude.....
         */
        while(true){
            System.out.println("0. exit");
            System.out.println("1. append at begining");
            System.out.println("2. append at end");
            System.out.println("3. insert at pos");
            System.out.println("4. delete at front");
            System.out.println("5. delete at end");
            System.out.println("6. display");
            System.out.println("7. odd even linkedlist");
            System.out.println("8. search node data");
            System.out.println("9. delete at pos");
            System.out.println("10. count of specific element");
            System.out.println("11. sum of all nodes");
            System.out.println("12. abs of odd sum and even sum");
            System.out.println("enter your choice: ");
            int choice = Integer.parseInt(System.console().readLine());
            switch (choice) {                
                case 0 -> exit(0);
                case 1 ->                     {
                        System.out.println("enter data: ");
                        int data = Integer.parseInt(System.console().readLine());
                        ll.appendAtBegining(data);
                    }
                case 2 ->                     {
                        System.out.println("enter data: ");
                        int data = Integer.parseInt(System.console().readLine());
                        ll.insAtEnd(data);
                    }
                    case 3 ->                     {
                        System.out.println("enter data: ");
                        int data = Integer.parseInt(System.console().readLine());
                        System.out.println("enter pos: ");
                        int pos = Integer.parseInt(System.console().readLine());
                        ll.insertAtPos(data, pos);
                    }
                    case 4 ->                     {
                        ll.deleteAtFront();
                    }
                    case 5 ->                     {
                        ll.deleteAtEnd();
                    }
                    case 6 ->                     {
                        ll.displayNodes();
                    }
                    case 7 ->                     {
                        ll.oddEvenLinkedList();
                    }
                    case 8 ->                     {
                        System.out.println("enter data: ");
                        int data = Integer.parseInt(System.console().readLine());
                        System.out.println(ll.searchNodeData(data));
                    }
                    case 9 ->                     {
                        System.out.println("enter pos: ");
                        int pos = Integer.parseInt(System.console().readLine());
                        ll.delateAtPos(pos);
                    }
                    case 10 ->{
                        System.out.println("Enter val to find: ");
                        int ele = Integer.parseInt(System.console().readLine());
                        System.out.println("count: "+ ll.countOfSpecificElement(ele));
                    }
                    case 11 -> {
                        System.out.println("Sum of all nodes: ");
                        ll.SumOfAllNodes();
                    }
                    case 12 -> {
                        System.out.println("abs of odd sum and even sum: ");
                        System.out.println(ll.absOddSumEvenSum());
                    }
                default -> {
                    System.out.println("invalid choice..");
                }
            }
        }
    }
}
