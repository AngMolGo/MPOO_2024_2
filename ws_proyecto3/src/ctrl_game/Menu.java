package src.ctrl_game;

import java.util.Scanner;
import java.util.ArrayList;

import src.ataques.Ataque;
import src.habilidades.Habilidad;
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
        /*
         * for (Pokemon pokemon : pokemonesList) {
         * System.out.println("----------------------------");
         * System.out.println("Escoje un pokemon inicial:");
         * pokemon.imprimirInformacion();
         * }
         */

        return e;
    }

    public void presentarCombate(Entrenador yo, Entrenador rival) {
        System.out.println("> Te encontraste a " + rival.getName());
    }

    public ArrayList<Integer> desplegarMenuPrincipal(Entrenador player) {
        ArrayList<Integer> accionesList = new ArrayList<Integer>();
        int opcionRegistrada;
        do {
            System.out.print("1. Ataque\n" +
                    "2. Habilidad\n" +
                    "3. Objeto\n" +
                    "> Selecciona una opción: ");
            opcionRegistrada = menuScanner.nextInt();
            
            if (opcionRegistrada == 2) {
                System.out.println("\n> Por ahora no están habilitadas las habilidades. \n");
                opcionRegistrada = 0;}
            if (opcionRegistrada == 3 && player.getItemsList().size() == 0) {
                System.out.println("\n> Ya no tienes objetos que utilizar\n");
                opcionRegistrada = 0;}
            
            System.out.println("");
        } while (opcionRegistrada <= 0 || opcionRegistrada >= 4);
        accionesList.add(opcionRegistrada);
        switch (opcionRegistrada) {
            case 1:
                opcionRegistrada = desplegarMenuAtaque(player.getPokemon().getAtaquesList());
                break;
            case 2:
                opcionRegistrada = desplegarMenuHabilidad(player.getPokemon().getHabilidadesList());
                break;
            case 3:
                opcionRegistrada = desplegarMenuObjeto(player.getItemsList());
                break;
            default:
                break;
        }
        accionesList.add(opcionRegistrada);
        return accionesList;
    }

    public int desplegarMenuAtaque(ArrayList<Ataque> ataques) {
        int opcionRegistrada;
        do {
            for (int i = 0; i < ataques.size(); i++) {
                System.out.println(i + 1 + ". " + ataques.get(i).getNombre());
            }
            System.out.print("> Escoge un ataque: ");
            opcionRegistrada = menuScanner.nextInt();
            System.out.println("");
        } while (opcionRegistrada <= 0 || opcionRegistrada >= ataques.size() + 1);
        return opcionRegistrada;
    }

    public int desplegarMenuHabilidad(ArrayList<Habilidad> habilidadList) {
        for (int i = 0; i < habilidadList.size(); i++) {
            System.out.println(i + 1 + ". " + habilidadList.get(i).getName());
        }
        System.out.print("> Escoge una habilidad a usar: ");
        int opcionRegistrada = menuScanner.nextInt();
        System.out.println("");
        if (opcionRegistrada > 0 && opcionRegistrada < habilidadList.size() + 1) {
            return opcionRegistrada;
        }
        return 1;
    }

    public int desplegarMenuObjeto(ArrayList<Item> itemsList) {
        int opcionRegistrada;
        do {
            for (int i = 0; i < itemsList.size(); i++) {
                System.out.println(i + 1 + ". " + itemsList.get(i).getName());
            }
            System.out.print("> Escoge un objeto a usar: ");
            opcionRegistrada = menuScanner.nextInt();
            System.out.println("");
        } while (opcionRegistrada <= 0 || opcionRegistrada >= itemsList.size() + 1);

        return opcionRegistrada;

    }

}
