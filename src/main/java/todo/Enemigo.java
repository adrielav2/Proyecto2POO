package todo;

import todo.iObservador;

/**
 *
 * @author david
 */
public class Enemigo extends AgenteBase implements iObservador{
    protected int posicionEnemigo[];
    
    public Enemigo(int vida, int Posx, int Posy) {
        super(vida, Posx, Posy);
        posicionEnemigo = new int[2];
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
