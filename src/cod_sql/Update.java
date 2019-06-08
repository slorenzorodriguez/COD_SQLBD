/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cod_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Doctor Mantequilla
 */
public class Update {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/Doctor Mantequilla/Documents/NetBeansProjects/test2.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 
    /**
     * Update datos de alumnos especificado por el id
     *
     * @param id
     * @param nombre  
     *  @param apellido 
     * @param telefono 
     */
    public void update(int id, String nombre, String apellido, int telefono) {
        String sql = "UPDATE alumnos SET nombre = ? , "
                + "apellido = ? , "
                 + "telefono = ? "
                + "WHERE id = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // establecer los parametros correctos
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setInt(3, telefono);
            pstmt.setInt(4, id);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Update app = new Update();
        // update en la tabla alumno donde el id sea 1; en este caso Sergio Lorenzo cambia a Pepe Lorenzo; el telefono también cambia.
        app.update(1, "Pepe", "Lorenzo", 555555555);
    }
 
}

