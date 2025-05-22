/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecadominio.dtos;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Dana Chavez
 */
public class FavoritosDTO {
    private ObjectId usuarioId;
    private List<ObjectId> artistas;
    private List<ObjectId> albumes;
    private List<ObjectId> canciones;
}
