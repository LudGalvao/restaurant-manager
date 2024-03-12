import javax.swing.*;
import login.login;

public class Main {
	public static void main(String[]args) {
		login loginInterface = new login();
		
		loginInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loginInterface.setVisible(true);
	}
}
