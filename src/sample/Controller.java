package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import whatsUPM.*;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller {
    private Usuario usuario;

    public Controller() {
        //this.usuario = new Usuario(1, "correo1", "contra1");
        //this.usuario.init();
        //this.usuario.getData();

        /*añadir un get data para que cada vez que el controller se instancia, se guarden los cambios realizados en la GUI,
          se deberia elmiminar el método init (incluirlo en el constructor de usuario) y, mediante el método getData
          sobreescribir los valores del usuario (La primera vez seran los mismos, un doble init).
        */

    }

    void setUsuario(Usuario usuario){
        this.usuario=usuario;
    }



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //ViewPrincipal
    @FXML
    Button bSalir;

    @FXML
    Button bChats;

    @FXML
    Button bAgendas;

    @FXML
    Button bEnviar;

    @FXML
    Button bPerfil;

    @FXML
    Button bVolver;

    //View Chats
    @FXML
    TextField sentText;

    @FXML
    VBox chatsPane;

    @FXML
    Label sentMessage;

    @FXML
    Label otherMessage;

    @FXML
    ImageView fotoOtroPerfil;

    @FXML
    Label aliasOtroPerfil;


    //View Perfil

    @FXML
    Label alias;

    @FXML
    Label correo;

    @FXML
    Label descripcion;

    @FXML
    ImageView fotoPerfil;

    //View Agendas View

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
    CheckBox ch1;

    @FXML
    CheckBox ch2;

    @FXML
    CheckBox ch3;

    @FXML
    CheckBox ch4;

    @FXML
    TextField nombreAgenda;


    void initialize() {

    }

    @FXML
    void exit() {
        System.exit(0);
    }

    @FXML
    void changeToChatsList() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chatsList.fxml"));
        Parent root =loader.load();
        Controller controller = loader.<Controller>getController();
        controller.setUsuario(usuario);

        //Parent root = FXMLLoader.load(getClass().getResource("chatsList.fxml"));
        Stage stage = (Stage) bChats.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
    }

    @FXML
    void refreshList() {
        fotoLista.setImage(this.usuario.getAgendas().get(0).getContactos().get(0).getFoto());
        aliasLista.setText(this.usuario.getAgendas().get(0).getContactos().get(0).getAlias());


    }

    @FXML
    void changeToAgendas() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("agendasView.fxml"));
        Parent root =loader.load();
        Controller controller = loader.<Controller>getController();
        controller.setUsuario(usuario);

        //Parent root = FXMLLoader.load(getClass().getResource("agendasView.fxml"));
        Stage stage = (Stage) bAgendas.getScene().getWindow();
        stage.setScene(new Scene(root, 382, 458));
        stage.setResizable(false);
    }

    @FXML
    void changeToPerfil() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("perfilView.fxml"));
        Parent root =loader.load();
        Controller controller = loader.<Controller>getController();
        controller.setUsuario(usuario);



        //Parent root = FXMLLoader.load(getClass().getResource("perfilView.fxml"));
        Stage stage = (Stage) bPerfil.getScene().getWindow();
        stage.setScene(new Scene(root, 502, 460));
        stage.setResizable(false);
    }

    @FXML
    private void showPerfil() {
        alias.setText(this.usuario.getPerfil().getAlias());
        correo.setText(this.usuario.getCorreo());
        descripcion.setText(this.usuario.getPerfil().getDescripcion());
        fotoPerfil.setImage(this.usuario.getPerfil().getFoto());
    }

    @FXML
    void showAboutUs() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AboutUs.fxml"));
        Parent root =loader.load();
        Controller controller = loader.<Controller>getController();
        controller.setUsuario(usuario);

        //Parent root = FXMLLoader.load(getClass().getResource("AboutUs.fxml"));
        Stage stage = (Stage) bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 634, 339));
        stage.setResizable(false);
    }

    @FXML
    void changeToPrincipal() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root =loader.load();
        Controller controller = loader.<Controller>getController();
        controller.setUsuario(usuario);

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage stage = (Stage) bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 556, 345));
        stage.setResizable(false);
    }

    @FXML
    void changeToSingleChat() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chatsView.fxml"));
        Parent root =loader.load();
        Controller controller = loader.<Controller>getController();
        controller.setUsuario(usuario);

        //Parent root = FXMLLoader.load(getClass().getResource("chatsView.fxml"));
        Stage stage = (Stage) bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 382, 458));
        stage.setResizable(false);

    }

    @FXML
    void changeToChatsListFromSingleChat() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chatsList.fxml"));
        Parent root =loader.load();
        Controller controller = loader.<Controller>getController();
        controller.setUsuario(usuario);

        //Parent root = FXMLLoader.load(getClass().getResource("chatsList.fxml"));
        Stage stage = (Stage) bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 439, 597));
        stage.setResizable(false);

    }

    @FXML
    void refresh() {

        fotoOtroPerfil.setImage(this.usuario.getAgendas().get(0).getContactos().get(0).getFoto());
        aliasOtroPerfil.setText(this.usuario.getAgendas().get(0).getContactos().get(0).getAlias());
        /*
        ArrayList<Mensaje> s = new ArrayList<>();

        try {
            ArrayList<String> mensajes= AccesoABD.recibirMensajes(AccesoABD.obtenerChat(this.usuario.getAgendas().get(0).getContactos().get(0).getAlias(),this.usuario.getPerfil().getAlias()));
            for (String mensajesBD : mensajes
                 ) {
                s.add(new Mensaje(mensajesBD,this.usuario.getPerfil().getAlias()));
                System.out.println(mensajesBD);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            }
        */
        //this.usuario.getChats().get(0).setMensajes(s);


        ArrayList<Mensaje> mensajes = this.usuario.getChats().get(0).getMensajes();

        try {
            List<String> p=Files.readAllLines(Paths.get("C:/ChatsWhatsUPM/chat0.txt"), Charset.defaultCharset());
            for (String eLista: p) {
                String eidUser = eLista.substring(0,1);
                String eTexto = eLista.substring(2);
                mensajes.add(new Mensaje(eTexto, Integer.parseInt(eidUser)));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        boolean alreadyInto = false;
        for (Mensaje mensaje : mensajes) {

            Label label = new Label(mensaje.getTexto());        //Creamos el mensaje "gráficamente"
            if(mensaje.getUsuarioOrigen()==1) {

                label.setStyle(sentMessage.getStyle());
                label.setAlignment(sentMessage.getAlignment());
                label.setPrefSize(363, 37);
            }
            else{

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

/*
            try {
                AccesoABD.mandarMensaje(texto, AccesoABD.obtenerChat(this.usuario.getPerfil().getAlias(), this.usuario.getAgendas().get(0).getContactos().get(0).getAlias()));
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            */

            /*If writting to a file*/


            //Modify the text string
            texto=this.usuario.getIdUsuario().toString()+ "|" + texto + "\n";


            //Write process

            try {
                Files.write(Paths.get("C:/ChatsWhatsUPM/chat0.txt"), texto.getBytes(), StandardOpenOption.APPEND);


            }catch (IOException e) {
            }
        }

        /*If storing to a database*/



    }

    @FXML
    void showAllContacts() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("contactList.fxml"));
        Parent root =loader.load();
        Controller controller = loader.<Controller>getController();
        controller.setUsuario(usuario);

        //Parent root = FXMLLoader.load(getClass().getResource("contactList.fxml"));
        Stage stage = (Stage) bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 350, 492));
        stage.setResizable(false);

    }

    @FXML
    void refreshAgendaList() {
        fotoListaAgenda.setImage(this.usuario.getAgendas().get(0).getContactos().get(0).getFoto());
        aliasListaAgenda.setText(this.usuario.getAgendas().get(0).getContactos().get(0).getAlias());
        try {
            ArrayList<String> usuarios = AccesoABD.recibirUsuarios(this.usuario.getPerfil().getAlias());
            ArrayList<Perfil> perfiles = new ArrayList<>();
            for (String s: usuarios) {

                Perfil p = new Perfil(s);
                perfiles.add(p);
                //this.usuario.getAgendas().get(0).getContactos().add(new Perfil(s));
            }
            this.usuario.getAgendas().get(0).setContactos(perfiles);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(this.usuario.getAgendas().get(0).getContactos().size());
    }

    @FXML
    void showAddContacts() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addContactView.fxml"));
        Parent root =loader.load();
        Controller controller = loader.<Controller>getController();
        controller.setUsuario(usuario);

        //Parent root = FXMLLoader.load(getClass().getResource("addContactView.fxml"));
        Stage stage = (Stage) bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 350, 492));
        stage.setResizable(false);

    }

    @FXML
    void crearAgenda(){
        ArrayList<Perfil> contactos = new ArrayList<>();
        if(ch1.isSelected()) contactos.add(this.usuario.getAgendas().get(0).getContactos().get(0));
        if(ch2.isSelected()) contactos.add(this.usuario.getAgendas().get(0).getContactos().get(1));
        if(ch3.isSelected()) contactos.add(this.usuario.getAgendas().get(0).getContactos().get(2));
        if(ch4.isSelected()) contactos.add(this.usuario.getAgendas().get(0).getContactos().get(3));


        Agenda nuevaAgenda = new Agenda(contactos, nombreAgenda.getText(),1);
        this.usuario.getAgendas().add(nuevaAgenda);

        System.out.println(this.usuario.getAgendas());


    }

}
