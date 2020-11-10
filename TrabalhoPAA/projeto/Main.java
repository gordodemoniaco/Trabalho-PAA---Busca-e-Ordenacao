package projeto;

import java.io.IOException;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        final int tamanho_base = 50000; // tamanho_base dos vetores
        final int tamanho_max = 1000000; // tamanho maximo
        int opFuncao = 0; // opcao de execucao do sistema
        Scanner entrada = new Scanner(System.in); // entrada do teclado
        boolean verify = true;
        Random r = new Random();
        Calendar cal = Calendar.getInstance();

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
        int x= tamanho_max/tamanho_base;
        switch(opFuncao){
            case 1:{
                for(int k=1; k<=x; k++){
                    int n = k*tamanho_base; // tamanho do vetor
                    int[] vetor = new int[n]; // instancia do vetor
                    int nao_contem = -1;    // valor que nao contem dentro do vetor
                    int contem = r.nextInt(n);  // valor aleatório que contem dentro do vetor
                    int result_contem= nao_contem;  // resultado da posicao onde o elemento foi encontrado
                    int result_nao_contem = contem; // deve retornar -1, ja q nao é encontrado
                    long tempo_contem = 0;  // variavel pra armazenar o tempo demorado pra encontrar
                    long tempo_nao_contem = 0; // variavel pra armazenar o tempo demorado pra nao encontrar
                    vetor = AuxiliarVetor.criarVetor(n); // cria um vetor 
                    for(int i=1; i<=50; i++){
                        // Algoritmo tempo onde contem o valor
                        tempo_contem = cal.getTimeInMillis();
                        result_contem = Busca.buscaSequencial(vetor, n, contem);
                        if(result_contem<0){
                            System.err.println("Elemento Não Encontrado | Erro!");
                            System.exit(1);
                        }
                        tempo_contem = cal.getTimeInMillis()-tempo_contem;
                        
                        Thread.sleep(100);

                        tempo_nao_contem = cal.getTimeInMillis();
                        result_nao_contem = Busca.buscaSequencial(vetor, n, nao_contem);
                        if(result_nao_contem>=0){
                            System.err.println("Elemento Encontrado | Erro!");
                            System.exit(1);
                        }
                        tempo_nao_contem = cal.getTimeInMillis()-tempo_nao_contem;

                        Thread.sleep(100);
                    }
                }
                
            }
            break;
            case 2:{
                
            }
            break;
            default:
                System.out.println("Programa Encerrado! Opções Inválidas");
            break;
        }
        entrada.close();

    }
}