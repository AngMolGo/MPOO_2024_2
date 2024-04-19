import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Estudiante{
    private int id;
    private String nombre;
    private List < Double > calificaciones;

    public int getID(){
        return id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public List < Double > getCalificaciones(){
        return calificaciones;
    }

    public void agregarCalificacion(Double c){
        if(calificaciones == null){
            calificaciones = new ArrayList< >();
        }
        calificaciones.add(c);
    }
}

public class P09{
    public static void main(String[] args){

        System.out.println("\n######### P09 #########\n");

        Scanner e_int = new Scanner(System.in);
        Scanner e_double = new Scanner(System.in);
        Scanner e_string = new Scanner(System.in);

        Estudiante e = new Estudiante();

        // Definimos valores usando los métodos set
        System.out.print("Ingresa ID: ");
        int in_idEstudiante = e_int.nextInt();
        e.setID(in_idEstudiante);

        System.out.print("Ingresa nombre: ");
        String in_nombreEstudiante = e_string.nextLine();
        e.setNombre(in_nombreEstudiante);

        // Agregamos calificaciones con el método agregaCalificacion
        Double in_calif = 0.0;
        for(int i = 1; i<=5;){
            System.out.print("Ingresa la calificación #" + i + ": ");
            in_calif = e_double.nextDouble();
            if(in_calif <= 10.0 && in_calif >= 0.0){
                if(in_calif < 5.0){
                    in_calif = 5.0;
                }
                e.agregarCalificacion(in_calif);
                i++;
            }else{
                System.out.println("No es un valor correcto. Intente de nuevo.");
            }
            
        }

        // Obtenemos valores usando los métodos get
        int idEstudiante = e.getID();
        String nombreEstudiante = e.getNombre();
        List <Double> calif = e.getCalificaciones();

        // Mostramos los valores
        System.out.println();
        System.out.println("ID de estudiante: " + idEstudiante);
        System.out.println("Nombre de estudiante: " + nombreEstudiante);
        System.out.println("Calificaciones de estudiante: " + calif);
        System.out.println();
    }
}