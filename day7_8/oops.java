// 🧑‍🎓 Base class: Student
class Student {
    String name;
    int rollNo;
    double marks;

    int a, b, c;

    // 🎯 Constructor 1: Initializes name, rollNo, and marks
    Student(String n, int r, double m) {
        name = n;
        rollNo = r;
        marks = m;
    }

    // 🎯 Constructor 2: Initializes a, b, and c
    Student(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // 📋 Method to display student details
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks: " + marks);
        System.out.println("Total marks (a + b + c): " + (a + b + c));
    }

    // 🏫 Method Overloading: College name
    void Collegename(String name) {
        System.out.println("The name of the college is: " + name);
    }

    void Collegename(String name, int age) {
        System.out.println("Age of " + name + " is " + age);
    }
}

// 🏆 Subclass: TopperStudent (demonstrates method overriding)
class TopperStudent extends Student {
    TopperStudent(String n, int r, double m) {
        super(n, r, m); // Call superclass constructor
    }

    // 🔁 Overridden display method
    @Override
    void display() {
        System.out.println("🏆 Topper Student Details:");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks: " + marks);
        System.out.println("🎉 Congratulations! You are a Topper!");
    }
}

// 🚀 Main class to run the program
public class oops {
    public static void main(String[] args) {
        // 👨‍🎓 Creating Student objects
        Student s1 = new Student("Chandu", 534, 34);
        Student s2 = new Student(1, 2, 3);

        // 🏅 Creating TopperStudent object
        TopperStudent ts1 = new TopperStudent("Chandu", 101, 99.9);

        // 🖨️ Displaying details
        System.out.println(" Student 1:");
        s1.display();
        s1.Collegename("NBKRIST");

        System.out.println("\n Student 2:");
        s2.display();
        s2.Collegename("NBKRIST", 100);

        ts1.display();
    }
}
