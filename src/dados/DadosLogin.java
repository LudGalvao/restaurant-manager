package dados;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DadosLogin {
    // Configurações de conexão com o banco de dados
    private static final String URL = "jdbc:mariadb://localhost:3306/login";
    private static final String USER = "root";
    private static final String PASSWORD = "12345ab";

    private String usuario;
    private String senha;
    private String perfil;

    public DadosLogin(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public boolean autenticarUsuario() {
        try {
      
            Class.forName("org.mariadb.jdbc.Driver");

   
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            
                String query = "SELECT perfil, password FROM usuarios WHERE username = ?";
                try (PreparedStatement statement = conn.prepareStatement(query)) {
                    statement.setString(1, usuario);
                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                      
                            String hashedPassword = resultSet.getString("password");
                            if (verificarSenha(senha, hashedPassword)) {
          
                                perfil = resultSet.getString("perfil");
                                return true;
                            }
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean verificarSenha(String senha, String hashedPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(senha.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            String hashedInputPassword = sb.toString();
            return hashedInputPassword.equals(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getPerfil() {
        return perfil;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
