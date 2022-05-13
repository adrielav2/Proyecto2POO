package todo;

import todo.iObservador;

/**
 *
 * @author david
 */
public class Aliado extends AgenteBase implements iObservador{
    
    public Aliado(int vida, int Posx, int Posy) {
        super(vida, Posx, Posy);
    }
    
    @Override
    public int getVida() {
        return vida;
    }

    @Override
    public void setVida(int vida) {
        this.vida = vida;
    }
    
    @Override
    public int[] getPosicion() {
        return posicion;
    }

    @Override
    public void setPosicion(int[] posicion) {
        this.posicion = posicion;
    }

    @Override
    public void actualizar() {
        
    }
}
