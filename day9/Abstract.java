interface first{
    abstract void display();
    abstract void print();
}

class second implements first{
    @Override
    public void display(){
        System.out.println("first method..");
    }
    @Override
    public void print(){
        System.out.println("second method..");
    }
}

public class Abstract{
    public static void main(String[] args) {
        second s = new second();
        s.display();
        s.print();
        
    }
}