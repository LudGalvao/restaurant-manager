package telas;

import javax.swing.*;
import dados.DadosLogin;
import telas.telaSuperADM;

public class telaLogin extends JFrame {
    public telaLogin() {

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

        DadosLogin dados = new DadosLogin("", "");

        botao.addActionListener(e -> {
            String usuario = usuarioText.getText();
            String senha = new String(senhaText.getPassword());
            dados.setUsuario(usuario);
            dados.setSenha(senha);
            
            if(dados.autenticarUsuario()) {
                if("SuperAdm".equals(dados.getPerfil())) {
                    janela.dispose(); 
                    new telaSuperADM().setVisible(true); 
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário não tem permissão de acesso como Super Administrador.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.");
            }
        });

        janela.setVisible(true);
    }
}
