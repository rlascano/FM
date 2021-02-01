
package fmrt.dao.imp;

import fmrt.dao.ProductoDAO;
import fmrt.modelo.Producto;
import fmrt.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodrigo
 */
public class ProductoDAOImp implements ProductoDAO {
    private static final Logger LOGGER = Logger.getLogger(ProductoDAOImp.class.getName());
    
    private final String GETALL = "SELECT ID_PRODUCTO, ID_CATEGORIA, NOMBRE"
            + " FROM PRODUCTOS ORDER BY NOMBRE";           
    private final String INSERT = "INSERT INTO PRODUCTOS (ID_CATEGORIA, NOMBRE)"
            + " VALUES (?, ?)";
    private final String UPDATE = "UPDATE PRODUCTOS SET NOMBRE = ?,"
            + " ID_CATEGORIA = ? WHERE ID_PRODUCTO = ?";
    private final String DELETE = "DELETE FROM PRODUCTOS WHERE ID_PRODUCTO ="
            + " ?";
    private final String GETONE = "SELECT ID_PRODUCTO, ID_CATEGORIA, NOMBRE"
            + " FROM PRODUCTOS WHERE ID_PRODUCTO = ?";    
    private final String GETBYNAME = "SELECT ID_PRODUCTO, ID_CATEGORIA, NOMBRE"
            + " FROM PRODUCTOS WHERE NAME LIKE ?";
    private final String FILTER = "SELECT ID_PRODUCTO, ID_CATEGORIA, NOMBRE"
            + " FROM PRODUCTOS WHERE ID_CATEGORIA = ?";    
    
    @Override
    public void insertar(Producto a) throws SQLException {
        try(Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstm = conn.prepareStatement(INSERT)) {
            
            pstm.setLong(1, a.getIdCategoria());
            pstm.setString(2, a.getNombre());            
            
            if(pstm.executeUpdate() == 0) {
                LOGGER.log(Level.WARNING, "No se pudo insertar producto");
                throw new SQLException("No se pudo insertar producto");
            }
        } catch(SQLException ex) {
            LOGGER.log(Level.SEVERE, "No se pudo insertar producto", ex.toString());
            throw new SQLException("No se pudo insertar producto", ex.getLocalizedMessage());
        }
    }

    @Override
    public void modificar(Producto a) throws SQLException {
        try(Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstm = conn.prepareStatement(UPDATE)) {
            
            pstm.setString(1, a.getNombre());
            pstm.setLong(2, a.getIdCategoria());
            pstm.setLong(3, a.getIdProducto());
            
            if(pstm.executeUpdate() == 0) {
                LOGGER.log(Level.WARNING, "No se pudo modificar producto");
                throw new SQLException("No se pudo modificar producto");
            }
        
        } catch(SQLException ex) {
            LOGGER.log(Level.SEVERE, "No se pudo modificar producto", ex.toString());
            throw new SQLException("No se pudo modificar producto");
        }
    }

    @Override
    public void eliminar(Producto a) throws SQLException {
        try(Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstm = conn.prepareStatement(DELETE)) {
            
            pstm.setLong(1, a.getIdProducto());
            
            if(pstm.executeUpdate() == 0) {
                LOGGER.log(Level.WARNING, "No se pudo eliminar producto");
                throw new SQLException();
            }
        } catch(SQLException ex) {
            LOGGER.log(Level.SEVERE, "No se pudo eliminar producto");
                LOGGER.log(Level.WARNING, "No se pudo eliminar producto", ex.toString());
                throw new SQLException();
        }
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> res = new ArrayList<>();
        try(Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstm = conn.prepareStatement(GETALL);
                ResultSet rs = pstm.executeQuery()) {
            
            while(rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getLong("ID_PRODUCTO"));
                p.setIdCategoria(rs.getLong("ID_CATEGORIA"));
                p.setNombre(rs.getString("NOMBRE"));
                res.add(p);
            }        
        } catch(SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener listado de productos");
            throw new SQLException("Error al obteber listado de productos");
        }       
        
        return res;
    }

    @Override
    public Producto obtener(Long id) throws SQLException {
        Producto p = new Producto();
        
        try(Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstm = conn.prepareStatement(GETONE)) {
            
            pstm.setLong(1, id);
            
            try(ResultSet rs = pstm.executeQuery()) {
                if(rs.next()) {
                    p.setIdProducto(rs.getLong("ID_PRODUCTO"));
                    p.setIdCategoria(rs.getLong("ID_CATEGORIA"));
                    p.setNombre(rs.getString("NOMBRE"));
                }    
            }
            
        } catch(SQLException ex) {
            LOGGER.log(Level.SEVERE, "No se pudo obtener producto", ex);
            throw new SQLException();
        }
        
        return p;
    }

    @Override
    public List<Producto> buscarPorNombre(String term) throws SQLException {
        List<Producto> res = new ArrayList<>();
        try(Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstm = conn.prepareStatement(GETBYNAME)) {
            
            pstm.setString(1, "%" + term + "%");
            
            try(ResultSet rs = pstm.executeQuery()) {
                while(rs.next()) {
                    Producto p = new Producto();
                    p.setIdProducto(rs.getLong("ID_PRODUCTO"));
                    p.setIdCategoria(rs.getLong("ID_CATEGORIA"));
                    p.setNombre(rs.getString("NOMBRE"));
                }
            }
        } catch(SQLException ex) {
            LOGGER.log(Level.SEVERE, "No se encontraron productos", ex);
            throw new SQLException();
        }
        
        return res;
    }
    
    @Override
    public List<Producto> filtrarPorCategoria(Long categoriaId) throws SQLException {
        List<Producto> productos = new ArrayList<>();
        
        try(Connection con = JDBCUtil.getConnection();
                PreparedStatement pstm = con.prepareStatement(FILTER)) {
            pstm.setLong(1, categoriaId);
            
            try(ResultSet rs = pstm.executeQuery()) {
                while(rs.next()) {
                    Producto p = new Producto();
                    p.setIdProducto(rs.getLong("ID_PRODUCTO"));
                    p.setIdCategoria(rs.getLong("ID_CATEGORIA"));
                    p.setNombre(rs.getString("NOMBRE"));
                    productos.add(p);
                } 
            }
        } catch(SQLException ex) {
            LOGGER.log(Level.SEVERE, "Hubo un error al filtrar los productos", ex);
        }        
        
        return productos;
    }
}
