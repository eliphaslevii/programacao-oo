import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Placar placar = new Placar();

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        Jogador jogador = new Jogador();
        jogador.setNome(nome);

        Jogo jogo = new Jogo(jogador);

        placar.adicionarJogador(jogador);

        placar.mostrarRanking();
    }
}
