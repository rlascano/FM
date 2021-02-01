/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmrt.vistas;

import fmrt.dao.imp.DAOManager;
import fmrt.modelo.Categoria;
import fmrt.modelo.Producto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rodrigo
 */
public class ProductosTableModel extends AbstractTableModel {
    
    private final DAOManager dao;
    private List<Producto> datos = new ArrayList<>();
    private final String[] columnNames = {"Categoria", "Nombre"};
    private List<Categoria> categorias;
    
    public ProductosTableModel(DAOManager dao) {
        super();
        this.dao = dao; 
        categorias = new ArrayList<>();
    }      
    
    public void update(String term) throws SQLException {
        if(term == null) {
            datos = dao.getProductoDAO().listar();
            categorias = dao.getCategoriaDAO().listar();            
        } else {
            datos = dao.getProductoDAO().buscarPorNombre(term);
        }    
    }
    
    public Producto getRow(int fila) {
        return datos.get(fila);
    }

    @Override
    public int getRowCount() {
        return datos.size(); 
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Producto p = datos.get(fila);        
        Object res = null;
                
        switch(columna) {
            case 0: 
                for (Categoria c : categorias) {
                    if(Objects.equals(c.getIdCategoria(), p.getIdCategoria())) {
                        res = c.getNombre();
                    }               
                }
                break;
            case 1:  
                res = p.getNombre();
                break;            
            default:
                res = null;
                break;                
        }
        
        return res;
    }
    
}
