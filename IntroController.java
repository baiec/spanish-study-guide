/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanish;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import spanish.Spanish;


/**
 * FXML Controller class
 *
 * @author Alex
 */
public class IntroController implements Initializable {

    public ScrollPane scrollpane;
    public VBox vbox;
    public Button btn;

    
    ArrayList<Button> setBtns = new ArrayList<Button>();
    
    
    /**
     * Sets up path to sets directory and runs populateFNM(), createSetBtns()
     * & insertSetBtns() 
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            scrollpane.setFitToWidth(true);
            createSetBtns();
            insertSetBtns();
    }  
   
    
    /**
     * For each set in the file name map create a button and put in ArrayList setBtns
     */
    
    private void createSetBtns(){
        Spanish.fnm.mappings.forEach(set->{
            Button btn = new Button(set[0]);
            btn.setId(set[0]);
            btn.setMinSize(620, 100);
            btn.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    Spanish.selectedSet = btn.getId();
                    scrollpane.getScene().getWindow().hide();
                }
            });
            setBtns.add(btn);
            System.out.println(setBtns.size());
        });
    }
    
    public void createSetBtnAction(){
        scrollpane.getScene().getWindow().hide();
        try {
            Spanish.launchCreateSet();
        } catch (Exception ex) {
            Logger.getLogger(IntroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void insertSetBtns(){
        for(int i = 0; i < setBtns.size(); i++){
            vbox.getChildren().add(setBtns.get(i));
        }
    }
}

