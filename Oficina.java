public class Oficina extends Espacio {
    private int totalParqueos;
    private boolean mantenimiento;

    // Constructor
    public Oficina(int id, double metrosCuadrados, int cantidadDisponible, int cantidadVendidos, String estado,
                   int totalParqueos, boolean mantenimiento) {
        super(id, metrosCuadrados, cantidadDisponible, cantidadVendidos, estado);
        this.totalParqueos = totalParqueos;
        this.mantenimiento = mantenimiento;
    }

   // Getters y setters para cada atributo adicional
   public int getTotalParqueos() {
       return totalParqueos;
   }

   public void setTotalParqueos(int totalParqueos) {
       this.totalParqueos = totalParqueos;
   }

   public boolean isMantenimiento() {
       return mantenimiento;
   }

   public void setMantenimiento(boolean mantenimiento) {
       this.mantenimiento = mantenimiento;
   }
}