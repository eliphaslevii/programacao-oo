package FoPag;

public abstract class Employee {
    protected String name;
    protected double salary;
    protected String designation;

    public Employee(String name, double salary, String designation) {
        this.name = name;
        this.salary = salary;
        this.designation = designation;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Designation: " + designation);
    }

    public double getSalary() {
        return salary;
    }

    public abstract double calculateSalary();
}
