package LoginSystem;

public abstract class User {
    protected String login;
    protected String passwordHash;

    public User(String login, String password) {
        if (login == null || login.trim().isEmpty()) {
            throw new IllegalArgumentException("Login cannot be null or empty.");
        }
        if (login.length() < 3) {
            throw new IllegalArgumentException("Login must be at least 3 characters long.");
        }
        this.login = login.trim();

        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty.");
        }
        this.passwordHash = hashPassword(password);
    }

    public String getLogin() {
        return login;
    }

    // New method added to User for subclasses to change password securely
    protected void setPassword(String newPlainTextPassword) {
        if (newPlainTextPassword == null || newPlainTextPassword.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty.");
        }
        this.passwordHash = hashPassword(newPlainTextPassword);
    }

    public boolean verifyPassword(String plainTextPassword) {
        if (plainTextPassword == null) {
            return false;
        }
        return this.passwordHash.equals(hashPassword(plainTextPassword));
    }

    public abstract void performUserAction();

    private String hashPassword(String plainTextPassword) {
        return "hashed_" + plainTextPassword;
    }

    @Override
    public String toString() {
        return "User [Login: " + login + "]";
    }
}