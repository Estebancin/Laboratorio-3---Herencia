/**
 * La clase Espacio representa un espacio genérico en el edificio.
 * Proporciona atributos y métodos comunes para todos los tipos de espacios.
 *
 * @author Esteban Ramírez y Dhastry Secaira
 */
public class Espacio {
    private int id;                
    private double metrosCuadrados; 
    private int cantidadDisponible; 
    private int cantidadVendidos;   
    private String estado;          

    /**
     * Constructor para crear un objeto de tipo Espacio.
     *
     * @param id Identificador único del espacio.
     * @param metrosCuadrados Área en metros cuadrados del espacio.
     * @param cantidadDisponible Número de unidades disponibles para la venta o alquiler.
     * @param cantidadVendidos Número de unidades que ya han sido vendidas o alquiladas.
     * @param estado Estado actual del espacio.
     */
    public Espacio(int id, double metrosCuadrados, int cantidadDisponible, int cantidadVendidos, String estado) {
        this.id = id;
        this.metrosCuadrados = metrosCuadrados;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadVendidos = cantidadVendidos;
        this.estado = estado;
    }

    /**
     * Obtiene el identificador único del espacio.
     *
     * @return El identificador único del espacio.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el área en metros cuadrados del espacio.
     *
     * @return El área en metros cuadrados del espacio.
     */
    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    /**
     * Establece el área en metros cuadrados del espacio.
     *
     * @param metrosCuadrados El nuevo valor del área en metros cuadrados.
     */
    public void setMetrosCuadrados(double metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    /**
     * Obtiene la cantidad de unidades disponibles para la venta o alquiler.
     *
     * @return La cantidad de unidades disponibles.
     */
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    /**
     * Establece la cantidad de unidades disponibles para la venta o alquiler.
     *
     * @param cantidadDisponible La nueva cantidad de unidades disponibles.
     */
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    /**
     * Obtiene la cantidad de unidades que ya han sido vendidas o alquiladas.
     *
     * @return La cantidad de unidades vendidas o alquiladas.
     */
    public int getCantidadVendidos() {
        return cantidadVendidos;
    }

    /**
     * Establece la cantidad de unidades vendidas o alquiladas.
     *
     * @param cantidadVendidos La nueva cantidad de unidades vendidas o alquiladas.
     */
    public void setCantidadVendidos(int cantidadVendidos) {
        this.cantidadVendidos = cantidadVendidos;
    }

    /**
     * Obtiene el estado actual del espacio.
     *
     * @return El estado actual del espacio.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual del espacio.
     *
     * @param estado El nuevo estado del espacio.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
