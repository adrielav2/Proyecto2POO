package Modelo;

import Vista.Tablero;
import xFactory.AgenteFactory;
import xObserver.Observadores;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author david
 */
public class operationsModel implements iConstantes {

    Random rand;
    public final int COLOR_WHITE = 3;

    Observadores observadores;

    AgenteFactory aFactury;

    ArrayList<AgenteBase> arrayAgentes;
    Jugador jugador;

    private boolean llaveDelJuego = true;
    private int rondas = 1;

    private int enemigosCreados = 1;
    private int aliadosCreados = 1;
    private int enemigosEliminados = 0;
    private int aliadosSalvados = 0;

    public operationsModel() {
        this.arrayAgentes = new <AgenteBase>ArrayList();
        this.jugador = new Jugador(4, 0, 0);
        this.aFactury = new AgenteFactory();
        observadores = new Observadores();
        rand = new Random();
    }

    //Metodo que se utiliza solo para dar inicio al juego (logica)
    public void iniciarJuego(Tablero tablero) {
        tablero.setBackGround(jugador.getPosicion(), JUGADOR);

        AgenteBase agente = aFactury.crearAgente(ENEMIGO, 1, rand.nextInt(24) + 5, rand.nextInt(24) + 5);
        arrayAgentes.add(agente);
        observadores.agregarObservador(agente);
        tablero.setBackGround(agente.getPosicion(), ENEMIGO);

        agente = aFactury.crearAgente(ALIADO, 1, 29, 29);
        arrayAgentes.add(agente);
        observadores.agregarObservador(agente);

        observadores.notificarObservadores(jugador.getPosicion());

        tablero.setTxfVida(jugador.getVida() + "");
        tablero.setTxfEnemigos(enemigosCreados + "");
        tablero.setTxfAliados(aliadosCreados + "");
    }

    /*
    Este metodo "accionJugador" sera el metodo principal para que el jugador relize todas las acciones
    por movimiento
     */
    public void accionJugador(Tablero tablero, int movimiento) {
        if (llaveDelJuego) {
            int posicion[] = new int[2];
            boolean pasoRealizado = false;
            boolean aliadoEliminad = false;

            posicion[X] = jugador.getPosicion()[X];
            posicion[Y] = jugador.getPosicion()[Y];

            JButton btns[][] = tablero.getBotones();
            switch (movimiento) {
                case 10://ENTER
                    atacarEnemigo(tablero);
                    break;
                case 65://A
                    jugador.setDireccion('A');
                    if (posicion[Y] > 0) {
                        if (btns[posicion[X]][posicion[Y] - 1].getBackground().equals(BG_ALIADO)) {
                            tablero.setBackGround(posicion, COLOR_WHITE);
                            posicion[Y] -= 1;
                            pasoRealizado = true;
                            aliadoEliminad = true;
                            break;
                        }
                        if (btns[posicion[X]][posicion[Y] - 1].getBackground().equals(BG_WHITE)) {
                            tablero.setBackGround(posicion, COLOR_WHITE);
                            posicion[Y] -= 1;
                            pasoRealizado = true;
                        }
                    }
                    break;
                case 68://D
                    jugador.setDireccion('D');
                    if (posicion[Y] < 29) {
                        if (btns[posicion[X]][posicion[Y] + 1].getBackground().equals(BG_ALIADO)) {
                            tablero.setBackGround(posicion, COLOR_WHITE);
                            posicion[Y] += 1;
                            pasoRealizado = true;
                            aliadoEliminad = true;
                            break;
                        }
                        if (btns[posicion[X]][posicion[Y] + 1].getBackground().equals(BG_WHITE)) {
                            tablero.setBackGround(posicion, COLOR_WHITE);
                            posicion[Y] += 1;
                            pasoRealizado = true;
                        }
                    }
                    break;
                case 83://S
                    jugador.setDireccion('S');
                    if (posicion[X] < 29) {
                        if (btns[posicion[X] + 1][posicion[Y]].getBackground().equals(BG_ALIADO)) {
                            tablero.setBackGround(posicion, COLOR_WHITE);
                            posicion[X] += 1;
                            pasoRealizado = true;
                            aliadoEliminad = true;
                            break;
                        }
                        if (btns[posicion[X] + 1][posicion[Y]].getBackground().equals(BG_WHITE)) {
                            System.out.println(posicion[X]);
                            tablero.setBackGround(posicion, COLOR_WHITE);
                            posicion[X] += 1;
                            pasoRealizado = true;
                        }
                    }
                    break;
                case 87://W
                    jugador.setDireccion('W');
                    if (posicion[X] > 0) {
                        if (btns[posicion[X] - 1][posicion[Y]].getBackground().equals(BG_ALIADO)) {
                            tablero.setBackGround(posicion, COLOR_WHITE);
                            posicion[X] -= 1;
                            pasoRealizado = true;
                            aliadoEliminad = true;
                            break;
                        }
                        if (btns[posicion[X] - 1][posicion[Y]].getBackground().equals(BG_WHITE)) {
                            tablero.setBackGround(posicion, COLOR_WHITE);
                            posicion[X] -= 1;
                            pasoRealizado = true;
                        }
                    }
                    break;
                default:
                    System.out.println("Tecla no valida");
            }
            if (pasoRealizado) { //Si se realizo el paso, se actualiza la vida, la posicion del jugdor, se notifica a los demas jugadores
                tablero.setBackGround(posicion, JUGADOR);
                jugador.setPosicion(posicion);

                rondas++;
                observadores.notificarObservadores(posicion);
                moverAgentes(tablero);

                //Aqui es donde se añadirá los nuevos aliados y enemigos
                if (rondas % 20 == 0 && enemigosCreados < MAX_ENEMIGOS) {
                    AgenteBase agente = aFactury.crearAgente(ENEMIGO, 1, rand.nextInt(30), rand.nextInt(30));
                    observadores.agregarObservador(agente);
                    arrayAgentes.add(agente);
                    enemigosCreados++;
                    tablero.setTxfEnemigos(enemigosCreados + "");
                    tablero.setBackGround(agente.getPosicion(), ENEMIGO);
                }
                if (rondas % 20 == 0 && aliadosCreados < MAX_ALIADOS) {
                    AgenteBase agente = aFactury.crearAgente(ALIADO, 1, rand.nextInt(30), rand.nextInt(30));
                    observadores.agregarObservador(agente);
                    arrayAgentes.add(agente);
                    aliadosCreados++;
                    tablero.setTxfAliados(aliadosCreados + "");
                }
                if (aliadoEliminad) {
                    borrarAliado(posicion);
                    aliadosCreados--;
                    aliadosSalvados++;
                    jugador.setVida(jugador.getVida() + 1);

                }
            }
        }
        actualizarLabels(tablero);
    }

