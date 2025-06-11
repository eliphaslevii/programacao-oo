package controller; // Declara que esta classe pertence ao pacote 'controller'.
// O pacote 'controller' é a camada intermediária entre a View e o Model,
// responsável por processar as requisições da View e interagir com o Model.

import model.*; // Importa todas as classes do pacote 'model' (ContactSys, Individual, Business).
// O Controller precisa do Model para manipular os dados dos contatos.

import java.util.ArrayList; // Importa ArrayList para criar uma lista dinâmica de contatos.
import java.util.List;      // Importa a interface List, usada para definir o tipo da coleção de contatos.

/**
 * A classe ContactController atua como o intermediário entre a interface do usuário (View)
 * e o modelo de dados (Model). Ela gerencia a lógica de negócio relacionada aos contatos,
 * como adicionar, listar e remover contatos.
 */
public class ContactController {
    // Uma lista privada para armazenar todos os objetos ContactSys (individuais e comerciais).
    // É inicializada como um ArrayList para permitir a adição e remoção dinâmica de elementos.
    private List<Contact> contacts = new ArrayList<>();

    /**
     * Adiciona um novo contato à lista, desde que ele ainda não exista.
     * Esta validação evita a duplicação de contatos com o mesmo CPF ou CNPJ.
     */
    public void addContact(Contact contact) {
        // Verifica se o contato que está sendo adicionado já existe na lista.
        if (!contactExists(contact)) {
            contacts.add(contact); // Se não existir, o contato é adicionado.
        }
    }

    /**
     * Retorna a lista completa de todos os contatos atualmente armazenados.
     * Esta lista é usada pela View para exibir os contatos ao usuário.
     */
    public List<Contact> show() {
        return contacts; // Retorna a referência à lista de contatos.
    }

    /**
     * Remove um contato da lista com base em seu identificador único (CPF ou CNPJ).
     * Itera sobre a lista e remove o primeiro contato encontrado cujo CPF ou CNPJ
     * corresponda ao 'id' fornecido.
     */
    public void delContact(String id) {
        // Usa o método removeIf (Java 8+) para remover elementos da lista de forma concisa.
        // A condição de remoção verifica se o contato é Individual e tem o CPF correspondente,
        // OU se é Business e tem o CNPJ correspondente.
        contacts.removeIf(c ->
                (c instanceof Individual && ((Individual) c).getSocialNumber().equals(id)) ||
                        (c instanceof Business && ((Business) c).getCnpj().equals(id))
        );
    }

    /**
     * Verifica se um determinado contato já existe na lista.
     * A existência é determinada pelo CPF para contatos individuais e pelo CNPJ para contatos comerciais.
     */
    private boolean contactExists(Contact contact) {
        // Itera sobre cada contato já existente na lista.
        for (Contact c : contacts) {
            // Se o contato a ser verificado e o contato existente forem ambos Individuais.
            if (contact instanceof Individual && c instanceof Individual) {
                // Compara os números de identificação social (CPFs).
                if (((Individual) contact).getSocialNumber().equals(((Individual) c).getSocialNumber())) {
                    return true; // Se forem iguais, o contato já existe.
                }
            }
            // Se o contato a ser verificado e o contato existente forem ambos Comerciais.
            else if (contact instanceof Business && c instanceof Business) {
                // Compara os CNPJs.
                if (((Business) contact).getCnpj().equals(((Business) c).getCnpj())) {
                    return true; // Se forem iguais, o contato já existe.
                }
            }
        }
        return false; // Se o loop terminar sem encontrar um contato correspondente, ele não existe.
    }
}