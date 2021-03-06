package spanish;

import java.util.ArrayList;

/**
 * Collection of key-value pairs of strings [<header>:<filename>]
 * @author Alex
 */
public class FileNameMap{

    public ArrayList<String[]> mappings = new ArrayList();
    private final int HEADER = 0;
    private final int FILENAME = 1;
    
    
    /**
     * Adds a key-value pair to the ArrayList mappings.
     * @param header String
     * @param fileName String
     */
    
    public void add(String header, String fileName){
       String[] temp = {header.trim(), fileName.toLowerCase().trim()};
       mappings.add(temp);
    }
    
    
    /**
     * Takes header (key) and returns filename (value).
     * @param header String
     * @return String; filename value corresponding to header key, if given
     * header doesn't exist in mappings, return "".
     */
    
    public String getFileName(String header){
        header = header.toLowerCase().trim();
        for(String[] a : mappings){
            if(header.equals(a[HEADER])){
                return a[FILENAME];
            }
        }
        return "";
    }
    
    @Override
    public String toString(){
        String x = "";
        for(String[] a : mappings){
            x += "[" + a[HEADER] + ", " + a[FILENAME] + "]";
        }
        return x;
    }

    
    public int size(){
        return mappings.size();
    }
    
    
    
    
}
