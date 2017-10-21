package escalonador;

public class Node {
    Processo elemento;
    Node proximo;

    public Node(Processo elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }
}
