import java.util.ArrayList;

public class Placar {
    // Lista para armazenar os jogadores e suas pontuações.
    private ArrayList<Jogador> ranking;

    // Construtor que inicializa a lista de ranking.
    public Placar() {
        ranking = new ArrayList<>();
    }

    // Método para adicionar um jogador ao ranking.
    void adicionarJogador(Jogador j) {
        ranking.add(j);
    }

    // Método que exibe o ranking dos jogadores ordenado por pontos.
    void mostrarRanking() {
        // Cria uma cópia da lista de ranking para não alterar a original
        ArrayList<Jogador> buffer = new ArrayList<>(ranking);

        // Ordena os jogadores pelo número de pontos, do menor para o maior.
        buffer.sort((j1, j2) -> Integer.compare(j2.getPontos(), j1.getPontos()));

        // Exibe o ranking na tela.
        System.out.println("\n Ranking de jogadores:");
        for (Jogador j : buffer) {
            // Exibe o nome do jogador e sua pontuação.
            System.out.printf("%s - %d pontos%n", j.getNome(), j.getPontos());
        }
    }
}
