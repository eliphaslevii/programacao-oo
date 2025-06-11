package model; // Declara que esta classe pertence ao pacote 'model'.
// O pacote 'model' é a camada que representa os dados e a lógica de negócio do aplicativo.

// A classe Individual herda de ContactSys, o que significa que um Individual
// é um tipo específico de ContactSys e, portanto, herda seus atributos e métodos.
public class Individual extends ContactSys {
    // Atributo específico para contatos individuais: o número de identificação social (CPF no Brasil).
    private String socialNumber;

    /**
     * Construtor para criar uma nova instância de Individual.
     */
    public Individual(String name, String surname, String phoneNumber, String email, String socialNumber) {
        // Chama o construtor da classe pai (ContactSys) para inicializar os atributos comuns a todos os contatos.
        super(name, surname, phoneNumber, email);
        // Realiza uma validação básica para o número social.
        // Verifica se o 'socialNumber' não é nulo e se corresponde a exatamente 11 dígitos numéricos.
        if (socialNumber != null && socialNumber.matches("\\d{11}")) {
            this.socialNumber = socialNumber; // Atribui o número social se a validação passar.
        } else {
            // Nota: Se a validação falhar aqui, 'socialNumber' permanecerá nulo ou o valor padrão,
            // dependendo de como ContactSys lida com seus atributos e se há um valor inicial.
            // Para um tratamento mais robusto, seria ideal lançar uma exceção ou definir um valor padrão claro.
        }
    }

    /**
     * Retorna o número de identificação social (CPF) do contato individual.
     */
    public String getSocialNumber() {
        return socialNumber;
    }

    /**
     * Define o número de identificação social (CPF) do contato individual.
     * Realiza uma validação para garantir que o número social seja válido (11 dígitos numéricos).
     */
    public void setSocialNumber(String socialNumber) {
        // Valida o novo 'socialNumber' antes de atribuí-lo.
        // Isso garante que o atributo socialNumber sempre mantenha um formato válido.
        if (socialNumber != null && socialNumber.matches("\\d{11}")) {
            this.socialNumber = socialNumber;
        } else {
            // Poderia adicionar um log de erro, lançar uma exceção ou notificar de alguma forma
            // que a tentativa de definir um número social inválido falhou.
            System.err.println("Aviso: Tentativa de definir um número social inválido.");
        }
    }

    /**
     * Sobrescreve o método toString() para fornecer uma representação textual significativa
     * de um objeto Individual. Isso é útil para depuração e para exibir informações no console.
     */
    public String toString() {
        // Constrói a string de saída usando os getters da classe pai (para nome, telefone, email)
        // e o atributo socialNumber desta própria classe.
        return "Name: " + getName() +
                "\nSocial Number: " + (socialNumber != null ? socialNumber : "N/A") + // Adicionado tratamento para socialNumber nulo
                "\nPhone: " + getPhoneNumber() +
                "\nEmail: " + getEmail();
    }
}