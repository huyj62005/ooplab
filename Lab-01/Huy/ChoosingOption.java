package Huy;

import javax.swing.JOptionPane

public class ChoosingOption {
    public static void main(String[] args) {
        String[] options = {"Yes", "No"};
        
        int option = JOptionPane.showOptionDialog(null, 
                "Do you want to change to the first class ticket?", 
                "Choose an Option", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                options, 
                options[0]);
        
        JOptionPane.showMessageDialog(null, 
                "You've chosen: " + (option == 0 ? "Yes" : "No"), 
                "Result", 
                JOptionPane.INFORMATION_MESSAGE);
        
        System.exit(0);
    }
}
