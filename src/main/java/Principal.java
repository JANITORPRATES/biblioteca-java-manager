import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Autor autor3, autor4;
        GerenciadorConexao.conectar();

        AutorRepository autorRepository = new AutorRepository();
        autor3 = new Autor("Ariano Suassuna3", LocalDate.of(1927, 6, 16));
        autor4 = new Autor("Carlos Drummond de Andrade4", LocalDate.of(1902, 10, 31));
        //autorRepository.incluir(autor3);
        //autorRepository.incluir(autor4);

        String novoNome = "Paulo Coelho";
        LocalDate novaDataNascimento = LocalDate.of(1947,8,24);

        //autorRepository.alterar(autor3.getId(), novoNome, Date.valueOf(novaDataNascimento));
        //autorRepository.excluir(8);

        Autor autorBusca = autorRepository.buscar(8);
        if(autorBusca != null){
            System.out.println(autorBusca);
        } else{
            System.out.println("Não foi possível localizar o autor com o id informado");
        }

        List<Autor> autores = autorRepository.listar();
        for(Autor a : autores){
            System.out.println(a);
        }


        Livro livroSelecionado, livro1, livro2, livro3;
        Object[] opcoes = {"Sim", "Não"};
        String[] opcoesOK_Cancelar = {"OK", "Cancelar"};
        JTextField campoTexto = new JTextField(10);
        int idLivro, okCancelar, resposta;
        String nomeUsuario;
        List<Livro> livrosDisponiveis;
        JComboBox<Livro> comboBoxLivros;

        autor3 = new Autor(1, "Vicente Paulo", LocalDate.of(1985, 9, 22));
        autor4 = new Autor(2, "Palloma Guimaraes", LocalDate.of(1993, 2, 28));

        biblioteca.adicionarAutor(autor3);
        biblioteca.adicionarAutor(autor4);

        livro1 = new Livro(1, "Direito constitucional", true, autor3, LocalDate.of(1999, 5, 14), LocalDate.now());
        livro2 = new Livro(2, "DNA Empreendedor", true, autor4, LocalDate.of(2021, 2, 27), LocalDate.now());
        livro3 = new Livro(3, "Fundos Imobiliarios do ZERO", true, autor4, LocalDate.of(2023, 8, 17), LocalDate.now());

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);

        while (true) {

            resposta = JOptionPane.showOptionDialog(null,
                    "Deseja ver os livros disponíveis?",
                    "Sistema de Livraria ",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

            if (resposta == JOptionPane.YES_OPTION) {
                livrosDisponiveis = biblioteca.listarLivrosDisponiveis();

                if (livrosDisponiveis.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "No momento não há livros disponíveis.",
                            "Aviso",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    resposta = JOptionPane.CLOSED_OPTION;
                } else {
                    comboBoxLivros = new JComboBox<>(livrosDisponiveis.toArray(new Livro[0]));

                    JOptionPane.showOptionDialog(
                            null,
                            comboBoxLivros,
                            "Livros disponíveis, selecione um Livro",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            opcoesOK_Cancelar,
                            opcoesOK_Cancelar[0]
                    );
                    idLivro = Integer.parseInt(comboBoxLivros.getSelectedItem().toString().substring(3, 4));
                    livroSelecionado = biblioteca.buscarLivroPorId(idLivro);

                    if (livroSelecionado != null && livroSelecionado.isDisponivel()) {

                        okCancelar = JOptionPane.showOptionDialog(
                                null,
                                campoTexto,
                                "Digite seu nome",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                opcoesOK_Cancelar,
                                opcoesOK_Cancelar[0]
                        );
                        if (okCancelar == 0) {
                            nomeUsuario = campoTexto.getText();
                            biblioteca.emprestarLivro(livroSelecionado, nomeUsuario);
                            JOptionPane.showMessageDialog(null, "O livro " + livroSelecionado.getTitulo() + " foi emprestado para " + nomeUsuario);
                            campoTexto.setText("");
                            okCancelar = -1;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Livro não encontrado ou não disponível para empréstimo.");
                    }
                }

            }
            if (resposta == JOptionPane.NO_OPTION || resposta == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(
                        null,
                        "Obrigado por utilizar o sistema da biblioteca.",
                        "Aviso",
                        JOptionPane.INFORMATION_MESSAGE
                );
                break;
            }

        }

    }
}

