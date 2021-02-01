/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmrt.dao.imp;

import fmrt.dao.ChoferDAO;
import fmrt.modelo.Chofer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import fmrt.util.JDBCUtil;

/**
 *
 * @author rodrigo
 */
public class ChoferDAOImp implements ChoferDAO {
    
    private static final Logger LOGGER = Logger.getLogger(ChoferDAOImp.class.getName());
    
    final String INSERT = "INSERT INTO CHOFERES (APELLIDO, NOMBRE, DNI) VALUES "
            + "(?, ?, ?)";
    final String GETALL = "SELECT ID_CHOFER, APELLIDO, NOMBRE, DNI FROM CHOFERES "
            + "ORDER BY APELLIDO, NOMBRE";
    final String GETONE = "SELECT ID_CHOFER, APELLIDO, NOMBRE, DNI FROM CHOFERES "
            + "WHERE ID_CHOFER = ?";
    final String DELETE = "DELETE FROM CHOFERES WHERE ID_CHOFER = ?";
    final String UPDATE = "UPDATE CHOFERES SET APELLIDO = ?, NOMBRE = ?, DNI = ? "
            + "WHERE ID_CHOFER = ?";
    final String GETAPELLIDO = "SELECT ID_CHOFER, APELLIDO, NOMBRE, DNI FROM CHOFERES "
            + "WHERE APELLIDO LIKE ? ORDER BY APELLIDO, NOMBRE";

    @Override
    public void insertar(Chofer a) throws SQLException {
        try(Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstm = conn.prepareStatement(INSERT)) {
            
            pstm.setString(1, a.getApellido());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getDni());
            
            if(pstm.executeUpdate() == 0) {
                LOGGER.log(Level.WARNING, "Error al insertar chofer");
                throw new SQLException("Error al insertar chofer");
            }
        }catch(SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al insertar chofer", ex.toString());
            throw new SQLException("Error al insertar chofer");
        }
    }

    @Override
    public void modificar(Chofer a) throws SQLException {
        try(Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstm = conn.prepareStatement(UPDATE)) {
            pstm.setString(1, a.getApellido());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getDni());
            pstm.setLong(4, a.getId_chofer());
            
            if(pstm.executeUpdate() == 0) {
                LOGGER.log(Level.WARNING, "No se pudo actualizar chofer id {0}", a.getId_chofer());
                throw new SQLException("No se pudo actualizar chofer");
            }
        } catch(SQLException ex) {
            LOGGER.log(Level.SEVERE, "No se pudo actualizar chofer", 
                    ex.toString());
            throw new SQLException("No se pudo actualizar chofer");
        }
    }

    @Override
    public void eliminar(Chofer a) throws SQLException {        
        try(Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstm = conn.prepareStatement(DELETE)) {
            pstm.setLong(1, a.getId_chofer());
            
            if(pstm.executeUpdate() == 0) {
                LOGGER.log(Level.WARNING, "No se pudo eliminar chofer con id {}",
                        a.getId_chofer());
                throw new SQLException("Error al eliminar chofer");
            }
        } catch(SQLException ex) {
            LOGGER.log(Level.SEVERE, "No se pudo eliminar chofer con id " + 
                    a.getId_chofer(), ex.toString());
            throw new SQLException("No se pudo eliminar chofer");
        }        
    }

    @Override
    public List<Chofer> listar() throws SQLException {
        List<Chofer> lista = new ArrayList<>();
        try(Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstm = conn.prepareStatement(GETALL);
                ResultSet rs = pstm.executeQuery()) {
            while(rs.next()) {
                Chofer c = new Chofer();
                c.setId_chofer(rs.getLong("id_chofer"));
                c.setApellido(rs.getString("apellido"));
                c.setNombre(rs.getString("nombre"));
                c.setDni(rs.getString("dni"));
                lista.add(c);
            }            
        } catch(SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener listado de choferes", ex);
            throw new SQLException("No se pudo obtener listado");
        }
        
        return lista;
    }

    @Override
    public Chofer obtener(Long id) throws SQLException {
        Chofer c = new Chofer();
        try(Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstm = conn.prepareStatement(GETONE)) {
            pstm.setLong(1, id);
            
            try(ResultSet rs = pstm.executeQuery()) {
                if(rs.next()) {                    
                    c.setId_chofer(rs.getLong("id_chofer"));
                    c.setApellido(rs.getString("apellido"));
                    c.setNombre(rs.getString("nombre"));
                    c.setDni(rs.getString("dni"));                    
                }   
            }    
        } catch(SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener chofer con id " + id, ex);
            throw new SQLException("No se pudo obtenerchofer");
        }
        
        return c;
    }

    @Override
    public List<Chofer> buscarPorApellido(String t) throws SQLException {
        List<Chofer> lista = new ArrayList<>();
        try(Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstm = conn.prepareStatement(GETAPELLIDO)) {            
            pstm.setString(1, "%" + t + "%");
            
            try(ResultSet rs = pstm.executeQuery()) {
                while(rs.next()) {               
                    Chofer temp = new Chofer();            
                    temp.setId_chofer(rs.getLong("id_chofer"));
                    temp.setApellido(rs.getString("apellido"));
                    temp.setNombre(rs.getString("nombre"));
                    temp.setDni(rs.getString("dni"));
                    lista.add(temp);
                }
            }    
        } catch(SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener listado de choferes", ex);
            throw new SQLException("No se pudo obtener listado");
        }
        
        return lista;
    }
    
}
