package DAO.arrayList;

import DAO.IAlumnoDAO;
import java.util.Iterator;
import java.util.List;
import modelo.Alumno;

public class AlumnoDAO implements IAlumnoDAO{
    
    List <Alumno> alumnos;
    
    public AlumnoDAO (){
        alumnos = DatosArray.getInstance().alumnos;
    }

    @Override
    public boolean insertar(Alumno alumno){
        Alumno a = alumnos.get(alumnos.size()-1);
        Alumno alumnoCopy = new Alumno(a.getId()+1, alumno.getNombre(), alumno.getApellidos());
        return alumnos.add(alumnoCopy);
      }

    @Override
    public boolean actualizar(Alumno alumno)  {
        boolean isInsertar = false;
        Alumno alumnoActualizar = buscar(alumno.getId());
        if (alumnoActualizar != null){
            alumnoActualizar.setApellidos(alumno.getApellidos());
            alumnoActualizar.setNombre(alumno.getNombre());
            isInsertar = true;
        }
        return isInsertar;
    }

    @Override
    public boolean eliminar(Alumno alumno)  {
         Iterator<Alumno> i = alumnos.iterator();
         Alumno a = null;
         while (i.hasNext()){
            a = i.next();
            if (a.getId() == alumno.getId()){
                return alumnos.remove(a);
            }
         }
         return false;
    }
    
    @Override
    public Alumno buscar(int id) {
         Iterator<Alumno> i = alumnos.iterator();
         Alumno a = null;
         while (i.hasNext()){
            a = i.next();
            if (a.getId() == id){
                return a;
            }
         }
         return null;
    }
    
    @Override
    public List<Alumno> listar(){
        return alumnos;        
    }
    
}
