/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanish.tests;

import spanish.FileNameMap;

/**
 *
 * @author Alex
 */
public class Tester {
        public static void main(String[] args){
            FileNameMap fnm = new FileNameMap();
            fnm.add("key", "value");
            System.out.println(fnm.size());
            if(new String("value").equals(fnm.getFileName("key"))){
                System.out.println("getFileName ok");
            } else System.out.println("oh no");
            //testAdd(fnm);
            
        }
        
        
        public static void testAdd(FileNameMap fnm){
            System.out.println("testing add");
            String h = "dog";
            String f = "cat";
            fnm.add(h, f);
            if(fnm.size() > 0){
                System.out.println("adding works");
            } 
            else System.out.println("doesn't work");
            System.out.println(fnm);
        }
}
