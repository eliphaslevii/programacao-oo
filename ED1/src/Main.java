import java.util.Scanner;

public class Main {

    /**
     * Aqui é onde tudo acontece!
     * Pede o nome do jogador, começa o jogo e no final mostra o ranking.
     */
    public static void main(String[] args) {
        // Scanner para pegar a entrada do teclado.
        Scanner input = new Scanner(System.in);

        // Criando o placar que vai guardar o ranking da galera.
        Placar placar = new Placar();

        // Pedindo o nome do jogador.
        System.out.print("Qual o seu nome, guerreiro? ");
        String nomeJogador = input.nextLine();  // Pegando o nome do jogador.

        // Criando o jogador e colocando o nome que ele passou.
        Jogador jogador = new Jogador();
        jogador.setNome(nomeJogador);  // Atribuindo o nome do jogador.

        // Criando o jogo e passando o jogador como parâmetro.
        // Aqui começa a diversão, com o jogo pedindo para adivinhar o número.
        Jogo jogo = new Jogo(jogador);

        // Colocando o jogador no placar depois que ele joga.
        placar.adicionarJogador(jogador);

        // Mostrando o ranking da galera depois do jogo.
        placar.mostrarRanking();
    }
}
