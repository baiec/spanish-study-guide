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
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Alex
 */
public class IntroController implements Initializable {

    public GridPane gridpane;
    public Button btn;
    
    /*@var absolute path to sets directory with trailing slash*/
    static String      setsDir  = new String();
    static FileNameMap fnm      = new FileNameMap();
    ArrayList<Button> setBtns = new ArrayList<Button>();
    
    
    
    /**
     * Sets up path to sets directory and runs populateFNM() 
     */
    
    public void submit(){
        System.out.println("set1btnWorks " + btn.getId());
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            if (System.getProperty("os.name").equalsIgnoreCase("windows")) {
                setsDir = System.getProperty("user.dir") + "\\src\\spanish\\sets\\";
            }
            else {
                setsDir = System.getProperty("user.dir") + "/src/spanish/sets/";
            }
            populateFNM();
            createSetBtns();
        }
        catch (NullPointerException npe) {
            System.out.println("Could not open sets directory (" + setsDir + ").");
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
    
    
    /**
     * For each set, look at the header line and map the header to the
     * file name and store inside the FileNameMap (fnm).
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
    
    
    /**
     * For each set in the file name map create a button and put in ArrayList setBtns
     */
    private void createSetBtns(){
        int x = 0;
        fnm.mappings.forEach(set->{
            Button btn = new Button(set[0]);
            btn.setId(set[0]);
            btn.setPrefSize(675, 117);
            //setBtns.add(btn);
            //System.out.println(setBtns.size());
        });
            
            
  /*
        Button btn1 = new Button("btn1");
            btn1.setId(;
            btn1.setPrefSize(938, 108);
            
            gridpane.add(new Button(SETNAME).setId(SETHE, 0, 2, 2, 1);
*/
    } 
    
}

