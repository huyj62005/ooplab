package Huy;

import javax.swing.JOptionPane;
public class Tinh {
	public static void main(String[] args) {
		String strNum1,strNum2;
		//String strNotification = "You've just entered: ";
		strNum1 = JOptionPane.showInputDialog(null,
				"Please input the first number: ","Input the first number",
				JOptionPane.INFORMATION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null,
				"Please input the second number: ","Input the second number",
				JOptionPane.INFORMATION_MESSAGE);
		double num1= Double.parseDouble(strNum1);
		double num2= Double.parseDouble(strNum2);
		double Tong= num1 + num2;
		double Hieu= num1 - num2;
		double Tich= num1 * num2;
		String message= "Tổng: " + Tong + "\n" +
						"Hiệu: " +Hieu +"\n" +
						"Tích: " + Tich +"\n";
		if (num2 != 0) {
			double Thuong = num1 / num2;
			message += "Thương: " + Thuong;
			} else {
				message += "Lỗi";
				}
		JOptionPane.showMessageDialog(null, message,
				"Kết quả ", JOptionPane.INFORMATION_MESSAGE);
	}
}