package FoPag;

public class CltEmployee extends Employee {
    public CltEmployee(String name,double salary,String designation) {
        super(name,salary,designation);
    }
    @Override
    public double calculateSalary() {
        return salary + 6805;
    }
}
