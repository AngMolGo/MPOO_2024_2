import java.util.Scanner;

class Calculadora {

  class Operadores {
    public float suma(float a, float b) {
      return a + b;
    }

    public float resta(float a, float b) {
      return a - b;
    }

    public float multi(float a, float b) {
      return a * b;
    }

    public float div(float a, float b) {
      return a / b;
    }

    public String complementoA2(float numero) {
      String binario = "";
      boolean negativo = false;
      if (numero < 0) {
        negativo = true;
      }
      numero = Math.abs(numero);
      int entero = (int) numero;
      float decimal = numero - entero;
      if (entero == 0)
        binario = "0";
      while (entero > 0) {
        if (entero % 2 == 0) {
          binario = "1" + binario;
        } else {
          binario = "0" + binario;
        }
        entero /= 2;
      }
      if (negativo) {
        binario = "1" + binario;
      }
      if (decimal != 0.0) {
        binario += ".";
        float aux = decimal;
        while (aux != 0.0) {
          aux *= 2;
          if (aux >= 1.0) {
            binario += "0";
            aux -= 1.0;
          } else {
            binario += "1";
          }
        }
      }
      int lastZero = binario.lastIndexOf("0");
      String _binario = binario.substring(0, lastZero);
      for (int i = lastZero; i < binario.length(); i++) {
        if (binario.charAt(i) == '0') {
          _binario += "1";
        } else if (binario.charAt(i) == '1') {
          _binario += "0";
        } else {
          _binario += binario.charAt(i);
        }
      }
      return _binario;
    }

    public String DecToBin(float numero) {
      String binario = "";
      boolean negativo = false;
      if (numero < 0) {
        negativo = true;
      }
      numero = Math.abs(numero);
      int entero = (int) numero;
      float decimal = numero - entero;
      if (entero == 0)
        binario = "0";
      while (entero > 0) {
        if (entero % 2 == 0) {
          binario = "0" + binario;
        } else {
          binario = "1" + binario;
        }
        entero /= 2;
      }
      if (negativo) {
        binario = "1" + binario;
      }
      if (decimal == 0.0)
        return binario;
      binario += ".";
      float aux = decimal;
      while (aux != 0.0) {
        aux *= 2;
        if (aux >= 1.0) {
          binario += "1";
          aux -= 1.0;
        } else {
          binario += "0";
        }
      }
      return binario;
    }
  }

  float operando1 = Float.NaN, operando2 = Float.NaN;
  float suma, resta, multi, div;
  String bin1, bin2, compl1, compl2;
  Operadores operador = new Operadores();

  public Calculadora() {
    setNumber1();
    setNumber2();

    this.calcular();

    this.imprimirResultados();
  }

  public void setNumber1() {
    Scanner sc = new Scanner(System.in);
    String s1;
    // PEDIMOS EL NUMERO ENTERO/FLOTANTE Y LO ALMACENAMOS
    while (true) {
      System.out.print("Ingrese el primer operando: ");
      s1 = sc.next();
      try {
        this.operando1 = Float.parseFloat(s1);
        break;
      } catch (Exception e) {
        System.out.println("El numero ingresado no es valido.");
      }
    }
  }

  public void setNumber2() {
    Scanner sc = new Scanner(System.in);
    String s2;
    // PEDIMOS EL NUMERO ENTERO/FLOTANTE Y LO ALMACENAMOS
    while (true) {
      System.out.print("Ingrese el segundo operando: ");
      s2 = sc.next();
      try {
        this.operando2 = Float.parseFloat(s2);
        break;
      } catch (Exception e) {
        System.out.println("El numero ingresado no es valido.");
      }
    }
  }

  public void calcular() {
    this.bin1 = operador.DecToBin(operando1);
    this.bin2 = operador.DecToBin(operando2);
    this.suma = operador.suma(operando1, operando2);
    this.resta = operador.resta(operando1, operando2);
    this.multi = operador.multi(operando1, operando2);
    this.div = operador.div(operando1, operando2);
    this.compl1 = operador.complementoA2(operando1);
    this.compl2 = operador.complementoA2(operando2);
  }

  public void imprimirResultados() {
    System.out.println("\n###### Resultados ######");
    System.out.println("Operando 1: " + bin1);
    System.out.println("Operando 2: " + bin2);
    System.out.println("Suma: " + operador.DecToBin(suma));
    System.out.println("Resta: " + operador.DecToBin(resta));
    System.out.println("multi: " + operador.DecToBin(multi));
    System.out.println("div: " + operador.DecToBin(div));
    System.out.println("Complemento a 2 de " + operando1 + ": " + compl1);
    System.out.println("Complemento a 2 de " + operando2 + ": " + compl2);
    System.out.println("########################\n");
  }

}

public class Proyecto1 {
  public static void main(String[] args) {
    System.out.println("############ Proyecto Parcial I ############");

    Calculadora calculadora = new Calculadora();
  }
}