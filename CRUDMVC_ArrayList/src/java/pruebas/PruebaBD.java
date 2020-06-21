
package pruebas;

import DAO.mySql.AlumnoDAO;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import modelo.Alumno;

public class PruebaBD {
        
    public static void main(String[] args) throws SQLException {
           
        //pruebas de la conexion a la base de datos
  /*      Connection con = null;
        
        try {
            con = Conexion.conectar(); 
            if (con != null) {
                System.out.println("La prueba de conexion se realizo con EXITO!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR en la conexion de la base de datos");
        }
    */    
        
//Pruebas del metodo insertar y de la consulta SQL
/*      Alumno a = new Alumno();
        a.setNombre("Pedro");
        a.setApellidos("Castillo");
        AlumnoDAO dao = new AlumnoDAO();
        dao.insertar(a);
   */     
    }
    
}
