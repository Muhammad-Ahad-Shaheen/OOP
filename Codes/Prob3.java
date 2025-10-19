class Student {
    protected String name;
    protected String studentId;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + studentId);
    }
}

class UndergraduateStudent extends Student {
    private String major;

    public UndergraduateStudent(String name, String studentId, String major) {
        super(name, studentId);
        this.major = major;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Major: " + major);
    }
}

class GraduateStudent extends Student {
    private String thesisTitle;

    public GraduateStudent(String name, String studentId, String thesisTitle) {
        super(name, studentId);
        this.thesisTitle = thesisTitle;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Thesis Title: " + thesisTitle);
    }
}

public class Prob3 {
    public static void main(String[] args) {
        UndergraduateStudent undergrad = new UndergraduateStudent("Ahad", "U12345", "Computer Science");
        GraduateStudent grad = new GraduateStudent("Shaheen", "G67890", "Artificial Intelligence");

        System.out.println("Undergraduate Student:");
        undergrad.display();
        System.out.println();

        System.out.println("Graduate Student:");
        grad.display();
    }
}