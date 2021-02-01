/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmrt.dao;

import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author rodrigo
 * @param <T> Clase DTO a manejar
 * @param <K> Clave primaria de la clase
 */
public interface DAO<T, K> {
    void insertar(T a) throws SQLException;    
    void modificar(T a) throws SQLException;
    void eliminar(T a) throws SQLException;
    List<T> listar() throws SQLException;
    T obtener(K id) throws SQLException;
}
