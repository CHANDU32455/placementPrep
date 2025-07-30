import java.util.Scanner;

class stack {
    int top = -1;
    int size;
    int[] stk;

    stack(int size) {
        this.size = size;
        stk = new int[size];
    }

    public void Push(int ele) {
        if (top == size - 1) {
            System.out.println("Stack full buddy...");
            return;
        }
        top++;
        stk[top] = ele;
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack empty buddy...");
            return;
        }
        // System.out.println(stk[top] + " ");
        top--;
    }

    public void peek() {
        if (top != -1) {
            System.out.println("top most ele: " + stk[top] + " ");
        } else {
            System.out.println(" top empty while peeking");
        }
    }

    public void PrintElements() {
        if (top == -1) {
            System.out.println("Stack Empty buddy...");
            return;
        }
        System.out.println("Stack elements:");
        for (int i = top; i >= 0; i--) {
            System.out.println(stk[i] + " ");
        }
    }
}

public class stackImplementation {
    public static void main(String[] args) {
        stack s = new stack(5);
        int choice;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("0. exit");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. peek");
            System.out.println("4. PrintElements Of Stack");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 0 :
                    System.exit(0);
                case 1:
                    System.out.println("Enter ele to push: ");
                    int data = sc.nextInt();
                    s.Push(data);
                    break;
                case 2:
                    s.pop();
                    break;
                case 3 :
                    s.peek();
                    break;
                case 4:
                    s.PrintElements();
                    break;
                default:
                System.out.println("Invalid Choice...");
                    break;
            }
        }
    }
}
