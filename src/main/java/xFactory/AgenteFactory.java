package xFactory;

import Modelo.*;


/**
 *
 * @author david
 */
public class AgenteFactory{

    public AgenteFactory() {
    }
    
    public AgenteBase crearAgente(int agente, int vida, int posX, int posY)
    {
        return switch (agente) {
            case 1 -> new Aliado(vida, posX, posY);
            case 2 -> new Enemigo(vida, posX, posY);
            default -> null;
        };
    }
}