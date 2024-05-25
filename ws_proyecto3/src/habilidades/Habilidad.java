package src.habilidades;

public class Habilidad {
 
    private String name;
    private String efecto;

    public Habilidad(String name, String efecto){
        this.name = name;
        this.efecto = efecto;
    }

    public String getName(){
        return name;
    }

    public String getEfectoInfo(){
        return efecto;
    }
}