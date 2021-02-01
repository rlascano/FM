/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmrt.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodrigo
 */
public class JDBCUtil {
   private static final Logger LOGGER = Logger.getLogger(JDBCUtil.class.getName());
    
   /**
     * Get database connection
     *
     * @return a Connection object
     * @throws SQLException
   */    
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
 
        try (FileInputStream f = new FileInputStream("./resources/db.properties")) {
 
            // load the properties file
            Properties pros = new Properties();
            pros.load(f);
 
            // assign db parameters
            String url = pros.getProperty("url");            
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);            
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "No se puede conectar a la base de datos", e);
        }
        return conn;
    }
}