    private void moverAgentes(Tablero refTablero) {
        if (llaveDelJuego) {
            for (AgenteBase agentes : arrayAgentes) { //Coloca las casillas en blanco
                refTablero.setBackGround(agentes.getPosicion(), COLOR_WHITE);
            }
            for (int i = 0; i < arrayAgentes.size(); i++) {
                arrayAgentes.get(i).moverAgente();
                //refPantalla.setBackGround(posiciones, arrayAgentes.get(i).getID());
                if (arrayAgentes.get(i).getVida() == 0 && arrayAgentes.get(i).getID() == ENEMIGO) {
                    refTablero.setBackGround(arrayAgentes.get(i).getPosicion(), COLOR_WHITE);
                    observadores.eliminarObservador(arrayAgentes.get(i));
                    arrayAgentes.remove(arrayAgentes.get(i));
                    --i;

                    enemigosCreados--;
                    enemigosEliminados++;
                    jugador.setVida(jugador.getVida() - 1);

                    comprobarPartida(refTablero);
                }
            }
            actualizarAgentesEnPantalla(refTablero);
        }
    }

    private void atacarEnemigo(Tablero refTablero) {
        int[] posicion = new int[2];
        posicion[X] = jugador.getPosicion()[X];
        posicion[Y] = jugador.getPosicion()[Y];
        switch (jugador.getDireccion()) //Esto es para de alguna manera "apuntar a cuadro que este mirando" y si hay algun objetivo, matarlo
        {
            case 'A':
                posicion[Y] -= 1;
                break;
            case 'D':
                posicion[Y] += 1;
                break;
            case 'W':
                posicion[X] -= 1;
                break;
            case 'S':
                posicion[X] += 1;
                break;
        }
        for (int i = 0; i < arrayAgentes.size(); i++) {
            if (posicion[X] == arrayAgentes.get(i).getPosicion()[X]
                    && posicion[Y] == arrayAgentes.get(i).getPosicion()[Y]
                    && arrayAgentes.get(i).getID() == ENEMIGO) {
                arrayAgentes.remove(i);
                --i;
                enemigosCreados--;
                enemigosEliminados++;
                refTablero.setBackGround(posicion, COLOR_WHITE);
            }
        }
        actualizarAgentesEnPantalla(refTablero);

    }

    public void actualizarAgentesEnPantalla(Tablero refTablero) {
        for (int i = 0; i < arrayAgentes.size(); i++) {
            refTablero.setBackGround(arrayAgentes.get(i).getPosicion(), arrayAgentes.get(i).getID());
        }
        refTablero.setBackGround(jugador.getPosicion(), JUGADOR);
    }

    public void borrarAliado(int[] posicion) {
        for (int i = 0; i < arrayAgentes.size(); i++) {
            if (arrayAgentes.get(i).getPosicion()[X] == posicion[X]
                    && arrayAgentes.get(i).getPosicion()[Y] == posicion[Y]
                    && arrayAgentes.get(i).getID() == ALIADO) {
                observadores.eliminarObservador(arrayAgentes.get(i));
                arrayAgentes.remove(i);
                break;
            }
        }
    }

    public void comprobarPartida(Tablero refTablero) {
        if (jugador.getVida() <= 0) {
            llaveDelJuego = false;
            refTablero.setTxfFin("¡Fin de la partida!");
            refTablero.setLblDownText("Presione R para reiniciar");
        }
    }

    public void reiniciarJuego(Tablero refTablero) {
        if (!llaveDelJuego) {
            llaveDelJuego = true;
            rondas = 1;
            enemigosCreados = 1;
            aliadosCreados = 1;
            enemigosEliminados = 0;
            aliadosSalvados = 0;
            observadores.eliminarObservadores();
            arrayAgentes.removeAll(arrayAgentes);
            
            jugador.setVida(3);
            iniciarJuego(refTablero);
            actualizarLabels(refTablero);
            refTablero.setLblDownText("");
            refTablero.setTxfFin("");
        }
    }
    
    public void actualizarLabels(Tablero tablero)
    {
        tablero.setTxfAliados(aliadosCreados + "");
        tablero.setTxfAliadosSalvados(aliadosSalvados + "");
        tablero.setTxfVida(jugador.getVida() + "");
        tablero.setTxfEnemigos(enemigosCreados + "");
        tablero.setTxfEnemigosEliminados(enemigosEliminados + "");
    }
}
