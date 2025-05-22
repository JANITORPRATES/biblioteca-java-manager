import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorRepository {
    private Connection conexao;

    public void incluir(Autor autor) {
        conexao = GerenciadorConexao.getConexao();
        try {
            String instrucaoSql = "INSERT INTO public.autor (nome, data_nascimento) VALUES (?, ?);";
            PreparedStatement pst = conexao.prepareStatement(instrucaoSql);
            pst.setString(1, autor.getNome());
            pst.setDate(2, Date.valueOf(autor.getDataNascimento()));
            pst.executeUpdate();
            System.out.println("Incluido um novo autor com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            GerenciadorConexao.fecharConexao();
        }

    }

    public void alterar(int id, String novoNome, Date novaDataNascimento) {
        conexao = GerenciadorConexao.getConexao();
        try {
            String instrucaoSql = "UPDATE public.autor SET nome=?, data_nascimento=? WHERE id=?;";
            PreparedStatement pst = conexao.prepareStatement(instrucaoSql);
            pst.setString(1, novoNome);
            pst.setDate(2, novaDataNascimento);
            pst.setInt(3, id);
            pst.executeUpdate();
            System.out.println("Atualização do autor de id = " + id + "realizado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            GerenciadorConexao.fecharConexao();
        }
    }

    public void excluir(Integer id) {
        conexao = GerenciadorConexao.getConexao();
        String instrucaoSql = "DELETE FROM public.autor WHERE id=?;";
        try {
            PreparedStatement pst = conexao.prepareStatement(instrucaoSql);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Autor de id = " + id + "excluido");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            GerenciadorConexao.fecharConexao();
        }

    }

    public List<Autor> listar() {
        conexao = GerenciadorConexao.getConexao();
        String instrucaoSql = "SELECT id, nome, data_nascimento FROM public.autor;";
        int id;
        String nome;
        Date data_nascimento;
        List<Autor> listaAutores = new ArrayList<>();
        try {
            PreparedStatement pst = conexao.prepareStatement(instrucaoSql);
            ResultSet resultado = pst.executeQuery();

            while (resultado.next()) {
                id = resultado.getInt("id");
                nome = resultado.getString("nome");
                data_nascimento = resultado.getDate("data_nascimento");

                Autor autor = new Autor(id, nome, data_nascimento.toLocalDate());
                listaAutores.add(autor);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            GerenciadorConexao.fecharConexao();
        }
        return listaAutores;
    }

    public Autor buscar(Integer id) {
        conexao = GerenciadorConexao.getConexao();
        String instrucaoSql = "SELECT id, nome, data_nascimento FROM public.autor WHERE id=?;";
        String nome;
        Date data_nascimento;
        Autor autor = null;
        try {
            PreparedStatement pst = conexao.prepareStatement(instrucaoSql);
            pst.setInt(1,id);
            ResultSet resultado = pst.executeQuery();

            if (resultado.next()) {
                id = resultado.getInt("id");
                nome = resultado.getString("nome");
                data_nascimento = resultado.getDate("data_nascimento");

                autor = new Autor(id, nome, data_nascimento.toLocalDate());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            GerenciadorConexao.fecharConexao();
        }

        return autor;
    }

}
