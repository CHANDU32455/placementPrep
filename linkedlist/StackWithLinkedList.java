class Node {
    int data;
    Node next = null;

    Node(int data) {
        this.data = data;
    }
}

class stack {
    Node top = null;
    private int size;

    stack(int size) {
        this.size = size;
    }

    public void push(int data) {
        Node newnode = new Node(data);
        newnode.next = top;
        top = newnode;
    }

    public void printStack() {
        if (this.top == null) {
            System.out.println("Stack empty...");
            return;
        }
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.print("Null\n");
    }

    public void pop() {
        if (top == null) {
            System.out.println("nothing to pop....");
            return;
        }
        System.out.println("Popped: " + top.data);
        top = top.next;
    }

    public void peek(){
        if(top == null){
            System.out.println("Stack empty...");
        }else{
            System.out.println("TopMost ele: " + top.data);
        }
    }
}

public class StackWithLinkedList {
    public static void main(String[] args) {
        stack s = new stack(5);
        s.push(10);
        s.push(20);
        s.printStack();
        s.pop();
        s.pop();
        s.printStack();
        s.peek();
        s.push(100);
        s.printStack();
        s.peek();
    }
}
