package projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AuxiliarVetor {

    public static int[] criarVetor(int n) {

        int[] vetor = new int[n]; // instaciando o vetor para o tamanho recebido
        List<Integer> lista = new ArrayList<>(); // arrayList para embaralhar o vetor
        Random r = new Random(); // numero aleatorio para randomizar o embaralhamento
        int i; // contador auxiliar
        for (i = 0; i < n; i++) {
            lista.add(i); // preenchendo a lista com numeros nao repetidos positivos
        }
        Collections.shuffle(lista, new Random(r.nextInt(200))); // embaralhando a lista aleatoriamente
        for (i = 0; i < n; i++) {
            vetor[i] = lista.get(i); // transferindo a lista embaralhada para um vetor
        }
        return vetor; // retorno do vetor
    }

    public static String opcaoSistema(int opcao) {
        if (opcao == 1)
            return "Busca";
        if (opcao == 2)
            return "Ordenação";
        else
            return "Opção Inválida! Escolha dentre as opções abaixo";
    }

    public static void wait(int ms) { // Delay
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
