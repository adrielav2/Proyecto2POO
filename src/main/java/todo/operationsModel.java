package todo;

import todo.AgenteFactory;
import todo.iConstantes;
import todo.AgenteBase;
import todo.Observadores;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class operationsModel implements iConstantes {
    Observadores observadores;
    
    AgenteFactory aFactury;

    ArrayList<AgenteBase> arrayAgentes;

    public operationsModel() {
        this.arrayAgentes = new <AgenteBase>ArrayList();
        this.aFactury = new AgenteFactory();
        observadores = new Observadores();
    }

    public int[] iniciarJuego() {
        int position[] = new int[3];
        AgenteBase agente;
        if (arrayAgentes.isEmpty()) {
            agente = aFactury.crearAgente(AGENTE, 8, 1, 1);
            position[0] = 1;
            position[1] = 1;
            position[2] = AGENTE;
        } else {
            agente = aFactury.crearAgente(ENEMIGO, 8, 12, 12);
            position[0] = 12;
            position[1] = 12;
            position[2] = ENEMIGO;
        }
        arrayAgentes.add(agente);
        observadores.agregarObservador(agente);
        return position;
    }
}
