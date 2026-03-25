package org.example;

import java.sql.*;

public class Main{
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword()
        ); Statement statement = connection.createStatement()) {
            //Preparar el String para insertar datos
            String sql = "INSERT INTO empleado(id, nombre, salario) VALUES (?,?,?)";
            //statement.executeUpdate(sql);

            //Preparar el statement para introducir los datos
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //Se introducen en el orden asignado en el String
            preparedStatement.setInt(1, 6);
            preparedStatement.setString(2, "Sabrina");
            preparedStatement.setDouble(3, 5.67);
            preparedStatement.executeUpdate();
            System.out.println("Registro insertado correctamente.");

            /* int n = ps.executeUpdate
            * sout(n) --> Mostrar número de líneas afectadas*/

        } catch (SQLException e) {
            System.out.println("ERROR --> " + e.getMessage());
        }
    }
}
