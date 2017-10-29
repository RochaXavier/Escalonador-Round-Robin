package escalonador;

public class ListaOrdenada {

    private Node inicio, fim;
    private int quantidade;

    public ListaOrdenada() {
        inicio = fim = null;
        quantidade = 0;
    }

    public boolean isEmpty() {
        return quantidade == 0;
    }

    public int size() {
        return quantidade;
    }

    public void add(Processo element) {
        Node novo = new Node(element);
        if (isEmpty()) {
            inicio = fim = novo;
        } else {
            if (inicio.elemento.tempoEntrada > novo.elemento.tempoEntrada) {
                novo.proximo = inicio;
                inicio = novo;
            } else {
                Node aux = inicio;
                while (aux != fim
                        && aux.proximo.elemento.tempoEntrada < novo.elemento.tempoEntrada) {
                    aux = aux.proximo;
                }
                novo.proximo = aux.proximo;
                aux.proximo = novo;
                if (novo.proximo == null) {
                    fim = novo;
                }
            }
        }
        quantidade++;
    }

    public Processo removeFirst() {
        if (!isEmpty()) {
            Node aux = inicio;
            if (inicio == fim) {
                inicio = fim = null;
            }else{
                inicio = inicio.proximo;
            }
            quantidade--;
            return aux.elemento;
        }
        System.out.println("Lista vazia");
        return null;
    }

    public String toString() {
        String saida = "";
        Node aux = inicio;
        while (aux != null) {
            saida += aux.elemento.toString() + "\n";
            aux = aux.proximo;
        }
        return saida;
    }

}
