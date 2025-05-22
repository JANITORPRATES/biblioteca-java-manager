import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;

public class ConexaoPostgres {

    private static final String URL = "jdbc:postgresql://localhost:5432/biblioteca_db";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "474f4b55";

    public Connection conectarComPropriedades() {
        Connection conexao = null;
        Properties props = new Properties();
        props.setProperty("user", USUARIO);
        props.setProperty("password", SENHA);

        try {
            conexao = DriverManager.getConnection(URL, props);
            System.out.println("Conexão estabelecida com sucesso usando propriedades.");

            String instrucaoSql = "INSERT INTO public.autor (id, nome, data_nascimento) " +
                    "VALUES (nextval('autor_id_seq'::regclass), ?, ?);";
            String nome = "Jose de Alencar";
            LocalDate dataNascimento = LocalDate.of(1972,5,13);

            PreparedStatement pst = conexao.prepareStatement(instrucaoSql);
            pst.setString(1, nome);
            pst.setDate(2, Date.valueOf(dataNascimento)); // Converte LocalDate para java.sql.Date

            pst.execute();

            System.out.println("registro inserido com sucesso");

        } catch (SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        }

        return conexao;
    }


    public static void main(String[] args) {
        ConexaoPostgres conexaoPg = new ConexaoPostgres();
        Connection conexao = conexaoPg.conectarComPropriedades();

        // Feche as conexões após o uso
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
}
