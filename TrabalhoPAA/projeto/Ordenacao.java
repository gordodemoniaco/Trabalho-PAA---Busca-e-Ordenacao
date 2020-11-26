package projeto;

public class Ordenacao {
    public static final String selection = "SelectionSort";
    public static final String insertion = "InsertionSort";
    public static final String bubble = "BubbleSort";
    public static final String merge = "MergeSort";
    public static final String quick = "QuickSort";
    public static final String erroOrdenacao = "Erro de Ordenação :";
    public static final String okOrdenacao = "Ordenação Verificada!";

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
        AuxiliarVetor.wait(10); // tempo de espera padrao
        long tempo = System.currentTimeMillis(); // inicializa contabilizaçao do tempo
        // Algoritmo comeca aqui
        for (int i = 0; i < n - 1; i++) {
            int k = i;
            for (int j = i + 1; j < n; j++) {
                if (vetor[j] < vetor[k]) {
                    k = j;
                }
            }
            int menorNumero = vetor[k];
            vetor[k] = vetor[i];
            vetor[i] = menorNumero;
        }
        // Fim do Algoritmo
        AuxiliarVetor.wait(10); // tempo de espera padrao
        tempo = System.currentTimeMillis() - tempo; // contabilizaçao do tempo
        // Verificação da Ordenação
        if (!verificaOrdenacao(vetor, n)) {
            System.err.println(erroOrdenacao + selection);
            System.exit(1);
        }
        System.out.println(selection + " | " + okOrdenacao);
        // Fim da verificaçao
        AuxiliarVetor.wait(1); // tempo de espera padrao
        return tempo;
    }

    public static long ordenaInsertion(int[] vetor, int n) { // InsertionSort
        AuxiliarVetor.wait(10); // tempo de espera padrao
        long tempo = System.currentTimeMillis(); // inicializa contabilizaçao do tempo
        // Algoritmo comeca aqui
        for (int i = 1; i < n; i++) {
            int k = vetor[i];
            int j = i-1;
            while ((j >= 0) && (vetor[j] > k)) {
                vetor[j+1] = vetor[j];
                j--;
            }
            vetor[j+1] = k;
        }
        // Fim do Algoritmo
        AuxiliarVetor.wait(10); // tempo de espera padrao
        tempo = System.currentTimeMillis() - tempo; // contabilizaçao do tempo
        // Verificação da Ordenação
        if (!verificaOrdenacao(vetor, n)) {
            System.err.println(erroOrdenacao + insertion);
            System.exit(1);
        }
        System.out.println(insertion + " | " + okOrdenacao);
        // Fim da verificaçao
        return tempo;
    }

    public static long ordenaBubble(int[] vetor, int n) { // BubbleSort
        AuxiliarVetor.wait(10); // tempo de espera padrao
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
        AuxiliarVetor.wait(10); // tempo de espera padrao
        tempo = System.currentTimeMillis() - tempo; // contabilizaçao do tempo
        // Verificação da Ordenação
        if (!verificaOrdenacao(vetor, n)) {
            System.err.println(erroOrdenacao + bubble);
            System.exit(1);
        }
        System.out.println(bubble + " | " + okOrdenacao);
        // Fim da verificaçao
        AuxiliarVetor.wait(1); // tempo de espera padrao
        return tempo;
    }

    public static long ordenaMerge(int[] vetor, int n) { // MergeSort
        AuxiliarVetor.wait(10); // tempo de espera padrao
        long tempo = System.currentTimeMillis(); // inicializa contabilizaçao do tempo
        // Algoritmo comeca aqui
        vetor = recursivoMerge(vetor, 0, n-1);
        // Fim do Algoritmo
        AuxiliarVetor.wait(10); // tempo de espera padrao
        tempo = System.currentTimeMillis() - tempo; // contabilizaçao do tempo
        // Verificação da Ordenação
        if (!verificaOrdenacao(vetor, n)) {
            System.err.println(erroOrdenacao + merge);
            System.exit(1);
        }
        System.out.println(merge + " | " + okOrdenacao);
        // Fim da verificaçao
        return tempo;

    }
    private static int[] recursivoMerge(int[] vetor, int inicio, int fim){
        if(inicio <fim){
            int meio = (inicio+fim)/2;
            
            vetor = recursivoMerge(vetor, inicio, meio);
            vetor = recursivoMerge(vetor, meio+1, fim);

            mesclar(vetor, inicio, meio, fim);
        }
        return vetor;
    }
    private static void mesclar(int[] vetor, int inicio, int meio, int fim){
        int[] auxiliar = new int[vetor.length];

        for(int i=inicio; i<=fim; i++){
            auxiliar[i] = vetor[i];
        }
        int i=inicio;
        int j=meio+1;

        for(int k=inicio; k<=fim; k++){
            if(i>meio){
                vetor[k] = auxiliar[j++];
            }
            else if(j>fim){
                vetor[k] = auxiliar[i++];
            }
            else if(auxiliar[i]<auxiliar[j]){
                vetor[k] = auxiliar[i++];
            }
            else{
                vetor[k] = auxiliar[j++];
            }
        }
    }
    public static long ordenaQuick(int[] vetor, int n) { // QuickSort
        AuxiliarVetor.wait(10); // tempo de espera padrao
        long tempo = System.currentTimeMillis(); // inicializa contabilizaçao do tempo
        // Algoritmo comeca aqui
        vetor = recursivoQuick(vetor, 0, n-1);

        // Fim do Algoritmo
        AuxiliarVetor.wait(10); // tempo de espera padrao
        tempo = System.currentTimeMillis() - tempo; // contabilizaçao do tempo
        // Verificação da Ordenação
        if (!verificaOrdenacao(vetor, n)) {
            System.err.println(erroOrdenacao + quick);
            System.exit(1);
        }
        System.out.println(quick + " | " + okOrdenacao);
        // Fim da verificaçao
        AuxiliarVetor.wait(1); // tempo de espera padrao
        return tempo;
    }
    private static int[] recursivoQuick(int[] vetor, int inicio, int fim){
        if (fim>inicio){
            int x = separarQuick(vetor, inicio, fim);
            vetor = recursivoQuick(vetor, inicio, x-1);
            vetor = recursivoQuick(vetor, x+1, fim);
        }
        return vetor;
    }
    private static int separarQuick(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1;
        int f = fim;

        while (i <= f) {
            if (vetor[i] <= pivo) {
                i++;
            } else if (pivo < vetor[f]) {
                f--;
            } else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }

    public static boolean verificaOrdenacao(int[] vetor, int n) { // verifica a ordenaçao do vetor
        boolean teste = false; // condicao inicial

        for (int i = 1; i < n; i++) { // looping de verificacao
            teste = (vetor[i - 1] < vetor[i]); // confere se a esta em ordem crescente
            if (!teste) // se nao ordenado, quebra o laço
                break;
        }
        return teste; // retorno da funcao (true = ordenado; false = erro de ordenaçao)
    }
}
