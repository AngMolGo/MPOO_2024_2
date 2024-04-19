import java.util.Scanner;

class Punto{
    double x, y;

    public Punto(double x, double y){
        this.x = x;
        this.y = y;
        System.out.println("Se creó el punto (" + x + "," + y + ")");
    }
}

class Vector{
    Punto pi, pf;

    public Vector(Punto pi, Punto pf){
        this.pi = pi;
        this.pf = pf;
    }

    public double getModule(){
        return Math.sqrt( Math.pow(pf.x - pi.x,2) + Math.pow(pf.y - pi.y,2) );
    }
}

public class P3{
    public static void main(String[] args){
        double p1x, p1y, p2x, p2y;

        Scanner e_Db = new Scanner(System.in);

        System.out.print("P1\n x = ");
        p1x = e_Db.nextDouble();
        System.out.print(" y = ");
        p1y = e_Db.nextDouble();
        Punto p1 = new Punto(p1x, p1y);

        System.out.print("\nP2\n x = ");
        p2x = e_Db.nextDouble();
        System.out.print(" y = ");
        p2y = e_Db.nextDouble();
        Punto p2 = new Punto(p2x, p2y);

        Vector v1 = new Vector(p1, p2);

        System.out.println("\nLa distancia entre puntos es de: " + v1.getModule() + " unidades de distancia");

    }
}