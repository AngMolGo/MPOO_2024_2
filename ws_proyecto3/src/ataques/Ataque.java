package src.ataques;

// Clase para representar la clase padre Ataque
public class Ataque {

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