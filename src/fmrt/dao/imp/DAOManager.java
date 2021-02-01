/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmrt.dao.imp;

import fmrt.dao.ChoferDAO;
import fmrt.dao.ProductoDAO;
import fmrt.dao.CategoriaDAO;
import fmrt.dao.EmpresaDAO;

/**
 *
 * @author rodrigo
 */
public class DAOManager {
    private ChoferDAO choferDAO = null;
    private ProductoDAO productoDAO = null;
    private CategoriaDAO categoriaDAO = null;
    private EmpresaDAO empresaDAO = null;
    
    public ChoferDAO getChoferDAO() {
        if(choferDAO == null) {
            choferDAO = new ChoferDAOImp();
        }
        
        return choferDAO;
    }
    
    public ProductoDAO getProductoDAO() {
        if(productoDAO == null) {
            productoDAO = new ProductoDAOImp();
        }
        
        return productoDAO;
    }
    
    public CategoriaDAO getCategoriaDAO() {
        if(categoriaDAO == null) {
            categoriaDAO = new CategoriaDAOImp();
        }
        
        return categoriaDAO;
    }
    
    public EmpresaDAO getEmpresaDAO() {
        if(empresaDAO == null) {
            empresaDAO = new EmpresaDAOImp();
        }
        
        return empresaDAO;
    }
}
