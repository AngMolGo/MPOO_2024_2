package src.ctrl_game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

import src.ataques.Ataque;
import src.pokemones.*;

// Clase para representar un combate
public class Combate {

    private Entrenador player;
    private Entrenador rival;

    private HashMap<String, ArrayList<ArrayList<String>>> tablaDeDaños = new HashMap<>();

    public Combate(Entrenador player, Entrenador oponente) {
        this.player = player;
        this.rival = oponente;
        inicializarTablaDeDaños();
        System.out.println("¡" + player.getName() + " pelea contra " + oponente.getName() + "!");
    }

    public boolean isGameOver() {
        boolean flag = false;
        boolean flag2 = false;
        for (Pokemon poke : player.getPokemonsList()) {
            if (poke.getVida() > 0) {
                flag = true;
            }
        }
        for (Pokemon poke : rival.getPokemonsList()) {
            if (poke.getVida() > 0) {
                flag2 = true;
            }
        }

        return !(flag && flag2);
    }

    public void atacar(Pokemon atacante, Pokemon defensor, Ataque ataque) {
        double v = defensor.getVida();
        System.out.println(
                "> " + atacante.getName() + " ataca a " + defensor.getName() + " con " + ataque.getNombre() + "!");

        ArrayList<ArrayList<String>> dañosDeAtaque = tablaDeDaños.get(ataque.getTipo());

        for (int i = 0; i < dañosDeAtaque.size(); i++) {
            for (String tipo : dañosDeAtaque.get(i)) {
                if (i == 0 && tipo == defensor.getTipo()) { // Inmune
                    System.out.println("\t¡No tuvo efecto!");
                    return;
                } else if (i == 1 && tipo == defensor.getTipo()) { // A medias
                    System.out.println("\t¡No es muy efectivo!");
                    double damage = ataque.getPotencia() * 0.5;
                    v -= damage;
                    defensor.setVida(v);
                    System.out.println("\t" + defensor.getName() + " recibe " + damage + " puntos de daño");
                    return;
                } else if (i == 2 && tipo == defensor.getTipo()) { // Normal
                    double damage = ataque.getPotencia();
                    v -= damage;
                    defensor.setVida(v);
                    System.out.println("\t" + defensor.getName() + " recibe " + damage + " puntos de daño");
                    return;
                } else if (i == 3 && tipo == defensor.getTipo()) { // Doble
                    System.out.println("\t¡Es muy efectivo!");
                    double damage = ataque.getPotencia() * 2;
                    v -= damage;
                    defensor.setVida(v);
                    System.out.println("\t" + defensor.getName() + " recibe " + damage + " puntos de daño");
                    return;
                }
            }
        }
        double damage = ataque.getPotencia();
        v -= damage;
        defensor.setVida(v);
        System.out.println("\t" + defensor.getName() + " recibe " + damage + " puntos de daño");
        return;
    }

    public void anunciar_ganador() {
        for (Pokemon poke : player.getPokemonsList()) {
            if (poke.getVida() > 0) {
                System.out.println(
                        "¡" + rival.getName() + " ha sido derrotado! ¡" + player.getName() + " ganó la batalla!");
                return;
            }
        }
        System.out.println("¡" + player.getName() + " ha sido derrotado! ¡" + rival.getName() + " ganó la batalla!");
        return;
    }

    public Entrenador quienVaPrimero() {
        if (player.getPokemon().getVelocidad() > rival.getPokemon().getVelocidad()) {
            return player;
        } else {
            return rival;
        }
    }

    public Entrenador quienVaSegunds() {
        if (player.getPokemon().getVelocidad() <= rival.getPokemon().getVelocidad()) {
            return player;
        } else {
            return rival;
        }
    }

