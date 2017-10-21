package Main;

import escalonador.Escalonador;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        escalonador.Escalonador escalonador = new Escalonador(4);
        escalonador.init(new File("input.txt"));
    }
}
