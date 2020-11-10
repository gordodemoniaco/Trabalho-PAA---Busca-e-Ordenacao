package projeto;

public class Busca {

    public static final String sequencial = "Sequencial";
    public static final String binaria = "Binária";

    public static String printOpBusca(int opBusca) {
        String tipo_busca = new String();
        switch (opBusca) {
            case 1:
                tipo_busca = sequencial;
                break;
            case 2:
                tipo_busca = binaria;
                break;
            default:
                tipo_busca = "Opção Inválida!";
                break;
        }
        return tipo_busca;
    }

    public static int buscaSequencial(int[] vetor, int n, int teste) {
        int posicao = -1; // valor padrao para não achar a posição (-1)
        // Algoritmo comeca aqui
        AuxiliarVetor.wait(1); // tempo de espera padrao
        for (int i = 0; i < n; i++) {
            posicao = -1; // garantia de valor padrao caso nao ache o elemento
            if (vetor[i] == teste) { // verifica se existe o elemento em cada posicao
                posicao = i; // se existir, captura a posicao
                break;
            }
        }
        // System.out.println(n+" | "+posicao); // impressao de teste
        // Fim do Algoritmo
        return posicao;

    }

    public static int buscaBinaria(int[] vetor, int n, int teste) {
        int posicao = teste; // valor padrao para não achar a posição (-1)
        AuxiliarVetor.wait(1); // tempo de espera padrão
        // Algoritmo comeca aqui

        // System.out.println(n+" | "+posicao); // impressao de teste
        // Fim do Algoritmo
        return posicao;
    }
}
