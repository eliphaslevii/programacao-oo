package LoginSystem;

public class Visitor extends User implements Authenticable { // <-- Now correctly implements Authenticable

    public Visitor(String login, String password) {
        super(login, password);
    }

    @Override
    public void performUserAction() {
        System.out.println("Visitante '" + getLogin() + "' está navegando em áreas públicas do sistema.");
    }

    @Override // Implementation for Authenticable
    public boolean authenticate(String plainTextPassword) {
        // Visitors also use the secure password verification from User
        return super.verifyPassword(plainTextPassword);
    }
}