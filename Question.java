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
public class Question {

    private String prompt = "";
    private String answer = "";
    private String type = "";
    
    public Question(String prompt, String answer, String type) {
        this.prompt = prompt;
        this.answer = answer;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public boolean validAnswer(String guess){
        
        return true;
    }
}
