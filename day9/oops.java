
class first {

    int a = 10;

    first() {
        System.out.println("first class constructer..");
    }
}

class second extends first {

    int a = 15;

    second() {
        System.out.println("Second class constructer..");
    }

    void display() {
        System.out.println(a);
        System.out.println(super.a);
        System.out.println(a * super.a);
    }
}

class third {
    int a,b;
    third(int x, int y){
        a = x;
        b = y;
    }
    void sum(){
        System.out.println("sum " + (a+b));
    }
    void sub(){
        System.out.println("Abs Diff:  " + Math.abs(a-b));
    }
}
class fourth extends third{
    fourth(){
        super(100, 200);
        super.sum();
        super.sub();
    }
}


class oops {

    public static void main(String[] args) {
        second s = new second();
        s.display();

        fourth f = new fourth();
    }
}
