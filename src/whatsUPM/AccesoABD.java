package whatsUPM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class AccesoABD {

    private  static final String user = "Asier";
    private  static final String userPass = "AsierAC";

    //private  static final String user = "Mario";
    //private  static final String userPass = "MarioJS";

    private  static final String urlBD = "jdbc:mysql://127.0.0.1:8889/WhatsUPM?useLegacyDatetimeCode=false&amp&&serverTimezone=UTC";
    private static Connection conexionBD = null;

    public static Connection getConexionBD() {
        return conexionBD;
    }


    private static Connection obtenerConexionBD () throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
       Connection connection = DriverManager.getConnection(urlBD, user, userPass);
        return connection;
    }

    public static boolean mandarMensaje(String mensaje, String chat) throws SQLException, ClassNotFoundException { //como throwea, añadir mensaje GUI
         conexionBD = obtenerConexionBD();

        //parametro chat deberá ser del tipo : `Chat:num-num`. El método obtenerChat() devuelve el chat en ese formato.
        //origen y destino.

        String query = "insert into "+ chat +" (mensaje) value (?)";
        PreparedStatement mandarMensaje = conexionBD.prepareStatement(query);
        mandarMensaje.setString(1, mensaje);

        Boolean correcto= !mandarMensaje.execute();

        conexionBD.close();
        return correcto; //True-->El mensaje se ha enviado correctamente False--> No creo que aparezca, antes peta una excepcion.
    }

    public static ArrayList<String> recibirUsuarios (String usuario) throws SQLException, ClassNotFoundException { //Para la agenda
        ArrayList<String> listaUsuarios = new ArrayList<>();

         conexionBD = obtenerConexionBD();

        Statement s = conexionBD.createStatement();
        ResultSet rs = s.executeQuery("SELECT nombre_usuario FROM Usuarios WHERE nombre_usuario <> \""+ usuario +"\"");

        while (rs.next()){
            listaUsuarios.add(rs.getString(1));
        }
        conexionBD.close();
        return listaUsuarios;
    }

    public static String obtenerChat(String nombre_usuarioOrigen, String nombre_usuarioDestino) throws SQLException, ClassNotFoundException {
         conexionBD = obtenerConexionBD();

        String query = "select id from Usuarios where nombre_usuario LIKE ?";

        //Obtener id del usuario Origen:
        PreparedStatement s = conexionBD.prepareStatement(query);
        s.setString(1, nombre_usuarioOrigen);

        ResultSet rs =s.executeQuery();
        rs.next();
        int idO = rs.getInt("id");

        //Obtener id del usuario Destino:
        s=conexionBD.prepareStatement(query);
        s.setString(1,nombre_usuarioDestino);

        rs=s.executeQuery();
        rs.next();
        int idD = rs.getInt("id");

        conexionBD.close();

        String chat = "`Chat:"+ idO+"-"+ idD+"`";
        return chat;
    }

    public static ArrayList<String> recibirMensajes (String chat) throws SQLException, ClassNotFoundException {

        //IMPORTANTE: Esta funcion no puede cerrar la conexion ya que si la cierra no se podrá acceder al ResultSet.
        //Despues de la llamada a esta función y del tratamiento del ResultSet se cerrará la conexion con getConexionBD
        //y con conexionBD.close();
         conexionBD = obtenerConexionBD();

        String query = "select * from "+ chat;
        Statement s = conexionBD.createStatement();
        ResultSet rs = s.executeQuery(query);

        ArrayList<String> mensajes = new ArrayList<>();
        while (rs.next()){
            mensajes.add(rs.getString(2));
        }



        conexionBD.close();
        return mensajes;
    }

}
