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

    // Método para cargar espacios desde un archivo CSV
    public void cargarEspacios(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos[0].matches("-?\\d+")) {
                    int id = Integer.parseInt(campos[0]);
                    double metrosCuadrados = Double.parseDouble(campos[1]);
                    int cantidadDisponible = Integer.parseInt(campos[2]);
                    int cantidadVendidos = Integer.parseInt(campos[3]);
                    String estado = campos[4];
                    String categoria = campos[5];
    
                    if (categoria.equals("Apartamento")) {
                        boolean lineaBlanca = Boolean.parseBoolean(campos[6]);
                        int habitaciones = Integer.parseInt(campos[7]);
                        espacios.add(new Apartamento(id, metrosCuadrados, cantidadDisponible,
                                                     cantidadVendidos, estado,
                                                     lineaBlanca, habitaciones));
                    } else if (categoria.equals("Oficina")) {
                        if (campos.length > 9) {
                            int totalParqueos = Integer.parseInt(campos[8]);
                            boolean mantenimiento = Boolean.parseBoolean(campos[9]);
                            espacios.add(new Oficina(id, metrosCuadrados,
                                                     cantidadDisponible,
                                                     cantidadVendidos,
                                                     estado,
                                                     totalParqueos,
                                                     mantenimiento));
                        }
                    } else if (categoria.equals("Amenidad")) {
                        if (campos.length > 11) {
                            String tipo = campos[10];
                            int capacidad = Integer.parseInt(campos[11]);
                            espacios.add(new Amenidad(id,
                                                      metrosCuadrados,
                                                      cantidadDisponible,
                                                      cantidadVendidos,
                                                      estado,
                                                      tipo,
                                                      capacidad));
                        }
                    }
                } else {
                    System.out.println("El ID " + campos[0] + " no es un número válido.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public Espacio buscarEspacio(int id) {
        for (Espacio espacio : espacios) {
            if (espacio.getId() == id) {
                return espacio;
            }
        }
        return null;
    }

    public List<Espacio> listarEspaciosPorCategoria(String categoria) {
        List<Espacio> espaciosPorCategoria = new ArrayList<>();
        for (Espacio espacio : espacios) {
            if (espacio.getClass().getSimpleName().equals(categoria)) {
                espaciosPorCategoria.add(espacio);
            }
        }
        return espaciosPorCategoria;
    }

    public void mostrarEstadosPorCategoria(String categoria) {
        for (Espacio espacio : espacios) {
            if (espacio.getClass().getSimpleName().equals(categoria)) {
                System.out.println("ID: " + espacio.getId() + ", Estado: " + espacio.getEstado());
            }
        }
    }

    public void generarInforme() {
        System.out.println("Listado de categorías con el total de espacios registrados:");
        System.out.println("Apartamentos: " + listarEspaciosPorCategoria("Apartamento").size());
        System.out.println("Oficinas: " + listarEspaciosPorCategoria("Oficina").size());
        System.out.println("Amenidades: " + listarEspaciosPorCategoria("Amenidad").size());

        System.out.println("\nListado de espacios por categoría:");
        for (Espacio espacio : espacios) {
            if (espacio instanceof Apartamento) {
                System.out.println("Apartamento con " + ((Apartamento) espacio).getHabitaciones() + " habitaciones");
            } else if (espacio instanceof Oficina) {
                System.out.println("Oficina con " + ((Oficina) espacio).getTotalParqueos() + " parqueos");
            } else if (espacio instanceof Amenidad) {
                System.out.println("Amenidad de tipo " + ((Amenidad) espacio).getTipo());
            }
        }

        System.out.println("\nTotal de espacios por estado:");
        int apartamentosReservados = 0;
        int apartamentosVendidos = 0;
        int apartamentosDisponibles = 0;
        for (Espacio espacio : listarEspaciosPorCategoria("Apartamento")) {
            if (espacio.getEstado().equals("reservado")) {
                apartamentosReservados++;
            } else if (espacio.getEstado().equals("vendido")) {
                apartamentosVendidos++;
            } else if (espacio.getEstado().equals("disponible")) {
                apartamentosDisponibles++;
            }
        }
        System.out.println("Apartamentos reservados: " + apartamentosReservados);
        System.out.println("Apartamentos vendidos: " + apartamentosVendidos);
        System.out.println("Apartamentos disponibles: " + apartamentosDisponibles);
    }
}
