/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexcion;

/**
 *
 * @author dbpan
 */
import Conexcion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PruebaConexion {
    public static void main(String[] args) {
        Connection conexion = Conexion.obtenerConexion();

        if (conexion != null) {
            System.out.println("Conexión exitosa a la base de datos SQLite.");

            try {
                String consulta = "SELECT * FROM usuarios";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                ResultSet resultado = statement.executeQuery();

                while (resultado.next()) {
                    String cedula = resultado.getString("cedula");
                    String nombre = resultado.getString("nombre");
                    String apellido = resultado.getString("apellido");
                    System.out.println("Cedula: " + cedula + ", Nombre: " + nombre + ", Apellido: " + apellido);
                }

                resultado.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            Conexion.cerrarConexion(conexion);
        } else {
            System.err.println("Error al conectar a la base de datos.");
        }
    }
}