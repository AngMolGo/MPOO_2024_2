import java.util.Scanner;

public class P2{

    // Auxiliares
    String nombre, raza, duenio;
    int edad;

    // Clase Perro
    public P2(String nombre, String raza, int edad, String duenio){
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.duenio = duenio;
    }

    public String getNombre(){
        return nombre;
    }

    public String getRaza(){
        return raza;
    }

    public String getDuenio(){
        return duenio;
    }

    public int getEdad(){
        return edad;
    }

    @Override
    public String toString(){
        return("\nLos datos del perro son:" +
        "\n\tNombre: " + getNombre() +
        "\n\tEdad: " + getEdad() +
        "\n\tRaza:" + getRaza() +
        "\n\tDuenio:" + getDuenio());
    }

    public static void main(String[] args){
        System.out.println("\t###############\n"+ "\t# Práctica 02 #\n" + "\t###############\n");

        String _nombre, _raza, _duenio;
        int _edad;
        Scanner myObj = new Scanner(System.in);        

        for(int i = 0; i<3; i++){
            System.out.print("\nIngresa el nombre del perrito: "); _nombre = myObj.nextLine();
            //System.out.print("\nEl nombre fue: " + _nombre);
            System.out.print("\nIngresa la edad del perrito: "); _edad = Integer.valueOf(myObj.nextLine());
            //System.out.print("\nLa edad fue: " + _edad);
            System.out.print("\nIngresa la raza del perrito: "); _raza = myObj.nextLine();
            //System.out.print("\nLa raza fue: " + _raza);
            System.out.print("\nIngresa el nombre del dueño del perrito: "); _duenio = myObj.nextLine();
            //System.out.print("\nEl duenio fue: " + _duenio);
            //myObj.close();
            P2 perro = new P2(_nombre, _raza, _edad, _duenio);
            System.out.println(perro.toString());
        }
    }
}