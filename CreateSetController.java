/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanish;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Alex
 */
public class CreateSetController implements Initializable {

    public GridPane createSetUI;
    public Button addItemBtn;
    public GridPane itemsPane;
    public TextField promptField;
    public TextField answerField;

    private ArrayList<Text[]> textFields = new ArrayList();
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        answerField.setOnKeyPressed(event -> {
            answerField.setStyle("-fx-border-color: #fff");
        });
        promptField.setOnKeyPressed(event -> {
            promptField.setStyle("-fx-border-color: #fff");
        });
        //itemsPane.getChildren().clear();
    }
    
    private void updateItemsPane(){
        itemsPane.getChildren().clear();
        for(int i=0;i<textFields.size();i++){
            itemsPane.addRow(i, textFields.get(i)[0], textFields.get(i)[1]);
        }
    }
    
   /*
    * Removes clicked node from current word list and puts Texts into TextFields
    */ 
    private void editNode(int index){
        Text[] text = textFields.get(index);
        promptField.setText(text[0].getText());
        answerField.setText(text[1].getText());
        textFields.remove(index);
        updateItemsPane();
    }
    
    public void addItemBtnAction () {
        if(promptField.getText().trim().equals("") && answerField.getText().trim().equals("")){
            promptField.setStyle("-fx-border-color: #ed5642");
            answerField.setStyle("-fx-border-color: #ed5642");
        } else if (promptField.getText().trim().equals("") && !answerField.getText().trim().equals("")){
            promptField.setStyle("-fx-border-color: #ed5642");
        } else if (!promptField.getText().trim().equals("") && answerField.getText().trim().equals("")){
            answerField.setStyle("-fx-border-color: #ed5642");
        } else {
            
            Text texts[] = new Text[2];
            texts[0] = new Text(promptField.getText());
            texts[1] = new Text(answerField.getText());
            textFields.add(texts);
            for(Text text : texts){
                text.setOnMouseClicked(event -> {
                    editNode(GridPane.getRowIndex(text));
                });
            }
            updateItemsPane();
            promptField.setText("");
            answerField.setText("");
        }
    }
       
}


