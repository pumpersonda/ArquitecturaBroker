package Broker;

/**
 * Created by Andr� on 09/10/2015.
 */
public class Candidato {
    private String nombre;
    private int votos;

    public Candidato(String nombre, int votos) {
        this.nombre = nombre;
        this.votos = votos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }
}
