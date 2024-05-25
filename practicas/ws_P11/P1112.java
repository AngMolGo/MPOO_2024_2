
import java.util.Random;

// Clase del Pokémon
class Pokemon {

    private String nombre;
    private int nivel;
    private String tipo;
    private double vida;
    private double velocidad;
    Random r = new Random();

    public Pokemon(String nombre, int nivel, String tipo) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = tipo;
        this.vida = (r.nextDouble() * 5 + 1) * nivel;
        this.velocidad = (r.nextDouble() * 3 + 1) * nivel;
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
        System.out.println("Nivel: " + nivel);
        System.out.println("Tipo: " + tipo);
        System.out.println("Vida: " + vida);
        System.out.println("Velocidad: " + velocidad);
    }
}
// Clase para representar un pokémon de tipo fuego

class PokemonFuego extends Pokemon {

    public PokemonFuego(String nombre, int nivel) {
        super(nombre, nivel, "Fuego");
    }
}

// Clase para representar un pokémon de tipo fuego
class PokemonHierba extends Pokemon {

    public PokemonHierba(String nombre, int nivel) {
        super(nombre, nivel, "Hierba");
    }
}

// Clase para representar la clase padre Ataque
class Ataque {

    private String nombre;
    private String tipo;
    private int potencia;

    public Ataque(String nombre, String tipo, int potencia) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.potencia = potencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPotencia() {
        return potencia;
    }
}

// Clase para representar un ataque de tipo fuego
class AtaqueFuego extends Ataque {

    public AtaqueFuego(String nombre, int potencia) {
        super(nombre, "Fuego", potencia);
    }
}

// Clase para representar un ataque de tipo fuego
class AtaqueHierba extends Ataque {

    public AtaqueHierba(String nombre, int potencia) {
        super(nombre, "Hierba", potencia);
    }
}

// Clase para representar un ataque de tipo normal
class AtaqueNormal extends Ataque {

    public AtaqueNormal(String nombre, int potencia) {
        super(nombre, "Normal", potencia);
    }
}

// Clase para representar un combate
class Combate {

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

public class P1112 {

    public static void main(String[] args) {
        Random r = new Random();

        // Creamos dos pokemon para el combate
        Pokemon charizard = new PokemonFuego("Charizard", 50);
        Pokemon venusaur = new PokemonHierba("Venusaur", 50);

        charizard.imprimirInformacion();
        venusaur.imprimirInformacion();
        System.out.println("--------------");

        // Creamos ataques para los Pokémon
        AtaqueFuego lanzallamas = new AtaqueFuego("Lanzallamas", 50);
        AtaqueHierba hojaAfilada = new AtaqueHierba("Hoja Afilada", 50);
        AtaqueNormal tacleo = new AtaqueNormal("Tacleo", 40);

        // Iniciamos combate
        Combate combate = new Combate();
        while (charizard.getVida() > 0 && venusaur.getVida() > 0) {
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
                System.out.println("\n> ¡" + charizard.getNombre() + " ha sido derrotado!, ¡" + venusaur.getNombre() + " ha ganado! <\n");
            } else if (venusaur.getVida() <= 0){
                System.out.println("\n> ¡" + charizard.getNombre() + " ha sido derrotado!, ¡" + venusaur.getNombre() + " ha ganado! <\n");
            } else {
                System.out.println("------------------");
            }
        }
    }
}
