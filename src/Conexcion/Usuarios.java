/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexcion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 *
 * @author dbpan
 */
public class Usuarios {
    private String cedula;
    private String nombre;
    private String apellido;

    public Usuarios() {
    }

    public Usuarios(String cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
public int insertar(Connection conexion) {
        try {
            // Sentencia SQL INSERT
            String sentenciaSQL = "INSERT INTO usuarios (cedula, nombre, apellido) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sentenciaSQL);
            preparedStatement.setString(1, cedula);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, apellido);

            // Ejecutar la sentencia INSERT
            int filasAfectadas = preparedStatement.executeUpdate();
            preparedStatement.close();

            return filasAfectadas;
        } catch (SQLException e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
            return 0;
        }
    }
    
}
