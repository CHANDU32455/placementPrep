class Student{
    private String name;
    public void setName(String n){
        this.name = n;
    }
    public String getname(){
        return this.name;
    }
}

class encapsulation{
    public static void main(String[] args) {
        Student s = new Student();
        s.getname();
        s.setName("chandu");
        System.out.println("name: "+s.getname());
    }
}