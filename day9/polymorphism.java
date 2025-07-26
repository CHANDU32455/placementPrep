
class animal {

    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class cat extends animal {

    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class polymorphism {

    public static void main(String[] args) {
        animal a;
        a = new Dog();
        a.sound();

        a = new cat();
        a.sound();
    }
}
