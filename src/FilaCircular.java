public class FilaCircular {
    private int[] elementos;
    private int capacidade;
    private int quantidadeElementos;
    private int posicaoInicio;
    private int posicaoFim;

    public FilaCircular(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.quantidadeElementos = 0;
        this.posicaoInicio = 0;
        this.posicaoFim = -1;
    }

    public boolean cheia() {
        return quantidadeElementos == capacidade;
    }

    public boolean vazia() {
        return quantidadeElementos == 0;
    }

    public boolean insere(int elemento) {
        if (cheia()) {
            return false;
        }
        posicaoFim = (posicaoFim + 1) % capacidade;
        elementos[posicaoFim] = elemento;
        quantidadeElementos = quantidadeElementos + 1;
        return true;
    }

    public int remove() {
        int elementoRemovido = elementos[posicaoInicio];
        posicaoInicio = (posicaoInicio + 1) % capacidade;
        quantidadeElementos = quantidadeElementos - 1;
        return elementoRemovido;
    }

    public void imprime() {
        if (vazia()) {
            System.out.println("Fila vazia.");
            return;
        }

        System.out.print("Fila (do primeiro ao último): ");
        int contador = 0;
        while (contador < quantidadeElementos) {
            int indice = (posicaoInicio + contador) % capacidade;
            System.out.print(elementos[indice]);
            if (contador < quantidadeElementos - 1) {
                System.out.print(" ");
            }
            contador = contador + 1;
        }
        System.out.println();
    }
}
