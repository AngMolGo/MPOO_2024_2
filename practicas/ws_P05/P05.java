class Conversiones{
    public void conversion(int n){
        int[] numeroBin = new int[1000];
        int i = 0;

        while ( n > 0 ){
            numeroBin[i] = n % 2;
            n = n / 2;
            i++;
        }

        for (int j = 7; j >=0; j--){
            System.out.print(numeroBin[j]);
        }
    }

    public void complementoAUno(int n){
        int[] numeroBin = new int[1000];
        int i = 0;

        while ( n > 0 ){
            numeroBin[i] = n % 2;
            n = n / 2;
            i++;
        }

        for (int j = i-1; j >=0; j--){
            numeroBin[j] = (numeroBin[j] == 0) ? 1 : 0;
            System.out.print(numeroBin[j]);
        }
    }
}


public class P05{
    public static void main(String[] args){
        System.out.println("####### Práctica 05 ########");
        Conversiones c = new Conversiones();
        for(int i = 1; i < 100; i++){
            System.out.print("   Decimal: " + i + "\t|");
            System.out.print("   Binario: ");
            c.conversion(i);
            System.out.print("\t|    Complemento a uno: ");
            c.complementoAUno(i);
            System.out.println();
        }
    }   
}