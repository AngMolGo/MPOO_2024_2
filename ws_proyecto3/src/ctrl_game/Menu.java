package src.ctrl_game;

import java.util.Scanner;
import java.util.ArrayList;

import src.ataques.Ataque;
import src.items.Item;


public class Menu {

    Scanner menuScanner = new Scanner(System.in);

    public void desplegarMenuPrincipal() {
        System.out.println("1. Ataque\n"  +
                           "2. Cambiar\n" +
                           "3. Objeto\n"  +
                           "4. Huir\n"    +
                           "Selecciona una opción: ");
    }

    public void desplegarMenuAtaque(ArrayList<Ataque> ataques){
        for(Ataque ataque : ataques){
            System.out.println("> " + ataque.getNombre());
        }
    }

    public void desplegarMenuHabilidad(ArrayList<Item> itemsList){
        for(Item item : itemsList){
            System.out.println("> " + item.getClass());
        }
    }

    public void desplegarMenuObjeto(){

    }

}
