import javax.swing.*;

import telas.telaLogin;

public class Main {
	public static void main(String[]args) {
		telaLogin loginInterface = new telaLogin();
		
		loginInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loginInterface.setVisible(true);
		
		
	}
}
