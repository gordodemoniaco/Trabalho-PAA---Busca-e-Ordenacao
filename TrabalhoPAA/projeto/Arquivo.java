package projeto;

import java.io.*;
import java.util.ArrayList;

public class Arquivo {
    public static final String nome_ordenacao = "ORDENACAO";
    public static final String nome_busca = "BUSCA";
    
    
    public static void escritor(ArrayList<String> linhas, String tipo) throws IOException {
        String caminho = "TrabalhoPAA/projeto/resultados/";
        String nome = caminho+tipo+System.getProperty("user.name")+System.currentTimeMillis()+".txt";

        FileWriter arq = new FileWriter(nome);
        PrintWriter gravarArq = new PrintWriter(arq);

        for(int i=0; i<linhas.size(); i++){
            gravarArq.println(linhas.get(i));
        }
        arq.close();
        System.out.println("Gravação do Arquivo Realizada com Sucesso!");
        System.out.println("Nome do Arquivo: "+ nome);
    }
    
}
