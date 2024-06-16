package questao_1;

public class Livro {

    private String titulo;
    private String autor;
    private Integer anoPublicacao;
    private String genero;
    private String codigoIsbn;
    private String[] pessoas = new String[5];

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCodigoIsbn() {
        return codigoIsbn;
    }

    public void setCodigoIsbn(String codigoIsbn) {
        this.codigoIsbn = codigoIsbn;
    }

    public String[] getPessoas() {
        return pessoas;
    }

    public void setPessoas(String[] pessoas) {
        this.pessoas = pessoas;
    }
}
