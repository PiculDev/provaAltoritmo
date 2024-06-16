package questao_2;

public class Paciente {

    private String nome;
    private String data;
    private String genero;
    private String numeroSus;
    private String[] diagnosticos = new String[5];

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNumeroSus() {
        return numeroSus;
    }

    public void setNumeroSus(String numeroSus) {
        this.numeroSus = numeroSus;
    }

    public String[] getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(String[] diagnosticos) {
        this.diagnosticos = diagnosticos;
    }
}
