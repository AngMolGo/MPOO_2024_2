// Clase Figura
abstract class Figura{
    public abstract void dibujar();
    public abstract double calculaArea();
}

// Clase derivada Circulo (Figura en R2)
class Circulo extends Figura{
    private double radio;

    public Circulo(double r){
        this.radio = r;
    }

    @Override
    public void dibujar(){
        System.out.println("Se dibuja un círculo...");
    }

    @Override
    public double calculaArea(){
        return Math.PI * radio * radio;
    }

    protected double getRadio(){
        return radio;
    }
}

// Clase derivada Cilindro que hereda de circulo
class Cilindro extends Circulo{
    private double altura;

    public Cilindro(double r, double a){
        super(r);
        this.altura = a;
    }

    @Override
    public void dibujar(){
        System.out.println("Dibujo un cilindro...");
    }

    @Override
    public double calculaArea(){
        // Para ek cálculo de la superficie total del area del cilindro (se incluye parte alta y parte baja de la figura)
        double areaCirculo = super.calculaArea();
        double areaLateral = 2 * Math.PI * getRadio() * altura;
        return 2 * areaCirculo + areaLateral;
    }
}

class Cuadrado extends Figura{
    private double lado;

    public Cuadrado(double l){
        this.lado = l;
    }

    @Override
    public void dibujar(){
        System.out.println("Se dibuja el cuadrado...");
    }

    @Override
    public double calculaArea(){
        return lado*lado;
    }

    public double getLado(){
        return lado;
    }
}

class PrismaC extends Cuadrado{
    double altura;

    public PrismaC(double l, double a){
        super(l);
        this.altura = a;
    }

    @Override
    public void dibujar(){
        System.out.println("Se dibuja el prisma cuadrángular...");
    }

    @Override
    public double calculaArea(){
        return getLado() * getLado() * 2 + getLado() * altura * 4;
    }
}

// Clase principal
public class P10B{
    public static void dibujaYCalcula(Figura f){
        System.out.println("");
        f.dibujar();
        double area = f.calculaArea();
        System.out.println("Area: " + area);
    }

    public static void main(String[] args){
        Figura circulo = new Circulo(7.0);
        Figura cilindro = new Cilindro(4.0, 9.0);
        Figura cuadrado = new Cuadrado(4.0);
        Figura prismaC = new PrismaC(3.0, 5.0);

        dibujaYCalcula(circulo);
        dibujaYCalcula(cilindro);
        dibujaYCalcula(cuadrado);
        dibujaYCalcula(prismaC);
        System.out.println("");
    }
}