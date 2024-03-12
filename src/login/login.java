package login;

import javax.swing.*;
import dados.dados_login;
import java.awt.*;

public class login extends JFrame{
    public login() {
    	
    	JPanel painel = new JPanel();
    	JFrame janela = new JFrame();
    	janela.setSize(350, 200);
    	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	janela.add(painel);
    	
    	painel.setLayout(null);
    	
    	JLabel userLabel = new JLabel("Usuario");
    	userLabel.setBounds(10, 20, 80, 25);
    	painel.add(userLabel);
    	
    	JTextField usuarioText = new JTextField();
    	usuarioText.setBounds(100, 20, 165, 25);
    	painel.add(usuarioText);
    	
    	JLabel senhaLabel = new JLabel("Senha");
    	senhaLabel.setBounds(10, 50, 80, 25);
    	painel.add(senhaLabel);
    	
    	JPasswordField senhaText = new JPasswordField();
    	senhaText.setBounds(100, 50, 165, 25);
    	painel.add(senhaText);
    	
    	JButton botao = new JButton("Login");
    	botao.setBounds(10, 80, 80, 25);
    	painel.add(botao);
    	
    	dados_login dados = new dados_login("", "");
    	
    	botao.addActionListener(e -> {
    	    String email = usuarioText.getText();
    	    String senha = new String(senhaText.getPassword());
    	    dados.setEmail(email);
    	    dados.setSenha(senha);
    	    
    	    System.out.println("Email: " + dados.getEmail());
    	    System.out.println("Senha: " + dados.getSenha());
    	});
    	
    	
    	
    	janela.setVisible(true);
    	
    }
}

