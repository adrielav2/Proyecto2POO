package todo;

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

        iniciarJuego();
    }

    private void iniciarJuego() {
        int posiciones[] = new int[3];//0_PosX, 1_PosY, 2_Objeto creado
        for (int i = 0; i < 2; i++) {
            posiciones = modelo.iniciarJuego();
            tablero.setBackGround(posiciones, posiciones[2]);
        }

        addKeyListener();
    }

    private void addKeyListener() {
        for (int i = 0; i < tablero.getBotones().length; i++) {
            for (int j = 0; j < tablero.getBotones().length; j++) {
                tablero.getBotones()[i][j].addKeyListener(this);
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
            case 10:
                System.out.println("Se ha presionado la ENTER");
                break;
            case 65:
                System.out.println("Se ha presionado la A");
                break;
            case 68:
                System.out.println("Se ha presionado la D");
                break;
            case 83:
                System.out.println("Se ha presionado la S");
                break;

            case 87:
                System.out.println("Se ha presionado la W");
                break;
            default:
                System.out.println("Se ha presionado otra tecla");
        }
    }
}
