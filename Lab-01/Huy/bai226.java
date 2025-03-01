package Huy;
import javax.swing.JOptionPane;
public class bai226 {

	public static void main(String[] args) {
        String[] options = {"Linear equation", "Linear system", "Second degree equation"};
        int choice = JOptionPane.showOptionDialog(
            null,
            "Choose an option:", 
            "Option Selector", 
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE, 
            null,
            options,
            options[0] 
        );
        String strResult;
        if (choice == 0) {
        	double num1 = Double.parseDouble(JOptionPane.showInputDialog("Enter a"));
    		double num2 = Double.parseDouble(JOptionPane.showInputDialog("Enter b"));
    		if(num1 == 0){
    			if(num2 == 0)strResult = "Infinite solutions";else strResult = "No solution";
    		}else {
    			strResult = "The solution is x = "+(-num2/num1);
    		}
    		JOptionPane.showMessageDialog(null,strResult);
        } else if (choice == 1) {
            
        	double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11"));
            double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12"));
            double b1 = Double.parseDouble(JOptionPane.showInputDialog("Enter b1"));
            double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21"));
            double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22"));
            double b2 = Double.parseDouble(JOptionPane.showInputDialog("Enter b2"));
            double determinant = a11 * a22 - a12 * a21;
            if (determinant == 0) {
            	if (a11 / a21 == a12 / a22 && b1 / b2 == a11 / a21) {
                    JOptionPane.showMessageDialog(null, "Infinite solutions");
                } else {
                    JOptionPane.showMessageDialog(null, "No solution");
                }
            } else {              
                double x1 = (b1 * a22 - b2 * a12) / determinant;
                double x2 = (a11 * b2 - a21 * b1) / determinant;
                JOptionPane.showMessageDialog(null, "The solution is:\n" +
                        "x1 = " + x1 + "\n" +
                        "x2 = " + x2);
            }
        	
        } else if (choice == 2) {
        	double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a"));
            double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b"));
            double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c"));
            if (a == 0) {
                if (b == 0) {
                    if (c == 0) {
                        JOptionPane.showMessageDialog(null, "Infinite solutions");
                    } else {
                        JOptionPane.showMessageDialog(null, "No solution");
                    }
                } else {
                    double x = -c / b;
                    JOptionPane.showMessageDialog(null, "The solution is x = " + x);
                }
            } else {
                double discriminant = b * b - 4 * a * c;
                if (discriminant > 0) {
                    double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                    double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                    JOptionPane.showMessageDialog(null, "Two real solutions:\n" +
                            "x1 = " + x1 + "\n" +
                            "x2 = " + x2);
                } else if (discriminant == 0) {
                    double x = -b / (2 * a);
                    JOptionPane.showMessageDialog(null, "One real solution x = " + x);
                } else {
                    JOptionPane.showMessageDialog(null, "No real solution");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No option chosen.");
        }
		
	}

}