/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmrt.vistas;

import fmrt.dao.EmpresaDAO;
import fmrt.modelo.Empresa;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rodrigo
 */
public class EmpresasTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Nombre", "CUIL", "Direccion",
        "Localidad", "Provincia", "País", "Codigo Postal"};
    private List<Empresa> datos = new ArrayList<>();
    private final EmpresaDAO dao;

    public EmpresasTableModel(EmpresaDAO dao) {
        this.dao = dao;
    }

    public void update() throws SQLException {
        datos = dao.listar();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
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
    public Object getValueAt(int fila, int columna) {
        Empresa e = datos.get(fila);
        Object res; 
        
        switch(columna) {
            case 0: 
                res = e.getNombre();                
                break;
            case 1: 
                res = e.getCuil();
                break;
            case 2: 
                res = e.getDireccion();
                break;
            case 3:
                res = e.getLocalidad();
                break;
            case 4: 
                res = e.getProvincia();
                break;
            case 5: 
                res = e.getPais();
                break;
            case 6: 
                res = e.getCodigoPostal();
                break;
            default:
                res = "No existe columna";
        }
        
        return res;
    }
    
    public Empresa getRow(int fila) {
        return datos.get(fila);
    } 
}
