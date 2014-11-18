package connection;

/**
 *
 * @author Sandman <sandman.net@gmail.com>
 */

import java.sql.*;
//import precios.Precios;
public class ConexionBD {

public String error="";
public Connection con=null;
private Statement stt;
private ResultSet rSet;

public boolean conectaBD(){
boolean resp=false;
try{
    Class.forName("org.postgresql.Driver").newInstance();
    this.con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/grhusoft","postgres","sandman");
    //System.out.print("Se conecto a la bd");
    resp=true;
    }catch(Exception e){
    //System.out.println("No se puede realizar la conexión");
    System.out.println(e);
}
return resp;
}

public ConexionBD() {
super();
}

public int Inserta (String sentencia){
    int dat=0;
    if(conectaBD()){
        try{
            this.stt=this.con.createStatement();
            dat=this.stt.executeUpdate(sentencia);
            this.stt.close();
            this.con.close();
        }
            catch(Exception e){
            this.error="ERROR al insertar el nuevo Cliente";
        }
    }
    return dat;
}

public int Modifica (String sentencia){
    int dat=0;
    if(conectaBD()){
        try{
            this.stt=this.con.createStatement();
            dat=this.stt.executeUpdate(sentencia);
            this.stt.close();
            this.con.close();
        }
            catch(Exception e){
            this.error="ERROR al modificar el Cliente";
        }
    }
    return dat;
}

public int Elimina (String sentencia){
    int dat=0;
    if(conectaBD()){
        try{
            this.stt=this.con.createStatement();
            dat=this.stt.executeUpdate(sentencia);
            this.stt.close();
            this.con.close();
        }
            catch(Exception e){
            this.error="ERROR al eliminar el nuevo Cliente";
        }
    }
    return dat;
}

public ResultSet listaProductos(String sentencia) {
    
        ResultSet rs = null;
        try
        {
        if(conectaBD()){
            Statement s = con.createStatement();
            rs = s.executeQuery(sentencia);
        }
        }
        catch (Exception e)
        {
             System.out.println("Error: "+e.toString());
        }
        return rs;
    
}

public ResultSet Consulta (String sentencia){
     ResultSet rs = null;
        try
        {
        if(conectaBD()){
            Statement s = con.createStatement();
            rs = s.executeQuery(sentencia);
        }
        }
        catch (Exception e)
        {
             System.out.println("Error: "+e.toString());
        }
        return rs;
}


public static void main(String[] args) {
// TODO Auto-generated method stub
////c.conectaBD();

}
}
