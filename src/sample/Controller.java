package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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

    @FXML
    TextField sentText;

    @FXML
    VBox chatsPane;

    @FXML
    Label sentMessage;

    @FXML
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
        Stage stage =(Stage)bVolver.getScene().getWindow();
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
    void sendMessage(){
        //Nuevo mensaje...
        String texto = sentText.getText();
        Label label= new Label(texto);
        label.setStyle(sentMessage.getStyle());
        label.setAlignment(sentMessage.getAlignment());
        label.setPrefSize(363, 37);
        chatsPane.getChildren().add(label);


    }

    @FXML
    void showAllContacts() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("contactList.fxml"));
        Stage stage =(Stage)bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 350, 492));
        stage.setResizable(false);

    }

    @FXML
    void showAddContacts() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addContactView.fxml"));
        Stage stage =(Stage)bVolver.getScene().getWindow();
        stage.setScene(new Scene(root, 350, 492));
        stage.setResizable(false);

    }

}