    private void inicializarTablaDeDaños() {
        // ### Tipo Acero ###
        tablaDeDaños.put("Acero", new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList()), // Inmunes
                new ArrayList<>(Arrays.asList("Acero", "Agua", "Electrico", "Fuego")), // Daño a medias
                new ArrayList<>(Arrays.asList("Normal", "Planta", "Hielo", "Lucha", "Veneno", "Tierra", "Volador",
                        "Psiquico", "Bicho", "Fantasma", "Dragon", "Siniestro")), // Daño normal
                new ArrayList<>(Arrays.asList("Hielo", "Roca", "Hada")) // Daño doble
        )));

        // ### Tipo Agua ###
        tablaDeDaños.put("Agua", new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList()), // Inmunes
                new ArrayList<>(Arrays.asList("Agua", "Planta", "Dragon")), // Daño a medias
                new ArrayList<>(Arrays.asList("Normal", "Hielo", "Lucha", "Veneno", "Tierra", "Volador", "Psiquico",
                        "Bicho", "Fantasma", "Siniestro", "Acero")), // Daño normal
                new ArrayList<>(Arrays.asList("Fuego", "Roca", "Tierra")) // Daño doble
        )));

        // ### Tipo Bicho ###
        tablaDeDaños.put("Bicho", new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList()), // Inmunes
                new ArrayList<>(Arrays.asList("Lucha", "Volador", "Veneno", "Fantasma", "Acero", "Fuego", "Hada")), // Daño
                                                                                                                    // a
                                                                                                                    // medias
                new ArrayList<>(Arrays.asList("Normal", "Agua", "Electrico", "Planta", "Hielo", "Tierra", "Psiquico",
                        "Bicho", "Dragon", "Siniestro")), // Daño normal
                new ArrayList<>(Arrays.asList("Planta", "Psiquico", "Siniestro")) // Daño doble
        )));

        // ### Tipo Dragon ###
        tablaDeDaños.put("Dragon", new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("Hada")), // Inmunes
                new ArrayList<>(Arrays.asList("Acero")), // Daño a medias
                new ArrayList<>(Arrays.asList("Normal", "Fuego", "Agua", "Electrico", "Planta", "Hielo", "Lucha",
                        "Veneno", "Tierra", "Volador", "Psiquico", "Bicho", "Fantasma", "Siniestro")), // Daño normal
                new ArrayList<>(Arrays.asList("Dragon")) // Daño doble
        )));

        // ### Tipo Electrico ###
        tablaDeDaños.put("Electrico", new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("Tierra")), // Inmunes
                new ArrayList<>(Arrays.asList("Planta", "Electrico", "Dragon")), // Daño a medias
                new ArrayList<>(Arrays.asList("Normal", "Agua", "Hielo", "Lucha", "Veneno", "Volador", "Psiquico",
                        "Bicho", "Fantasma", "Siniestro", "Acero", "Fuego", "Hada")), // Daño normal
                new ArrayList<>(Arrays.asList("Agua", "Volador")) // Daño doble
        )));

        // ### Tipo Fantasma ###
        tablaDeDaños.put("Fantasma", new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("Normal")), // Inmunes
                new ArrayList<>(Arrays.asList("Siniestro")), // Daño a medias
                new ArrayList<>(Arrays.asList("Fuego", "Agua", "Electrico", "Planta", "Hielo", "Lucha", "Veneno",
                        "Tierra", "Volador", "Psiquico", "Bicho", "Dragon", "Acero", "Hada")), // Daño normal
                new ArrayList<>(Arrays.asList("Fantasma", "Psiquico")) // Daño doble
        )));

        // ### Tipo Fuego ###
        tablaDeDaños.put("Fuego", new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList()), // Inmunes
                new ArrayList<>(Arrays.asList("Fuego", "Agua", "Roca", "Dragon")), // Daño a medias
                new ArrayList<>(Arrays.asList("Normal", "Lucha", "Veneno", "Volador", "Fantasma", "Psiquico", "Bicho",
                        "Siniestro", "Acero", "Hada")), // Daño normal
                new ArrayList<>(Arrays.asList("Planta", "Hielo", "Bicho", "Acero")) // Daño doble
        )));

        // ### Tipo Hielo ###
        tablaDeDaños.put("Hielo", new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList()), // Inmunes
                new ArrayList<>(Arrays.asList("Fuego", "Agua", "Hielo", "Acero")), // Daño a medias
                new ArrayList<>(Arrays.asList("Normal", "Electrico", "Lucha", "Veneno", "Tierra", "Volador", "Psiquico",
                        "Bicho", "Fantasma", "Dragon", "Siniestro", "Hada")), // Daño normal
                new ArrayList<>(Arrays.asList("Planta", "Tierra", "Dragon", "Volador")) // Daño doble
        )));

        // ### Tipo Lucha ###
        tablaDeDaños.put("Lucha", new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("Fantasma")), // Inmunes
                new ArrayList<>(Arrays.asList("Veneno", "Volador", "Psiquico", "Bicho", "Hada")), // Daño a medias
                new ArrayList<>(Arrays.asList("Fuego", "Agua", "Electrico", "Planta", "Hielo", "Tierra", "Lucha",
                        "Dragon", "Siniestro", "Acero")), // Daño normal
                new ArrayList<>(Arrays.asList("Normal", "Hielo", "Roca", "Siniestro", "Acero")) // Daño doble
        )));

        // ### Tipo Normal ###
        tablaDeDaños.put("Normal", new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("Fantasma")), // Inmunes
                new ArrayList<>(Arrays.asList("Roca", "Acero")), // Daño a medias
                new ArrayList<>(Arrays.asList("Fuego", "Agua", "Electrico", "Planta", "Hielo", "Lucha", "Veneno",
                        "Tierra", "Volador", "Psiquico", "Bicho", "Dragon", "Siniestro", "Hada")), // Daño normal
                new ArrayList<>(Arrays.asList()) // Daño doble
        )));

        // ### Tipo Planta (Planta) ###
        tablaDeDaños.put("Planta", new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList()), // Inmunes
                new ArrayList<>(Arrays.asList("Fuego", "Planta", "Veneno", "Volador", "Bicho", "Dragon", "Acero")), // Daño
                                                                                                                    // a
                                                                                                                    // medias
                new ArrayList<>(Arrays.asList("Normal", "Electrico", "Hielo", "Lucha", "Tierra", "Fantasma", "Psiquico",
                        "Siniestro", "Hada")), // Daño normal
                new ArrayList<>(Arrays.asList("Agua", "Tierra", "Roca")) // Daño doble
        )));

        // ### Tipo Psiquico ###
        tablaDeDaños.put("Psiquico", new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("Siniestro")), // Inmunes
                new ArrayList<>(Arrays.asList("Psiquico", "Acero")), // Daño a medias
                new ArrayList<>(Arrays.asList("Normal", "Fuego", "Agua", "Electrico", "Planta", "Hielo", "Lucha",
                        "Veneno", "Tierra", "Volador", "Bicho", "Fantasma", "Dragon", "Hada")), // Daño normal
                new ArrayList<>(Arrays.asList("Lucha", "Veneno")) // Daño doble
        )));

        // ### Tipo Roca ###
        tablaDeDaños.put("Roca", new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList()), // Inmunes
                new ArrayList<>(Arrays.asList("Lucha", "Tierra", "Acero")), // Daño a medias
                new ArrayList<>(Arrays.asList("Fuego", "Agua", "Electrico", "Planta", "Hielo", "Veneno", "Volador",
                        "Psiquico", "Bicho", "Fantasma", "Dragon", "Siniestro", "Hada")), // Daño normal
                new ArrayList<>(Arrays.asList("Fuego", "Hielo", "Volador", "Bicho")) // Daño doble
        )));

        // ### Tipo Siniestro ###
        tablaDeDaños.put("Siniestro", new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList()), // Inmunes
                new ArrayList<>(Arrays.asList("Lucha", "Siniestro", "Hada")), // Daño a medias
                new ArrayList<>(Arrays.asList("Normal", "Fuego", "Agua", "Electrico", "Planta", "Hielo", "Veneno",
                        "Tierra", "Volador", "Bicho", "Acero", "Dragon")), // Daño normal
                new ArrayList<>(Arrays.asList("Psiquico", "Fantasma")) // Daño doble
        )));

        // ### Tipo Tierra ###
        tablaDeDaños.put("Tierra", new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("Volador")), // Inmunes
                new ArrayList<>(Arrays.asList("Planta", "Bicho")), // Daño a medias
                new ArrayList<>(Arrays.asList("Normal", "Agua", "Hielo", "Lucha", "Veneno", "Psiquico", "Fantasma",
                        "Dragon", "Siniestro", "Acero", "Fuego", "Hada")), // Daño normal
                new ArrayList<>(Arrays.asList("Veneno", "Roca", "Acero", "Fuego", "Electrico")) // Daño doble
        )));

        // ### Tipo Veneno ###
        tablaDeDaños.put("Veneno", new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("Acero")), // Inmunes
                new ArrayList<>(Arrays.asList("Veneno", "Tierra", "Roca", "Fantasma")), // Daño a medias
                new ArrayList<>(Arrays.asList("Normal", "Fuego", "Agua", "Electrico", "Hielo", "Lucha", "Volador",
                        "Psiquico", "Bicho", "Dragon", "Siniestro")), // Daño normal
                new ArrayList<>(Arrays.asList("Planta", "Hada")) // Daño doble
        )));

        // ### Tipo Volador ###
        tablaDeDaños.put("Volador", new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList()), // Inmunes
                new ArrayList<>(Arrays.asList("Roca", "Electrico", "Acero")), // Daño a medias
                new ArrayList<>(Arrays.asList("Normal", "Fuego", "Agua", "Planta", "Hielo", "Lucha", "Veneno",
                        "Psiquico", "Fantasma", "Dragon", "Siniestro", "Hada")), // Daño normal
                new ArrayList<>(Arrays.asList("Planta", "Lucha", "Bicho")) // Daño doble
        )));
    }

}
