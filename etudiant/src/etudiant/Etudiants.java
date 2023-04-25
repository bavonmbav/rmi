
package etudiant;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Etudiants extends Application {
    
    @Override
    public void start(Stage primaryStage) {
     try {
            Parent root = FXMLLoader.load(getClass().getResource("/vue/login.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.show();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());   
        }
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
