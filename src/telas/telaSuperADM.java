package telas;

import javax.swing.*;

public class telaSuperADM extends JFrame {
    public telaSuperADM() {
        // Configurações da janela
        setTitle("Super Administrador");
        setSize(300, 200);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Componentes da interface
        JLabel label = new JLabel("Funcionou");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);
    }
}
