
package DAO;

import java.util.List;
import modelo.Alumno;

public interface IAlumnoDAO {
    
    List<Alumno> listar();
    boolean actualizar(Alumno alumno);
    boolean eliminar(Alumno alumno);
    boolean insertar(Alumno alumno);
    Alumno buscar(int id);
    
}
