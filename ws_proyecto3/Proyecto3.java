import src.ataques.*;
import src.pokemones.*;
import src.ctrl_game.*;

import java.util.ArrayList;
import java.util.Random;

public class Proyecto3 {

    static private ArrayList<Pokemon> pokemonesList = new ArrayList<Pokemon>();

    static private void generarPokemones() {
        AtaqueNormal ataqueNormal_ = new AtaqueNormal("Tacleo", 50);
        
        // ### Pokemon Normal ###
        PokemonNormal pokemonNormal = new PokemonNormal("Eevee", 50);
        pokemonNormal.addAtaque(ataqueNormal_);
        pokemonNormal.addAtaque(new AtaqueNormal("Golpe", 40));
        pokemonNormal.addAtaque(new AtaqueNormal("Ataque Rápido", 30));
        pokemonesList.add(pokemonNormal);
        
        // ### Pokemon Acero ###
        PokemonAcero pokemonAcero = new PokemonAcero("Steelix", 50);
        pokemonAcero.addAtaque(ataqueNormal_);
        pokemonAcero.addAtaque(new AtaqueAcero("Cola Férrea", 100));
        pokemonAcero.addAtaque(new AtaqueAcero("Garra Metal", 50));
        pokemonesList.add(pokemonAcero);

        // ### Pokemon Agua ###
        PokemonAgua pokemonAgua = new PokemonAgua("Blastoise", 50);
        pokemonAgua.addAtaque(ataqueNormal_);
        pokemonAgua.addAtaque(new AtaqueAgua("Hidrobomba", 110));
        pokemonAgua.addAtaque(new AtaqueAgua("Pistola Agua", 40));
        pokemonesList.add(pokemonAgua);

        // ### Pokemon Bicho ###
        PokemonBicho pokemonBicho = new PokemonBicho("Butterfree", 50);
        pokemonBicho.addAtaque(ataqueNormal_);
        pokemonBicho.addAtaque(new AtaqueBicho("Picadura", 60));
        pokemonBicho.addAtaque(new AtaqueBicho("Zumbido", 90));
        pokemonesList.add(pokemonBicho);

        // ### Pokemon Dragón ###
        PokemonDragon pokemonDragon = new PokemonDragon("Dragonite", 50);
        pokemonDragon.addAtaque(ataqueNormal_);
        pokemonDragon.addAtaque(new AtaqueDragon("Garra Dragón", 80));
        pokemonDragon.addAtaque(new AtaqueDragon("Enfado", 120));
        pokemonesList.add(pokemonDragon);

        // ### Pokemon Eléctrico ###
        PokemonElectrico pokemonElectrico = new PokemonElectrico("Pikachu", 50);
        pokemonElectrico.addAtaque(ataqueNormal_);
        pokemonElectrico.addAtaque(new AtaqueElectrico("Impactrueno", 40));
        pokemonElectrico.addAtaque(new AtaqueElectrico("Rayo", 90));
        pokemonesList.add(pokemonElectrico);

        // ### Pokemon Fantasma ###
        PokemonFantasma pokemonFantasma = new PokemonFantasma("Gengar", 50);
        pokemonFantasma.addAtaque(ataqueNormal_);
        pokemonFantasma.addAtaque(new AtaqueFantasma("Bola Sombra", 80));
        pokemonFantasma.addAtaque(new AtaqueFantasma("Tinieblas", 100));
        pokemonesList.add(pokemonFantasma);

        // ### Pokemon Fuego ###
        PokemonFuego pokemonFuego = new PokemonFuego("Charizard", 50);
        pokemonFuego.addAtaque(ataqueNormal_);
        pokemonFuego.addAtaque(new AtaqueFuego("Llamarada", 110));
        pokemonFuego.addAtaque(new AtaqueFuego("Ascuas", 40));
        pokemonesList.add(pokemonFuego);

        // ### Pokemon Hielo ###
        PokemonHielo pokemonHielo = new PokemonHielo("Lapras", 50);
        pokemonHielo.addAtaque(ataqueNormal_);
        pokemonHielo.addAtaque(new AtaqueHielo("Rayo Hielo", 90));
        pokemonHielo.addAtaque(new AtaqueHielo("Viento Hielo", 55));
        pokemonesList.add(pokemonHielo);

        // ### Pokemon Lucha ###
        PokemonLucha pokemonLucha = new PokemonLucha("Machamp", 50);
        pokemonLucha.addAtaque(ataqueNormal_);
        pokemonLucha.addAtaque(new AtaqueLucha("Golpe Karate", 50));
        pokemonLucha.addAtaque(new AtaqueLucha("A Bocajarro", 120));
        pokemonesList.add(pokemonLucha);

        // ### Pokemon Planta ###
        PokemonPlanta pokemonPlanta = new PokemonPlanta("Venusaur", 50);
        pokemonPlanta.addAtaque(ataqueNormal_);
        pokemonPlanta.addAtaque(new AtaquePlanta("Latigazo", 45));
        pokemonPlanta.addAtaque(new AtaquePlanta("Rayo Solar", 120));
        pokemonesList.add(pokemonPlanta);

        // ### Pokemon Psíquico ###
        PokemonPsiquico pokemonPsiquico = new PokemonPsiquico("Alakazam", 50);
        pokemonPsiquico.addAtaque(ataqueNormal_);
        pokemonPsiquico.addAtaque(new AtaquePsiquico("Confusión", 50));
        pokemonPsiquico.addAtaque(new AtaquePsiquico("Psicorrayo", 65));
        pokemonesList.add(pokemonPsiquico);

        // ### Pokemon Roca ###
        PokemonRoca pokemonRoca = new PokemonRoca("Onix", 50);
        pokemonRoca.addAtaque(ataqueNormal_);
        pokemonRoca.addAtaque(new AtaqueRoca("Avalancha", 75));
        pokemonRoca.addAtaque(new AtaqueRoca("Roca Afilada", 100));
        pokemonesList.add(pokemonRoca);

        // ### Pokemon Siniestro ###
        PokemonSiniestro pokemonSiniestro = new PokemonSiniestro("Umbreon", 50);
        pokemonSiniestro.addAtaque(ataqueNormal_);
        pokemonSiniestro.addAtaque(new AtaqueSiniestro("Triturar", 80));
        pokemonSiniestro.addAtaque(new AtaqueSiniestro("Pulso Umbrío", 80));
        pokemonesList.add(pokemonSiniestro);

        // ### Pokemon Tierra ###
        PokemonTierra pokemonTierra = new PokemonTierra("Groudon", 50);
        pokemonTierra.addAtaque(ataqueNormal_);
        pokemonTierra.addAtaque(new AtaqueTierra("Terremoto", 100));
        pokemonTierra.addAtaque(new AtaqueTierra("Fisura", 150));
        pokemonesList.add(pokemonTierra);

        // ### Pokemon Veneno ###
        PokemonVeneno pokemonVeneno = new PokemonVeneno("Muk", 50);
        pokemonVeneno.addAtaque(ataqueNormal_);
        pokemonVeneno.addAtaque(new AtaqueVeneno("Ácido", 40));
        pokemonVeneno.addAtaque(new AtaqueVeneno("Bomba Lodo", 90));
        pokemonesList.add(pokemonVeneno);

        // ### Pokemon Volador ###
        PokemonVolador pokemonVolador = new PokemonVolador("Pidgeot", 50);
        pokemonVolador.addAtaque(ataqueNormal_);
        pokemonVolador.addAtaque(new AtaqueVolador("Ataque Aéreo", 60));
        pokemonVolador.addAtaque(new AtaqueVolador("Tornado", 40));
        pokemonesList.add(pokemonVolador);
    }

