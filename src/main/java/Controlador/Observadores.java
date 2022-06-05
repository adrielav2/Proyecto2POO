package Controlador;

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
    
    public void eliminarObservadores()//Elimina todos los objetos
    {
        observadores.removeAll(observadores);
    }

    public void notificarObservadores(int[] posiciones) {
        for (iObservador agentes : observadores) {
            agentes.actualizar(posiciones);
        }
    }
}
