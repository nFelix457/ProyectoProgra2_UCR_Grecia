
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {

    public static Connection conectar() throws ClassNotFoundException {
        Connection con = null;

        String password = "denisgh";
        String usuario = "denisgh";
        String url = "jdbc:mysql://localhost:3306/alumnos3";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, password);
            if (con != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
            e.printStackTrace();
        }
        return con;
    }
}