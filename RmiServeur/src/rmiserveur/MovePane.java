

package rmiserveur;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class MovePane {
    static  double i = 0, y = 0;
    
    public static void mouv(MouseEvent event)
    {
        
        Node node = (Node)event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        
        stage.setX(event.getScreenX()-i);
        stage.setY(event.getScreenY()-y);
    }
      public static void mouvXY(MouseEvent event)
    {
             i = event.getSceneX();
            y = event.getSceneY();
    }
}
