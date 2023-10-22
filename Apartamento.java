public class Apartamento extends Espacio {
    private boolean lineaBlanca;
    private int habitaciones;

    // Constructor
    public Apartamento(int id, double metrosCuadrados, int cantidadDisponible, int cantidadVendidos, String estado,
                       boolean lineaBlanca, int habitaciones) {
        super(id, metrosCuadrados, cantidadDisponible, cantidadVendidos, estado);
        this.lineaBlanca = lineaBlanca;
        this.habitaciones = habitaciones;
    }

    // Getters y setters para cada atributo adicional
    public boolean isLineaBlanca() {
        return lineaBlanca;
    }

    public void setLineaBlanca(boolean lineaBlanca) {
        this.lineaBlanca = lineaBlanca;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }
}
