import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ControladorEdificio controlador = new ControladorEdificio();
        controlador.cargarEspacios("espacios.csv");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Por favor, elige una opción:");
            System.out.println("1. Buscar espacio por ID");
            System.out.println("2. Listar espacios por categoría");
            System.out.println("3. Mostrar estados por categoría");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // consume newline

            if (opcion == 1) {
                System.out.println("Por favor, introduce el ID del espacio:");
                int id = scanner.nextInt();
                scanner.nextLine();  // consume newline
                Espacio espacio = controlador.buscarEspacio(id);
                if (espacio != null) {
                    System.out.println(espacio);
                } else {
                    System.out.println("No se encontró ningún espacio con ese ID.");
                }
            } else if (opcion == 2) {
                System.out.println("Por favor, introduce la categoría (Apartamento, Oficina, Amenidad):");
                String categoria = scanner.nextLine();
                List<Espacio> espacios = controlador.listarEspaciosPorCategoria(categoria);
                for (Espacio espacio : espacios) {
                    System.out.println(espacio);
                }
            } else if (opcion == 3) {
                System.out.println("Por favor, introduce la categoría (Apartamento, Oficina, Amenidad):");
                String categoria = scanner.nextLine();
                controlador.mostrarEstadosPorCategoria(categoria);
            } else if (opcion == 4) {
                break;
            } else {
                System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        }

        scanner.close();
    }
}
