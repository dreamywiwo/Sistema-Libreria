/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecanegocio.implementaciones;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tune.sistemabibliotecanegocio.exception.NegocioException;
import tune.sistemabibliotecanegocio.interfaces.IInsercionMasivaBO;
import tune.sistemabibliotecapersistencia.exception.PersistenciaException;
import tune.sistemabibliotecapersistencia.interfaces.IInsercionMasiva;

/**
 *
 * @author Dana Chavez
 */
public class InsercionMasivaBO implements IInsercionMasivaBO {

    private IInsercionMasiva insercionMasivaDAO;

    public InsercionMasivaBO(IInsercionMasiva insercionMasivaDAO) {
        this.insercionMasivaDAO = insercionMasivaDAO;
    }

    @Override
    public void insertarArtistasMasivamente() throws NegocioException {
        try {
            this.insercionMasivaDAO.insertarArtistasMasivamente();
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron insertar los artistas", ex);
        }
    }

    @Override
    public List<String> obtenerGenerosUnicos() throws NegocioException {
        return this.insercionMasivaDAO.obtenerTodosLosGenerosUnicos();
    }

}
