/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucha
 */
import java.util.*;
import java.sql.*;

public class Acciones_cliente {
    
    /*
    Esta clase va a representar el manejo de todas las opciones con la
    cual opera el usuario
    */
    
    //crear una clase de conexion
    
    public static Connection getConnection(){
        String url, user, password;
        //donde esta mi bd
        url="jdbc:mysql://localhost:3306/estetica_clientes";
        user="root";
        password="villegas579";
        
        //objeto de conexion
        Connection con = null;
        try{
            //cuando exista la conexion
            Class.forName("com.mysql.jdbc.Driver");
            //enviamos los parametros de la conexion
            url="jdbc:mysql://localhost:3306/estetica_clientes";
            con = DriverManager.getConnection(url, user, password);
            
            System.out.println("Si se conecto");
            
        }catch(Exception e){
            System.out.println("No se conecto");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        
        return con;
    }
    
    
  
    
    public static int Guardar(Cliente a){
        int estatus = 0;
        
        try{
        
            
            Connection con = Acciones_cliente.getConnection();
            //ahora establezco mi querry
            String q = "insert into Clientes (nombre, apellido, telefono, email,lugar)"
                    + " values (?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
          
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellido());
            ps.setString(3, a.getTelefono());
            ps.setString(4, a.getEmail());
            ps.setString(5, a.getLugar());
            estatus = ps.executeUpdate();
            con.close();
            System.out.println("Registro exitoso");
            
        }catch(Exception e){
            System.out.println("No encontro la tabla");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return estatus;
    }
    
    //editar
    
    public static int Actualizar(Cliente a){
        int estatus = 0;
        
        try{
        
            //voy a mandar a llamar a mi metodo de conexion
            Connection con = Acciones_cliente.getConnection();
            //ahora establezco mi querry
            String q = "update Clientes set nombre = ?,"
                    + " apellido = ?,"
                    + " telefono = ?,"
                    + " email = ?,"
                    + " lugar = ?"
                    + " where id_cliente = ?";
            //preparamos la sentencia de la querry
            PreparedStatement ps = con.prepareStatement(q);
            //tanto obtener como enviar los parametros gracias al encapsulamiento
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellido());
            ps.setString(3, a.getTelefono());
            ps.setString(4, a.getEmail());
            ps.setString(5, a.getLugar());
            ps.setInt(6, a.getId());
            
            estatus = ps.executeUpdate();
            con.close();
            System.out.println("Actualizacion exitosa");
            
        }catch(Exception e){
            System.out.println("No encontro la tabla");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return estatus;
    }
    
    //eliminar
    public static int Eliminar(int id){
        int estatus = 0;
        
        try{
        
            //voy a mandar a llamar a mi metodo de conexion
            Connection con = Acciones_cliente.getConnection();
            //ahora establezco mi querry
            String q = "delete from Clientes where id_cliente = ?";
            //preparamos la sentencia de la querry
            PreparedStatement ps = con.prepareStatement(q);
            //tanto obtener como enviar los parametros gracias al encapsulamiento
            ps.setInt(1, id);
            
            estatus = ps.executeUpdate();
            con.close();
            System.out.println("Borrado exitoso");
            
        }catch(Exception e){
            System.out.println("No encontro la tabla");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return estatus;
    }
    
    
    //buscar por id
    public static Cliente getClienteById(int id){
        //objeto de alumno
        Cliente a = new Cliente();
        
        try{
        
            //voy a mandar a llamar a mi metodo de conexion
            Connection con = Acciones_cliente.getConnection();
            //ahora establezco mi querry
            String q = "select * from Clientes where id_cliente = ?";
            //preparamos la sentencia de la querry
            PreparedStatement ps = con.prepareStatement(q);
            //tanto obtener como enviar los parametros gracias al encapsulamiento
            ps.setInt(1, id);
            //preparo la consulta
            ResultSet rs = ps.executeQuery();
            
            //buscamos dentro de la tabla
            if(rs.next()){
                a.setId(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setApellido(rs.getString(3));
                a.setTelefono(rs.getString(4));
                a.setEmail(rs.getString(5));
                a.setLugar(rs.getString(6));
            }
            
            con.close();
            System.out.println("Consulta exitoso");
            
        }catch(Exception e){
            System.out.println("No encontro la tabla");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return a;
    }
    
    
    //consulta general
    public static List<Cliente> getAllClientes(){
        //objeto de arraylist para almacenar los alumnos
        List<Cliente> lista = new ArrayList<Cliente>();
        
        try{
        
            //voy a mandar a llamar a mi metodo de conexion
            Connection con = Acciones_cliente.getConnection();
            //ahora establezco mi querry
            String q = "select * from Clientes";
            //preparamos la sentencia de la querry
            PreparedStatement ps = con.prepareStatement(q);
            
            //preparo la consulta
            ResultSet rs = ps.executeQuery();
            
            //obtengo toda la tabla y como no se su dimension
            while(rs.next()){
                //objeto de alumno
                Cliente a = new Cliente();
                a.setId(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setApellido(rs.getString(3));
                a.setTelefono(rs.getString(4));
                a.setEmail(rs.getString(5));
                a.setLugar(rs.getString(6));
                lista.add(a);
            }
            
            con.close();
            System.out.println("Consulta exitoso");
            
        }catch(Exception e){
            System.out.println("No encontro la tabla");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return lista;
    } 
}