package src.ctrl_game;

import java.util.Scanner;


public class Menu {

    Scanner menuScanner = new Scanner(System.in);

    public void desplegarMenuPrincipal() {
        System.out.println("1. Ataque\n"+
                           "2. Cambiar\n" +
                           "3. Objeto\n" +
                           "4. Huir\n" +
                           "Selecciona una opción: ");
    }

    public void desplegarMenuAtaque(){
        System.out.println("1. Ataque\n"+
                           "2. Curar\n" +
                           "Selecciona una opción: ");
    }

}
