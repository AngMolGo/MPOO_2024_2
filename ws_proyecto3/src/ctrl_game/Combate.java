package src.ctrl_game;

import src.ataques.Ataque;
import src.pokemones.*;

// Clase para representar un combate
public class Combate {

    public void atacar(Pokemon atacante, Pokemon defensor, Ataque ataque) {
        //atacante.imprimirInformacion();
        //defensor.imprimirInformacion();
        double v = defensor.getVida();
        System.out.println("> " + atacante.getName() + " ataca a " + defensor.getName() + " con " + ataque.getNombre() + "!");

        // Lógica para determinar la eficacia del ataque basado en los tipos de Pokémon
        // Esto es solo un ejemplo, pueden expandir o mejorar esta lógica según la mecánica del juego
        if (ataque.getTipo().equals("Fuego") && defensor.getTipo().equals("Hierba")) {
            System.out.println("\t¡Es muy efectivo!");
            double damage = ataque.getPotencia() * 2;
            v -= damage;
            defensor.setVida(v);
            System.out.println("\tEl Pokémon rival recibe " + damage + " puntos de daño");

        } else if (ataque.getTipo().equals("Hierba") && defensor.getTipo().equals("Fuego")) {
            System.out.println("\t¡No es muy efectivo!");
            double damage = ataque.getPotencia() * 0.5;
            v -= damage;
            defensor.setVida(v);
            System.out.println("\tEl Pokémon rival recibe " + damage + " puntos de daño");

        } else {
            double damage = ataque.getPotencia();
            v -= damage;
            defensor.setVida(v);
            System.out.println("\tEl Pokémon rival recibe " + damage + " puntos de daño");
        }
    }
}