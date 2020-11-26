package projeto;

public class Busca {

    public static final String sequencial = "Sequencial";
    public static final String binaria = "Binária";
    private static final int nao_encontrado = -1;

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

    public static int buscaSequencial(int[] vetor, int n, int teste) { // Busca Sequencial
        int posicao = Busca.nao_encontrado; // valor padrao para não achar a posição (-1)
        AuxiliarVetor.wait(1);
        // Algoritmo comeca aqui
        for (int i = 0; i < n; i++) {
            if (vetor[i] == teste) { // verifica se existe o elemento em cada posicao
                posicao = i;
                break;
            }
            posicao = -1; // garantia de valor padrao caso nao ache o elemento
        }
        // System.out.println(n+" | "+posicao); // impressao de teste
        // Fim do Algoritmo
        return posicao;

    }

    public static int buscaBinaria(int[] vetor, int n, int teste) { // Busca Binária
        AuxiliarVetor.wait(1); // tempo de espera padrão
        // Algoritmo comeca aqui
        int inferior = 0;
        int superior = n-1;

        while(inferior<=superior){
            int meio = (inferior+superior)/2;
            
            if(vetor[meio]<teste)
                inferior = meio+1;
            else if(vetor[meio]>teste)
                superior = meio-1;
            else
                return meio;
        }
        // System.out.println(n+" | "+posicao); // impressao de teste
        // Fim do Algoritmo
        return Busca.nao_encontrado;
    }

}
