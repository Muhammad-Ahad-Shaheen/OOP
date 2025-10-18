class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Employee Name: " + name);
    }
}

class Manager extends Employee {
    private String department;

    public Manager(String name, String department) {
        super(name); 
        this.department = department;
    }

    public void manage() {
        System.out.println(name + " is managing the " + department + " department.");
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Department: " + department);
    }
}

public class Prob2 {
    public static void main(String[] args) {
        Manager manager = new Manager("Ahad Shaheen", "Sales");
        manager.display();
        manager.manage();
    }
}