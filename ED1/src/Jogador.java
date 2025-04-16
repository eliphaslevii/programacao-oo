
public class Jogador {
    private String nome;
    private int tentativas;
    private int pontos;

    public String getNome() {
        return nome;
    }
    public int getTentativas() {
        return tentativas;
    }
    public int getPontos() {
        return pontos;
    }
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }

}
