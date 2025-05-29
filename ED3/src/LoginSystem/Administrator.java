package LoginSystem;

public class Administrator extends User implements Authenticable, Manageable, Loggable {

    public Administrator(String login, String password) {
        super(login, password);
    }

    @Override
    public boolean authenticate(String plainTextPassword) {
        return super.verifyPassword(plainTextPassword);
    }

    // REMOVE THE @Override ANNOTATION HERE
    public void changePassword(String newPassword) {
        // Delegates password update to the User superclass's secure setPassword method.
        super.setPassword(newPassword);
        System.out.println("Password changed successfully for user: " + this.getLogin());
        logOperation("Password change initiated by " + this.getLogin());
    }

    @Override
    public void manageUserAccount(String targetUserLogin, ManagementAction action) {
        System.out.println("Administrator '" + this.getLogin() + "' performing action '" + action + "' on user: " + targetUserLogin);
        logOperation("Administrator " + this.getLogin() + " performed " + action + " on user " + targetUserLogin);

        // Example logic (placeholder):
        if (action == ManagementAction.BLOCK) {
            System.out.println("User '" + targetUserLogin + "' blocked successfully.");
        } else if (action == ManagementAction.UNBLOCK) {
            System.out.println("User '" + targetUserLogin + "' unblocked successfully.");
        } else if (action == ManagementAction.RESET_PASSWORD) {
            System.out.println("Password for user '" + targetUserLogin + "' reset successfully (requires new password assignment logic).");
        }
    }

    @Override
    public void logOperation(String operationDescription) {
        System.out.println("[LOG] " + this.getLogin() + " - " + operationDescription);
    }

    @Override
    public void performUserAction() {
        System.out.println("Administrator " + getLogin() + " is performing administrative duties.");
    }
}