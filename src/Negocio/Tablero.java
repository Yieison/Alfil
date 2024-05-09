/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.Alfil;
import Modelo.Peon;
import java.util.ArrayList;

/**
 *
 * @author madar
 */
public class Tablero {

    private char[][] tableroMatriz;
    private boolean direccionPeon; // true abajo-arriba   false arriba-abajo
    private Peon peon;
    private Alfil alfil;
    public ArrayList<Tablero> table = new ArrayList<Tablero>();

    ;

    public Tablero() {
    }

    public Tablero(int i_alfil, int j_alfil, int i_peon, int j_peon, boolean direccionPeon) {

        this.peon = new Peon(i_peon, j_peon);
        this.alfil = new Alfil(i_alfil, j_alfil);
        this.direccionPeon = direccionPeon;
        this.tableroMatriz = new char[8][8];

    }

    public void posicionarPeon() {
        tableroMatriz[peon.getI_peon()][peon.getJ_peon()] = 'P';
    }

    public void posicionarAlfil() {
        tableroMatriz[alfil.getI_alfil()][alfil.getJ_alfil()] = 'A';
    }

    public void imprimirMatriz() {
        System.out.println("    0   1   2    3   4   5   6   7");
        for (int i = 0; i < tableroMatriz.length; i++) {
            System.out.print(i);
            for (int j = 0; j < tableroMatriz[i].length; j++) {
                System.out.print("   " + tableroMatriz[i][j] + " ");
            }
            System.out.println(); // Agrega un salto de línea después de imprimir cada fila
        }
        System.out.println("****************************************************");
    }

    public void marcarDiagonales() {
        // Marcamos la posición actual

        //tableroMatriz[alfil.getI_alfil()][alfil.getJ_alfil()] = '_';
        // Recorremos las diagonales superiores
        for (int i = alfil.getI_alfil() - 1, j = alfil.getJ_alfil() - 1; i >= 0 && j >= 0; i--, j--) {
            if (tableroMatriz[i][j] == 'P') {
                tableroMatriz[i][j] = 'M';
            } else {
                tableroMatriz[i][j] = '*';
            }
        }

        for (int i = alfil.getI_alfil() - 1, j = alfil.getJ_alfil() + 1; i >= 0 && j < tableroMatriz.length; i--, j++) {
            if (tableroMatriz[i][j] == 'P') {
                tableroMatriz[i][j] = 'M';
            } else {
                tableroMatriz[i][j] = '*';
            }
        }

        // Recorremos las diagonales inferiores
        for (int i = alfil.getI_alfil() + 1, j = alfil.getJ_alfil() - 1; i < tableroMatriz.length && j >= 0; i++, j--) {
            if (tableroMatriz[i][j] == 'P') {
                tableroMatriz[i][j] = 'M';
            } else {
                tableroMatriz[i][j] = '*';
            }
        }

        for (int i = alfil.getI_alfil() + 1, j = alfil.getJ_alfil() + 1; i < tableroMatriz.length && j < tableroMatriz.length; i++, j++) {
            if (tableroMatriz[i][j] == 'P') {
                tableroMatriz[i][j] = 'M';
            } else {
                tableroMatriz[i][j] = '*';
            }
        }
    }
    int cont = 0;

    public String jugar(int i_peon, int j_peon) {
        System.out.println("PEON SE ENCUENTRA EN LA POSICION [" + i_peon + "][" + j_peon + "]");
        cont++;
        imprimirMatriz();

        if ((tableroMatriz[i_peon][j_peon] == '*' || tableroMatriz[i_peon][j_peon] == 'M') && (cont > 0)) {
            System.out.println("FIN DEL JUEGO, GANA EL ALFIL");
            return "FIN DEL JUEGO, GANA EL ALFIL";
        } else if ((i_peon == 0 && direccionPeon == true || tableroMatriz[i_peon][j_peon] == 'A') || (i_peon == 7 && direccionPeon == false)) {
            System.out.println("FIN DEL JUEGO, GANA EL PEÓN");
            return "FIN DEL JUEGO, GANA EL PEÓN";
        }

        if (direccionPeon == true) {

            if (tableroMatriz[i_peon - 1][j_peon] == '*' || tableroMatriz[i_peon - 1][j_peon] == 'M') {
                tableroMatriz[i_peon - 1][j_peon] = 'M';
                posicionarPeon();
            } else {
                tableroMatriz[i_peon - 1][j_peon] = 'P';
            }
            return jugar(--i_peon, j_peon);

        } else {
            if (tableroMatriz[i_peon + 1][j_peon] == '*' || tableroMatriz[i_peon + 1][j_peon] == 'M') {
                tableroMatriz[i_peon + 1][j_peon] = 'M';
                posicionarPeon();
            } else {
                tableroMatriz[i_peon + 1][j_peon] = 'P';
            }
            return jugar(++i_peon, j_peon);
        }
    }

    public void imprimirArray() {
        for (Tablero t : table) {
            t.imprimirMatriz();
        }
    }

    public char[][] getTableroMatriz() {
        return tableroMatriz;
    }

    public void setTableroMatriz(char[][] tableroMatriz) {
        this.tableroMatriz = tableroMatriz;
    }

    public boolean isDireccionPeon() {
        return direccionPeon;
    }

    public void setDireccionPeon(boolean direccionPeon) {
        this.direccionPeon = direccionPeon;
    }

    public Peon getPeon() {
        return peon;
    }

    public void setPeon(Peon peon) {
        this.peon = peon;
    }

    public Alfil getAlfil() {
        return alfil;
    }

    public void setAlfil(Alfil alfil) {
        this.alfil = alfil;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public ArrayList<Tablero> getTable() {
        return table;
    }

    public void setTable(ArrayList<Tablero> table) {
        this.table = table;
    }

}
