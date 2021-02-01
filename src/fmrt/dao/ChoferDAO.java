/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmrt.dao;

import fmrt.modelo.Chofer;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author rodrigo
 */
public interface ChoferDAO extends DAO<Chofer, Long> {

    /**
     *
     * @param t
     * @return Listado de Choferes filtrados por apellido.
     * @throws java.sql.SQLException
     */
    public List<Chofer> buscarPorApellido(String t) throws SQLException;    
}
