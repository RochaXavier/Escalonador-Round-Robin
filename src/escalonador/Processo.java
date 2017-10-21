package escalonador;

public class Processo {

    String codigo;
    int duracaoCompleta;
    int duracaoRestante;
    int tempoEntrada;
    int tempoFinalizado;

    public Processo(String codigo, int duracaoCompleta, int tempoEntrada) {
        this.codigo = codigo;
        this.duracaoCompleta = duracaoCompleta;
        this.duracaoRestante = duracaoCompleta;
        this.tempoEntrada = tempoEntrada;
        
    }

    public void descontaMilisegundos(int milisegundos) {
        if (!finalizado()) {
            duracaoRestante = duracaoRestante - milisegundos;
            if (duracaoRestante <= 0) {
                duracaoRestante = 0;
            }
        }
    }

    public boolean finalizado() {
        return duracaoRestante == 0;
    }

    @Override
    public String toString() {
        return "Processo " + codigo + " " + duracaoRestante + "ms de " + duracaoCompleta + "ms.";
    }

    public String tempoDeEspera() {
        return (tempoFinalizado - tempoEntrada - duracaoCompleta) + "ms";
    }

}
