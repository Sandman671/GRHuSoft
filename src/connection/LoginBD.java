package connection;

import java.sql.ResultSet;
import tables.*;
import warnings.*;

/**
 *
 * @author Sandman <sandman.net@gmail.com>
 */
public class LoginBD {

    private ResultSet datos;
    private int datos2;
    ConexionBD conecta=new ConexionBD();
    login l = new login();
    String rol;

public int insertarsesion(login log)
{
    datos=this.conecta.Consulta("SELECT rol FROM usuarios where usuario= '"+log.getUsuario()+"'");
    try {
           
    while (datos.next()) {
                  rol=(datos.getString("rol"));
            }
    } catch (Exception e) {

            Warning1 w = new Warning1();
            w.setVisible(true);

        }
    datos2=this.conecta.Inserta("INSERT into sesiones (usuario,rol,fecha,hora_inicio,hora_cierre)values ( '"+log.getUsuario()+"','" + rol + "',CURRENT_DATE,CURRENT_TIME,CURRENT_TIME)");
    return datos2;
}




    public ResultSet consultausuario(login l)
{
    datos=this.conecta.Consulta("SELECT * FROM usuarios where usuario= '"+l.getUsuario()+"' and pass='" +l.getPass()+"'");
    return datos;
}




}
