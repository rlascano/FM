/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmrt.dao.imp;

import fmrt.dao.EmpresaDAO;
import fmrt.modelo.Empresa;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import fmrt.util.JDBCUtil;
import java.util.ArrayList;

/**
 *
 * @author rodrigo
 */
public class EmpresaDAOImp implements EmpresaDAO {

    private static final Logger LOGGER = Logger.getLogger(EmpresaDAOImp.class.getName());

    private final String INSERT = "INSERT INTO EMPRESAS (NOMBRE, CUIL, DIRECCION,"
            + "LOCALIDAD, PROVINCIA, PAIS, CODIGO_POSTAL) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String GETALL = "SELECT ID_EMPRESA, NOMBRE, CUIL, DIRECCION, LOCALIDAD, PROVINCIA,"
            + " PAIS, CODIGO_POSTAL FROM EMPRESAS";
    private final String UPDATE = "UPDATE EMPRESAS SET NOMBRE = ?, CUIL=?, DIRECCION = ?,"
            + "LOCALIDAD = ?, PROVINCIA = ?, PAIS = ?, CODIGO_POSTAL = ? WHERE ID_EMPRESA = ?";
    private final String DELETE = "DELETE FROM EMPRESAS WHERE ID_EMPRESA = ?";
    private final String GETONE = INSERT + " WHERE ID_EMPRESA = ?";

    @Override
    public void insertar(Empresa a) throws SQLException {
        try ( Connection con = JDBCUtil.getConnection();  PreparedStatement pstm = con.prepareStatement(INSERT)) {
            pstm.setString(1, a.getNombre());
            pstm.setString(2, a.getCuil());
            pstm.setString(3, a.getDireccion());
            pstm.setString(4, a.getLocalidad());
            pstm.setString(5, a.getProvincia());
            pstm.setString(6, a.getPais());
            pstm.setString(7, a.getCodigoPostal());

            if (pstm.executeUpdate() < 1) {
                throw new SQLException("No se pudo agregar el registro");
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "No se pudo agregar la empresa", ex);
        }
    }

    @Override
    public void modificar(Empresa a) throws SQLException {
        try ( Connection con = JDBCUtil.getConnection();  PreparedStatement pstm = con.prepareStatement(UPDATE)) {
            pstm.setString(1, a.getNombre());
            pstm.setString(2, a.getCuil());
            pstm.setString(3, a.getDireccion());
            pstm.setString(4, a.getLocalidad());
            pstm.setString(5, a.getProvincia());
            pstm.setString(6, a.getPais());
            pstm.setString(7, a.getCodigoPostal());
            pstm.setLong(8, a.getId());

            if (pstm.executeUpdate() < 1) {
                throw new SQLException("No se pudo modificar el registro");
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "No se pudo modificar la empresa");
        }
    }

    @Override
    public void eliminar(Empresa a) throws SQLException {
        try ( Connection con = JDBCUtil.getConnection();  PreparedStatement pstm = con.prepareStatement(DELETE)) {
            pstm.setLong(1, a.getId());

            if (pstm.executeUpdate() < 1) {
                throw new SQLException("No se pudo eliminar la empresa");
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "No se pudo eliminar la empresa");
        }
    }

    @Override
    public List listar() throws SQLException {
        ArrayList<Empresa> lista = new ArrayList<>();

        try ( Connection con = JDBCUtil.getConnection();
                PreparedStatement pstm = con.prepareStatement(GETALL);
                ResultSet rs = pstm.executeQuery()) {            
            while (rs.next()) {   
                Empresa e = new Empresa();
                e.setId(rs.getLong("id_empresa"));
                e.setNombre(rs.getString("nombre"));
                e.setCuil(rs.getString("cuil"));
                e.setDireccion(rs.getString("direccion"));
                e.setLocalidad(rs.getString("localidad"));
                e.setProvincia(rs.getString("provincia"));
                e.setPais(rs.getString("pais"));
                e.setCodigoPostal(rs.getString("codigo_postal"));
                lista.add(e);
            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener empresas");
        }
        return lista;
    }

    @Override
    public Empresa obtener(Long id) throws SQLException {
        Empresa e = new Empresa();

        try ( Connection con = JDBCUtil.getConnection();  PreparedStatement pstm = con.prepareStatement(GETONE)) {

            pstm.setLong(1, id);

            try ( ResultSet rs = pstm.executeQuery()) {

                if (rs.next()) {
                    e.setId(rs.getLong("id_empresa"));
                    e.setNombre(rs.getString("nombre"));
                    e.setCuil(rs.getString("cuil"));
                    e.setDireccion(rs.getString("direccion"));
                    e.setLocalidad(rs.getString("localidad"));
                    e.setProvincia(rs.getString("provincia"));
                    e.setPais(rs.getString("pais"));
                    e.setCodigoPostal(rs.getString("codigo_postal"));
                }
            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener empresa");
        }
        return e;
    }

}
