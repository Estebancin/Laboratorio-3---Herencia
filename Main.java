/**
 * La clase Main permite interactuar con el usuario
 * y realizar operaciones en el edificio, como buscar espacios por ID, listar espacios por
 * categoría, mostrar estados por categoría y generar informes.
 *
 * @author Esteban Ramírez y Dhastry Secaira
 * Fecha de creación: 19/10/23
 * Fecha de última modificación: 23/10/23
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControladorEdificio controlador = new ControladorEdificio();
        controlador.cargarEspacios("espacios.csv"); 

        System.out.println("Por favor, elige una opción:");
        System.out.println("1. Buscar espacio por ID");
        System.out.println("2. Listar espacios por categoría");
        System.out.println("3. Mostrar estados por categoría");
        System.out.println("4. Generar informe");
        System.out.println("5. Salir");

        int opcion = scanner.nextInt();

        while (opcion != 5) {
            if (opcion == 1) {
                System.out.println("Por favor, introduce el ID del espacio (1-6):");
                int id = scanner.nextInt();
                Espacio espacio = controlador.buscarEspacio(id);
                if (espacio != null) {
                    System.out.println(espacio);
                } else {
                    System.out.println("Espacio no encontrado.");
                }
            } else if (opcion == 2) {
                System.out.println("Por favor, introduce la categoría (Apartamento, Oficina, Amenidad):");
                String categoria = scanner.next();
                controlador.generarInformeEspaciosPorCategoria(categoria);
            } else if (opcion == 3) {
                System.out.println("Por favor, introduce la categoría (Apartamento, Oficina, Amenidad):");
                String categoria = scanner.next();
                controlador.generarInformeEstadosPorCategoria(categoria);
            } else if (opcion == 4) {
                System.out.println("");
                System.out.println("");
                controlador.generarInformeCategorias();
                controlador.generarInformeEspaciosPorCategoria("Apartamento");
                System.out.println("");
                controlador.generarInformeEspaciosPorCategoria("Oficina");
                System.out.println("");
                controlador.generarInformeEspaciosPorCategoria("Amenidad");
                System.out.println("");
                controlador.generarInformeEstadosPorCategoria("Apartamento");
                System.out.println("");
                controlador.generarInformeEstadosPorCategoria("Oficina");
                System.out.println("");
                controlador.generarInformeEstadosPorCategoria("Amenidad");
            }

            System.out.println("Por favor, elige una opción:");
            System.out.println("1. Buscar espacio por ID");
            System.out.println("2. Listar espacios por categoría");
            System.out.println("3. Mostrar estados por categoría");
            System.out.println("4. Generar informe");
            System.out.println("5. Salir");

            opcion = scanner.nextInt();
        }

        System.out.println("Hasta luego!");
    }
}
