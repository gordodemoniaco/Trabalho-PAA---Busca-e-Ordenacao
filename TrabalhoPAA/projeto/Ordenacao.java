package projeto;

public class Ordenacao {
    public static final String selection = "SelectionSort";
    public static final String insertion = "InsertionSort";
    public static final String bubble = "BubbleSort";
    public static final String merge = "MergeSort";
    public static final String quick = "QuickSort";

    public static String printOpOrdenacao(int opOrdenacao) {
        String tipo_ordenacao = new String();
        switch (opOrdenacao) {
            case 1:
                tipo_ordenacao = selection;
                break;
            case 2:
                tipo_ordenacao = insertion;
                break;
            case 3:
                tipo_ordenacao = bubble;
                break;
            case 4:
                tipo_ordenacao = merge;
                break;
            case 5:
                tipo_ordenacao = quick;
                break;
            default:
                tipo_ordenacao = "Opção Inválida!";
                break;
        }
        return tipo_ordenacao;
    }

    public static long ordenaSelection(int[] vetor, int n) { // SelectionSort
        AuxiliarVetor.wait(1); // tempo de espera padrao
        long tempo = System.currentTimeMillis();
        // Algoritmo comeca aqui

        // Fim do Algoritmo
        tempo = System.currentTimeMillis() - tempo; // contabilizaçao do tempo
        return tempo;
    }

    public static long ordenaInsertion(int[] vetor, int n) { // InsertionSort
        AuxiliarVetor.wait(1); // tempo de espera padrao
        long tempo = System.currentTimeMillis(); // inicializa contabilizaçao do tempo
        // Algoritmo comeca aqui

        // Fim do Algoritmo
        tempo = System.currentTimeMillis() - tempo; // contabilizaçao do tempo
        return tempo;
    }

    public static long ordenaBubble(int[] vetor, int n) { // BubbleSort
        AuxiliarVetor.wait(1); // tempo de espera padrao
        long tempo = System.currentTimeMillis(); // inicializa contabilizaçao do tempo
        // Algoritmo comeca aqui
        int x = n;
        for (int i = 0; i < n; i++) {
            for (int k = 1; k < x; k++) {
                int aux = vetor[k - 1];
                if (aux > vetor[k]) {
                    vetor[k - 1] = vetor[k];
                    vetor[k] = aux;
                }
            }
            x--;
        }
        // Fim do Algoritmo
        tempo = System.currentTimeMillis() - tempo; // contabilizaçao do tempo
        if (!verificaOrdenacao(vetor, n)) { // se a ordenaçao do vetor estiver errada, sai do programa com erro
            System.err.println("Erro de ordenacao");
            System.exit(1);
        }
        System.out.println(bubble + " | Ordenação OK!"); // Impressão de verificaçao
        return tempo;
    }

    public static long ordenaMerge(int[] vetor, int n) { // MergeSort
        AuxiliarVetor.wait(1); // tempo de espera padrao
        long tempo = System.currentTimeMillis(); // inicializa contabilizaçao do tempo
        // Algoritmo comeca aqui

        // Fim do Algoritmo
        tempo = System.currentTimeMillis() - tempo; // contabilizaçao do tempo
        return tempo;

    }

    public static long ordenaQuick(int[] vetor, int n) { // QuickSort
        AuxiliarVetor.wait(1); // tempo de espera padrao
        long tempo = System.currentTimeMillis(); // inicializa contabilizaçao do tempo
        // Algoritmo comeca aqui

        // Fim do Algoritmo
        tempo = System.currentTimeMillis() - tempo; // contabilizaçao do tempo
        return tempo;
    }

    public static boolean verificaOrdenacao(int[] vetor, int n) { // verifica a ordenaçao do vetor
        boolean teste = false; // condicao inicial

        for (int i = 1; i < n; i++) { // looping de verificacao
            teste = (vetor[i - 1] <= vetor[i]); // confere se a esta em ordem crescente
            if (!teste) // se nao ordenado, quebra o laço
                break;
        }
        return teste; // retorno da funcao (true = ordenado; false = erro de ordenaçao)
    }
}
