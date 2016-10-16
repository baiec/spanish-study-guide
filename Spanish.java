/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanish;

import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Alex
 */
public class Spanish extends Application {
    
    FileNameMap fnm = new FileNameMap();
    
    @Override
    public void start(Stage stage) throws Exception {

        try{
            FileReader fr = new FileReader("sets\\set1.txt");
            int c = 0;
            String line = "";
            while((c = fr.read()) != -1){
                if((char) c != '\n'){
                    line = line + c;
                }
                else {
                    System.out.println(line);
                    line = "";
                }
            }
        } catch(IOException e){
            System.out.println(e);
        } 
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
