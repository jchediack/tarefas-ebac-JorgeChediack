import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        // Configuraçã MacMini
        String url = "jdbc:postgresql://localhost:15432/vendas_online";
        String user = "postgres";
        String password = "admin";
/*
        //Configuração Notebook
        String url = "jdbc:postgresql://localhost:5432/EBAC";
        String user = "postgres";
        String password = "root";
*/
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Conectado com o Banco de Dados");
            } else {
                System.out.println("Falha de Conexão!");
            }
        } catch (SQLException e) {
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
