package projeto;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        final int tamanho_base = 500000; // tamanho_base dos vetores
        final int tamanho_max = 10000000; // tamanho maximo
        int opFuncao = 0; // opcao de execucao do sistema
        Scanner entrada = new Scanner(System.in); // entrada do teclado
        boolean verify = true;
        Random r = new Random();

        System.out.println("Projeto de Busca e Ordenação");
        System.out.println("");

        while (verify) {
            System.out.println("1 - Busca | 2 - Ordenação");
            System.out.printf("Opção: ");
            opFuncao = entrada.nextInt();
            System.out.println("Opcão Selecionada: " + opFuncao + " - " + AuxiliarVetor.opcaoSistema(opFuncao));
            if (opFuncao == 1 || opFuncao == 2)
                verify = false;
        }
        int x = tamanho_max / tamanho_base;
        switch (opFuncao) {
            case 1: {
                for (int k = 1; k <= x; k++) {
                    // Criação de vetor
                    long tempo_criacao = System.currentTimeMillis(); // varaivel pra armazenar o tempo de criacao do
                                                                     // vetor
                    int n = k * tamanho_base; // tamanho do vetor
                    int[] vetor = new int[n]; // instancia do vetor
                    vetor = AuxiliarVetor.criarVetor(n); // cria um vetor
                    tempo_criacao = System.currentTimeMillis() - tempo_criacao; // contabiliza o tempo de criacao

                    int result_contem; // resultado da posicao onde o elemento foi encontrado
                    int result_nao_contem; // deve retornar -1, ja q nao é encontrado

                    long tempo_sequencial = 0; // variavel pra armazenar a media do tempo da busca sequencial
                    long tempo_binaria = 0; // variavel pra armazenar a media do tempo da busca sequencial
                    int teste = r.nextInt(n); // variavel que paroniza um numero pertencente aleatorio

                    // Busca Sequencial
                    for (int i = 1; i <= 50; i++) {
                        long tempo_contem = 0; // variavel pra armazenar o tempo demorado pra encontrar
                        long tempo_nao_contem = 0; // variavel pra armazenar o tempo demorado pra nao encontrar

                        // Busca pra elemento que contem
                        tempo_contem = System.currentTimeMillis(); // inicializa contador de tempo
                        result_contem = Busca.buscaSequencial(vetor, n, teste); // realiza a busca
                        if (result_contem < 0) { // verifica se não deu erro
                            System.err.println("Elemento Não Encontrado | Erro!"); // caso erro fecha o programa
                            System.exit(1);
                        }
                        tempo_contem = System.currentTimeMillis() - tempo_contem; // contabiliza o tempo gasto

                        // Busca pra elemento que nao contem
                        tempo_nao_contem = System.currentTimeMillis(); // inicializa contador de tempo
                        result_nao_contem = Busca.buscaSequencial(vetor, n, -1); // realiza a busca
                        if (result_nao_contem >= 0) { // verifica se não deu erro
                            System.err.println("Elemento Encontrado | Erro!"); // caso erro fecha o programa
                            System.exit(1);
                        }
                        tempo_nao_contem = System.currentTimeMillis() - tempo_nao_contem; // contabiliza o tempo gasto

                        tempo_sequencial += tempo_contem + tempo_nao_contem; // acumulador de tempo
                    }

                    // Busca Binaria
                    for (int i = 1; i <= 50; i++) {
                        long tempo_contem = 0; // variavel pra armazenar o tempo demorado pra encontrar
                        long tempo_nao_contem = 0; // variavel pra armazenar o tempo demorado pra nao encontrar

                        // Busca pra elemento que contem
                        tempo_contem = System.currentTimeMillis(); // inicializa contador de tempo
                        result_contem = Busca.buscaBinaria(vetor, n, teste); // realiza a busca
                        if (result_contem < 0) { // verifica se não deu erro
                            System.err.println("Elemento Não Encontrado | Erro!"); // caso erro fecha o programa
                            System.exit(1);
                        }
                        tempo_contem = System.currentTimeMillis() - tempo_contem; // contabiliza o tempo gasto

                        // Busca pra elemento que nao contem
                        tempo_nao_contem = System.currentTimeMillis(); // inicializa contador de tempo
                        result_nao_contem = Busca.buscaBinaria(vetor, n, -1); // realiza a busca
                        if (result_nao_contem >= 0) { // verifica se não deu erro
                            System.err.println("Elemento Encontrado | Erro!"); // caso erro fecha o programa
                            System.exit(1);
                        }
                        tempo_nao_contem = System.currentTimeMillis() - tempo_nao_contem; // contabiliza o tempo gasto

                        tempo_binaria += tempo_contem + tempo_nao_contem; // acumulador de tempo
                    }

                    // tempo_sequencial = tempo_sequencial/100; // media do tempo gasto
                    // tempo_binaria = tempo_binaria/100; // media do tempo gasto
                    System.out.println("Tamanho do Vetor: " + n + " | Tempo de Criação: " + tempo_criacao
                            + " <> Tempo Médio da Busca Sequencial: " + tempo_sequencial
                            + " | Tempo Médio da Busca Binária: " + tempo_binaria);
                }

            }
                break;
            case 2: {
                for (int k = 1; k <= x; k++) {
                    // Criação de vetor
                    long tempo_criacao = System.currentTimeMillis(); // varaivel pra armazenar o tempo de criacao do
                                                                     // vetor
                    int n = k * tamanho_base; // tamanho do vetor
                    int[] vetor = new int[n]; // instancia do vetor
                    vetor = AuxiliarVetor.criarVetor(n); // cria um vetor
                    tempo_criacao = System.currentTimeMillis() - tempo_criacao; // contabiliza o tempo de criacao do
                                                                                // vetor

                    // Selection Sort
                    long tempo_selection = Ordenacao.ordenaSelection(vetor, n);

                    // Insertion Sort
                    long tempo_insertion = Ordenacao.ordenaInsertion(vetor, n);

                    // Bubble Sort
                    long tempo_bubble = Ordenacao.ordenaBubble(vetor, n);

                    // Merge Sort
                    long tempo_merge = Ordenacao.ordenaMerge(vetor, n);

                    // Quick Sort
                    long tempo_quick = Ordenacao.ordenaQuick(vetor, n);

                    System.out.println("Tamanho do Vetor: " + n + " | Tempo de Criação: " + tempo_criacao);
                    System.out.println("Tempo <" + Ordenacao.selection + ">: " + tempo_selection);
                    System.out.println("Tempo <" + Ordenacao.insertion + ">: " + tempo_insertion);
                    System.out.println("Tempo <" + Ordenacao.bubble + ">: " + tempo_bubble);
                    System.out.println("Tempo <" + Ordenacao.merge + ">: " + tempo_merge);
                    System.out.println("Tempo <" + Ordenacao.quick + ">: " + tempo_quick);

                }

            }
                break;
            default:
                System.out.println("Programa Encerrado! Opções Inválidas");
                break;
        }
        entrada.close();

    }
}