package LoginSystem;

public class Client extends User implements Authenticable {

    public Client(String login, String password) {
        super(login, password);
    }

    @Override
    public boolean authenticate(String plainTextPassword) {
        boolean isPasswordCorrect = super.verifyPassword(plainTextPassword);

        // Client-specific authentication rule: password length must be > 6
        boolean meetsClientSpecificLength = plainTextPassword != null && plainTextPassword.length() > 6;

        return isPasswordCorrect && meetsClientSpecificLength;
    }

    @Override
    public void performUserAction() {
        System.out.println("Client '" + getLogin() + "' is accessing their account features.");
    }
}