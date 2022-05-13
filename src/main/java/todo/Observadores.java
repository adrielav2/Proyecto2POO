package todo;

import todo.iObservador;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Observadores {

    private ArrayList<iObservador> observadores;

    public Observadores() {
        this.observadores = new <iObservador>ArrayList();
    }

    public void agregarObservador(iObservador agente) {
        observadores.add(agente);
    }

    public void eliminarObservador(iObservador agente) {
        observadores.remove(agente);
    }

    public void notificarObservadores() {
        for (iObservador agentes : observadores) {
            agentes.actualizar();
        }
    }
}
