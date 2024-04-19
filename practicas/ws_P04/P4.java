import java.util.Scanner;

class Matriz{
    int ren, col;
    int[][] arreglo;
    
    // CONSTRUCTOR
    public Matriz(int ren, int col){
        this.ren = ren;
        this.col = col;
        this.arreglo = new int[ren][col];
        //System.out.println("Se creó una matriz de " + ren + "x" + col + " vacía");
    }

    // DEVUELVE UN OBJETO DE CLASE MATRIZ
    Matriz traspuesta(){
        Matriz traspuesta = new Matriz(col, ren);
        for(int i = 0; i<ren; i++){
            for(int j = 0; j<col; j++){
                traspuesta.setValue(j,i,arreglo[i][j]);
            }
        }
        return traspuesta;
    }

    // DESPLIEGA EN PANTALLA LA MATRIZ
    void desplegarMatriz(){
        for(int i = 0; i<ren; i++){
            for(int j = 0; j<col; j++){
                //System.out.print("Hola i=" + i + " j=" + j);
                System.out.print(this.arreglo[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    // 1. CAMBIA EL CONTENIDO DE LA MATRIZ (PARA USUARIO)
    void setMatriz(){
        Scanner miScan = new Scanner(System.in);

        System.out.print("¿Ingresar valores por columnas o por renglones? [c/r]: ");
        char des = miScan.next().charAt(0);
        if(des == 'r'){
            System.out.println("Por renglones:");
            for(int i = 0; i<ren; i++){
                for(int j = 0; j<col; j++){
                    System.out.print("[" + j +  "][" + i + "] = ");
                    this.arreglo[i][j] = miScan.nextInt();
                }
                System.out.println(" ");
            }
        }
        if(des == 'c'){
            System.out.println("Por columnas:");
            for(int i = 0; i<col; i++){
                for(int j = 0; j<ren; j++){
                    System.out.print("[" + i +  "][" + j + "] = ");
                    this.arreglo[j][i] = miScan.nextInt();
                }
                System.out.println(" ");
            }
        }

        

        System.out.println("Matriz ingresada: ");
        this.desplegarMatriz();
    }

    // 2. CAMBIA EL CONTENIDO DE LA MATRIZ (PARA TEST RÁPIDO)
    void setMatriz(int[][] arreglo){
        this.arreglo = arreglo;
        System.out.println("Matriz ingresada: ");
        this.desplegarMatriz();
    }

    // ENCAPSULAMIENTO: CAMBIA EL VALOR DE UNA CASILLA DE LA MATRIZ
    void setValue(int ren, int col, int value){
        arreglo[ren][col] = value;
    }
}

public class P4{
    public static void main(String [] args){
        
        // Hola mundo
        System.out.println("Hola mundo\n");

        // ######################   EJEMPLO RÁPIDO (TEST)   ##############################
        /*
        Matriz miMatriz_ejemplo = new Matriz(3, 3); // Creamos un objeto de la clase Matriz
        System.out.println("Matriz vacía:");
        miMatriz_ejemplo.desplegarMatriz(); // Muestra en pantalla la matriz
        
        // Aquí cambiaremos la matriz completa
        int[][] arreglo = {{1,2,3},{4,5,6},{7,8,9}}; // Para pruebas rápidas
        miMatriz_ejemplo.setMatriz(arreglo);
        
        // * Forma rápida para desplegar matriz *
        System.out.println("Matriz inversa:");
        miMatriz_ejemplo.traspuesta().desplegarMatriz();
        */

        // * Manera larga de desplegar matriz *
        /* 
        Matriz mT = miMatriz.traspuesta();
        mT.desplegarMatriz();
        */

        // ######################   Práctica #4   ##############################
        Matriz matriz = new Matriz(3,3); //Creamos un objeto de la clase Matriz
        matriz.setMatriz(); //Le pedimos al usario que ingrese los valores de la matriz
        System.out.println("Matriz traspuesta:");
        matriz.traspuesta().desplegarMatriz(); // Desplegamos la matriz traspuesta
    }
}