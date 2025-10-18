interface Payable {
    double getPaymentAmount();
}

class Employee implements Payable {
    protected String name;
    protected String socialSecurityNumber;

    public Employee(String name, String socialSecurityNumber) {
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @Override
    public double getPaymentAmount() {
        return 0.0;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
}

class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String name, String socialSecurityNumber, double weeklySalary) {
        super(name, socialSecurityNumber);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double getPaymentAmount() {
        return weeklySalary;
    }
}

class HourlyEmployee extends Employee {
    private double hourlyWage;
    private double hoursWorked;

    public HourlyEmployee(String name, String socialSecurityNumber, double hourlyWage, double hoursWorked) {
        super(name, socialSecurityNumber);
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double getPaymentAmount() {
        return hourlyWage * hoursWorked;
    }
}

public class Prob9 {
    public static void main(String[] args) {
        Employee salariedEmployee = new SalariedEmployee("Ahad", "123-45-6789", 800);
        Employee hourlyEmployee = new HourlyEmployee("Shaheen", "987-65-4321", 15, 40);

        System.out.println("Salaried Employee: " + salariedEmployee.getName() + ", Payment: " + salariedEmployee.getPaymentAmount());
        System.out.println("Hourly Employee: " + hourlyEmployee.getName() + ", Payment: " + hourlyEmployee.getPaymentAmount());
    }
}