package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import whatsUPM.Mensaje;
import whatsUPM.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller {

    public Controller() {
        this.usuario = new Usuario(1, "correo1", "contra1");
        this.usuario.init();
    }

    private Usuario usuario;

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

    void initialize() {

    }

    @FXML
    void exit(){
        System.exit(0);
    }

    @FXML
    void changeToChatsList() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("chatsList.fxml"));
        Stage stage =(Stage)bChats.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
    }

    @FXML
    void refreshList(){
        fotoLista.setImage(this.usuario.getAgendas().get(0).getContactos().get(0).getFoto());
        aliasLista.setText(this.usuario.getAgendas().get(0).getContactos().get(0).getAlias());

    }

    @FXML
    void changeToAgendas() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("agendasView.fxml"));
        Stage stage =(Stage)bAgendas.getScene().getWindow();
        stage.setScene(new Scene(root, 382, 458));
        stage.setResizable(false);
    }

    @FXML
    void changeToPerfil() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("perfilView.fxml"));
        Stage stage =(Stage)bPerfil.getScene().getWindow();
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
        Parent root = FXMLLoader.load(getClass().getResource("AboutUs.fxml"));
        Stage stage =(Stage)bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 634, 339));
        stage.setResizable(false);
    }

    @FXML
    void changeToPrincipal() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage stage =(Stage)bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 556, 345));
        stage.setResizable(false);
    }

    @FXML
    void changeToSingleChat() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("chatsView.fxml"));
        Stage stage = (Stage) bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 382, 458));
        stage.setResizable(false);

    }

    @FXML
    void changeToChatsListFromSingleChat() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("chatsList.fxml"));
        Stage stage =(Stage)bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 439, 597));
        stage.setResizable(false);

    }
    @FXML
    void refresh() {

        fotoOtroPerfil.setImage(this.usuario.getAgendas().get(0).getContactos().get(0).getFoto());
        aliasOtroPerfil.setText(this.usuario.getAgendas().get(0).getContactos().get(0).getAlias());


        ArrayList<Mensaje> mensajes = this.usuario.getChats().get(0).getMensajes();

        int size = chatsPane.getChildren().size();
        boolean alreadyInto = false;
        for (Mensaje mensaje : mensajes) {


            Label label = new Label(mensaje.getTexto());        //Creamos el mensaje "gráficamente"
            label.setStyle(sentMessage.getStyle());
            label.setAlignment(sentMessage.getAlignment());
            label.setPrefSize(363, 37);



            for (int i = 0; i <size ; i++) {                        //Confirmamos que no se haya mostrado ya
                Label l =(Label)chatsPane.getChildren().get(i);

                if (l.getText().equalsIgnoreCase(label.getText())){
                    alreadyInto= true;
                }
            }

        if (!alreadyInto)chatsPane.getChildren().add(label);        //Añadimos el mensaje a la conversación



        }
    }
    @FXML
    void sendMessage(){


        String texto = sentText.getText();
    if(!texto.equalsIgnoreCase("")) {                             //Si el mensaje no está vacio...
        Mensaje mensaje = new Mensaje(texto, this.usuario.getIdUsuario());   //Nuevo mensaje
        this.usuario.getChats().get(0).getMensajes().add(mensaje);           //Lo añadimos al chat
        Label label = new Label(texto);                                      //Lo creamos "gráficamente"
        label.setStyle(sentMessage.getStyle());
        label.setAlignment(sentMessage.getAlignment());
        label.setPrefSize(363, 37);
        chatsPane.getChildren().add(label);                                   //Lo añadimos al resto de la conversación
}
    }

    @FXML
    void showAllContacts() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("contactList.fxml"));
        Stage stage =(Stage)bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 350, 492));
        stage.setResizable(false);

    }
    @FXML
    void refreshAgendaList(){
        fotoListaAgenda.setImage(this.usuario.getAgendas().get(0).getContactos().get(0).getFoto());
        aliasListaAgenda.setText(this.usuario.getAgendas().get(0).getContactos().get(0).getAlias());
    }

    @FXML
    void showAddContacts() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addContactView.fxml"));
        Stage stage =(Stage)bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 350, 492));
        stage.setResizable(false);

    }

}
