public class Jogador {
    // Atributos que guardam as informações do jogador.
    private String nome;  // O nome do jogador.
    private int tentativas;  // O número de tentativas que o jogador fez.
    private int pontos;  // A pontuação do jogador.

    // Getter para o nome do jogador.
    public String getNome() {
        return nome;
    }

    // Getter para o número de tentativas feitas pelo jogador.
    public int getTentativas() {
        return tentativas;
    }

    // Getter para a pontuação do jogador.
    public int getPontos() {
        return pontos;
    }

    // Setter para a pontuação do jogador.
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    // Setter para o nome do jogador.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Setter para o número de tentativas do jogador.
    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }

    // Método que adiciona mais tentativas ao jogador.
    public void incrementarTentativas() {
        this.tentativas++;
    }
}
