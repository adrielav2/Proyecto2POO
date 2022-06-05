package Modelo;

/**
 *
 * @author david
 */
public class Jugador implements iConstantes{
    private int vida;
    private int []posicion;
    private char direccion = 'S'; //Valores -> ARRIBA(w), ABAJO(s), IZQ(a), DER(d)
    
    Jugador(int vida, int Posx, int Posy) {
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

    public char getDireccion() {
        return direccion;
    }

    public void setDireccion(char direccion) {
        this.direccion = direccion;
    }
}
