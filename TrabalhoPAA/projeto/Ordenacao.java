package projeto;

public class Ordenacao {
    public static final String selection = "SelectionSort";
    public static final String insertion = "InsertionSort";
    public static final String bubble = "BubbleSort";
    public static final String merge = "MergeSort";
    public static final String quick = "QuickSort";

    public static String printOpOrdenacao(int opOrdenacao) {
        String tipo_ordenacao = new String();
        switch (opOrdenacao){
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
}
