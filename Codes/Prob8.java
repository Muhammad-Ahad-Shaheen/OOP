class Employee {
    protected String name;
    protected String socialSecurityNumber;

    public Employee(String name, String socialSecurityNumber) {
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public double earnings() {
        return 0.0; 
    }
}

class CommissionEmployee extends Employee {
    private double sales;

    public CommissionEmployee(String name, String socialSecurityNumber, double sales) {
        super(name, socialSecurityNumber);
        this.sales = sales;
    }

    @Override
    public double earnings() {
        return sales * 0.1;
    }
}

class BasePlusCommissionEmployee extends Employee {
    private double baseSalary;
    private CommissionEmployee commissionEmployee;

    public BasePlusCommissionEmployee(String name, String socialSecurityNumber, double sales, double baseSalary) {
        super(name, socialSecurityNumber);
        this.commissionEmployee = new CommissionEmployee(name, socialSecurityNumber, sales);
        this.baseSalary = baseSalary;
    }

    @Override
    public double earnings() {
        return baseSalary + commissionEmployee.earnings();
    }
}

public class Main {
    public static void main(String[] args) {
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee("Ahad", "123-45-6789", 1000, 500);
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Earnings: " + employee.earnings());
    }
}