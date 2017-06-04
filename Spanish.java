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
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.input.InputEvent;
import javafx.stage.WindowEvent;

/**
 * Spanish
 *
 * A quizlet-like application for studying Spanish.
 *
 * @author Alex
 */

public class Spanish extends Application {

    public static String selectedSet   = "";
    public static String newSet        = "";
    public static FileNameMap fnm      = new FileNameMap();
    /*@var absolute path to sets directory with trailing slash*/
    public static String      setsDir  = new String();


    public static void main(String[] args) {
        
        setPaths();
        populateFNM();
        launch(args);
        
    }


    @Override
    public void start(Stage stage) throws Exception {
        
        createWindow("Intro.fxml", IntroStageCloseWindow);
   
    }


    EventHandler<WindowEvent> IntroStageCloseWindow = new EventHandler<WindowEvent>() {
        
        public void handle(WindowEvent we) {
            
            if(selectedSet.equals("create")){
                createWindow("createSet.fxml", CreateSetCloseWindow);
            } 
            else {
                System.out.println(selectedSet);

            }
        }
    };
    
    EventHandler<WindowEvent> CreateSetCloseWindow = new EventHandler<WindowEvent>() {
        
        public void handle(WindowEvent we){
            
            if(newSet == null){
                createWindow("Intro.fxml", IntroStageCloseWindow);
            } 
            else {
                System.out.println(selectedSet);
            }
            
        }
        
    };
        

    /**
     * Sets absolute path to sets dir
     */

    private static void setPaths() {
        try {
            if (System.getProperty("os.name").equalsIgnoreCase("windows")) {
                Spanish.setsDir = System.getProperty("user.dir") + "\\src\\spanish\\sets\\";
            }
            else {
                Spanish.setsDir = System.getProperty("user.dir") + "/src/spanish/sets/";
            }

        }
        catch (NullPointerException npe) {
            System.out.println("Could not open sets directory (" + Spanish.setsDir + ").");
        }
    }


    /**
     * For each set, look at the header line and map the header to the
     * file name and store inside the FileNameMap (Spanish.fnm).
     */

    private static void populateFNM(){
        //set is the file name
        setsDirContents().forEach((set)->{
            FileReader fr = null;

            try {
                fr = new FileReader(set);
                int c = 0;
                String header = "";
                while((c = fr.read()) != -1){
                    if((char) c != '\n'){
                        header = header + (char) c;
                    } else break;
                }
                fnm.add(header, set.getAbsolutePath());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Spanish.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException e){
                System.out.println(e);
            }
        });
    }
    
    /*
    * Creates and shows all components for a given view (fxml file)
    */
    public void createWindow (String viewName, EventHandler<WindowEvent> closeEventHandler) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource(viewName));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnHidden(closeEventHandler);
        } catch (IOException e){
            System.err.println(e);
        }
        
    }


    /**
     * @return ArrayList<File> The contents of the sets directory.
     * @throws NullPointerException Thrown when the setsDir is not found.
     */

    private static ArrayList<File> setsDirContents() throws NullPointerException {

        File f;
        ArrayList<File> files;

        f = new File(setsDir);
        files = new ArrayList<>(Arrays.asList(f.listFiles()));

        return files;
    }
    
    /*public static void launchCreateSet(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("createSet.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            System.err.println(e);
        }
    }*/
}
