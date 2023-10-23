import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControladorEdificio {
    private List<Espacio> espacios;

    // Constructor
    public ControladorEdificio() {
        espacios = new ArrayList<>();
    }

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
    

    // Método para buscar un espacio por ID
    public Espacio buscarEspacio(int id) {
        for (Espacio espacio : espacios) {
            if (espacio.getId() == id) {
                return espacio;
            }
        }
        return null;
    }

    // Método para listar espacios por categoría
    public List<Espacio> listarEspaciosPorCategoria(String categoria) {
        List<Espacio> espaciosPorCategoria = new ArrayList<>();
        for (Espacio espacio : espacios) {
            if (espacio.getClass().getSimpleName().equals(categoria)) {
                espaciosPorCategoria.add(espacio);
            }
        }
        return espaciosPorCategoria;
    }

    // Método para mostrar estados por categoría
    public void mostrarEstadosPorCategoria(String categoria) {
        List<Espacio> espaciosPorCategoria = listarEspaciosPorCategoria(categoria);
        System.out.println("Estados de " + categoria + ":");

        for (Espacio espacio : espaciosPorCategoria) {
            System.out.println("ID: " + espacio.getId() + ", Estado: " + espacio.getEstado());
        }
    }

    // Método para generar el listado de categorías con el total de espacios registrados
    public void generarInformeCategorias() {
        int totalApartamentos = listarEspaciosPorCategoria("Apartamento").size();
        int totalOficinas = listarEspaciosPorCategoria("Oficina").size();
        int totalAmenidades = listarEspaciosPorCategoria("Amenidad").size();

        System.out.println("1. Listado de categorías con el total de espacios registrados");
        System.out.println("a. Apartamentos - " + totalApartamentos);
        System.out.println("b. Oficinas - " + totalOficinas);
        System.out.println("c. Amenidades - " + totalAmenidades);
    }

    // Método para generar el listado de espacios por categoría
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

    // Método para generar el total de espacios por estado
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