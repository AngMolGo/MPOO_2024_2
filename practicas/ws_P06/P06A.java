import java.util.Scanner;

class Rombo{
    public void imprimeR(int n){
        int c1 = 1;
        int c2 = 1;
        char c = 'A';

        for(int i = 1; i < (n * 2); i++){
            // Imprimir espacios
            for(int esp = n - c2; esp > 0; esp--){
                System.out.print(" ");
            }
            if(i < n){
                c2++;
            } else {
                c2--;
            }
            for(int j = 0; j < c1; j++){
                System.out.print(c);
                if(j < c1 / 2){
                    c++;
                } else {
                    c--;
                }
            }
            if(i < n){
                c1 = c1 + 2;
            } else {
                c1 = c1-2;
            }
            c = 'A';
            System.out.println();
        }
    }
}

public class P06A{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Ingresa el tamaño de tu rombo: ");
        int n = in.nextInt();
        Rombo r = new Rombo();
        r.imprimeR(n);
    }
}