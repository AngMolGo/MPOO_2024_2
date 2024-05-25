package src.pokemones;

import java.util.ArrayList;
import java.util.Random;

import src.ataques.Ataque;
import src.habilidades.Habilidad;

// Clase del Pokémon
public class Pokemon {

    private String name;
    private int nivel;
    private String tipo;
    private double vida;
    private double velocidad;
    private String estado_salud;
    private ArrayList<Ataque> ataquesList = new ArrayList<Ataque>();
    private ArrayList<Habilidad> habilidadesList = new ArrayList<Habilidad>();

    Random r = new Random();

    public Pokemon(String name, int nivel, String tipo) {
        this.name = name;
        this.nivel = nivel;
        this.tipo = tipo;
        this.vida = (r.nextDouble() * 5 + 1) * nivel;
        this.velocidad = (r.nextDouble() * 3 + 1) * nivel;
        this.estado_salud = "sano";
    }

    // ########### INFORMACION GENERAL ###########

    // Método para imprimir la información general del pokemon
    public void imprimirInformacion() {
        System.out.println("Nombre: " + name);
        System.out.println(" > Nivel: " + nivel);
        System.out.println(" > Tipo: " + tipo);
        System.out.println(" > Vida: " + vida);
        System.out.println(" > Velocidad: " + velocidad);
        for (int i = 0; i < ataquesList.size(); i++) {
            System.out.println(" > Ataque #" + (i + 1) + ": " + ataquesList.get(i).getNombre() + " ["
                    + ataquesList.get(i).getTipo() + "]");
        }
    }

    // Método para obtener nombre
    public String getName() {
        return name;
    }

    // Método para cambiar nombre
    public void setName(String name) {
        this.name = name;
    }

    // Método para obtener el nivel del pokemon
    public int getNivel() {
        return nivel;
    }

    // Método para cambiar (subir de nivel) el nivel del pokemon
    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    // Método para obtener el tipo de pokemon
    public String getTipo() {
        return tipo;
    }

    // Método para obtener el nivel de vida del pokemon
    public double getVida() {
        return vida;
    }

    // Método para cambiar el nivel de vida del pokemon
    public void setVida(double v) {
        this.vida = v;
    }

    // Método para obtener la velocidad del pokemon
    public double getVelocidad() {
        return velocidad;
    }

    // Método para cambiar la velocidad del pokemon
    public void setVelocidad(double velocidad){
        this.velocidad = velocidad;
    }

    // Método para obtener el estado de salud del pokemon
    public String getEstadoSalud() {
        return estado_salud;
    }

    // Método para cambiar el estado de saluda del pokemon
    public void setEstadoSalud() {

    }



    // ########### ATAQUES ###########

    // Método para agregar (aprender) un ataque nuevo
    public void addAtaque(Ataque ataque) {
        ataquesList.add(ataque);
    }

    // Método para obtener (lectura/copiar) un ataque
    public Ataque getAtaque(int index){
        return ataquesList.get(index);
    }

    // Método para obtener (lectura/copia) la lista de ataques del pokemon
    public ArrayList<Ataque> getAtaquesList(){
        return ataquesList;
    }

    // Método para obtener un ataque al azar
    public Ataque getAtaqueRandom(){
        Random r = new Random();
        if(ataquesList.isEmpty()){
            return null;
        }else{
            Ataque ataqueRandom = ataquesList.get(r.nextInt(ataquesList.size()-1));
            return ataqueRandom;
        }
    }

    // ########### HABILIDADES ###########

    // Método para agregar (aprender) un ataque nuevo
    public void addHabilidad(Habilidad habilidad) {
        habilidadesList.add(habilidad);
    }

    // Método para obtener (lectura/copia) una habilidad del pokemon
    public Habilidad getHabilidad(int index){
        return habilidadesList.get(index);
    }

    // Método para obtener (lectura/copia) la lista de habilidades del pokemon
    public ArrayList<Habilidad> getHabilidadesList(){
        return habilidadesList;
    }

}