//Clase abstracta vehículo
abstract class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;
    private String tipoCombustible;
    private double eficiencia;

    public Vehiculo(String marca, String modelo, int anio, String tc, double e){
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.tipoCombustible = tc;
        this.eficiencia = e;
    }

    public String getMarca(){
        return marca;
    }

    public String getModelo(){
        return modelo;
    }

    public int getAnio(){
        return anio;
    }

    public String getTipoC(){
        return tipoCombustible;
    }

    public double getEficiencia(){
        return eficiencia;
    }

    public abstract double calculoEficiencia();
    public abstract double calculoDistanciaR();
    public abstract double getVelocidadMax();
}

//Clase derivada trailer
class Trailer extends Vehiculo{
    private double capacidadCarga;

    public Trailer(String marca, String modelo, int anio, String tc, double e, double c){
        super(marca, modelo, anio, tc, e);
        this.capacidadCarga = c;
    }

    public double getCapacidadCarga(){
        return capacidadCarga;
    }

    @Override
    public double calculoEficiencia(){
        return getEficiencia() * (1.0 / (1.0 + (getCapacidadCarga() / 1000.0)));
    }

    @Override
    public double calculoDistanciaR(){
        return calculoEficiencia() * getEficiencia();
    }

    @Override
    public double getVelocidadMax(){
        return 80.0;
    }
}

//Clase derivada carro
class Carro extends Vehiculo{
    private int numAsientos;

    public Carro(String marca, String modelo, int anio, String tc, double e, int na){
        super(marca, modelo, anio, tc, e);
        this.numAsientos = na;
    }

    public int getAsientos(){
        return numAsientos;
    }

    @Override
    public double calculoEficiencia(){
        return getEficiencia() * (1.0 / (1.0 + (getAsientos() / 5.0)));
    }

    @Override
    public double calculoDistanciaR(){
        return calculoEficiencia() * getEficiencia();
    }

    @Override
    public double getVelocidadMax(){
        return 130.0;
    }
}

//Clase derivada motocicleta
class Moto extends Vehiculo{
    private double cilindraje;

    public Moto(String marca, String modelo, int anio, String tc, double e, double c){
        super(marca, modelo, anio, tc, e);
        this.cilindraje = c;
    }

    public double getCilindraje(){
        return cilindraje;
    }

    @Override
    public double calculoEficiencia(){
        return getEficiencia() * (1.0 / (1.0 + (getCilindraje() / 1000.0)));
    }

    @Override
    public double calculoDistanciaR(){
        return calculoEficiencia() * getEficiencia();
    }

    @Override
    public double getVelocidadMax(){
        return 80.0;
    }
}

/**
 * Clase principal
 */
public class P08B {
    public static void main(String[] args) {
        //Se crean objetos de cada vehículo
        Trailer t = new Trailer("Tatra", "810 4x", 2020, "DIESEL", 8.112, 4.5);
        Carro c = new Carro("Volkswagen", "Virtus", 2023, "HÍBRIDO", 6.123, 8);
        Moto m = new Moto("Honda", "CR600", 2023, "GASOLINA", 2.1, 5);

        System.out.println("Datos del trailer:");
        System.out.println("Modelo: " + t.getModelo());
        System.out.println("Eficiencia de Combustible: " + t.calculoEficiencia());
        System.out.println("Distancia recorrida: " + t.calculoDistanciaR());
        System.out.println("Velocidad Maxima: " + t.getVelocidadMax());
        System.out.println();
        System.out.println("Datos del carro:");
        System.out.println("Modelo: " + c.getModelo());
        System.out.println("Eficiencia de Combustible: " + c.calculoEficiencia());
        System.out.println("Distancia recorrida: " + c.calculoDistanciaR());
        System.out.println("Velocidad Maxima: " + c.getVelocidadMax());
        System.out.println();
        System.out.println("Datos de la moto:");
        System.out.println("Modelo: " + m.getModelo());
        System.out.println("Eficiencia de Combustible: " + m.calculoEficiencia());
        System.out.println("Distancia recorrida: " + m.calculoDistanciaR());
        System.out.println("Velocidad Maxima: " + m.getVelocidadMax());
    }
}