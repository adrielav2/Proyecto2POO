package todo;

/**
 *
 * @author david
 */
public class Agente extends AgenteBase{
    
    public Agente(int vida, int Posx, int Posy) {
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
}
