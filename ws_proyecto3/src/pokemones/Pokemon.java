package src.pokemones;

import java.util.ArrayList;
import java.util.Random;

import src.ataques.Ataque;

// Clase del Pokémon
public class Pokemon {

    private String nombre;
    private int nivel;
    private String tipo;
    private double vida;
    private double velocidad;
    private String estado_salud;
    private ArrayList<Ataque> ataquesList = new ArrayList<Ataque>();

    Random r = new Random();

    public Pokemon(String nombre, int nivel, String tipo) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = tipo;
        this.vida = (r.nextDouble() * 5 + 1) * nivel;
        this.velocidad = (r.nextDouble() * 3 + 1) * nivel;
        this.estado_salud = "sano";
    }

    public void addAtaque(Ataque ataque){
        ataquesList.add(ataque);
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public String getTipo() {
        return tipo;
    }

    public double getVida() {
        return vida;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVida(double v) {
        this.vida = v;
    }

    public void imprimirInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println(" > Nivel: " + nivel);
        System.out.println(" > Tipo: " + tipo);
        System.out.println(" > Vida: " + vida);
        System.out.println(" > Velocidad: " + velocidad);
        for(int i = 0; i < ataquesList.size(); i++){
            System.out.println(" > Ataque #" + (i+1) + ": " + ataquesList.get(i).getNombre() + " [" + ataquesList.get(i).getTipo() + "]");
        }
    }

    public void setEstadoSalud(){

    }

    public String getEstadoSalud(){
        return estado_salud;
    }
}