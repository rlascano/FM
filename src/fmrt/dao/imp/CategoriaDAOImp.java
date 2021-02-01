/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmrt.dao.imp;

import fmrt.dao.CategoriaDAO;
import fmrt.modelo.Categoria;
import fmrt.util.JDBCUtil;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author rodrigo
 */
public class CategoriaDAOImp implements CategoriaDAO {
    
    private static final Logger LOGGER = Logger.getLogger(CategoriaDAOImp.class.getName());
    
    private final String GETALL = "SELECT ID_CATEGORIA, NOMBRE FROM CATEGORIAS"
            + " ORDER BY NOMBRE";
    private final String INSERT = "INSERT INTO CATEGORIAS (NOMBRE) VALUES "
            + " (?)";
    private final String UPDATE = "UPDATE CATEGORIAS SET NOMBRE = ? WHERE "
            + "ID_CATEGORIA = ?";
    private final String DELETE = "DELETE FROM CATEGORIAS WHERE ID_CATEGORIA = "
            + "?";
    private final String GETONE = "SELECT ID_CATEGORIA, NOMBRE FROM CATEGORIAS"
            + " WHERE ID_CATEGORIA = ?";
    
    
    @Override
    public void insertar(Categoria a) throws SQLException {
        try(Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstm = conn.prepareStatement(INSERT)) {
            
            pstm.setString(1, a.getNombre());
            
            if(pstm.executeUpdate() == 0) {
                LOGGER.log(Level.WARNING, "No se pudo insertar categoria");
                throw new SQLException("No se pudo insertar categoria");
            }
        } catch(SQLException ex) {
            LOGGER.log(Level.SEVERE, "No se pudo agregar categoria", ex.toString());
            throw new SQLException("No se pudo insertar categoria");
        }
    }

    @Override
    public void modificar(Categoria a) throws SQLException {
        try(Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstm = conn.prepareStatement(UPDATE)) {
            
            pstm.setString(1, a.getNombre());
            pstm.setLong(2, a.getIdCategoria());
            
            if(pstm.executeUpdate() == 0) {
                LOGGER.log(Level.WARNING, "No se pudo modificar categoria");
                throw new SQLException("No se pudo modificar categoria");
            }
        
        } catch(SQLException ex) {
            LOGGER.log(Level.SEVERE, "No se pudo modificar categoria", ex.toString());
            throw new SQLException("No se pudo modificar categoria");
        }
    }

    @Override
    public void eliminar(Categoria a) throws SQLException {
        try(Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstm = conn.prepareStatement(DELETE)) {
            
            pstm.setLong(1, a.getIdCategoria());
            
            if(pstm.executeUpdate() == 0) {
                LOGGER.log(Level.WARNING, "No se pudo eliminar categoria");
                throw new SQLException();
            }
        } catch(SQLException ex) {
            LOGGER.log(Level.SEVERE, "No se pudo eliminar categoria");
                LOGGER.log(Level.WARNING, "No se pudo eliminar categoria", ex.toString());
                throw new SQLException();
        }
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> res = new ArrayList<>();
        try(Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstm = conn.prepareStatement(GETALL);
                ResultSet rs = pstm.executeQuery()) {
            
            while(rs.next()) {
                Categoria c = new Categoria();
                c.setIdCategoria(rs.getLong("ID_CATEGORIA"));
                c.setNombre(rs.getString("NOMBRE"));
                res.add(c);
            }        
        } catch(SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener listado de categorias");
            throw new SQLException("Error al obteber listado de categorias");
        }       
        
        return res;
    }

    @Override
    public Categoria obtener(Long id) throws SQLException {
        Categoria c = new Categoria();
        
        try(Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstm = conn.prepareStatement(GETONE)) {
            
            pstm.setLong(1, id);
            
            try(ResultSet rs = pstm.executeQuery()) {
                if(rs.next()) {
                    c.setIdCategoria(rs.getLong("ID_CATEGORIA"));
                    c.setNombre(rs.getString("NOMBRE"));
                }    
            }
            
        } catch(SQLException ex) {
            LOGGER.log(Level.SEVERE, "No se pudo obtener categoria", ex);
            throw new SQLException();
        }
        
        return c;
    }
    
}
