package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author david
 */
public class operationsController implements ActionListener, KeyListener {

    private Tablero tablero;
    private operationsModel modelo;

    public operationsController(Tablero tablero, operationsModel modelo) {
        this.tablero = tablero;
        this.modelo = modelo;
        tablero.setVisible(true);

        _init_();
    }

    private void _init_() {
        modelo.iniciarJuego(tablero);
        addKeyListener();
        addActionListener();
    }

    private void addKeyListener() {
        for (int i = 0; i < tablero.getBotones().length; i++) {
            for (int j = 0; j < tablero.getBotones().length; j++) {
                tablero.getBotones()[i][j].addKeyListener(this);
            }
        }
    }
    
    private void addActionListener()
    {
        for (int i = 0; i < tablero.getBotones().length; i++) {
            for (int j = 0; j < tablero.getBotones().length; j++) {
                tablero.getBotones()[i][j].addMouseListener(new java.awt.event.MouseAdapter() {//pone a la casilla a la escucha del mouse para saber cuando se esta dando clic
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        tablero.Click(evt);//llama al metodo que debe ejecutarse cuando se da clic
                    }
                });
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyCode());
        switch (e.getKeyCode()) {
            case 10: //ENTER
                modelo.accionJugador(tablero, 10);
                break;
            case 65://A
                modelo.accionJugador(tablero, 65);
                break;
            case 68://D
                modelo.accionJugador(tablero, 68);
                break;
            case 83://S
                modelo.accionJugador(tablero, 83);
                break;
            case 82:
                tablero.setAllBackGroundWhite();
                modelo.reiniciarJuego(tablero);
                break;
            case 87://W
                modelo.accionJugador(tablero, 87);
                break;
            default:
                System.out.println("Se ha presionado otra tecla");
        }
    }
}
