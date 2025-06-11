package view; // Declara que esta classe pertence ao pacote 'view'.
// O pacote 'view' é a camada de apresentação, responsável pela interação com o usuário.

import controller.ContactController; // Importa a classe ContactController do pacote 'controller'.
// A View precisa do Controller para solicitar operações de negócio.
import model.*; // Importa todas as classes do pacote 'model'.
// O 'model' contém as classes de dados e a lógica de negócio (ex: Contact, Individual, Business).

import java.util.List; // Importa a interface List, utilizada para armazenar coleções de objetos (como contatos).
import java.util.Scanner; // Importa a classe Scanner, essencial para ler a entrada do usuário do console.

/**
 * A classe ContactView é a interface do usuário (UI) do aplicativo.
 * Ela é responsável por exibir o menu, solicitar dados ao usuário e mostrar os resultados das operações.
 * A View não contém lógica de negócio; ela delega todas as ações ao ContactController.
 */
public class ContactView {
    private final ContactController controller; // Uma instância do ContactController para delegar as operações.
    // 'final' garante que esta referência seja inicializada apenas uma vez.
    private final Scanner scanner; // Um objeto Scanner para ler a entrada do teclado do usuário.

    /**
     * Construtor da classe ContactView.
     * Inicializa o ContactController e o Scanner quando uma nova instância da View é criada.
     */
    public ContactView() {
        this.controller = new ContactController(); // Cria uma nova instância do controlador.
        this.scanner = new Scanner(System.in); // Configura o scanner para ler da entrada padrão (teclado).
    }

    /**
     * Exibe o menu principal do gerenciador de contatos e gerencia as escolhas do usuário.
     * O menu será exibido repetidamente até que o usuário escolha a opção de sair.
     */
    public void displayMenu() {
        int option; // Variável para armazenar a opção selecionada pelo usuário.
        do { // Inicia um loop 'do-while' para garantir que o menu seja exibido pelo menos uma vez.
            System.out.println("\n===== Contact Manager ====="); // Título do menu.
            System.out.println("1. Add Individual");        // Opção para adicionar um contato individual.
            System.out.println("2. Add Business Contact");  // Opção para adicionar um contato comercial.
            System.out.println("3. List Contacts");         // Opção para listar todos os contatos.
            System.out.println("4. Delete Contact");        // Opção para remover um contato.
            System.out.println("5. Exit");                  // Opção para sair do programa.
            System.out.print("Select an option: ");         // Solicita a entrada do usuário.

            option = scanner.nextInt(); // Lê o número inteiro digitado pelo usuário como a opção.
            scanner.nextLine(); // **Importante:** Limpa o buffer do scanner.
            // `nextInt()` lê apenas o número, deixando a quebra de linha (`\n`) no buffer.
            // `nextLine()` consome essa quebra de linha, evitando que ela interfira em `nextLine()` futuras.

            switch (option) { // Utiliza uma estrutura 'switch' para executar a ação correspondente à opção escolhida.
                case 1 -> addIndividual(); // Chama o método para adicionar um contato individual.
                case 2 -> addBusiness(); // Chama o método para adicionar um contato comercial.
                case 3 -> listContacts(); // Chama o método para listar os contatos existentes.
                case 4 -> removeContact(); // Chama o método para remover um contato.
                case 5 -> System.out.println("Exiting..."); // Mensagem de saída. (Note que no código original estava '0', mas o menu exibe '5' para sair).
                default -> System.out.println("Invalid option."); // Mensagem para opções que não correspondem a nenhuma das listadas.
            }
        } while (option != 5); // O loop continua enquanto a opção não for '5' (Sair).
        // (No código original estava '0', ajustado para '5' para consistência com o menu.)
    }

    /**
     * Coleta as informações necessárias para criar um novo contato do tipo "Individual"
     * e, em seguida, delega a adição desse contato ao ContactController.
     */
    private void addIndividual() {
        System.out.print("Name: "); // Solicita o nome.
        String name = scanner.nextLine(); // Lê o nome.
        System.out.print("Surname: "); // Solicita o sobrenome.
        String surname = scanner.nextLine(); // Lê o sobrenome.
        System.out.print("Phone: "); // Solicita o telefone.
        String phone = scanner.nextLine(); // Lê o telefone.
        System.out.print("Email: "); // Solicita o e-mail.
        String email = scanner.nextLine(); // Lê o e-mail.
        System.out.print("Social Number (CPF, 11 digits): "); // Solicita o CPF.
        String socialNumber = scanner.nextLine(); // Lê o CPF.

        // Cria um novo objeto Individual com os dados fornecidos pelo usuário.
        Individual individual = new Individual(name, surname, phone, email, socialNumber);
        controller.addContact(individual); // Chama o método `addContact` do controller para persistir o contato.
        System.out.println("Individual added."); // Confirma ao usuário que o contato foi adicionado.
    }

    /**
     * Coleta as informações necessárias para criar um novo contato do tipo "Business" (Empresa)
     * e, em seguida, delega a adição desse contato ao ContactController.
     */
    private void addBusiness() {
        System.out.print("Company Name: "); // Solicita o nome da empresa.
        String name = scanner.nextLine(); // Lê o nome da empresa.
        System.out.print("Responsible Person: "); // Solicita o nome da pessoa de contato responsável.
        String surname = scanner.nextLine(); // Lê o nome da pessoa responsável (usando 'surname' do modelo base).
        System.out.print("Phone: "); // Solicita o telefone comercial.
        String phone = scanner.nextLine(); // Lê o telefone comercial.
        System.out.print("Email: "); // Solicita o e-mail comercial.
        String email = scanner.nextLine(); // Lê o e-mail comercial.
        System.out.print("CNPJ (14 digits): "); // Solicita o CNPJ.
        String cnpj = scanner.nextLine(); // Lê o CNPJ.

        // Cria um novo objeto Business com os dados fornecidos pelo usuário.
        Business business = new Business(name, surname, phone, email, cnpj);
        controller.addContact(business); // Chama o método `addContact` do controller para persistir o contato.
        System.out.println("Business contact added."); // Confirma ao usuário que o contato comercial foi adicionado.
    }

    /**
     * Solicita ao ContactController a lista de todos os contatos cadastrados
     * e os exibe no console. Se não houver contatos, uma mensagem apropriada é mostrada.
     */
    private void listContacts() {
        List<Contact> contacts = controller.show(); // Obtém a lista de contatos do controller.

        if (contacts.isEmpty()) { // Verifica se a lista de contatos está vazia.
            System.out.println("No contacts available."); // Mensagem se não houver contatos.
        } else {
            for (Contact c : contacts) { // Itera sobre cada contato na lista.
                System.out.println("\n----------------------"); // Linha separadora para melhorar a leitura.
                System.out.println(c); // Imprime a representação em String do objeto Contact.
                // Isso pressupõe que as classes Contact, Individual e Business
                // tenham um método `toString()` bem implementado.
            }
        }
    }

    /**
     * Solicita ao usuário o identificador (CPF para Individual ou CNPJ para Business)
     * do contato a ser removido e delega essa operação ao ContactController.
     */
    private void removeContact() {
        System.out.print("Enter CPF or CNPJ of contact to remove: "); // Solicita o identificador único.
        String id = scanner.nextLine(); // Lê o CPF ou CNPJ digitado pelo usuário.

        controller.delContact(id); // Chama o método `delContact` do controller para realizar a remoção.
        System.out.println("Contact removed (if existed)."); // Mensagem de confirmação.
        // A lógica para verificar se o contato realmente existia
        // e foi removido com sucesso geralmente está no controller ou na camada de repositório.
    }
}