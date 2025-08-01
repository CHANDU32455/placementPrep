import java.util.*;

class STACK{
    Stack<Integer> stk = new Stack<>();

    void push(int data){
         stk.push(data);
         System.out.println(data + " added to stack.");
    }
    void pop(){
        if(!stk.isEmpty()){
            System.err.println("popped ele: "+ stk.pop());
        }else{
            System.err.println("Stack underflow..");
        }
    }

    void peek(){
        if(!stk.isEmpty()){
            System.err.println("Top most ele of Stack: "+ stk.peek());
        }else{
            System.out.println("stk empty to peek..");
        }
    }
    void showStkElements(){
        if(stk.isEmpty()){
            System.out.println("Stk empty while printing..");
            return;
        }else{
            System.out.println("Elements of Stack: ");
            for(int i = stk.size()-1; i>=0; i--){
            System.out.print(stk.get(i)+ " ");
        }
        }
    }
}

public class stackImplementationWithCollections {
    public static void main(String[] args) {
        STACK s = new STACK();
        s.push(10);
        s.push(20);
        s.pop();
        s.pop();
        s.peek();
        s.showStkElements();
        s.push(30);
        s.push(40);
        s.peek();
        s.showStkElements();
    }
}