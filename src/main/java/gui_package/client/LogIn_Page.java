package gui_package.client;

import gui_package.clientController.LogInController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class LogIn_Page extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
/*        Image image = new Image("SLU_LOGO.jpg");*/

        FXMLLoader fxmlLoader =
                new FXMLLoader(LogIn_Page.class.getResource("src/main/resources/com/java/fmxl/logInPage.fxml"));
        LogInController logInController = fxmlLoader.getController();
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("EMPLOYEE");
/*        primaryStage.getIcons().add(image);*/
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
