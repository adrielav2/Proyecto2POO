package todo;
/**
 *
 * @author david
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        operationsModel model = new operationsModel();
        operationsController operations = new operationsController(tablero, model);
//        Observadores ob = new Observadores();
//        Enemigo enemigo = new Enemigo(12,12,12);
//        ob.agregarObservador(enemigo);
    }
}