class CommissionEmployee {
    private String name;
    private double sales;

    public CommissionEmployee(String name, double sales) {
        this.name = name;
        this.sales = sales;
    }

    public double earnings() {
        return sales * 0.1;
    }

    public String getName() {
        return name;
    }
}

class BasePlusCommissionEmployee {
    private CommissionEmployee commissionEmployee;
    private double baseSalary;

    public BasePlusCommissionEmployee(String name, double sales, double baseSalary) {
        this.commissionEmployee = new CommissionEmployee(name, sales);
        this.baseSalary = baseSalary;
    }

    public double earnings() {
        return baseSalary + commissionEmployee.earnings();
    }

    public String getName() {
        return commissionEmployee.getName();
    }
}

public class Prob1 {
    public static void main(String[] args) {
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee("Ahad", 1000, 500);
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Total Earnings: " + employee.earnings());
    }
}