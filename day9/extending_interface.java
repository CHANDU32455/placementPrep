
interface first {

    abstract void sum(int a, int b);
}

interface second extends first {

    abstract void sub(int a, int b);
}

interface third extends second {

    abstract void mul(int a, int b);
}

class Calculator implements third {

    @Override
    public void sum(int a, int b) {
        System.out.println("sum is: " + (a + b));
    }

    @Override
    public void sub(int a, int b) {
        System.out.println("sub is: " + (a - b));
    }

    @Override
    public void mul(int a, int b) {
        System.out.println("mul is: " + (a * b));
    }
}

public class extending_interface {

    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.sum(10, 20);
        c.sub(20, 10);
        c.mul(10, 20);

        fourth f = new fourth();
        f.display();
        f.print();
        f.show();
    }
}

// extending multiple interfaces
abstract class fourth implements first, second, third{
    public void display(){
        System.out.println("display method..");
    }
    public void print(){
        System.out.println("print method..");
    }
    public void show(){
        System.out.println("show method..");
    }
}