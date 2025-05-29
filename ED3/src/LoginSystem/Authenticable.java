package LoginSystem;

public interface Authenticable {
    boolean authenticate(String plainTextPassword);
}