package spanish.tests;

import spanish.FileNameMap;

/**
 *
 * @author Alex
 */
public class FNMTester {
        public static void main(String[] args){
            System.out.println(testAdd() ? "add works" : "add doesn't work");
            System.out.println(testGetFileName() ? "getFileName works" : "getFileName doesn't work");
            System.out.println(testToString() ? "toString works" : "toString doesn't work");
        }
 
        
        public static boolean testAdd(){
            FileNameMap fnm = new FileNameMap();
            String h = "dog";
            String f = "cat";
            fnm.add(h, f);
            if(fnm.size() > 0){
                return true;
            } 
            else {
                return false;
            }
        }

        public static boolean testGetFileName() {
            FileNameMap fnm = new FileNameMap();
            fnm.add("header", "fileName");
            if(new String("filename").equals(fnm.getFileName("header"))){
                return true;
            } else {
                return false;
            }
        }
        
        public static boolean testToString(){
            FileNameMap fnm = new FileNameMap();
            fnm.add("h","f");
            String x = fnm.toString();
            if(x.charAt(0) == '[' && x.charAt(x.length()-1) == ']'){
                System.out.println(fnm);
                return true;
            } else {
                return false;
            }        

        }
}
