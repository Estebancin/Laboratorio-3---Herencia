/**
 * La clase Apartamento representa un tipo de espacio en el edificio.
 *
 * @author Esteban Ramírez y Dhastry Secaira
 */
public class Apartamento extends Espacio {
    private boolean lineaBlanca;  
    private int habitaciones;     

    /**
     * Constructor para crear un objeto de tipo Apartamento.
     *
     * @param id Identificador único del apartamento.
     * @param metrosCuadrados Área en metros cuadrados del apartamento.
     * @param cantidadDisponible Cantidad disponible de apartamentos.
     * @param cantidadVendidos Cantidad de apartamentos vendidos.
     * @param estado Estado actual del apartamento (por ejemplo, "disponible").
     * @param lineaBlanca Indica si el apartamento incluye línea blanca.
     * @param habitaciones Número de habitaciones en el apartamento.
     */
    public Apartamento(int id, double metrosCuadrados, int cantidadDisponible, int cantidadVendidos, String estado,
                       boolean lineaBlanca, int habitaciones) {
        super(id, metrosCuadrados, cantidadDisponible, cantidadVendidos, estado);
        this.lineaBlanca = lineaBlanca;
        this.habitaciones = habitaciones;
    }

    /**
     * Verifica si el apartamento incluye línea blanca.
     *
     * @return `true` si el apartamento incluye línea blanca, de lo contrario, `false`.
     */
    public boolean isLineaBlanca() {
        return lineaBlanca;
    }

    /**
     * Establece si el apartamento incluye línea blanca.
     *
     * @param lineaBlanca `true` si el apartamento incluye línea blanca, de lo contrario, `false`.
     */
    public void setLineaBlanca(boolean lineaBlanca) {
        this.lineaBlanca = lineaBlanca;
    }

    /**
     * Obtiene el número de habitaciones en el apartamento.
     *
     * @return El número de habitaciones en el apartamento.
     */
    public int getHabitaciones() {
        return habitaciones;
    }

    /**
     * Establece el número de habitaciones en el apartamento.
     *
     * @param habitaciones El nuevo número de habitaciones en el apartamento.
     */
    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }
}
