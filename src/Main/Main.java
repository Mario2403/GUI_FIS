package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import whatsUPM.Usuario;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Usuario usuario = new Usuario(1, "correo1@alumnos.upm.es", "contra1");
        usuario.init();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root =loader.load();
        Controller controller = loader.<Controller>getController();
        controller.setUsuario(usuario);


        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("whatsUPM");
        primaryStage.getIcons().add(new Image("data/AppLogoTransparent.png"));
        primaryStage.setScene(new Scene(root, 556, 345));
        primaryStage.setResizable(false);
        primaryStage.show();



        

    }


    public static void main(String[] args) {
        launch(args);
    }
}
