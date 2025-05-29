package FoPag;

public class TemporaryEmployee extends Employee {

    public TemporaryEmployee(String name, double salary,String designation) {
        super(name, salary, designation);
    }

    @Override
    public double calculateSalary() {
        return salary - 170.5;
    }
}
