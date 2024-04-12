import java.util.Scanner;

public class Proyecto2 {

    public static void desplegarMenu() {
        System.out.print(
                "\nOperación que desea realizar:" +
                        "\n1. Registrar tarea" +
                        "\n2. Realizar tarea" +
                        "\n3. Mostrar estado de la lista" +
                        "\n4. Eliminar tarea" +
                        "\n5. Salir" +
                        "\n\nOpción: ");
    }

    public static void main(String[] args) {

        boolean game_over = false;
        Scanner e_choose = new Scanner(System.in);


        while (!game_over) {
            try {

                desplegarMenu();

                switch (e_choose.next()) {
                    case "1":
                        System.out.println("\n> Registrando tarea...");
                        break;
                    case "2":
                        System.out.println("\n> Realizando tarea...");
                        break;
                    case "3":
                        System.out.println("\n> Desplegando tablero...");
                        break;
                    case "4":
                        System.out.println("\n> Eliminando tarea");
                        break;
                    case "5":
                        System.out.println("\n> Cerrando programa. Muchas gracias por participar.\n");
                        game_over = true;
                        break;
                    default:
                        System.out.println("\n> No es una opción");
                        break;
                }
                Thread.sleep(2000);

            } catch (Exception e) {
                System.out.println("\n> Ocurrión un error: " + e);
            }

        }

        e_choose.close();

    }
}