/**
 * La clase ControladorEdificio se encarga de gestionar las operaciones relacionadas con
 * los espacios en el edificio, como cargar espacios desde un archivo CSV, buscar espacios por ID,
 * listar espacios por categoría, mostrar estados de espacios por categoría y generar informes.
 * Esta clase administra una lista de objetos de tipo Espacio.
 * 
 * @author Esteban Ramírez y Dhastry Secaira
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControladorEdificio {
    private List<Espacio> espacios;
    /**
    * Constructor para crear un objeto ControladorEdificio.
    * Inicializa la lista de espacios como un nuevo ArrayList.
    */
    public ControladorEdificio() {
        espacios = new ArrayList<>();
    }
    /**
     * Carga los datos de los espacios desde un archivo CSV y crea objetos de tipo
     * Apartamento, Oficina o Amenidad según la categoría de cada espacio.
     *
     * @param rutaArchivo Ruta del archivo CSV que contiene los datos de los espacios.
     */
    public void cargarEspacios(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] campos = linea.split("\\|");
                if (campos.length >= 5) {
                    int id = Integer.parseInt(campos[0]);
                    double metrosCuadrados = Double.parseDouble(campos[1]);
                    int cantidadDisponible = Integer.parseInt(campos[2]);
                    int cantidadVendidos = Integer.parseInt(campos[3]);
                    String estado = campos[4];
                    String categoria = campos[5];
    
                    if (categoria.equals("Apartamento") && campos.length >= 8) {
                        boolean lineaBlanca = campos[6].equals("true");
                        int habitaciones = Integer.parseInt(campos[7]);
                        espacios.add(new Apartamento(id, metrosCuadrados, cantidadDisponible, cantidadVendidos, estado, lineaBlanca, habitaciones));
                    } else if (categoria.equals("Oficina") && campos.length >= 8) {
                        int totalParqueos = 0;
                        if (!campos[6].isEmpty()) {
                            totalParqueos = Integer.parseInt(campos[6]);
                        }
                        boolean mantenimiento = campos[7].equals("true");
                        espacios.add(new Oficina(id, metrosCuadrados, cantidadDisponible, cantidadVendidos, estado, totalParqueos, mantenimiento));
                    } else if (categoria.equals("Amenidad") && campos.length >= 8) {
                        String tipo = campos[6].isEmpty() ? "Desconocido" : campos[6];
                        int capacidad = campos[7].isEmpty() ? 0 : Integer.parseInt(campos[7]);
                        espacios.add(new Amenidad(id, metrosCuadrados, cantidadDisponible, cantidadVendidos, estado, tipo, capacidad));
                    }
                } else {
                    System.out.println("Error en el formato de línea: " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Busca un espacio por su identificador único (ID).
     *
     * @param id El ID del espacio que se desea buscar.
     * @return El espacio encontrado o null si no se encontró ningún espacio con el ID especificado.
     */   
    public Espacio buscarEspacio(int id) {
        for (Espacio espacio : espacios) {
            if (espacio.getId() == id) {
                return espacio;
            }
        }
        return null;
    }
    /**
     * Lista los espacios de una categoría específica.
     *
     * @param categoria La categoría de espacios que se desea listar (por ejemplo, "Apartamento").
     * @return Una lista de espacios que pertenecen a la categoría especificada.
     */
    public List<Espacio> listarEspaciosPorCategoria(String categoria) {
        List<Espacio> espaciosPorCategoria = new ArrayList<>();
        for (Espacio espacio : espacios) {
            if (espacio.getClass().getSimpleName().equals(categoria)) {
                espaciosPorCategoria.add(espacio);
            }
        }
        return espaciosPorCategoria;
    }
    /**
     * Muestra los estados de los espacios por categoría.
     *
     * @param categoria La categoría de espacios de la cual se mostrarán los estados (por ejemplo, "Apartamento").
     */
    public void mostrarEstadosPorCategoria(String categoria) {
        List<Espacio> espaciosPorCategoria = listarEspaciosPorCategoria(categoria);
        System.out.println("Estados de " + categoria + ":");

        for (Espacio espacio : espaciosPorCategoria) {
            System.out.println("ID: " + espacio.getId() + ", Estado: " + espacio.getEstado());
        }
    }
    /**
     * Genera un informe con el total de espacios registrados para cada categoría.
     */
    public void generarInformeCategorias() {
        int totalApartamentos = listarEspaciosPorCategoria("Apartamento").size();
        int totalOficinas = listarEspaciosPorCategoria("Oficina").size();
        int totalAmenidades = listarEspaciosPorCategoria("Amenidad").size();

        System.out.println("1. Listado de categorías con el total de espacios registrados");
        System.out.println("a. Apartamentos - " + totalApartamentos);
        System.out.println("b. Oficinas - " + totalOficinas);
        System.out.println("c. Amenidades - " + totalAmenidades);
    }
    /**
     * Genera un informe de los espacios por categoría, con información específica
     * dependiendo del tipo de espacio.
     *
     * @param categoria La categoría de espacios para la cual se generará el informe.
     */
    public void generarInformeEspaciosPorCategoria(String categoria) {
        List<Espacio> espaciosPorCategoria = listarEspaciosPorCategoria(categoria);

        System.out.println("2. Listado de espacios por categoría " + categoria + ":");
        for (Espacio espacio : espaciosPorCategoria) {
            if (categoria.equals("Apartamento") && espacio instanceof Apartamento) {
                Apartamento apartamento = (Apartamento) espacio;
                System.out.println("a. Apartamentos " + apartamento.getHabitaciones() + " Habitación - ID: " + apartamento.getId());
            } else if (categoria.equals("Oficina") && espacio instanceof Oficina) {
                Oficina oficina = (Oficina) espacio;
                System.out.println("b. Oficinas con " + oficina.getTotalParqueos() + " parqueos - ID: " + oficina.getId());
            } else if (categoria.equals("Amenidad") && espacio instanceof Amenidad) {
                Amenidad amenidad = (Amenidad) espacio;
                System.out.println("c. Amenidades de tipo " + amenidad.getTipo() + " - ID: " + amenidad.getId());
            }
        }
    }
    /**
     * Genera un informe del total de espacios por estado para una categoría específica.
     *
     * @param categoria La categoría de espacios de la cual se generará el informe.
     */
    public void generarInformeEstadosPorCategoria(String categoria) {
        List<Espacio> espaciosPorCategoria = listarEspaciosPorCategoria(categoria);
        System.out.println("3. Total de espacios por estado " + categoria + ":");

        int reservados = 0;
        int vendidos = 0;
        int disponibles = 0;

        for (Espacio espacio : espaciosPorCategoria) {
            if (espacio.getEstado().equals("reservado")) {
                reservados++;
            } else if (espacio.getEstado().equals("vendido")) {
                vendidos++;
            } else if (espacio.getEstado().equals("disponible")) {
                disponibles++;
            }
        }

        System.out.println("a. " + categoria + " reservados: " + reservados);
        System.out.println("b. " + categoria + " vendidos: " + vendidos);
        System.out.println("c. " + categoria + " disponibles: " + disponibles);
    }
}
