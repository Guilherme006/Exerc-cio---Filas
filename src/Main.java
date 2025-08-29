import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe o tamanho da fila (capacidade maior que zero): ");
        int tamanhoFila = leitor.nextInt();
        while (tamanhoFila <= 0) {
            System.out.print("Valor inválido. Informe novamente um tamanho maior que zero: ");
            tamanhoFila = leitor.nextInt();
        }

        FilaCircular fila = new FilaCircular(tamanhoFila);

        int opcaoEscolhida = -1;
        while (opcaoEscolhida != 0) {
            System.out.println();
            System.out.println("===== MENU FILA CIRCULAR =====");
            System.out.println("1 - Inserir elemento");
            System.out.println("2 - Remover elemento");
            System.out.println("3 - Imprimir fila");
            System.out.println("4 - Verificar se está cheia");
            System.out.println("5 - Verificar se está vazia");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcaoEscolhida = leitor.nextInt();

            if (opcaoEscolhida == 1) {
                System.out.print("Informe o valor inteiro a ser inserido: ");
                int valorParaInserir = leitor.nextInt();
                boolean foiInserido = fila.insere(valorParaInserir);
                if (foiInserido) {
                    System.out.println("Elemento inserido: " + valorParaInserir);
                } else {
                    System.out.println("Não foi possível inserir. A fila está cheia.");
                }

            } else if (opcaoEscolhida == 2) {
                if (fila.vazia()) {
                    System.out.println("Não há o que remover. A fila está vazia.");
                } else {
                    int elementoRemovido = fila.remove();
                    System.out.println("Elemento removido: " + elementoRemovido);
                }

            } else if (opcaoEscolhida == 3) {
                fila.imprime();

            } else if (opcaoEscolhida == 4) {
                if (fila.cheia()) {
                    System.out.println("A fila está cheia.");
                } else {
                    System.out.println("A fila NÃO está cheia.");
                }

            } else if (opcaoEscolhida == 5) {
                if (fila.vazia()) {
                    System.out.println("A fila está vazia.");
                } else {
                    System.out.println("A fila NÃO está vazia.");
                }

            } else if (opcaoEscolhida == 0) {
                System.out.println("Encerrando o programa...");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        leitor.close();
    }
}