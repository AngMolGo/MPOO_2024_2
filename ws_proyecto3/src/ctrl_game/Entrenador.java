package src.ctrl_game;

import java.util.ArrayList;

import src.items.CuraTotal;
import src.items.Item;
import src.items.Posion;
import src.pokemones.Pokemon;

public class Entrenador {
 
    private ArrayList<Item> itemsList = new ArrayList<Item>();
    private ArrayList<Pokemon> pokemonesList= new ArrayList<Pokemon>();
    private ArrayList<Integer> listAcciones = new ArrayList<Integer>();

    String name;

    public Entrenador(String name, Pokemon initialPokemon){
        this.name = name;
        if(initialPokemon != null){
            this.pokemonesList.add(initialPokemon);
        }
        itemsList.add(new Posion("Posion", "Incrementa la salud"));
        itemsList.add(new CuraTotal("Cura total", "Cura la salud del pokemon al 100%"));
        listAcciones.clear();
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
            System.out.println("\n> Se usó " + itemsList.get(index-1).getName());
            if(itemsList.get(index-1).getName() == "Cura total"){
                pokemonesList.get(0).setVida(pokemonesList.get(0).getVida_max());
                System.out.println("* Se incrementó toda la vida del pokemon");
            }
            else{
                if(itemsList.get(index-1).getName() == "Posion"){
                    pokemonesList.get(0).setVida(pokemonesList.get(0).getVida() + 20);
                    if(pokemonesList.get(0).getVida() > pokemonesList.get(0).getVida_max()){
                        pokemonesList.get(0).setVida(pokemonesList.get(0).getVida_max());
                    }
                    System.out.println("* Se incrementó 20 puntos de salud");
                }
            }
            return itemsList.remove(index-1);
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

    public void setAcciones(ArrayList<Integer> acciones){
        this.listAcciones = acciones;
    }

    public ArrayList<Integer> getAcciones(){
        return listAcciones;
    }
}