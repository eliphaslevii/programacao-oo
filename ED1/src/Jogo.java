import java.util.Random;
import java.util.Scanner;

public class Jogo {

    private Jogador jogador;
    private int numeroSecreto;

    // Construtor do jogo, que recebe um jogador
    public Jogo(Jogador jogador) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        // Gera um número secreto entre 1 e 100
        this.numeroSecreto = rand.nextInt(100) + 1;
        int tentativas = 5; // O jogador tem 5 tentativas

        // Loop do jogo, onde o jogador tenta adivinhar o número secreto
        while (tentativas > 0) {
            // Informa o número de tentativas restantes
            System.out.printf("%s, digite um número entre 1 e 100. Você tem %d tentativas: ", jogador.getNome(), tentativas);

            // O jogador faz a aposta
            int aposta = scanner.nextInt();

            // Se o número não estiver correto
            if (numeroSecreto != aposta) {
                tentativas--; // Subtrai 1 tentativa
                System.out.printf("\nO número %d não está correto.\nAgora você tem %d tentativas...\n", aposta, tentativas);
                comparaNumeros(numeroSecreto, aposta); // Informa se o número secreto é maior ou menor que a aposta
                jogador.setTentativas(jogador.getTentativas() + 1); // Incrementa as tentativas do jogador
            } else {
                // Se o jogador acertou o número
                System.out.printf("Parabéns %s, você acertou!\n", jogador.getNome());
                jogador.setPontos(100 - jogador.getTentativas() * 10); // Calcula a pontuação, considerando as tentativas
                break; // Finaliza o jogo
            }
        }
    }

    // Compara o número secreto com a aposta do jogador e informa se o número secreto é maior ou menor
    public void comparaNumeros(int numeroSecreto, int aposta) {
        if (numeroSecreto > aposta) {
            System.out.printf("\nO número secreto é maior que sua aposta: %d\n", aposta);
        } else if (numeroSecreto < aposta) {
            System.out.printf("\nO número secreto é menor que sua aposta: %d\n", aposta);
        }
    }
}
