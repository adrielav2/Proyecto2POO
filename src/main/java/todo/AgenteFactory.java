/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todo;

import todo.Agente;
import todo.AgenteBase;
import todo.Aliado;
import todo.Enemigo;

/**
 *
 * @author david
 */
public class AgenteFactory{

    public AgenteFactory() {
    }
    
    public AgenteBase crearAgente(int agente, int vida, int posX, int posY)
    {
        return switch (agente) {
            case 0 -> new Agente(vida, posX, posY);
            case 1 -> new Aliado(vida, posX, posY);
            case 2 -> new Enemigo(vida, posX, posY);
            default -> null;
        };
    }
}