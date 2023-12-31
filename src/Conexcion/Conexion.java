/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexcion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexion {
    //C:/Users/dbpan/OneDrive/Documentos/sqLite/DB
    private static final String URL = "jdbc:sqlite:./DB/Usuarios";

    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }

    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
