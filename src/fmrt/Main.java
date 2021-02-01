/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmrt;

import java.sql.SQLException;
import fmrt.vistas.ProductosFrame;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 *
 * @author rodrigo
 */
public class Main {
    
    private final static Logger LOG_RAIZ = Logger.getLogger("fmrt"); 
    private final static Logger DAO_LOGGER = Logger.getLogger("fmrt.dao.impl");   

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        Handler consoleHandler = new ConsoleHandler(); 
        FileHandler fileHandler = null;
        
        try (FileInputStream f = new FileInputStream("./resources/db.properties")) {
            Properties pros = new Properties();
            pros.load(f);
            String log = pros.getProperty("log");             
            fileHandler = new FileHandler(log, true);
        } catch(IOException ex) {
            System.out.println("Error al encontrar archivo de logs");
        }
        
        
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        fileHandler.setFormatter(simpleFormatter);
        
        LOG_RAIZ.addHandler(consoleHandler);
        LOG_RAIZ.addHandler(fileHandler);
        
        consoleHandler.setLevel(Level.ALL);
        fileHandler.setLevel(Level.ALL);  

        ProductosFrame.main(args);         
    }
    
}
