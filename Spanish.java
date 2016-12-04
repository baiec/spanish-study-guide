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
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Alex
 */
public class Spanish extends Application {
    
    FileNameMap fnm;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        //fnm = new FileNameMap();
        
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        populateFNM();
        launch(args);
    }
    

    /**
     * Looks in sets directory and maps files to filename headers
     * using FileNameMap (fnm).
     */
    
    public static void populateFNM(){
        try{
            File f = new File(System.getProperty("user.dir") + "\\src\\spanish\\sets");
            ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
            
            for(File file : files){
                System.out.println(file);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        /*
        String path = "C:\\Users\\Alex\\Desktop\\Stash\\code\\spanish\\src\\spanish\\sets\\set2.txt";
        
        try{
            FileReader fr = new FileReader(path);
            int c = 0;
            String line = "";
            while((c = fr.read()) != -1){
                if((char) c != '\n'){
                    line = line + (char) c;
                }
                else {
                    System.out.println(line);
                    fnm.add(line, path);
                    System.out.println(fnm);
                    System.out.println(fnm.getFileName("set1"));
                    break;
                }
            }
        } catch(IOException e){
            System.out.println(e);
        } 
        */
    }
}
