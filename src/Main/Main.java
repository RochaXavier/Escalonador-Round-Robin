package Main;

import escalonador.Escalonador;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        Processo a = new Processo("A1", 10, 15);
//        Processo b = new Processo("B1", 10, 5);
//        Processo c = new Processo("C1", 10, 25);
//        Processo d = new Processo("D1", 10, 10);
//        ListaOrdenada lo = new ListaOrdenada();
//        lo.add(d);
//        System.out.println(lo.toString());
//        lo.add(c);
//        System.out.println(lo.toString());
//        lo.add(b);
//        System.out.println(lo.toString());
//        lo.add(a);
//        System.out.println(lo.toString());
//        System.out.println("start remove");
//        System.out.println(lo.removeFirst());
//        System.out.println(lo.removeFirst());
//        System.out.println(lo.removeFirst());
//        System.out.println(lo.removeFirst());
//        System.out.println(lo.removeFirst());
//        System.out.println(lo.removeFirst());
//        System.out.println(lo.removeFirst());
//        System.out.println(lo.removeFirst());
         escalonador.Escalonador escalonador = new Escalonador(4);
         escalonador.init(new File("input.txt"));
    }
}
