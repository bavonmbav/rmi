/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import beans.Etudiant;
import java.net.URL;
import java.rmi.Naming;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import service.IEtudiants;


public class TableEtudiantController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField login;
    @FXML
    private TextField password;
    @FXML
    private TableView<Etudiant> tableView;
    @FXML
    private TextField recherche;
   @FXML
    private TableColumn<Etudiant, Integer> idEtu;
    @FXML
    private TableColumn<Etudiant, String> NomEt;
    @FXML
    private TableColumn<Etudiant, String> LoginEt;
    @FXML
    private TableColumn<Etudiant, String> PasseW;
    @FXML
    private TableColumn<Etudiant, String> Dates;

    ObservableList<Etudiant> etudiantData = FXCollections.observableArrayList();
    @FXML
    private ImageView refrech;
    private ListView<Etudiant> listeEtudi;
    @FXML
    private TableView<Etudiant> tab;
    @FXML
    private TableColumn<Etudiant, String> nomet;
    @FXML
    private TableColumn<Etudiant, String> log;
    @FXML
    private TableColumn<Etudiant, String> pass;
    @FXML
    private Text nomText;
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        initialiser();
       
    }    

    @FXML
    private void getRecherche(MouseEvent event) {
        try {
            
            IEtudiants stub = (IEtudiants) Naming.lookup("rmi://localhost:1099/ETUD");
            List<Etudiant> liste = stub.chercherEtudiantId(Integer.parseInt(recherche.getText()));
            for(Etudiant et : liste){
             Alert alerte = new Alert(Alert.AlertType.INFORMATION, "nom : "+et.getNomEd()+" login : " +et.getLogin());
                      alerte.showAndWait();
              
            } 
            
            recherche.setText(" ");
            
             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void getAd(KeyEvent event) {
        try {
             if (event.getCode() == KeyCode.ENTER) {
                // Action à effectuer lorsque la touche Entrée est pressée
                if(login.getText().isEmpty() || password.getText().isEmpty() || nom.getText().isEmpty()){
                    Alert alerte = new Alert(Alert.AlertType.ERROR, "Veuillez remplir tous les champs !");
                    alerte.showAndWait();
                }else
                {
                      IEtudiants stub = (IEtudiants) Naming.lookup("rmi://localhost:1099/ETUD");
                      stub.AddEtudiant(nom.getText(), login.getText(), password.getText(), new Date());
                      
                      Alert alerte = new Alert(Alert.AlertType.INFORMATION, "enregistrement reussi..");
                      alerte.showAndWait();
                      initialiser();
                }

              
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void getADD(ActionEvent event) {
        try {
              if(login.getText().isEmpty() || password.getText().isEmpty() || nom.getText().isEmpty()){
                    Alert alerte = new Alert(Alert.AlertType.ERROR, "Veuillez remplir tous les champs !");
                    alerte.showAndWait();
                }else
                {
                      IEtudiants stub = (IEtudiants) Naming.lookup("rmi://localhost:1099/ETUD");
                      stub.AddEtudiant(nom.getText(), login.getText(), password.getText(), new Date());
                      
                      Alert alerte = new Alert(Alert.AlertType.INFORMATION, "enregistrement reussi..");
                      alerte.showAndWait();
                      initialiser();
                }
        } catch (Exception e) {
        }
    }

    @FXML
    private void getSupp(KeyEvent event) {
        try {
            if (event.getCode() == KeyCode.ENTER){
                IEtudiants stub = (IEtudiants) Naming.lookup("rmi://localhost:1099/ETUD");
                stub.supprimerEtudiant(recherche.getText());
                              Alert alerte = new Alert(Alert.AlertType.INFORMATION, "vous avez supprimer");
                              alerte.showAndWait();
                initialiser();
            }
        } catch (Exception e) {
        }
    }

    @FXML
    private void getSupprimer(ActionEvent event) {
        try {
             IEtudiants stub = (IEtudiants) Naming.lookup("rmi://localhost:1099/ETUD");
             stub.supprimerEtudiant(recherche.getText());
              Alert alerte = new Alert(Alert.AlertType.INFORMATION, "vous avez supprimer");
                      alerte.showAndWait();
                      initialiser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void getModified(KeyEvent event) {
        try {
              if (event.getCode() == KeyCode.ENTER){
                  IEtudiants stub = (IEtudiants) Naming.lookup("rmi://localhost:1099/ETUD");
                    Etudiant etdu = new Etudiant(Integer.parseInt(recherche.getText()),nom.getText() , login.getText(), password.getText());
                    stub.modifierEtudiant(etdu);
                     Alert alerte = new Alert(Alert.AlertType.INFORMATION,"Modification reussi  "+ "nom : "+etdu.getNomEd()+" login : " +etdu.getLogin());
                     alerte.showAndWait();
                    recherche.setText("");
                    nom.setText("");
                    login.setText("");
                    password.setText("");
                initialiser();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void getModifier(ActionEvent event) {
         
        try {
           IEtudiants stub = (IEtudiants) Naming.lookup("rmi://localhost:1099/ETUD");
            Etudiant etdu = new Etudiant(Integer.parseInt(recherche.getText()),nom.getText() , login.getText(), password.getText());
            stub.modifierEtudiant(etdu);
            Alert alerte = new Alert(Alert.AlertType.INFORMATION,"Modification reussi  "+ "nom : "+etdu.getNomEd()+" login : " +etdu.getLogin());
                     alerte.showAndWait();
            recherche.setText("");
            nom.setText("");
            login.setText("");
            password.setText("");
            initialiser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void initialiser()
    {
        try {
            idEtu.setCellValueFactory(new PropertyValueFactory<>("idE"));
            NomEt.setCellValueFactory(new PropertyValueFactory<>("nomEd"));
            LoginEt.setCellValueFactory(new PropertyValueFactory<>("login"));
            PasseW.setCellValueFactory(new PropertyValueFactory<>("passWord"));
            Dates.setCellValueFactory(new PropertyValueFactory<>("date"));
            IEtudiants stub = (IEtudiants) Naming.lookup("rmi://localhost:1099/ETUD");
            List<Etudiant> etudiantDat = stub.listeEtudiant();
            for(Etudiant et:etudiantDat){
                 etudiantData.addAll(et);
                  
            } tableView.setItems(etudiantData); 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
           
    }

    @FXML
    private void selectNom(MouseEvent event) {
           try {
            
           
            IEtudiants stub = (IEtudiants) Naming.lookup("rmi://localhost:1099/ETUD");
            List<Etudiant> liste = stub.chercherEtudiantNom(recherche.getText());
            for(Etudiant et : liste){
               Alert alerte = new Alert(Alert.AlertType.INFORMATION, "nom : "+et.getNomEd()+" login : " +et.getLogin());
                      alerte.showAndWait();
            } 
            
            recherche.setText(" ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
