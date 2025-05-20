import java.time.LocalDate;

public class Livro {

    private int id;
    private String titulo;
    private Autor autor;
    private boolean disponivel;
    private LocalDate dataPublicacao;
    private LocalDate dataAtualizacao;

    public Livro(int id, String titulo, boolean disponivel, Autor autor, LocalDate dataPublicacao, LocalDate dataAtualizacao) {
        this.id = id;
        this.titulo = titulo;
        this.disponivel = disponivel;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return  "id:" + id +
                ", titulo:'" + titulo +
                ", autor:" + autor.getNome() ;
    }
}
