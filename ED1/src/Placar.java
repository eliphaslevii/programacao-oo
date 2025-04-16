import java.util.ArrayList;

public class Placar {
    private ArrayList<Jogador> ranking;

    public Placar() {
        ranking = new ArrayList<>();
    }

    void adicionarJogador(Jogador j) {
        ranking.add(j);
    }

    void mostrarRanking() {
        ArrayList<Jogador> buffer = new ArrayList<>(ranking);

        buffer.sort((j1,j2)-> Integer.compare(j1.getPontos(), j2.getPontos()));

        System.out.println("\n Ranking de jogadores");
        for (Jogador j : ranking) {
            System.out.printf("%s - %d%n", j.getNome(), j.getPontos());
        }
    }
}
