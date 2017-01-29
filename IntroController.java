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
import javafx.scene.layout.GridPane;
import spanish.Spanish;


/**
 * FXML Controller class
 *
 * @author Alex
 */
public class IntroController implements Initializable {

    public GridPane gridpane;
    public Button btn;
    
    ArrayList<Button> setBtns = new ArrayList<Button>();
    
    
    /**
     * Sets up path to sets directory and runs populateFNM(), createSetBtns()
     * & insertSetBtns() 
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
            btn.setPrefSize(675, 117);
            btn.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    Spanish.selectedSet = btn.getId();
                    gridpane.getScene().getWindow().hide();
                }
            });
            setBtns.add(btn);
            System.out.println(setBtns.size());
        });
    }
    
    
    private void insertSetBtns(){
        for(int i = 0; i < setBtns.size(); i++){
            gridpane.add(setBtns.get(i), 0, i, 2, 1);
            
        }
    }
    
}

