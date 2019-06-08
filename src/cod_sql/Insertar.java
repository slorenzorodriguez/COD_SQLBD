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
public class Insertar {
     private Connection connect() {
        //parametros de conexion
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
     *Insertar una linea en la tabla alumnos
     *
     * @param nombre
     * @param apellido
     * @param telefono
     */
    public void insert(String nombre, String apellido, int telefono) {
        String sql = "INSERT INTO alumnos(nombre,apellido,telefono) VALUES(?,?,?)";
 
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setInt(3, telefono);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        Insertar app = new Insertar();
        //insertamos 3 lineas a la tabla
        app.insert("Sergio", "Lorenzo", 612345678);
       app.insert("Gerardo", "Silva", 123456789);
       app.insert("David", "Cuña", 987654321);
    }
 
}

