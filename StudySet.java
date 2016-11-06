/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanish;

/**
 *
 * @author Alex
 */
public class StudySet {
    
    private String[] prompts = new String[]{};
    private String[] answers = new String[]{};
    private int[] used = new int[]{};
    
    public StudySet(String fileName){
        
    }
    
    public String[] getPrompts() {
        return prompts;
    }

    public void setPrompts(String prompt) {
        this.prompts = prompts;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }
   
}
