/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanish;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Alex
 */
public class CreateSetController implements Initializable {

    public GridPane createSetUI;
    public Button addItemBtn;
    public GridPane itemsPane;

    private int items = 0;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //System.out.println("hi im the cree8 set controller");
        
        //createSetUI.add(new Label("First"), 0, 0);
    }
    
    
    public void addItemBtnAction () {
        items++;
        System.out.println("There are " + items + " items");
                
        TextField prompt = new TextField();
        TextField answer = new TextField();
        prompt.setId("prompt-" + items);
        answer.setId("answer-" + items);
        
        itemsPane.addRow(items, prompt, answer);
    }

}
