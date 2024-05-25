package src.ctrl_game;

import java.util.ArrayList;

import src.items.Item;
import src.pokemones.Pokemon;

public class Entrenador {
 
    private ArrayList<Item> itemsList;
    private ArrayList<Pokemon> pokemonesList;

    String name;

    public Entrenador(String name){
        this.name = name;
    }

    // Método para obtener el nombre del entrenador
    public String getName(){
        return name;
    }

    // Método para cambiar el nombre del entrenador
    public void setName(String name){
        this.name = name;
    }

    // Método para agregar Items
    public void addItem(Item item){
        itemsList.add(item);
    }

    // Método para usar (quitar) Items, regresa el objeto Item a utilizar
    public Item useItem(int index){
        if(itemsList.isEmpty()){
            return null;
        }else{
            return itemsList.remove(index);
        }
    }

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

}