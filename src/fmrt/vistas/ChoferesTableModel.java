/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmrt.vistas;

import fmrt.dao.ChoferDAO;
import fmrt.modelo.Chofer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rodrigo
 */
public class ChoferesTableModel extends AbstractTableModel {
    
    private final ChoferDAO choferDAO;
    private List<Chofer> datos = new ArrayList<>();
    private final String[] columnNames = {"Apellido", "Nombre", "DNI"};
    
    public ChoferesTableModel(ChoferDAO choferDAO) {
        super();
        this.choferDAO = choferDAO;        
    }    
    
    public void update(String term) throws SQLException {
        if(term == null) {
            datos = choferDAO.listar();
        } else {
            datos = choferDAO.buscarPorApellido(term);
        }    
    }
    
    public Chofer getRow(int fila) {
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
        Chofer c = datos.get(fila);
        Object res;
        
        switch(columna) {
            case 0: 
                res = c.getApellido();
                break;
            case 1:  
                res = c.getNombre();
                break;
            case 2: 
                res = c.getDni();
                break;
            default:
                res = null;
                break;                
        }
        
        return res;
    }    
}
