/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.net.InetAddress;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import rmiserveur.MovePane;
import service.EtudiantService;

/**
 * FXML Controller class
 *
 * @author 18mt4
 */
public class ServeurRmiController implements Initializable {

    @FXML
    private ImageView imagess;
    @FXML
    private VBox pare;
    @FXML
    private Text ipAdress;
    private Registry registry;

        // Arrêt du serveur RMI
//    UnicastRemoteObject.unexportObject(obj, true);
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void Exit(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void getActiver(MouseEvent event) {
        try {
               registry = LocateRegistry.createRegistry(1099);
               EtudiantService skeleton = new EtudiantService();
               Naming.rebind("rmi://localhost:1099/ETUD", skeleton);
               String ipAddress = InetAddress.getLocalHost().getHostAddress();
               
               ipAdress.setText("IP: "+ipAddress);
               Image img = new Image("/image/icons8_ok_48px.png");
               imagess.setImage(img);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    @FXML
    private void getdesactiver(MouseEvent event) {
        
        try {
               
              registry.unbind("ETUD");
               // Arrêt du serveur RMI
               UnicastRemoteObject.unexportObject(registry, true);
                ipAdress.setText("IP:");
               Image img = new Image("/image/icons8_stop_sign_48px.png");
               imagess.setImage(img);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @FXML
    private void getMouvY(MouseEvent event) {
         MovePane.mouv(event);
    }

    @FXML
    private void getMovX(MouseEvent event) {
       
         MovePane.mouvXY(event);
    }

    @FXML
    private void getmv(MouseEvent event) {
         MovePane.mouv(event);
    }

    @FXML
    private void getxv(MouseEvent event) {
        MovePane.mouvXY(event);
    }
    
    
}
