package DAO.arrayList;

import java.util.ArrayList;
import java.util.List;
import modelo.Alumno;


public class DatosArray {
    private static DatosArray instance ;
    public List <Alumno> alumnos;
    
    private DatosArray(){
        alumnos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Alumno alumno = new Alumno (i, "nombre"+i, "apellidos"+i);
            alumnos.add(alumno);
        }
    }
    
    public static DatosArray getInstance() {
        if (instance == null) {
            instance = new DatosArray();
        }
        return instance;
    }
}
