// Clase padre empleado
class Empleado{
    private int salario;

    public Empleado(int salario){
        this.salario = salario;
    }

    public void trabajar(){
        System.out.println("Estoy trabajando como empleado.");
    }

    public int getSalario(){
        return salario;
    }
}

// Clase hija Ingeniero
class Ingeniebrio extends Empleado{
    public Ingeniebrio(int salario){
        super(salario);
    }

    @Override
    public void trabajar(){
        System.out.println("Mi trabajo es resolver problemas.");
    }

    public void tipoIngeniero(){
        System.out.println("Soy un ing. eléctrico electrónico.");
    }
}

class RH extends Empleado{
    public RH(int salario){
        super(salario);
    }

    @Override
    public void trabajar(){
        System.out.println("Administro contrataciones y empleados.");
    }

    public void agregaEmpleado(){
        System.out.println("Contraté a un ingeniero.");
    }
}

// Clase principal
// Clase que tiene método main
public class P07C{
    public static void main(String[] args){
        System.out.println("\n######### P07C ###########\n");
        
        Empleado e = new Empleado(8000);
        
        Ingeniebrio i = new Ingeniebrio(30000);

        RH rh = new RH(20000);

        e.trabajar();
        System.out.println("Por lanzarse por las cocas gana: " + e.getSalario());
        System.out.println("");

        i.trabajar();
        System.out.println("Por generar ansiedad y producir cara chueca gana: " + i.getSalario());
        i.tipoIngeniero();
        System.out.println("");

        rh.trabajar();
        System.out.println("Por fingir que trabajo gano: " + rh.getSalario());
        rh.agregaEmpleado();

        System.out.println("");
    }
}