package DAO.mySql;

import DAO.IAlumnoDAO;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Alumno;

public class AlumnoDAO implements IAlumnoDAO{
    
    final String GETALL = "SELECT * FROM alumnos";
    final String INSERT = "INSERT INTO alumnos(nombre, apellidos) VALUES (?,?)";
    final String GETONE = "SELECT id_alumno, nombre, apellidos FROM alumnos WHERE id_alumno = ?";
    final String UPDATE = "UPDATE alumnos SET nombre = ?, apellidos = ? WHERE id_alumno = ?";
    final String DELETE = "DELETE FROM alumnos WHERE id_alumno = ?";

    
    @Override
    public boolean insertar(Alumno alumno){
       boolean isInsertar = false;
        Connection con = null;
        
        PreparedStatement stat = null;
        try {
            con = Conexion.conectar();
            stat = con.prepareStatement(INSERT);
            stat.setString(1, alumno.getNombre());
            stat.setString(2, alumno.getApellidos());
            System.out.println("Insercion EXITOSA");
            if (stat.executeUpdate() == 0){
                System.out.println("Error: método insertar");
            }
        } catch (SQLException e) {
            System.out.println("Error: método insertar");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error2: método actualizar");
        }finally{
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {}
            }
        }
        return isInsertar;
      }

    @Override
    public boolean actualizar(Alumno alumno){
        boolean isActualizar = false;
        Connection con = null;
       
        PreparedStatement stat = null;
        try {
            con = Conexion.conectar();
            stat = con.prepareStatement(UPDATE);
            stat.setString(1, alumno.getNombre());
            stat.setString(2, alumno.getApellidos());
            stat.setInt(3, alumno.getId());
            if (stat.executeUpdate() == 0){
                System.out.println("Error1: método actualizar");
            }
            
        } catch (SQLException e) {
            System.out.println("Error2: método actualizar");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error2: método actualizar");
        }finally{
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {}
            }
        }
        return isActualizar;
    }

    @Override
    public boolean eliminar(Alumno alumno){
        boolean isEliminar= false;
        Connection con = null;
        
        PreparedStatement stat = null;
        try {
            con = Conexion.conectar();
            stat = con.prepareStatement(DELETE);
            stat.setInt(1, alumno.getId());
            if (stat.executeUpdate() == 0){
                 System.out.println("Error1: método eliminar");
            }
        } catch (SQLException e) {
             System.out.println("Error2: método eliminar");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error2: método eliminar");
        }finally{
            if (stat != null) 
                try {
                    stat.close();
            } catch (SQLException ex) {}
            }
        return isEliminar;
    }
    
    @Override
    public Alumno buscar(int id){
        Connection con = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        Alumno a = null;
        try {
            con = Conexion.conectar();
            stat = con.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                a = convertir(rs);
            }else{
                System.out.println("No se encontro el registro");
            }
        } catch (SQLException e) {
            System.out.println("Error: método buscar");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: método buscar");
        }finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {}
            }
            
            if (stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {}
            }
        }
        return a;        
    }
    
    @Override
    public List<Alumno> listar(){
        Connection con = null;
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        List <Alumno> alumnos = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stat = con.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {                
                alumnos.add(convertir(rs));
            }
        } catch (SQLException e) {
            System.out.println("Error: método listar");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: método listar");
        }finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {}
            }
            
            if (stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {}
            }
        }
        return alumnos;        
    }
    
    private Alumno convertir (ResultSet rs)throws SQLException{
        String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        int id = rs.getInt("id_alumno");
        Alumno alumno = new Alumno (id, nombre, apellidos);
        return alumno;
    }


    
}
