public class Amenidad extends Espacio {
    private String tipo;
    private int capacidad;

    // Constructor
    public Amenidad(int id, double metrosCuadrados, int cantidadDisponible, int cantidadVendidos, String estado,
                    String tipo, int capacidad) {
        super(id, metrosCuadrados, cantidadDisponible, cantidadVendidos, estado);
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    // Getters y setters para cada atributo adicional
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
