package src.ctrl_game;

import src.ataques.Ataque;
import src.pokemones.*;

// Clase para representar un combate
public class Combate {

    public void atacar(Pokemon atacante, Pokemon defensor, Ataque ataque) {
        double v = defensor.getVida();
        System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre() + " con " + ataque.getNombre() + "!");

        // Lógica para determinar la eficacia del ataque basado en los tipos de Pokémon
        // Esto es solo un ejemplo, pueden expandir o mejorar esta lógica según la mecánica del juego
        if (ataque.getTipo().equals("Fuego") && defensor.getTipo().equals("Hierba")) {
            System.out.println("¡Es muy efectivo!");
            double damage = ataque.getPotencia() * 2;
            v -= damage;
            defensor.setVida(v);
            System.out.println("El Pokémon rival recibe " + damage + " puntos de daño");

        } else if (ataque.getTipo().equals("Hierba") && defensor.getTipo().equals("Fuego")) {
            System.out.println("¡No es muy efectivo!");
            double damage = ataque.getPotencia() * 0.5;
            v -= damage;
            defensor.setVida(v);
            System.out.println("El Pokémon rival recibe " + damage + " puntos de daño");

        } else {
            double damage = ataque.getPotencia();
            v -= damage;
            defensor.setVida(v);
            System.out.println("El Pokémon rival recibe " + damage + " puntos de daño");
        }
    }
}