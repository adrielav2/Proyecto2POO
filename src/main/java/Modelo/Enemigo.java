package Modelo;

import java.util.Random;
import xObserver.iObservador;

/**
 *
 * @author david
 */
public class Enemigo extends AgenteBase implements iObservador {

    private final int rango = 4;
    private Random rand;

    public Enemigo(int vida, int Posx, int Posy) {
        super(vida, Posx, Posy);
        rand = new Random();
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
    public void moverAgente() {
        if (Math.abs(posJugador[X] - posicion[X]) <= this.rango
                && Math.abs(posJugador[Y] - posicion[Y]) <= this.rango) {
            if (posicion[X] != posJugador[X]) {
                posicion[X] += (posJugador[X] - posicion[X]) / Math.abs(posJugador[X] - posicion[X]);
            } else if (posicion[Y] != posJugador[Y]) {
                posicion[Y] += (posJugador[Y] - posicion[Y]) / Math.abs(posJugador[Y] - posicion[Y]);
            }
            if (posicion[X] == posJugador[X] && posicion[Y] == posJugador[Y]) {
                this.vida = 0;
            }
        } else {
            boolean move = rand.nextBoolean();
            if (move) {
                posicion[X] += rand.nextInt(3) - 1;
            } else {
                posicion[Y] += rand.nextInt(3) - 1;
            }
            if (posicion[X] > 29) {
                posicion[X]--;
            }
            if (posicion[X] < 0) {
                posicion[X]++;
            }
            if (posicion[Y] > 29) {
                posicion[Y]--;
            }
            if (posicion[Y] < 0) {
                posicion[Y]++;
            }
        }
    }

    @Override
    public int getID() {
        return ENEMIGO;
    }

    @Override
    public void actualizar(int[] posiciones) {
        posJugador = posiciones;
    }
}
