package Controlador;

import Controlador.AgenteBase;
import Controlador.iObservador;

/**
 *
 * @author david
 */
public class Aliado extends AgenteBase implements iObservador{
    private final int rango = 3;
    
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
    public int[] getPosJugador() {
        return posJugador;
    }
    
    @Override
    public void moverAgente()
    {
        
    }
    
    @Override
    public int getID()
    {
        if (Math.abs(posJugador[X] - posicion[X]) <= this.rango
                && Math.abs(posJugador[Y] - posicion[Y]) <= this.rango) {
            return ALIADO;
        }
        else
        {
            return 3;
        }
    }

    @Override
    public void actualizar(int[] posiciones) {
        posJugador = posiciones;
    }
}
