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
 * @author slorenzorodriguez
 */
public class Delete {
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
     * Borrar un alumno de la tabla especificando su id
     *
     * @param id
     */
    public void delete(int id) {
        String sql = "DELETE FROM alumnos WHERE id = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // establecer los parametros
            pstmt.setInt(1, id);
            // ejecutar la consulta delete
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Delete app = new Delete();
        // borrar una linea estableciendo su id, en este caso el 3
        app.delete(3);
    }
 
}

