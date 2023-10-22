public class Espacio {
    private int id;
    private double metrosCuadrados;
    private int cantidadDisponible;
    private int cantidadVendidos;
    private String estado;

    // Constructor
    public Espacio(int id, double metrosCuadrados, int cantidadDisponible, int cantidadVendidos, String estado) {
        this.id = id;
        this.metrosCuadrados = metrosCuadrados;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadVendidos = cantidadVendidos;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(double metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getCantidadVendidos() {
        return cantidadVendidos;
    }

    public void setCantidadVendidos(int cantidadVendidos) {
        this.cantidadVendidos = cantidadVendidos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}