package projeto;

import java.io.*;

public class Arquivo {
    public static final String caminho = "../";
    public static void escritor (String arquivo) throws IOException{
        BufferedWriter caneta = new BufferedWriter(new FileWriter(caminho+arquivo+".txt"));

    }
}
