class Superclass {
    protected String protectedMember = "Protected Member";
    private String privateMember = "Private Member";

    public void display() {
        System.out.println("Superclass Display");
    }
}

class Subclass extends Superclass {
    public void accessMembers() {
        System.out.println("Accessing: " + protectedMember);
    }
}

public class Prob5 {
    public static void main(String[] args) {
        Subclass subclass = new Subclass();
        subclass.accessMembers();
        subclass.display();
    }
}