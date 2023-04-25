
package vue;

import java.net.URL;
import java.rmi.Naming;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.IEtudiants;

public class RegistreController implements Initializable {

    @FXML
    private VBox parent;
    @FXML
    private TextField nom;
    @FXML
    private TextField Login;
    @FXML
    private PasswordField passeWord;
    private Stage s = new Stage();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void seconnecterkey(KeyEvent event) {
        try {
             if (event.getCode() == KeyCode.ENTER) {
                // Action à effectuer lorsque la touche Entrée est pressée
                if(Login.getText().isEmpty() || passeWord.getText().isEmpty() || nom.getText().isEmpty()){
                    Alert alerte = new Alert(Alert.AlertType.ERROR, "Veuillez remplir tous les champs !");
                    alerte.showAndWait();
                }else
                {
                      IEtudiants stub = (IEtudiants) Naming.lookup("rmi://localhost:1099/ETUD");
                      stub.AddEtudiant(Login.getText(), Login.getText(), Login.getText(), new Date());
                      
                      Alert alerte = new Alert(Alert.AlertType.CONFIRMATION, "vous etes enregistrer");
                      alerte.showAndWait();
                        
                        Parent fxml = FXMLLoader.load(getClass().getResource("/vue/login.fxml"));
                        parent.getScene().getWindow().hide();
                        s.setScene(new Scene(fxml));
                        s.initStyle(StageStyle.DECORATED);
                        s.show();
                }

              
            }
        } catch (Exception e) {
             Alert alerte = new Alert(Alert.AlertType.ERROR, "le serveur n'est pas operationel veuiller patienter");
                          alerte.showAndWait();
                           Login.setText("");
                          passeWord.setText("");
        }
    }

    @FXML
    private void enrgistre(ActionEvent event) {
         try {
          
                if(Login.getText().isEmpty() || passeWord.getText().isEmpty() || nom.getText().isEmpty()){
                    Alert alerte = new Alert(Alert.AlertType.ERROR, "Veuillez remplir tous les champs !");
                    alerte.showAndWait();
                }else
                {
                      IEtudiants stub = (IEtudiants) Naming.lookup("rmi://localhost:1099/ETUD");
                      stub.AddEtudiant(nom.getText(), Login.getText(), passeWord.getText(), new Date());
                      
                      Alert alerte = new Alert(Alert.AlertType.CONFIRMATION, "vous etes enregistrer");
                      alerte.showAndWait();
                        
                        Parent fxml = FXMLLoader.load(getClass().getResource("/vue/login.fxml"));
                        parent.getScene().getWindow().hide();
                        s.setScene(new Scene(fxml));
                        s.initStyle(StageStyle.DECORATED);
                        s.show();
                }

        } catch (Exception e) {
                           Alert alerte = new Alert(Alert.AlertType.ERROR, "le serveur n'est pas operationel veuiller patienter");
                           alerte.showAndWait();
                           Login.setText("");
                          passeWord.setText("");
        }
    }

    @FXML
    private void retour(MouseEvent event) {
         try {
                  Parent fxml = FXMLLoader.load(getClass().getResource("/vue/login.fxml"));
                        parent.getScene().getWindow().hide();
                        s.setScene(new Scene(fxml));
                        s.initStyle(StageStyle.DECORATED);
                        s.show();
             } catch (Exception e) {
                 e.printStackTrace();
             }
    }
   }
   
