package src.ctrl_game;

import java.util.ArrayList;

import src.items.Item;
import src.pokemones.Pokemon;

public class Entrenador {
 
    private ArrayList<Item> itemsList = new ArrayList<Item>();
    private ArrayList<Pokemon> pokemonesList= new ArrayList<Pokemon>();

    String name;

    public Entrenador(String name, Pokemon initialPokemon){
        this.name = name;
        if(initialPokemon != null){
            this.pokemonesList.add(initialPokemon);
        }
    }

    // ######## INFORMACION DE ENTRENADOR ########

    // Método para obtener el nombre del entrenador (Jugador)
    public String getName(){
        return name;
    }

    // Método para cambiar el nombre del entrenador (Jugador)
    public void setName(String name){
        this.name = name;
    }



    // ######## ITEMS ########

    // Método para agregar Items
    public void addItem(Item item){
        itemsList.add(item);
    }

    // Método para obtener (lectura/copia) Items
    public Item getItem(int index){
        return itemsList.get(index);
    }

    // Método para obtener (lectura/copia) de los Items del entrenador
    public ArrayList<Item> getItemsList(){
        return itemsList;
    }

    // Método para usar (quitar/pop) Items, regresa el objeto Item a utilizar
    public Item useItem(int index){
        if(itemsList.isEmpty()){
            return null;
        }else{
            return itemsList.remove(index);
        }
    }



    // ######## POKEMONES ########
    
    // Método para capturar (agregar) Pokemones
    public void addPokemon(Pokemon pokemon){
        pokemonesList.add(pokemon);
    }

    // Método para liberar (eliminar) Pokemones, regresa el objeto Pokemon a retirar
    public Pokemon popPokemon(int index){
        if(pokemonesList.isEmpty()){
            return null;
        } else {
            return pokemonesList.remove(index);
        }
    }

    // Método para obtener el primer pokemon de tu lista de pokemones
    public Pokemon getPokemon(){
        if (pokemonesList.isEmpty()){
            System.err.println("No se pudo encontrar un pokemon o que se yo. Estaba vacío.");
            return null;
        } else {
        return pokemonesList.get(0);
        }
    }

    // Método para obtener (lectura/copia) de un pokemon
    public Pokemon getPokemon(int index){
        if (pokemonesList.isEmpty()){
            return null;
        } else {
        return pokemonesList.get(index);
        }
    }

    // Método para obtener (Lectura/copia) de la lista de pokemones
    public ArrayList<Pokemon> getPokemonsList(){
        return pokemonesList;
    }
}