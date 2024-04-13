import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

abstract class Tarea {
    String actividad;
    int estado;

    abstract void setActividad(String actividad);

    abstract String getActividad();

    abstract void setEstado(int estado);

    abstract int getEstado();
}

class TareaKanban extends Tarea {
    String responsable;

    public TareaKanban(String actividad, String responsable, int estado) {
        this.actividad = actividad;
        this.responsable = responsable;
        this.estado = estado;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getActividad() {
        return this.actividad;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return this.estado;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getResponsable() {
        return this.responsable;
    }

}

class TableroKanban {
    private HashMap<String, Integer> camposMap = new HashMap<>();
    private ArrayList<ArrayList<TareaKanban>> camposList = new ArrayList<ArrayList<TareaKanban>>();

    public TableroKanban(String... datos) {

        // Campos: To-do, Doing, Done
        int i = 0;
        for (String dato : datos) {
            // System.out.println("Procesando dato: " + dato);
            camposMap.put(dato, i++);
            camposList.add(new ArrayList<TareaKanban>());
        }
        // System.out.println(camposMap);
        // System.out.println(camposList);

    }

    // Agrega una tarea en el primer campo (To-Do)
    public void agregarTarea(String tarea, String responsable) {
        TareaKanban task = new TareaKanban(tarea, responsable, 0);
        camposList.get(0).add(task);
    }

    // Agrega una tarea en el campo introducido
    public void agregarTarea(String tarea, String responsable, String campo) {
        if (!isCampo(campo)) {
            System.out.println("No se pudo agregar la lista. No se encontró el campo solicitado.");
            return;
        }

        int _campo = camposMap.get(campo);
        TareaKanban task = new TareaKanban(tarea, responsable, _campo);
        camposList.get(_campo).add(task);
    }

    // Agregar una tarea hecha a un campo
    public void agregarTarea(TareaKanban tarea, String campo) {
        if (!isCampo(campo)) {
            System.out.println("No se pudo agregar la lista. No se encontró el campo solicitado.");
            return;
        }

        int _campo = camposMap.get(campo);
        tarea.setEstado(_campo);
        camposList.get(_campo).add(tarea);
    }

    public void imprimirTablero() {

        // Encabezado
        int ancho_col = 40;

        System.out.println("╔" + ("═".repeat(ancho_col) + "╦").repeat(3 - 1) + "═".repeat(ancho_col) + "╗");
        for (int i = 0; i < camposMap.size(); i++) {
            // Está chafa esta implementación pero funciona xP
            String campo = "";
            for(String _campo : camposMap.keySet()){
                if(i == camposMap.get(_campo)) campo = _campo;
            }
            int espacio_blanco1 = (ancho_col - campo.length()) / 2;
            int espacio_blanco2 = ancho_col - campo.length() - espacio_blanco1;
            System.out.printf("║%-" + espacio_blanco1 + "s", "");
            System.out.printf("%s", campo);
            System.out.printf("%" + espacio_blanco2 + "s", "");
        }
        System.out.println("║");
        System.out.println("╠" + ("═".repeat(ancho_col) + "╬").repeat(3 - 1) + "═".repeat(ancho_col) + "╣");

        // Obtener el máximo de tareas en cualquier columna
        int maxTareas = Math.max(Math.max(camposList.get(0).size(), camposList.get(1).size()),
                camposList.get(2).size());

        // Iterar sobre el máximo número de tareas
        for (int i = 0; i < maxTareas; i++) {
            // Obtener el nombre de la tarea para cada columna, o cadena vacía si no hay
            // tarea en esa columna
            String tareaToDo = (i < camposList.get(0).size()) ? " * " + camposList.get(0).get(i).getActividad() + "("
                    + camposList.get(0).get(i).getResponsable() + ")" : "";
            String tareaDoing = (i < camposList.get(1).size()) ? " * " + camposList.get(1).get(i).getActividad() + "("
                    + camposList.get(1).get(i).getResponsable() + ")" : "";
            String tareaDone = (i < camposList.get(2).size()) ? " * " + camposList.get(2).get(i).getActividad() + "("
                    + camposList.get(2).get(i).getResponsable() + ")" : "";

            // Imprimir las tareas alineadas en columnas con ancho fijo
            System.out.printf("║%-" + ancho_col + "s║%-" + ancho_col + "s║%-" + ancho_col + "s║%n", tareaToDo,
                    tareaDoing, tareaDone);
        }
        System.out.println("╚" + ("═".repeat(ancho_col) + "╩").repeat(3 - 1) + "═".repeat(ancho_col) + "╝");
    }

    public void moverTarea(String campo_actual, int index, String campo_destino) {
        if (!isCampo(campo_actual) || !isCampo(campo_destino)) {
            System.out.println("No se pudo completar el cambio.");
            return;
        }
        TareaKanban _tarea = camposList.get(camposMap.get(campo_actual)).remove(index);
        agregarTarea(_tarea, campo_destino);
    }

    public void eliminarTarea(String campo, int index) {
        if (!isCampo(campo)) {
            System.out.println("No se pudo eliminar la tarea. No existe el campo.");
            return;
        }
        camposList.get(camposMap.get(campo)).remove(index);
    }

    private boolean isCampo(String campo) {
        if (camposMap.get(campo) == null) {
            System.out.println("No se encontró el campo solicitado.");
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<TareaKanban> getCampoList(String campo) {
        if (!isCampo(campo)) {
            System.out.println("No se pudo encontrar el campo solicitado.");
            return null;
        }
        return camposList.get(camposMap.get(campo));
    }

}

public class Proyecto2 {

    public static void desplegarMenu() {
        System.out.print(
                "\nOperación que desea realizar:" +
                        "\n1. Registrar tarea" +
                        "\n2. Comenzar tarea" +
                        "\n3. Terminar tarea" +
                        "\n4. Mostrar estado de la lista" +
                        "\n5. Eliminar tarea" +
                        "\n6. Salir" +
                        "\n\nOpción: ");
    }

    public static void main(String[] args) {

        boolean game_over = false;
        Scanner e_choose = new Scanner(System.in);
        Scanner e_registro = new Scanner(System.in);
        Scanner e_pausa = new Scanner(System.in);

        TableroKanban tablero = new TableroKanban("To-do", "Doing", "Done");

        while (!game_over) {
            try {

                desplegarMenu();

                switch (e_choose.next()) {

                    case "1":
                        System.out.print("\n### REGISTRO ###");
                        System.out.print("\n > Actividad: ");
                        String _registro_actividad = e_registro.nextLine();
                        System.out.print(" > Responsable: ");
                        String _registro_responsable = e_registro.nextLine();
                        tablero.agregarTarea(_registro_actividad, _registro_responsable);

                        System.out.println("\n> Registrando tarea...");
                        break;

                    case "2":
                        if (tablero.getCampoList("To-do").isEmpty()) {
                            System.out.println("\n>No hay tareas pendientes.");
                        } else {
                            tablero.moverTarea("To-do", 0, "Doing");
                            System.out.println("\n> Comenzando tarea...");
                        }

                        break;

                    case "3":
                        if (tablero.getCampoList("Doing").isEmpty()) {
                            System.out.println("\n> No hay tareas actualmente en curso.");
                        } else {
                            tablero.moverTarea("Doing", 0, "Done");
                            System.out.println("\n> Terminando tarea...");
                        }
                        break;

                    case "4":
                        System.out.println("\n> Desplegando tablero...\n");
                        tablero.imprimirTablero();
                        e_pausa.nextLine();
                        break;

                    case "5":
                        if (tablero.getCampoList("To-do").isEmpty()) {
                            System.out.println("\n> No hay tareas pendientes.");
                        } else {
                            tablero.eliminarTarea("To-do", 0);
                            System.out.println("\n> Eliminando tarea");
                        }
                        break;

                    case "6":
                        System.out.println("\n> Cerrando programa. Muchas gracias por participar.\n");
                        game_over = true;
                        break;
                    default:
                        System.out.println("\n> No es una opción");
                        break;
                }
                // System.out.println(tablero.camposList);

                Thread.sleep(500);

            } catch (Exception e) {
                System.out.println("\n> Ocurrión un error: " + e);
            }

        }
        e_registro.close();
        e_choose.close();
        e_pausa.close();

    }
}