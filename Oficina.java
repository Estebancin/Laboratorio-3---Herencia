/**
 * La clase Oficina representa un espacio de tipo "Oficina" en el edificio.
 * Esta clase extiende la clase Espacio y agrega atributos adicionales
 * específicos para las oficinas, como el número total de parqueos y si
 * incluye mantenimiento.
 *
 * @author Esteban Ramírez y Dhastry Secaira 
 */
public class Oficina extends Espacio {
    private int totalParqueos; 
    private boolean mantenimiento; 

    /**
     * Constructor de la clase Oficina.
     *
     * @param id Identificador único del espacio.
     * @param metrosCuadrados Tamaño del espacio en metros cuadrados.
     * @param cantidadDisponible Número de unidades disponibles para la venta o el alquiler.
     * @param cantidadVendidos Número de unidades que ya han sido vendidas o alquiladas.
     * @param estado Estado actual del espacio (disponible, reservado, etc.).
     * @param totalParqueos Número total de parqueos asignados a la oficina.
     * @param mantenimiento Indica si la oficina incluye mantenimiento.
     */
    public Oficina(int id, double metrosCuadrados, int cantidadDisponible, int cantidadVendidos, String estado,
                   int totalParqueos, boolean mantenimiento) {
        super(id, metrosCuadrados, cantidadDisponible, cantidadVendidos, estado);
        this.totalParqueos = totalParqueos;
        this.mantenimiento = mantenimiento;
    }

    /**
     * Obtiene el número total de parqueos asignados a la oficina.
     *
     * @return Número total de parqueos asignados a la oficina.
     */
    public int getTotalParqueos() {
        return totalParqueos;
    }

    /**
     * Establece el número total de parqueos asignados a la oficina.
     *
     * @param totalParqueos Número total de parqueos asignados a la oficina.
     */
    public void setTotalParqueos(int totalParqueos) {
        this.totalParqueos = totalParqueos;
    }

    /**
     * Verifica si la oficina incluye mantenimiento.
     *
     * @return true si la oficina incluye mantenimiento, false en caso contrario.
     */
    public boolean isMantenimiento() {
        return mantenimiento;
    }

    /**
     * Establece si la oficina incluye mantenimiento.
     *
     * @param mantenimiento true si la oficina incluye mantenimiento, false en caso contrario.
     */
    public void setMantenimiento(boolean mantenimiento) {
        this.mantenimiento = mantenimiento;
    }
}
