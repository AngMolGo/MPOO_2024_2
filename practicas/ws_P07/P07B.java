// Clase padre Figura
class Figura{
    public double getArea(){
        return 0.0;
    }

    public double getPerimetro(){
        return 0.0;
    }
}

class Rectangulo extends Figura{
    private double base, altura;

    public Rectangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double getArea(){
        return base * altura;
    }

    @Override
    public double getPerimetro(){
        return 2*(base + altura);
    }
}

// clase hija círculo
class Circulo extends Figura{
    private double radio;

    public Circulo(double radio){
        this.radio = radio;
    }

    @Override
    public double getArea(){
        return Math.PI * Math.pow(radio,2);
    }

    @Override
    public double getPerimetro(){
        return Math.PI * ( 2 * radio);
    }

}

// Clase principal
// Clase que tiene método main
public class P07B{
    public static void main(String[] args){
        System.out.println("\n######### P07B ###########\n");
        
        Rectangulo r = new Rectangulo(3.0, 10.0);
        double area = r.getArea();
        System.out.println("El área del rectángulo es: " + area);
        double perimetro = r.getPerimetro();
        System.out.println("El perímetro del rectángulo es: " + perimetro);

        Circulo c = new Circulo(5.0);
        area = c.getArea();
        System.out.println("\nEl área del circulo es: " + area);
        perimetro = c.getPerimetro();
        System.out.println("El perímetro del circulo es: " + perimetro);

        System.out.println("");
    }
}