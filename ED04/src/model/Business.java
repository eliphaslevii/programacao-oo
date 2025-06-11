package model; // Declara que esta classe pertence ao pacote 'model'.
// O pacote 'model' é a camada do seu aplicativo que lida com a representação dos dados e a lógica de negócio.

/**
 * Representa um contato comercial (pessoa jurídica).
 * Esta classe estende 'ContactSys', o que significa que um 'Business' é um tipo específico de 'ContactSys'
 * e herda seus atributos e comportamentos básicos, como nome, telefone e email.
 */
public class Business extends ContactSys {
    // Atributo específico para contatos comerciais: o Cadastro Nacional da Pessoa Jurídica (CNPJ).
    private String cnpj;

    /**
     * Construtor para criar uma nova instância de um contato comercial.
     * Ele inicializa os atributos herdados da classe pai 'ContactSys' e define o CNPJ.
     */
    public Business(String name, String surname, String phoneNumber, String email, String cnpj) {
        // Chama o construtor da classe pai (ContactSys) para inicializar os atributos comuns,
        // como o nome da empresa (neste contexto, 'name'), a pessoa de contato ('surname'),
        // telefone e email.
        super(name, surname, phoneNumber, email);
        // Realiza uma validação básica para o CNPJ.
        // Verifica se o 'cnpj' não é nulo e se consiste em exatamente 14 dígitos numéricos.
        if (cnpj != null && cnpj.matches("\\d{14}")) {
            this.cnpj = cnpj; // Se a validação for bem-sucedida, o CNPJ é atribuído.
        } else {
            // Caso o CNPJ fornecido seja inválido, ele não será atribuído ou permanecerá nulo.
            // Para um sistema mais robusto, aqui seria ideal lançar uma exceção
            // ou registrar um aviso para indicar que o CNPJ é inválido.
        }
    }

    /**
     * Retorna o CNPJ (Cadastro Nacional da Pessoa Jurídica) do contato comercial.
     *
     * @return O CNPJ como uma String.
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Define o CNPJ do contato comercial.
     * Inclui uma validação para garantir que o CNPJ fornecido tenha o formato correto (14 dígitos numéricos).
     *
     * @param cnpj O novo CNPJ a ser definido.
     */
    public void setCnpj(String cnpj) {
        // Valida o novo valor do 'cnpj' antes de atribuí-lo.
        // Isso ajuda a manter a integridade dos dados, garantindo que o CNPJ tenha o formato esperado.
        if (cnpj != null && cnpj.matches("\\d{14}")) {
            this.cnpj = cnpj;
        } else {
            // Se o CNPJ for inválido, uma mensagem de erro é impressa no console de erro.
            // Em aplicações maiores, isso poderia ser substituído por um sistema de logging.
            System.err.println("Aviso: Tentativa de definir um CNPJ inválido.");
        }
    }

    /**
     * Sobrescreve o método `toString()` padrão para fornecer uma representação textual clara e legível
     * de um objeto 'Business'. Isso é muito útil para depuração e para exibir informações do contato
     * no console de forma formatada.
     *
     * @return Uma String formatada contendo o nome da empresa, CNPJ, telefone e email.
     */
    @Override // Esta anotação indica que o método está sobrescrevendo um método da classe pai (Object, via ContactSys).
    public String toString() {
        // Constrói a string de saída usando os métodos 'getName()', 'getPhoneNumber()' e 'getEmail()'
        // da classe pai 'ContactSys', e o atributo 'cnpj' desta própria classe.
        return "Company: " + getName() +
                "\nCNPJ: " + (cnpj != null ? cnpj : "N/A") + // Inclui um tratamento para CNPJ nulo, exibindo "N/A" se for o caso.
                "\nPhone: " + getPhoneNumber() +
                "\nEmail: " + getEmail();
    }
}