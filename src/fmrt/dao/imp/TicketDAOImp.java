/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmrt.dao.imp;

import java.sql.Connection;
import fmrt.dao.TicketDAO;
import fmrt.modelo.Ticket;
import fmrt.util.JDBCUtil;
import java.sql.SQLException;
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
public class TicketDAOImp implements TicketDAO {

    private static final Logger LOGGER = Logger.getLogger(TicketDAOImp.class.getName());
    private DAOManager dao;

    private final String INSERT = "INSERT INTO TICKETS NUMERO, PRODUCTO_ID, "
            + "CLIENTE_ID, TRANSPORTE_ID, TARA, BRUTO, INGRESO, EGRESO, "
            + "PATENTECHASIS, PATENTESEMI, "
            + "OBSERVACIONES VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String UPDATE = "UPDATE TICKETS SET NUMERO = ?, PRODUCTO_ID = ?, "
            + "CLIENTE_ID = ?, TRANSPORTE_ID = ?, TARA = ?, BRUTO = ?, INGRESO = ?, "
            + "EGRESO = ?, PATENTECHASIS = ?, PATENTESEMI = ?, OBSERVACIONES = ? "
            + "WHERE TICKET_ID = ?";
    private final String DELETE = "DELETE TICKETS WHERE TICKET_ID = ?";
    private final String GETALL = "SELECT TICKET_ID, NUMERO, PRODUCTO_ID, CLIENTE_ID, "
            + "TRANSPORTE_ID, TARA, BRUTO, INGRESO, EGRESO, OBSERVACIONES "
            + " PATENTECHASIS, PATENTESEMI FROM TICKETS";
    private final String GETONE = "SELECT TICKET_ID, NUMERO, PRODUCTO_ID, CLIENTE_ID, "
            + "TRANSPORTE_ID, TARA, BRUTO, INGRESO, EGRESO, OBSERVACIONES "
            + "PATENTECHASIS PATENTESEMI FROM TICKETS WHERE TICKET_ID = ?";

    public TicketDAOImp() {
        dao = new DAOManager();
    }

    @Override
    public void insertar(Ticket a) throws SQLException {
        try (Connection con = JDBCUtil.getConnection();
                PreparedStatement pstm = con.prepareStatement(INSERT)) {
            pstm.setLong(1, a.getNumero());
            pstm.setLong(2, a.getProducto().getIdProducto());
            pstm.setLong(3, a.getCliente().getId());
            pstm.setLong(4, a.getTransportista().getId());
            pstm.setInt(5, a.getTara());
            pstm.setInt(6, a.getBruto());
            pstm.setString(7, a.getIngreso());
            pstm.setString(8, a.getEgreso());
            pstm.setString(9, a.getPatenteChasis());
            pstm.setString(10, a.getPatenteSemi());
            pstm.setString(11, a.getObservaciones());

            pstm.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al insertar Ticket");
        }
    }

    @Override
    public void modificar(Ticket a) throws SQLException {
        try (Connection con = JDBCUtil.getConnection();
                PreparedStatement pstm = con.prepareStatement(UPDATE)) {
            pstm.setLong(1, a.getNumero());
            pstm.setLong(2, a.getProducto().getIdProducto());
            pstm.setLong(3, a.getCliente().getId());
            pstm.setLong(4, a.getTransportista().getId());
            pstm.setInt(5, a.getTara());
            pstm.setInt(6, a.getBruto());
            pstm.setString(7, a.getIngreso());
            pstm.setString(8, a.getEgreso());
            pstm.setString(9, a.getPatenteChasis());
            pstm.setString(10, a.getPatenteSemi());
            pstm.setString(11, a.getObservaciones());
            pstm.setLong(12, a.getId());

            pstm.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al modificar Ticket");
        }
    }

    @Override
    public void eliminar(Ticket a) throws SQLException {
        try (Connection con = JDBCUtil.getConnection();
                PreparedStatement pstm = con.prepareStatement(DELETE)) {
            pstm.setLong(1, a.getId());

            pstm.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar Ticket");
        }
    }

    @Override
    public List<Ticket> listar() throws SQLException {
        List<Ticket> tickets = new ArrayList<>();

        try (Connection con = JDBCUtil.getConnection();
                PreparedStatement pstm = con.prepareStatement(GETALL);
                ResultSet rs = pstm.executeQuery()) {
            while (rs.next()) {
                Ticket t = new Ticket();
                t.setId(rs.getLong("TICKET_ID"));
                t.setNumero(rs.getLong("NUMERO"));
                t.setProducto(dao.getProductoDAO().obtener(rs.getLong("PRODUCTO_ID")));
                t.setCliente(dao.getEmpresaDAO().obtener(rs.getLong("CLIENTE_ID")));
                t.setTransportista(dao.getEmpresaDAO().obtener(rs.getLong("TRANSPORTISTA_ID")));
                t.setTara(rs.getInt("TARA"));
                t.setBruto(rs.getInt("BRUTO"));
                t.setIngreso(rs.getString("INGRESO"));
                t.setEgreso(rs.getString("EGRESO"));
                t.setPatenteChasis(rs.getString("PATENTECHASIS"));
                t.setPatenteSemi(rs.getString("PATENTESEMI"));
                t.setObservaciones(rs.getString("OBSERVACIONES"));
                tickets.add(t);
            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "No se pudieron obtener los tickets");
        }

        return tickets;
    }

    @Override
    public Ticket obtener(Long id) throws SQLException {
        Ticket t = new Ticket();

        try (Connection con = JDBCUtil.getConnection();
                PreparedStatement pstm = con.prepareStatement(GETONE)) {

            pstm.setLong(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    t.setId(rs.getLong("TICKET_ID"));
                    t.setNumero(rs.getLong("NUMERO"));
                    t.setProducto(dao.getProductoDAO().obtener(rs.getLong("PRODUCTO_ID")));
                    t.setCliente(dao.getEmpresaDAO().obtener(rs.getLong("CLIENTE_ID")));
                    t.setTransportista(dao.getEmpresaDAO().obtener(rs.getLong("TRANSPORTISTA_ID")));
                    t.setTara(rs.getInt("TARA"));
                    t.setBruto(rs.getInt("BRUTO"));
                    t.setIngreso(rs.getString("INGRESO"));
                    t.setEgreso(rs.getString("EGRESO"));
                    t.setPatenteChasis(rs.getString("PATENTECHASIS"));
                    t.setPatenteSemi(rs.getString("PATENTESEMI"));
                    t.setObservaciones(rs.getString("OBSERVACIONES"));
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "No se pudieron obtener los tickets");
        }

        return t;
    }

}
