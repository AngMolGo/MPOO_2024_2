// Clase abstracta Vehiculo

abstract class Vehiculo {
    public abstract void iniciaMotor();
    public abstract void detieneMotor();
}

// Clase derivada Carro
class Carro extends Vehiculo{
    @Override
    public void iniciaMotor(){
        System.out.println("El carro se ha arrancado con la llave.");
    }

    @Override
    public void detieneMotor(){
        System.out.println("El carro se ha detenido y se gira la llave para terminar marcha.");
    }
}

// Clase derivada Motocicleta
class Moto extends Vehiculo{
    @Override
    public void iniciaMotor(){
        System.out.println("El motor de la moto se ha iniciado con patada inicial en pedal.");
    }

    @Override
    public void detieneMotor(){
        System.out.println("El motor de la moto se ha detenido cuando la ignición se apaga");
    }
}

// Clase principal

public class P10A{
    public static void main(String[] args){
        Vehiculo auto = new Carro();
        Vehiculo motito = new Moto();

        iniciaYDetieneMotor(auto);
        iniciaYDetieneMotor(motito);
        System.out.println("");
    }

    public static void iniciaYDetieneMotor(Vehiculo v){
        System.out.println("");
        v.iniciaMotor();
        v.detieneMotor();
    }
}