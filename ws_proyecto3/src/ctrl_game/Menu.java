package src.ctrl_game;

import java.util.Scanner;
import java.util.ArrayList;

import src.ataques.Ataque;
import src.items.Item;
import src.pokemones.Pokemon;

public class Menu {

    Scanner menuScanner = new Scanner(System.in);

    public Entrenador inicio(ArrayList<Pokemon> pokemonesList) {
        Entrenador e;
        String name = "Angel";
        e = new Entrenador(name, null);

        System.out.println("Pon tu nombre: " + name);

        // CAMBIAR POR ESCOGER POR TECLAS
        /*for (Pokemon pokemon : pokemonesList) {
            System.out.println("----------------------------");
            System.out.println("Escoje un pokemon inicial:");
            pokemon.imprimirInformacion();
        }*/

        return e;
    }

    public void presentarCombate(Entrenador yo, Entrenador rival) {
        System.out.println("> Te encontraste a " + rival.getName());
    }

    public void desplegarMenuPrincipal() {
        System.out.println("1. Ataque\n" +
                "2. Habilidad (en desarrollo)\n" +
                "3. Objeto\n" +
                "Selecciona una opción: ");
    }

    public void desplegarMenuAtaque(ArrayList<Ataque> ataques) {
        for (Ataque ataque : ataques) {
            System.out.println("> " + ataque.getNombre());
        }
    }

    public void desplegarMenuHabilidad(ArrayList<Item> itemsList) {
        for (Item item : itemsList) {
            System.out.println("> " + item.getClass());
        }
    }

    public void desplegarMenuObjeto() {

    }

}
