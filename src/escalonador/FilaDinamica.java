package escalonador;

public class FilaDinamica {
    private Node inicio, fim;
    private int quantidade;

    public FilaDinamica() {
        inicio = fim = null;
        quantidade = 0;
    }
    
    public boolean isEmpty() {
        return quantidade == 0;
    }
    
    public int size() {
        return quantidade;
    }
    
    public void enqueue(Processo elemento) {
        Node novo = new Node(elemento);
        if (isEmpty()) {
            inicio = novo;
        } else {
            fim.proximo = novo;
        }
        fim = novo;
        quantidade++;
    }
    
    public Processo dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node aux = inicio;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        aux.proximo = null;
        quantidade--;
        return aux.elemento;
    }
     public Processo front() {
        if (isEmpty()) {
            return null;
        }
        return inicio.elemento;
    }
}
