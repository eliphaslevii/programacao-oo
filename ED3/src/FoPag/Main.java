package FoPag;

public class Main {
    public static void main(String[] args) {
        Employee cltEmployee = new CltEmployee("Tito", 2250.55,"Desentortador de vidro  ");
        Employee tempEmployee = new TemporaryEmployee("Amadeo", 2000.0,"Trocador de rodapé");
        Employee cltEmployee2 = new CltEmployee("Beto Abelha", 2230.55,"Pastor mirim");
        Employee tempEmployee2 = new TemporaryEmployee("Tomas Turbina", 50230.55,"Médico de ovelhas");

        System.out.println("CLT FoPag.Employee:");
        cltEmployee.display();
        System.out.println("Final Salary: $" + cltEmployee.calculateSalary());
        System.out.println();

        System.out.println("Temporary FoPag.Employee:");
        tempEmployee.display();
        System.out.println("Final Salary: $" + tempEmployee.calculateSalary());

        System.out.println();
        System.out.println("Clt Employee2:");
        cltEmployee2.display();
        System.out.println("Final Salary: $" + cltEmployee2.calculateSalary());

        System.out.println();
        System.out.println("Temporary Employee2:");
        tempEmployee2.display();
        System.out.println("Final Salary: $" + tempEmployee2.calculateSalary());

    }
}
