import java.util.ArrayList;

class Libro{
    private String titulo;
    private String autor;

    public Libro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
}

class Biblioteca{
    private ArrayList<Libro> libros;

    public Biblioteca(){
        libros = new ArrayList <Libro>();
    }

    //Método para agregar libros
    public void addLibro(Libro l){
        libros.add(l);
    }
    // Método para eliminar libros
    public void eliminaLibro(Libro l){
        libros.remove(l);
    }

    // Método para pedir la biblioteca
    public ArrayList<Libro> obtenerLibros(){
        return libros;
    }
}

public class P06B{
    public static void main(String[] args){
        Biblioteca b = new Biblioteca();

        Libro l1 = new Libro("50 Shades", "E.L. James");
        Libro l2 = new Libro("La máquina del tiempo", "H.G. Wells");
        Libro l3 = new Libro("El retrato de Dorian Gray", "Oscar Wilde");
        Libro l4 = new Libro("Viaje al centro de la tierra", "Julio Verne");

        b.addLibro(l1);
        b.addLibro(l2);
        b.addLibro(l3);
        b.addLibro(l4);

        System.out.println("\nLibros en la biblioteca: ");
        for(Libro l: b.obtenerLibros()){
            System.out.println(l.getTitulo() + " escrito por " + l.getAutor());
        }


        b.eliminaLibro(l1);

        System.out.println("\nLibros en la biblioteca: ");
        for(Libro l: b.obtenerLibros()){
            System.out.println(l.getTitulo() + " escrito por " + l.getAutor());
        }
    }
}