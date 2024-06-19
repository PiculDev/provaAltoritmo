package questao_3;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class PrincipalJogo {
    public static void main(String[] args) {

        ArrayList<Jogo> jogos = new ArrayList<>();
        int opcao;

        do {
            opcao = escolherOpcao();

            if (opcao == 1) {
                cadastrarJogo(jogos);
            } else if (opcao == 2) {
                listarJogos(jogos);
            } else if (opcao == 3) {
                buscarPorPlataforma(jogos);
            } else if (opcao == 4) {
                buscarPorNota(jogos);
            } else if (opcao == 5) {
                listarFiltradosPlataformaAno(jogos);
            }

        } while (opcao != 6);
    }

    private static Integer escolherOpcao() {

        String opcoes = "1 - Cadastrar Jogo.\n" +
                "2 - Listar jogos.\n" +
                "3 - Buscar plataforma.\n" +
                "4 - Buscar por nota.\n" +
                "5 - Buscar jogo por maior nota filtrando plataforma e ano.\n" +
                "6 - Sair";

        return Integer.parseInt(JOptionPane.showInputDialog(opcoes));
    }

    private static void cadastrarJogo(ArrayList<Jogo> jogos) {

        Jogo _jogo = new Jogo();

        _jogo.setTitulo(JOptionPane.showInputDialog("Insira o título do jogo!"));
        _jogo.setPlataforma(JOptionPane.showInputDialog("Insira a plataforma do jogo!"));
        _jogo.setAnoLancamento(Integer.parseInt(JOptionPane.showInputDialog("Insira o ano de lançamento!")));
        _jogo.setNota(Double.parseDouble(JOptionPane.showInputDialog("Insira a Nota do jogo!")));

        if (_jogo.getAnoLancamento() == null || _jogo.getAnoLancamento() < 1990 || _jogo.getAnoLancamento() > 2024) {
            do {
                _jogo.setAnoLancamento(Integer.parseInt(JOptionPane.showInputDialog("Insira o ano de lançamento!")));

            } while (_jogo.getAnoLancamento() == null || _jogo.getAnoLancamento() < 1990 || _jogo.getAnoLancamento() > 2024);
        }

        jogos.add(_jogo);
    }

    private static void listarJogos(ArrayList<Jogo> jogos) {

        if (jogos.isEmpty()) {

            exibirMensagem("Não há nenhum jogo cadastrado!");

        } else {

            String mensagem = "";

            for (var jogo : jogos) {

                mensagem += " Título: " + jogo.getTitulo()
                        + "\nAno de Lançamento: " + jogo.getAnoLancamento()
                        + "\nPlataforma: " + jogo.getPlataforma()
                        + "\nNota: " + jogo.getNota();
            }

            exibirMensagem(mensagem);
        }
    }

    private static void buscarPorPlataforma(ArrayList<Jogo> jogos) {

        String plataforma = JOptionPane.showInputDialog("Insira uma plataforma para filtrar!");

        var jogosFiltrados = jogos.stream().filter(i -> i.getPlataforma().equalsIgnoreCase(plataforma)).toList();

        if (jogosFiltrados.isEmpty()) {

            exibirMensagem("Não há nenhum jogo com essa plataforma cadastrado!");

        } else {

            String mensagem = "";

            for (var jogo : jogosFiltrados) {

                mensagem += " Título: " + jogo.getTitulo()
                        + "\nAno de Lançamento: " + jogo.getAnoLancamento()
                        + "\nPlataforma: " + jogo.getPlataforma()
                        + "\nNota: " + jogo.getNota();
            }

            exibirMensagem(mensagem);
        }
    }

    private static void buscarPorNota(ArrayList<Jogo> jogos) {

        Double nota = Double.parseDouble(JOptionPane.showInputDialog("Insira uma nota para filtrar!"));

        var jogosFiltrados = jogos.stream().filter(i -> Objects.equals(i.getNota(), nota)).toList();

        if (jogosFiltrados.isEmpty()) {

            exibirMensagem("Não há nenhum jogo com essa nota cadastrado!");

        } else {

            String mensagem = "";

            for (var jogo : jogosFiltrados) {

                mensagem += " Título: " + jogo.getTitulo()
                        + "\nAno de Lançamento: " + jogo.getAnoLancamento()
                        + "\nPlataforma: " + jogo.getPlataforma()
                        + "\nNota: " + jogo.getNota();
            }

            exibirMensagem(mensagem);
        }
    }

    private static void listarFiltradosPlataformaAno(ArrayList<Jogo> jogos) {

        Integer ano = Integer.parseInt(JOptionPane.showInputDialog("Insira uma ano para filtrar!"));
        String plataforma = JOptionPane.showInputDialog("Insira uma plataforma para filtrar!");

        var jogosFiltrados = jogos.stream().filter(i -> i.getAnoLancamento() == ano && i.getPlataforma().equalsIgnoreCase(plataforma)).toList();

        double maiorNota = jogosFiltrados.stream()
                .max(Comparator.comparingDouble(Jogo::getNota))
                .map(Jogo::getNota)
                .orElse(0.0);

        jogosFiltrados = jogosFiltrados.stream().filter(i -> Objects.equals(i.getNota(), maiorNota)).toList();

        if (jogosFiltrados.isEmpty()) {

            exibirMensagem("Não há nenhum jogo para os filtros selecionados!");

        } else {

            String mensagem = "";

            for (var jogo : jogosFiltrados) {

                mensagem += " Título: " + jogo.getTitulo()
                        + "\nAno de Lançamento: " + jogo.getAnoLancamento()
                        + "\nPlataforma: " + jogo.getPlataforma()
                        + "\nNota: " + jogo.getNota();
            }

            exibirMensagem(mensagem);
        }
    }

    private static void exibirMensagem(String mensagem) {

        JOptionPane.showMessageDialog(null, mensagem);
    }
}
