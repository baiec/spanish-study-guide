/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanish;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 *
 * @author Alex
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private TextField answerInput;
    @FXML private Label prompt;
    @FXML private GridPane gridpane;
    
    boolean createSet = false;
    Question question;
    
    @FXML
    private void submit(ActionEvent event) {
        question.setAnswer("answer");
        if(answerInput.getText().trim().isEmpty()){
            prompt.setText("type something");
        }
        else if (answerInput.getText().trim().equals(question.getAnswer())){
            prompt.setText("correct!");
        }
        else {
            prompt.setText("ur wrong");
        }
        answerInput.clear(); 
    }
    
    @FXML
    private void addA(ActionEvent event){
        answerInput.appendText("á");
    }
    @FXML
    private void addE(ActionEvent event){
        answerInput.appendText("é");
    }
    @FXML
    private void addI(ActionEvent event){
        answerInput.appendText("í");
    }
    @FXML
    private void addO(ActionEvent event){
        answerInput.appendText("ó");
    }
    @FXML
    private void addU(ActionEvent event){
        answerInput.appendText("ú");
    }
    @FXML
    private void addN(ActionEvent event){
        answerInput.appendText("ñ");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
