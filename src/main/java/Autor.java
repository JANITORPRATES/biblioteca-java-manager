import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Autor {

    private int id;
    private String nome;
    private LocalDate dataNascimento;

    public Autor(int id, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Autor(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id = " + id +
                ", nome = '" + nome + '\'' +
                ", dataNascimento = " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                '}';
    }
}