/**
 * La clase Amenidad representa un tipo de espacio en el edificio.
 * @author Esteban Ramírez y Dhastry Secaira
 * 
 */
public class Amenidad extends Espacio {
    private String tipo;        
    private int capacidad;      

    /**
     * Constructor para crear un objeto de tipo Amenidad.
     *
     * @param id Identificador único de la amenidad.
     * @param metrosCuadrados Área en metros cuadrados de las amenidades.
     * @param cantidadDisponible Cantidad disponible de la amenidad.
     * @param cantidadVendidos Cantidad de unidades vendidas de la amenidad.
     * @param estado Estado actual de la amenidad (por ejemplo, "disponible").
     * @param tipo Tipo de amenidad.
     * @param capacidad Capacidad máxima de la amenidad.
     */
    public Amenidad(int id, double metrosCuadrados, int cantidadDisponible, int cantidadVendidos, String estado,
                    String tipo, int capacidad) {
        super(id, metrosCuadrados, cantidadDisponible, cantidadVendidos, estado);
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    /**
     * Obtiene el tipo de amenidad.
     *
     * @return El tipo de amenidad.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de amenidad.
     *
     * @param tipo El nuevo tipo de amenidad a establecer.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la capacidad máxima de la amenidad.
     *
     * @return La capacidad máxima de personas que puede albergar la amenidad.
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad máxima de la amenidad.
     *
     * @param capacidad La nueva capacidad máxima de la amenidad a establecer.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}


