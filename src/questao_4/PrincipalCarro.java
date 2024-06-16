package questao_4;

import javax.swing.*;
import java.util.ArrayList;

public class PrincipalCarro {
    public static void main(String[] args) {

        ArrayList<Carro> carros = new ArrayList<>();
        int opcao;

        do {
            opcao = escolherOpcao();

            if (opcao == 1) {
                cadastrarCarro(carros);
            } else if (opcao == 2) {
                listarCondutores(carros);
            } else if (opcao == 3) {
                buscarCarroPorNome(carros);
            } else if (opcao == 4) {
                buscarAno(carros);
            } else if (opcao == 5) {
                listarCarrosCor(carros);
            }

        } while (opcao != 6);
    }

    private static Integer escolherOpcao() {

        String opcoes = "1 - Cadastrar Carro.\n" +
                "2 - Localizar carro pela placa.\n" +
                "3 - Filtrar carro por condutor.\n" +
                "4 - Listar todos os carros fabricados no ano de 2024.\n" +
                "5 - Listar carros de uma determinada cor.\n" +
                "6 - Sair";

        return Integer.parseInt(JOptionPane.showInputDialog(opcoes));
    }

    private static void cadastrarCarro(ArrayList<Carro> carros) {

        Carro _carro = new Carro();

        _carro.setMarca(JOptionPane.showInputDialog("Insira a marca do carro!"));
        _carro.setModelo(JOptionPane.showInputDialog("Insira o modelo do carro!"));
        _carro.setAnoFabricacao(Integer.parseInt(JOptionPane.showInputDialog("Insira o ano de fabricação do carro!")));
        _carro.setCor(JOptionPane.showInputDialog("Insira a cor do carro!"));
        _carro.setPlaca(JOptionPane.showInputDialog("Insira a placa do carro!"));

        if (_carro.getPlaca() == null || _carro.getPlaca().length() != 7) {
            do {
                _carro.setPlaca(JOptionPane.showInputDialog("Insira a placa do carro!"));

            } while (_carro.getPlaca() == null || _carro.getPlaca().length() != 7);
        }

        for (int i = 0; i < 5; i++) {
            _carro.getCondutores()[i] = JOptionPane.showInputDialog("Insira os condutores do carro!");
        }

        carros.add(_carro);
    }

    private static void listarCondutores(ArrayList<Carro> carros) {

        String placa = JOptionPane.showInputDialog("Insira a placa do carro!");

        var carroFiltrado = carros.stream().filter(i -> i.getPlaca().equalsIgnoreCase(placa)).findFirst().orElse(null);

        if (carroFiltrado == null) {

            exibirMensagem("Não há nenhum carro com essa placa!");

        } else {

            String mensagem = "Condutores do carro:";

            for (int i = 0; i < 5; i++) {

                mensagem += " " + carroFiltrado.getCondutores()[i] + ",";
            }

            exibirMensagem(mensagem);
        }
    }

    private static void buscarCarroPorNome(ArrayList<Carro> carros) {

        String nomeCondutor = JOptionPane.showInputDialog("Insira o nome do condutor para filtrar!");

        String mensagem = "Carros que o condutor pode dirigir: ";

        for (var carro : carros) {

            for (int i = 0; i < 5; i++) {

                if (carro.getCondutores()[i].contains(nomeCondutor)) {

                    mensagem += " " + carro.getModelo() + ",";
                }
            }
        }

        exibirMensagem(mensagem);
    }

    private static void buscarAno(ArrayList<Carro> carros) {

        var carrosFiltrados = carros.stream().filter(i -> i.getAnoFabricacao() == 2024).toList();

        if (carrosFiltrados.isEmpty()) {

            exibirMensagem("Não há nenhum carro com essa ano de fabricação!");

        } else {

            String mensagem = "";

            for (var carro : carrosFiltrados) {

                mensagem += " Modelo: " + carro.getModelo()
                        + "\nMarca: " + carro.getMarca()
                        + "\nAno de Fabricação: " + carro.getAnoFabricacao()
                        + "\nCor: " + carro.getCor()
                        + "\nPlaca: " + carro.getPlaca();
            }

            exibirMensagem(mensagem);
        }
    }

    private static void listarCarrosCor(ArrayList<Carro> carros) {

        String cor = JOptionPane.showInputDialog("Insira uma cor para filtrar!");

        var carrosFiltrados = carros.stream().filter(i -> i.getCor().equalsIgnoreCase(cor)).toList();

        if (carrosFiltrados.isEmpty()) {

            exibirMensagem("Não há nenhum carro para a cor filtrada!");

        } else {

            String mensagem = "";

            for (var carro : carrosFiltrados) {

                mensagem += " Modelo: " + carro.getModelo()
                        + "\nMarca: " + carro.getMarca()
                        + "\nAno de Fabricação: " + carro.getAnoFabricacao()
                        + "\nCor: " + carro.getCor()
                        + "\nPlaca: " + carro.getPlaca();
            }

            exibirMensagem(mensagem);
        }
    }

    private static void exibirMensagem(String mensagem) {

        JOptionPane.showMessageDialog(null, mensagem);
    }
}

