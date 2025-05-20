/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecadominio.entidades;

import org.bson.types.ObjectId;

/**
 *
 * @author Dana Chavez
 */
public class Cancion {
    private ObjectId idCancion;  // Identificador único
    private String nombreCancion;
    private String duracion;  // En formato "mm:ss"
    private String fechaLanzamiento;
    private ObjectId generoMusical;  // Referencia a un género (por ejemplo, "Pop", "Rock")

    public Cancion() {
    }
   
    public ObjectId getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(ObjectId idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public ObjectId getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(ObjectId generoMusical) {
        this.generoMusical = generoMusical;
    }

}
