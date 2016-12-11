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
 * Spanish
 * 
 * A quizlet like application for studying Spanish.
 * 
 * @author Alex
 */

public class Spanish extends Application {

    static String      setsDir  = new String();
    static FileNameMap fnm      = new FileNameMap();

    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        try {
            initialize();
        }
        catch (NullPointerException npe) {
            System.out.println("Could not open sets directory (" + setsDir + ").");
        }
        
        launch(args);
    }


    /**
     * Performs preliminary start-up tasks.
     */
    
    private static void initialize() {
        if (System.getProperty("os.name").equalsIgnoreCase("windows")) {
            setsDir = System.getProperty("user.dir") + "\\src\\spanish\\sets";
        }
        else {
            setsDir = System.getProperty("user.dir") + "/src/spanish/sets";
        }
        
        setsDirContents().forEach((file)->{
            System.out.println(file.getName());
        });
        
        // populateFNM();
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
    
    
    /**
     * For each set, look at the header line and map the header to the
     * file name and store inside the FileNameMap (fnm).
     */
    
    private static void populateFNM() {
        return;
    }
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
