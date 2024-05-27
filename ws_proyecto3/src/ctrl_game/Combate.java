package src.ctrl_game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
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


            
        
        
        
                if (ataque.getTipo().equals("Fuego") && defensor.getTipo().equals("Hierba")) {
            System.out.println("\t¡Es muy efectivo!");
            double damage = ataque.getPotencia() * 2;
            v -= damage;
            defensor.setVida(v);
            System.out.println("\t" + defensor.getName() + " recibe " + damage + " puntos de daño");

        } else if (ataque.getTipo().equals("Hierba") && defensor.getTipo().equals("Fuego")) {
            System.out.println("\t¡No es muy efectivo!");
            double damage = ataque.getPotencia() * 0.5;
            v -= damage;
            defensor.setVida(v);
            System.out.println("\t" + defensor.getName() + " recibe " + damage + " puntos de daño");

        } else {
            double damage = ataque.getPotencia();
            v -= damage;
            defensor.setVida(v);
            System.out.println("\t" + defensor.getName() + "l recibe " + damage + " puntos de daño");
        }
    }

    public void anunciar_ganador() {
        for (Pokemon poke : player.getPokemonsList()) {
            if (poke.getVida() > 0) {
                System.out.println("¡" + rival.getName() + " ha sido derrotado! ¡" + player.getName() + " ganó la batalla!");
                return;
            }
        }
        System.out.println("¡" + player.getName() + " ha sido derrotado! ¡" + rival.getName() + " ganó la batalla!");
        return;
    }

    public Entrenador quienVaPrimero(){
        if(player.getPokemon().getVelocidad() > rival.getPokemon().getVelocidad()){
            return player;
        } else {
            return rival;
        }
    }

    public Entrenador quienVaSegunds(){
        if(player.getPokemon().getVelocidad() <= rival.getPokemon().getVelocidad()){
            return player;
        } else {
            return rival;
        }
    }


    private void inicializarTablaDeDaños() {
        // ### Tipo Acero ###
        tablaDeDaños.put("Acero", new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList()), // Inmunes
            new ArrayList<>(Arrays.asList("Acero", "Agua", "Eléctrico", "Fuego")), // Daño a medias
            new ArrayList<>(Arrays.asList("Normal", "Hierba", "Hielo", "Lucha", "Veneno", "Tierra", "Volador", "Psíquico", "Bicho", "Fantasma", "Dragón", "Siniestro")), // Daño normal
            new ArrayList<>(Arrays.asList("Hielo", "Roca", "Hada")) // Daño doble
        )));

        // ### Tipo Agua ###
        tablaDeDaños.put("Agua", new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList()), // Inmunes
            new ArrayList<>(Arrays.asList("Agua", "Hierba", "Dragón")), // Daño a medias
            new ArrayList<>(Arrays.asList("Normal", "Hielo", "Lucha", "Veneno", "Tierra", "Volador", "Psíquico", "Bicho", "Fantasma", "Siniestro", "Acero")), // Daño normal
            new ArrayList<>(Arrays.asList("Fuego", "Roca", "Tierra")) // Daño doble
        )));

        // ### Tipo Bicho ###
        tablaDeDaños.put("Bicho", new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList()), // Inmunes
            new ArrayList<>(Arrays.asList("Lucha", "Volador", "Veneno", "Fantasma", "Acero", "Fuego", "Hada")), // Daño a medias
            new ArrayList<>(Arrays.asList("Normal", "Agua", "Eléctrico", "Hierba", "Hielo", "Tierra", "Psíquico", "Bicho", "Dragón", "Siniestro")), // Daño normal
            new ArrayList<>(Arrays.asList("Hierba", "Psíquico", "Siniestro")) // Daño doble
        )));

        // ### Tipo Dragón ###
        tablaDeDaños.put("Dragón", new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("Hada")), // Inmunes
            new ArrayList<>(Arrays.asList("Acero")), // Daño a medias
            new ArrayList<>(Arrays.asList("Normal", "Fuego", "Agua", "Eléctrico", "Hierba", "Hielo", "Lucha", "Veneno", "Tierra", "Volador", "Psíquico", "Bicho", "Fantasma", "Siniestro")), // Daño normal
            new ArrayList<>(Arrays.asList("Dragón")) // Daño doble
        )));

        // ### Tipo Eléctrico ###
        tablaDeDaños.put("Eléctrico", new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("Tierra")), // Inmunes
            new ArrayList<>(Arrays.asList("Hierba", "Eléctrico", "Dragón")), // Daño a medias
            new ArrayList<>(Arrays.asList("Normal", "Agua", "Hielo", "Lucha", "Veneno", "Volador", "Psíquico", "Bicho", "Fantasma", "Siniestro", "Acero", "Fuego", "Hada")), // Daño normal
            new ArrayList<>(Arrays.asList("Agua", "Volador")) // Daño doble
        )));

        // ### Tipo Fantasma ###
        tablaDeDaños.put("Fantasma", new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("Normal")), // Inmunes
            new ArrayList<>(Arrays.asList("Siniestro")), // Daño a medias
            new ArrayList<>(Arrays.asList("Fuego", "Agua", "Eléctrico", "Hierba", "Hielo", "Lucha", "Veneno", "Tierra", "Volador", "Psíquico", "Bicho", "Dragón", "Acero", "Hada")), // Daño normal
            new ArrayList<>(Arrays.asList("Fantasma", "Psíquico")) // Daño doble
        )));

        // ### Tipo Fuego ###
        tablaDeDaños.put("Fuego", new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList()), // Inmunes
            new ArrayList<>(Arrays.asList("Fuego", "Agua", "Roca", "Dragón")), // Daño a medias
            new ArrayList<>(Arrays.asList("Normal", "Lucha", "Veneno", "Volador", "Fantasma", "Psíquico", "Bicho", "Siniestro", "Acero", "Hada")), // Daño normal
            new ArrayList<>(Arrays.asList("Hierba", "Hielo", "Bicho", "Acero")) // Daño doble
        )));

        // ### Tipo Hielo ###
        tablaDeDaños.put("Hielo", new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList()), // Inmunes
            new ArrayList<>(Arrays.asList("Fuego", "Agua", "Hielo", "Acero")), // Daño a medias
            new ArrayList<>(Arrays.asList("Normal", "Eléctrico", "Lucha", "Veneno", "Tierra", "Volador", "Psíquico", "Bicho", "Fantasma", "Dragón", "Siniestro", "Hada")), // Daño normal
            new ArrayList<>(Arrays.asList("Hierba", "Tierra", "Dragón", "Volador")) // Daño doble
        )));

        // ### Tipo Lucha ###
        tablaDeDaños.put("Lucha", new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("Fantasma")), // Inmunes
            new ArrayList<>(Arrays.asList("Veneno", "Volador", "Psíquico", "Bicho", "Hada")), // Daño a medias
            new ArrayList<>(Arrays.asList("Fuego", "Agua", "Eléctrico", "Hierba", "Hielo", "Tierra", "Lucha", "Dragón", "Siniestro", "Acero")), // Daño normal
            new ArrayList<>(Arrays.asList("Normal", "Hielo", "Roca", "Siniestro", "Acero")) // Daño doble
        )));

        // ### Tipo Normal ###
        tablaDeDaños.put("Normal", new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("Fantasma")), // Inmunes
            new ArrayList<>(Arrays.asList("Roca", "Acero")), // Daño a medias
            new ArrayList<>(Arrays.asList("Fuego", "Agua", "Eléctrico", "Hierba", "Hielo", "Lucha", "Veneno", "Tierra", "Volador", "Psíquico", "Bicho", "Dragón", "Siniestro", "Hada")), // Daño normal
            new ArrayList<>(Arrays.asList()) // Daño doble
        )));

        // ### Tipo Planta (Hierba) ###
        tablaDeDaños.put("Hierba", new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList()), // Inmunes
            new ArrayList<>(Arrays.asList("Fuego", "Hierba", "Veneno", "Volador", "Bicho", "Dragón", "Acero")), // Daño a medias
            new ArrayList<>(Arrays.asList("Normal", "Eléctrico", "Hielo", "Lucha", "Tierra", "Fantasma", "Psíquico", "Siniestro", "Hada")), // Daño normal
            new ArrayList<>(Arrays.asList("Agua", "Tierra", "Roca")) // Daño doble
        )));

        // ### Tipo Psíquico ###
        tablaDeDaños.put("Psíquico", new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("Siniestro")), // Inmunes
            new ArrayList<>(Arrays.asList("Psíquico", "Acero")), // Daño a medias
            new ArrayList<>(Arrays.asList("Normal", "Fuego", "Agua", "Eléctrico", "Hierba", "Hielo", "Lucha", "Veneno", "Tierra", "Volador", "Bicho", "Fantasma", "Dragón", "Hada")), // Daño normal
            new ArrayList<>(Arrays.asList("Lucha", "Veneno")) // Daño doble
        )));

        // ### Tipo Roca ###
        tablaDeDaños.put("Roca", new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList()), // Inmunes
            new ArrayList<>(Arrays.asList("Lucha", "Tierra", "Acero")), // Daño a medias
            new ArrayList<>(Arrays.asList("Fuego", "Agua", "Eléctrico", "Hierba", "Hielo", "Veneno", "Volador", "Psíquico", "Bicho", "Fantasma", "Dragón", "Siniestro", "Hada")), // Daño normal
            new ArrayList<>(Arrays.asList("Fuego", "Hielo", "Volador", "Bicho")) // Daño doble
        )));

        // ### Tipo Siniestro ###
        tablaDeDaños.put("Siniestro", new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList()), // Inmunes
            new ArrayList<>(Arrays.asList("Lucha", "Siniestro", "Hada")), // Daño a medias
            new ArrayList<>(Arrays.asList("Normal", "Fuego", "Agua", "Eléctrico", "Hierba", "Hielo", "Veneno", "Tierra", "Volador", "Bicho", "Acero", "Dragón")), // Daño normal
            new ArrayList<>(Arrays.asList("Psíquico", "Fantasma")) // Daño doble
        )));

        // ### Tipo Tierra ###
        tablaDeDaños.put("Tierra", new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("Volador")), // Inmunes
            new ArrayList<>(Arrays.asList("Hierba", "Bicho")), // Daño a medias
            new ArrayList<>(Arrays.asList("Normal", "Agua", "Hielo", "Lucha", "Veneno", "Psíquico", "Fantasma", "Dragón", "Siniestro", "Acero", "Fuego", "Hada")), // Daño normal
            new ArrayList<>(Arrays.asList("Veneno", "Roca", "Acero", "Fuego", "Eléctrico")) // Daño doble
        )));

        // ### Tipo Veneno ###
        tablaDeDaños.put("Veneno", new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("Acero")), // Inmunes
            new ArrayList<>(Arrays.asList("Veneno", "Tierra", "Roca", "Fantasma")), // Daño a medias
            new ArrayList<>(Arrays.asList("Normal", "Fuego", "Agua", "Eléctrico", "Hielo", "Lucha", "Volador", "Psíquico", "Bicho", "Dragón", "Siniestro")), // Daño normal
            new ArrayList<>(Arrays.asList("Hierba", "Hada")) // Daño doble
        )));

        // ### Tipo Volador ###
        tablaDeDaños.put("Volador", new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList()), // Inmunes
            new ArrayList<>(Arrays.asList("Roca", "Eléctrico", "Acero")), // Daño a medias
            new ArrayList<>(Arrays.asList("Normal", "Fuego", "Agua", "Hierba", "Hielo", "Lucha", "Veneno", "Psíquico", "Fantasma", "Dragón", "Siniestro", "Hada")), // Daño normal
            new ArrayList<>(Arrays.asList("Hierba", "Lucha", "Bicho")) // Daño doble
        )));
    }

    
    
}
