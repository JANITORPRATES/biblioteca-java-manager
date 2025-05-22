import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GerenciadorConexao {
    private static Connection conexao;
    private static final String URL = "jdbc:postgresql://localhost:5432/biblioteca_db";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "474f4b55";

    public static synchronized void conectar() {
        if (conexao == null) {
            Properties props = new Properties();
            props.setProperty("user", USUARIO);
            props.setProperty("password", SENHA);

            try {
                conexao = DriverManager.getConnection(URL, props);
                System.out.println("Conexao realizada com sucesso");
            } catch (SQLException e) {
                System.err.println("Erro ao conectar ao banco de dados " + e.getMessage());
                throw new RuntimeException("Erro ao conectar ao banco de dados ",e);
            }
        }
    }

    public static Connection getConexao() {
        if(conexao==null){
            conectar();
        }
        return conexao;
    }

    public static synchronized void fecharConexao(){
        if(conexao!= null){
            try{
                conexao.close();
                System.out.println("Conexão fechada");
                conexao = null;
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao fechar a conexao: " + e.getMessage());
            }
        }
    }

}
