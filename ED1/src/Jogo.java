import java.util.Random;
import java.util.Scanner;

public class Jogo {

    private Jogador jogador;
    private int numeroSecreto;

    public Jogo(Jogador jogador) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        this.numeroSecreto = rand.nextInt(100) + 1;
        int tentativas = 5;


        while (tentativas > 0) {
            System.out.printf("%s Digite um número entre 1 e 100 você tem %d tentativas:",jogador.getNome(),tentativas);

            int aposta = scanner.nextInt();

            if(numeroSecreto != aposta){
                tentativas--;
                System.out.printf("\nO número %d não está correto\n Agora você tem %d tentativas...",aposta,tentativas);
                comparaNumeros(numeroSecreto,aposta);
                jogador.setTentativas(jogador.getTentativas()+1);
            }else{
                System.out.printf("Parabéns %s você acertou",jogador.getNome());
                jogador.setPontos(100 - jogador.getTentativas() * 10);
                break;
            }
        }

    }
    public void comparaNumeros(int numeroSecreto, int aposta){
        if (numeroSecreto > aposta) {
            System.out.printf("\nO numero secreto é maior que sua aposta -> %d\n",aposta);
        } else if (numeroSecreto < aposta) {
            System.out.printf("\nO número secreto é menor que sua aposta -> %d\n",aposta);
        }
    }
}
