package escalonador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Escalonador {

    private int tempo = 0;
    private int quantum;
    private FilaDinamica fila;
    private FilaDinamica filaAux;

    public Escalonador(int quantum) {
        this.quantum = quantum;
        fila = new FilaDinamica();
    }

    private void processarQuantum() {
        if (!fila.isEmpty()) {
          
            Processo p = fila.dequeue();
            //System.out.println(tempo);
            if (p.duracaoRestante <= quantum) {
                tempo += p.duracaoRestante;
                p.descontaMilisegundos(p.duracaoRestante);
                p.tempoFinalizado = tempo;
                System.out.println("Finalizado: " + p.toString() + " Espera de: " + p.tempoDeEspera());
            } else {
                tempo += quantum;
                p.descontaMilisegundos(quantum);
                fila.enqueue(p);
                System.out.println("Executando: " + p.toString());
            }          
           filaAux.enqueue(new Processo(p.codigo, p.duracaoRestante, p.tempoEntrada));
        }
    }

    public void init(File file) {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, " ");
                int duracao = 0, entrada = 0;
                String codigo = "";
                int i = 0;
                for (i = 0; st.hasMoreTokens(); i++) {
                    switch (i) {
                        case 0:
                            codigo = st.nextElement().toString();
                            break;
                        case 1:
                            duracao = Integer.parseInt(st.nextElement().toString());
                            break;
                        case 2:
                            entrada = Integer.parseInt(st.nextElement().toString());
                            break;
                        default:
                            st.nextElement();
                            break;
                    }
                }
                if (i < 3) {
                    throw new Exception("Falha ao ler arquivo, numero insuficente de parametros");
                }
                filaAux.enqueue(new Processo(codigo, duracao, entrada));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Falha ao carregar arquivo de entrada");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Falha ao carregar arquivo de entrada");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Falha aleatoria");
            ex.printStackTrace();
        }

        while (!fila.isEmpty()) {
            //System.out.println(fila.front().toString());
           // System.out.println(fila.dequeue().tempoEntrada);
            processarQuantum();
        }
    }
}
