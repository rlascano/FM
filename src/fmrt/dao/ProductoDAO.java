/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmrt.dao;

import fmrt.modelo.Producto;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author rodrigo
 */
public interface ProductoDAO extends DAO<Producto, Long> {
    public List<Producto> buscarPorNombre(String term) throws SQLException;
    public List<Producto> filtrarPorCategoria(Long categoriaId) throws SQLException;
}
