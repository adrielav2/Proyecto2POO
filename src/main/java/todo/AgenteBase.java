package todo;

/**
 *
 * @author david
 */
public class AgenteBase implements iConstantes, iObservador{
    protected int vida;
    protected int posicion[];

    public AgenteBase(int vida, int Posx, int Posy) {
        this.vida = vida;
        this.posicion = new int[2];
        this.posicion[X] = Posx;
        this.posicion[Y] = Posy;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int[] getPosicion() {
        return posicion;
    }

    public void setPosicion(int[] posicion) {
        this.posicion = posicion;
    }

    @Override
    public void actualizar() {
       
    }
}
