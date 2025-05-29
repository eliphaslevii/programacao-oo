package LoginSystem;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Inicializando o Sistema de Login ---");

        // Creating instances of our users
        Administrator admin = new Administrator("superAdmin", "adminPassSecure!1");
        Visitor guest = new Visitor("guestViewer", "noPasswordNeeded");
        Client joao = new Client("joaoSilva", "clientSecureP@ss");

        System.out.println("\n--- Testando Administrador ---");
        System.out.println(admin);
        System.out.println("Autenticação de 'adminPassSecure!1': " + admin.authenticate("adminPassSecure!1"));
        System.out.println("Autenticação com 'senhaErrada': " + admin.authenticate("senhaErrada"));
        admin.performUserAction();

        try {
            admin.changePassword("superNovaSenha@2025");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao trocar senha do Admin: " + e.getMessage());
        }

        admin.manageUserAccount(joao.getLogin(), ManagementAction.BLOCK);
        admin.manageUserAccount("outroUser", ManagementAction.RESET_PASSWORD);
        admin.logOperation("Revisão de logs do sistema.");

        System.out.println("\n--- Testando Visitante ---");
        System.out.println(guest);
        guest.performUserAction();

        // Visitor authentication
        System.out.println("Autenticação de visitante com 'noPasswordNeeded': " + guest.authenticate("noPasswordNeeded"));
        System.out.println("Autenticação de visitante com 'outraSenha': " + guest.authenticate("outraSenha"));

        System.out.println("\n--- Testando Cliente ---");
        System.out.println(joao);
        joao.performUserAction();

        System.out.println("Autenticação de 'clientSecureP@ss': " + joao.authenticate("clientSecureP@ss"));
        System.out.println("Autenticação com '12345': " + joao.authenticate("12345"));
        System.out.println("Autenticação com 'short': " + joao.authenticate("short")); // Fails due to client-specific length rule

        System.out.println("\n--- Testando Criação de Usuários Inválidos (Exceções Esperadas) ---");
        try {
            new Administrator(null, "pass");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar Admin: " + e.getMessage());
        }

        try {
            new Client("user", "");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar Cliente: " + e.getMessage());
        }

        System.out.println("\n--- Fim da Execução do Programa ---");
    }
}