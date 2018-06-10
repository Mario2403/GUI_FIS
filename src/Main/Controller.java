package Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import whatsUPM.*;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller {
    private Usuario usuario;

    public Controller() {

    }

    void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    /*** Declaracion de etiquetas para referenciar distintos elementos de la GUI ***/

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //ViewPrincipal
    @FXML
    Button bSalir, bChats, bAgendas, bEnviar, bPerfil, bVolver;

    //View Chats
    @FXML
    TextField sentText;

    @FXML
    VBox chatsPane;

    @FXML
    Label sentMessage, otherMessage, aliasOtroPerfil;

    @FXML
    ImageView fotoOtroPerfil;

    //View Perfil

    @FXML
    Label alias, correo, descripcion;

    @FXML
    ImageView fotoPerfil;

    //ViewAgendas View

    @FXML
    Label categoria;

    //ChatsList View

    @FXML
    Label aliasLista;

    @FXML
    ImageView fotoLista;

    //AgendaList View

    @FXML
    Label aliasListaAgenda;

    @FXML
    ImageView fotoListaAgenda;

    //AgendaCreate View

    @FXML
    Button bCrear;

    @FXML
    CheckBox ch1, ch2, ch3, ch4;

    @FXML
    TextField nombreAgenda;

    /*** Fin etiquetas ***/

    void initialize() {

    }

    @FXML
    void exit() {
        System.exit(0);
    }

    /*** Metodos para cambiar entre ventanas ***/


    @FXML
    void changeToChatsList() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chatsList.fxml")); //Cargamos el archivo FXML
        Parent root = loader.load();
        Controller controller = loader.<Controller>getController();
        controller.setUsuario(usuario);                             //Le pasamos al controller el usuario actual

        Stage stage = (Stage) bChats.getScene().getWindow();        //Cambiamos la ventana
        stage.setScene(new Scene(root));
        stage.setResizable(false);
    }


    @FXML
    void changeToAgendas() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("agendasView.fxml"));
        Parent root = loader.load();
        Controller controller = loader.<Controller>getController();
        controller.setUsuario(usuario);

        Stage stage = (Stage) bAgendas.getScene().getWindow();
        stage.setScene(new Scene(root, 382, 458));
        stage.setResizable(false);
    }

    @FXML
    void changeToPerfil() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("perfilView.fxml"));
        Parent root = loader.load();
        Controller controller = loader.<Controller>getController();
        controller.setUsuario(usuario);

        Stage stage = (Stage) bPerfil.getScene().getWindow();
        stage.setScene(new Scene(root, 502, 460));
        stage.setResizable(false);
    }


    @FXML
    void showAboutUs() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AboutUs.fxml"));
        Parent root = loader.load();
        Controller controller = loader.<Controller>getController();
        controller.setUsuario(usuario);

        Stage stage = (Stage) bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 634, 339));
        stage.setResizable(false);
    }


    @FXML
    void changeToPrincipal() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller controller = loader.<Controller>getController();
        controller.setUsuario(usuario);

        Stage stage = (Stage) bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 556, 345));
        stage.setResizable(false);
    }

    @FXML
    void changeToSingleChat() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chatsView.fxml"));
        Parent root = loader.load();
        Controller controller = loader.<Controller>getController();
        controller.setUsuario(usuario);

        Stage stage = (Stage) bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 382, 458));
        stage.setResizable(false);

    }

    @FXML
    void changeToChatsListFromSingleChat() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chatsList.fxml"));
        Parent root = loader.load();
        Controller controller = loader.<Controller>getController();
        controller.setUsuario(usuario);

        Stage stage = (Stage) bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 439, 597));
        stage.setResizable(false);

    }

    @FXML
    void showAllContacts() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("contactList.fxml"));
        Parent root = loader.load();
        Controller controller = loader.<Controller>getController();
        controller.setUsuario(usuario);

        Stage stage = (Stage) bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 350, 492));
        stage.setResizable(false);

    }


    @FXML
    void showAddContacts() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addContactView.fxml"));
        Parent root = loader.load();
        Controller controller = loader.<Controller>getController();
        controller.setUsuario(usuario);

        Stage stage = (Stage) bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 350, 492));
        stage.setResizable(false);

    }

    /*** Fin metodos de cambio de ventanas ***/


    /*** Metodos de actualizacion de ventanas ***/
    @FXML
    private void showPerfil() {
        alias.setText(this.usuario.getPerfil().getAlias());
        correo.setText(this.usuario.getCorreo());
        descripcion.setText(this.usuario.getPerfil().getDescripcion());
        fotoPerfil.setImage(this.usuario.getPerfil().getFoto());
    }

    @FXML
    void refreshList() {
        fotoLista.setImage(this.usuario.getAgendas().get(0).getContactos().get(0).getFoto());
        aliasLista.setText(this.usuario.getAgendas().get(0).getContactos().get(0).getAlias());


    }

    @FXML
    void refresh() {

        fotoOtroPerfil.setImage(this.usuario.getAgendas().get(0).getContactos().get(0).getFoto());      //Extraemos la foto del usuario
        aliasOtroPerfil.setText(this.usuario.getAgendas().get(0).getContactos().get(0).getAlias());     //Extraemos el alias del usuario

        ArrayList<Mensaje> mensajes = this.usuario.getChats().get(0).getMensajes();                     //Extraemos los contactos de su agenda

        try {
            List<String> p = Files.readAllLines(Paths.get("C:/ChatsWhatsUPM/chat0.txt"), Charset.defaultCharset()); //Abrimos fichero correspondiente al chat
            for (String eLista : p) {                                       //Formato del mensaje: "idusuario|mensaje\n"
                String eidUser = eLista.substring(0, 1);                    //Extraemos el idUsuario
                String eTexto = eLista.substring(2);                        //Extraemos el mensaje
                mensajes.add(new Mensaje(eTexto, Integer.parseInt(eidUser)));   //añadimos el mensaje al objeto usuario

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        boolean alreadyInto = false;
        for (Mensaje mensaje : mensajes) {

            Label label = new Label(mensaje.getTexto());        //Creamos el mensaje "gráficamente"
            if (mensaje.getUsuarioOrigen() == 1) {              //Comprobamos si el mensaje es nuestro o de la otra persona

                label.setStyle(sentMessage.getStyle());
                label.setAlignment(sentMessage.getAlignment());
                label.setPrefSize(363, 37);
            } else { //es de la otra persona

                label.setStyle(otherMessage.getStyle());
                label.setAlignment(otherMessage.getAlignment());
                label.setPrefSize(363, 37);

            }

            int size = chatsPane.getChildren().size();
            for (int i = 0; i < size; i++) {                        //Confirmamos que no se haya mostrado ya
                Label l = (Label) chatsPane.getChildren().get(i);

                if (l.getText().equalsIgnoreCase(label.getText())) {
                    alreadyInto = true;
                }
            }
            chatsPane.setMargin(label, new Insets(0, 0, 5, 0));

            if (!alreadyInto) chatsPane.getChildren().add(label);        //Añadimos el mensaje a la conversación


        }
    }

    @FXML
    void sendMessage() {


        String texto = sentText.getText();
        if (!texto.equalsIgnoreCase("")) {                             //Si el mensaje no está vacio...
            Mensaje mensaje = new Mensaje(texto, this.usuario.getIdUsuario());   //Nuevo mensaje
            this.usuario.getChats().get(0).getMensajes().add(mensaje);           //Lo añadimos al chat
            Label label = new Label(texto);                                      //Lo creamos "gráficamente"
            label.setStyle(sentMessage.getStyle());
            label.setAlignment(sentMessage.getAlignment());
            label.setPrefSize(363, 37);
            label.setPadding(new Insets(5, 5, 5, 5));
            chatsPane.setMargin(label, new Insets(0, 0, 5, 0));

            chatsPane.getChildren().add(label);                                   //Lo añadimos al resto de la conversación

            //Formateamos el String dfel mensaje  "idusuario|mensaje\n"
            texto = this.usuario.getIdUsuario().toString() + "|" + texto + "\n";


            //Guardamos el mensaje en le fichero (Base de datos local).

            try {
                Files.write(Paths.get("C:/ChatsWhatsUPM/chat0.txt"), texto.getBytes(), StandardOpenOption.APPEND);


            } catch (IOException e) {}
        }


    }


    @FXML
    void refreshAgendaList() {
        fotoListaAgenda.setImage(this.usuario.getAgendas().get(0).getContactos().get(0).getFoto());         //Extraemos la foto del usuario
        aliasListaAgenda.setText(this.usuario.getAgendas().get(0).getContactos().get(0).getAlias());        //Extraemos el alias del usuario

        /*  //Implementacion en base de datos (necesita un servidor de MySQL en local)
        try {
            ArrayList<String> usuarios = AccesoABD.recibirUsuarios(this.usuario.getPerfil().getAlias());
            ArrayList<Perfil> perfiles = new ArrayList<>();
            for (String s : usuarios) {

                Perfil p = new Perfil(s);
                perfiles.add(p);
            }
            this.usuario.getAgendas().get(0).setContactos(perfiles);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(this.usuario.getAgendas().get(0).getContactos().size());
        */
    }

    @FXML
    void crearAgenda() {
        ArrayList<Perfil> contactos = new ArrayList<>();
        if (ch1.isSelected()) contactos.add(this.usuario.getAgendas().get(0).getContactos().get(0));        //Extraemos de cada checkBox el perfil seleccionado
        if (ch2.isSelected()) contactos.add(this.usuario.getAgendas().get(0).getContactos().get(1));
        if (ch3.isSelected()) contactos.add(this.usuario.getAgendas().get(0).getContactos().get(2));
        if (ch4.isSelected()) contactos.add(this.usuario.getAgendas().get(0).getContactos().get(3));


        Agenda nuevaAgenda = new Agenda(contactos, nombreAgenda.getText(), 1);
        this.usuario.getAgendas().add(nuevaAgenda);                                     //añadimos la nueva agenda

    }

}
