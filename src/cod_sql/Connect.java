/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cod_sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author slorenzorodriguez
 */
public class Connect {

    /**
     * @param args the command line arguments
     */
 public static void connect() {
        Connection conn = null;
        try {
            // establecemos parámetros de la base de datos
            String url = "jdbc:sqlite:C:/Users/Doctor Mantequilla/Documents/NetBeansProjects";
            // creamos la conexion a la base 
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
 //metodo para crear la base de datos
 public static void createNewDatabase(String fileName) {
 //establecemos la url dónde queramos crear dicha base de datos
        String url = "jdbc:sqlite:C:/Users/Doctor Mantequilla/Documents/NetBeansProjects/" + fileName;
 
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          connect();
          createNewDatabase("test2.db");
    }
}
    

