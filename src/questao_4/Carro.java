package questao_4;

public class Carro {

    private String marca;
    private String modelo;
    private Integer anoFabricacao;
    private String cor;
    private String placa;
    private String[] condutores = new String[5];

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String[] getCondutores() {
        return condutores;
    }

    public void setCondutores(String[] condutores) {
        this.condutores = condutores;
    }
}
