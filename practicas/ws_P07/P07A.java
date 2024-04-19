// Clase Padre
class Vehiculo {
    public void conducir(){
        System.out.println("El vehículo está en operación...");
    }
}


// Clase hija carro
class Carro extends Vehiculo{
    @Override
    public void conducir(){
        System.out.println("Estoy avanzando entre carretera...");
    }
}

// Clase hija carro
class Avion extends Vehiculo{
    @Override
    public void conducir(){
        System.out.println("Estoy avanzando por el cielo...");
    }
}

// Clase principal
// Clase que tiene método main
public class P07A{
    public static void main(String[] args){

        System.out.println("\n######### P07A ###########\n");

        Vehiculo v = new Vehiculo();
        Carro c = new Carro();
        Avion a = new Avion();

        v.conducir();
        c.conducir();
        a.conducir();

        System.out.println("");
    }
}