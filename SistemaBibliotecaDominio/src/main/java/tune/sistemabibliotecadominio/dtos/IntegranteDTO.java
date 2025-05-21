
package tune.sistemabibliotecadominio.dtos;

import java.time.LocalDate;

public class IntegranteDTO {
    private String nombreCompleto;
    private String rol;  
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;  
    private String estadoActividad; 

    public IntegranteDTO(String nombreCompleto, String rol, LocalDate fechaIngreso, LocalDate fechaSalida, String estadoActividad) {
        this.nombreCompleto = nombreCompleto;
        this.rol = rol;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.estadoActividad = estadoActividad;
    }

    public IntegranteDTO(String nombreCompleto, String rol, LocalDate fechaIngreso, String estadoActividad) {
        this.nombreCompleto = nombreCompleto;
        this.rol = rol;
        this.fechaIngreso = fechaIngreso;
        this.estadoActividad = estadoActividad;
    }
   
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getEstadoActividad() {
        return estadoActividad;
    }

    public void setEstadoActividad(String estadoActividad) {
        this.estadoActividad = estadoActividad;
    }
}
