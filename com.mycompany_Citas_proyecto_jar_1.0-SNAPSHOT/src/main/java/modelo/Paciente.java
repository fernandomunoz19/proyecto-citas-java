
package modelo;


public class Paciente {
    private String identificacion;
    private String nombre;
    private String apellidos;
    private String fechadenacimiento;
    private String genero;
    
  public Paciente(String identificacion, String nombre, String apellidos, String fechadenacimiento, String genero) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechadenacimiento = fechadenacimiento;
        this.genero = genero;
    }
    public String getIdentificacion() {
        return identificacion;
    }

 
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

   
    public String getNombres() {
        return nombre;
    }

    
    public void setNombres(String nombres) {
        this.nombre = nombres;
    }

    
    public String getApellidos() {
        return apellidos;
    }

    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechadenacimiento() {
        return fechadenacimiento;
    }

   
    public void setFechadenacimiento(String fechadenacimiento) {
        this.fechadenacimiento = fechadenacimiento;
    }
    public String getGenero() {
    return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