    public static void main(String[] args) {

        generarPokemones();
        for(Pokemon pokemon : pokemonesList){
            System.out.println("----------------------------");
            pokemon.imprimirInformacion();
        }


    }

    static public void combateDePrueba() {

        Random r = new Random();

        // Creamos dos pokemon para el combate
        Pokemon charizard = new PokemonFuego("Charizard", 50);
        Pokemon venusaur = new PokemonPlanta("Venusaur", 50);
        charizard.imprimirInformacion();
        venusaur.imprimirInformacion();
        System.out.println("--------------");

        // Creamos ataques para los Pokémon
        //AtaqueFuego lanzallamas = new AtaqueFuego("Lanzallamas", 50);
        //AtaquePlanta hojaAfilada = new AtaquePlanta("Hoja Afilada", 50);
        AtaqueNormal tacleo = new AtaqueNormal("Tacleo", 40);

        // Iniciamos combate
        Combate combate = new Combate();
        while (charizard.getVida() > 0 && venusaur.getVida() > 0) {

            System.out.println("Selecciona una opción");

            int velocidadIgual = r.nextInt(2);
            if (charizard.getVelocidad() > venusaur.getVelocidad()) {
                combate.atacar(charizard, venusaur, tacleo);
                if (venusaur.getVida() <= 0) {
                    System.out.println("¡" + venusaur.getNombre() + " se ha desmayado!");
                } else {
                    combate.atacar(venusaur, charizard, tacleo);
                }
            } else if (venusaur.getVelocidad() > charizard.getVelocidad()) {
                combate.atacar(venusaur, charizard, tacleo);
                if (charizard.getVida() <= 0) {
                    System.out.println("¡" + charizard.getNombre() + " se ha desmayado!");
                } else {
                    combate.atacar(charizard, venusaur, tacleo);
                }
            } else {
                if (velocidadIgual == 0) {
                    combate.atacar(charizard, venusaur, tacleo);
                    if (venusaur.getVida() <= 0) {
                        System.out.println("¡" + venusaur.getNombre() + " se ha desmayado!");
                    } else {
                        combate.atacar(venusaur, charizard, tacleo);
                    }
                } else {
                    combate.atacar(venusaur, charizard, tacleo);
                    if (charizard.getVida() <= 0) {
                        System.out.println("¡" + charizard.getNombre() + " se ha desmayado!");
                    } else {
                        combate.atacar(charizard, venusaur, tacleo);
                    }
                }
            }
            if (charizard.getVida() <= 0) {
                System.out.println("\n> ¡" + charizard.getNombre() + " ha sido derrotado!, ¡" + venusaur.getNombre()
                        + " ha ganado! <\n");
            } else if (venusaur.getVida() <= 0) {
                System.out.println("\n> ¡" + charizard.getNombre() + " ha sido derrotado!, ¡" + venusaur.getNombre()
                        + " ha ganado! <\n");
            } else {
                System.out.println("------------------");
            }
        }
    }
}