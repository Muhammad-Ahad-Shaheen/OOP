class Animal {
    protected String name;
    public Animal(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Animal Name: " + name);
    }
}

class Dog extends Animal {
    private String breed;
    public Dog(String name, String breed) {
        super(name); 
        this.breed = breed;
    }

    public void display() {
        super.display(); 
        System.out.println("Dog Breed: " + breed);
    }
}

public class Prob7 {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", "Golden Retriever");
        dog.display();
    }
}