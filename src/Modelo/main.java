package Modelo;

import Negocio.Tablero;

public class main {

    public static void main(String[] args) {
        Tablero tab = new Tablero(0,2 , 7, 7, false);
        tab.posicionarAlfil();
        tab.posicionarPeon();
        tab.imprimirMatriz();
        tab.marcarDiagonales();
        tab.imprimirMatriz();
        tab.jugar(tab.getPeon().getI_peon(),tab.getPeon().getJ_peon());
        tab.imprimirArray();
    
        
    }
}

