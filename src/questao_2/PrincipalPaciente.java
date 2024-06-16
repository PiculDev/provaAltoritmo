package questao_2;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class PrincipalPaciente {
    public static void main(String[] args) {

        ArrayList<Paciente> pacientes = new ArrayList<>();
        int opcao;

        do {
            opcao = escolherOpcao();

            if (opcao == 1) {
                cadastrarPaciente(pacientes);
            } else if (opcao == 2) {
                listarDiagnosticoPaciente(pacientes);
            } else if (opcao == 3) {
                buscarPorNome(pacientes);
            } else if (opcao == 4) {
                buscarAno(pacientes);
            } else if (opcao == 5) {
                listarPacientesGenero(pacientes);
            }

        } while (opcao != 6);
    }

    private static Integer escolherOpcao() {

        String opcoes = "1 - Cadastrar Paciente.\n" +
                "2 - Localizar paciente pelo código do cartão SUS.\n" +
                "3 - Filtrar pacientes por nome.\n" +
                "4 - Listar todos os pacientes nascidos no ano 2000.\n" +
                "5 - Listar pacientes por gênero.\n" +
                "6 - Sair";

        return Integer.parseInt(JOptionPane.showInputDialog(opcoes));
    }

    private static void cadastrarPaciente(ArrayList<Paciente> pacientes) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        boolean dataValida = false;
        Date date = null;

        Paciente _paciente = new Paciente();

        _paciente.setNome(JOptionPane.showInputDialog("Insira o nome do paciente!"));
        _paciente.setGenero(JOptionPane.showInputDialog("Insira o gênero do paciente! ('F' para feminino e 'M' para masculino)"));
        _paciente.setNumeroSus(JOptionPane.showInputDialog("Insira código do cartão SUS do paciente!"));

        if (_paciente.getNumeroSus() == null || _paciente.getNumeroSus().length() != 15) {
            do {
                _paciente.setNumeroSus(JOptionPane.showInputDialog("Insira código do cartão SUS do paciente!"));

            } while (_paciente.getNumeroSus() == null || _paciente.getNumeroSus().length() != 15);
        }

        while (!dataValida) {
            String data = JOptionPane.showInputDialog("Informe uma data (dd/MM/yyyy):");

            try {
                date = dateFormat.parse(data);
                dataValida = true;
                _paciente.setData(data);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Data inválida, por favor tente novamente.");
            }
        }

        for (int i = 0; i < 5; i++) {
            _paciente.getDiagnosticos()[i] = JOptionPane.showInputDialog("Insira o diagnóstico do paciente!");
        }

        pacientes.add(_paciente);
    }

    private static void listarDiagnosticoPaciente(ArrayList<Paciente> pacientes) {

        Integer numeroSus = Integer.parseInt(JOptionPane.showInputDialog("Insira o número do cartão para filtrar."));

        var pacienteFiltrado = pacientes.stream().filter(i -> Objects.equals(i.getNumeroSus(), numeroSus)).findFirst().orElse(null);

        if (pacienteFiltrado == null) {

            exibirMensagem("Não há nenhum paciente com esse número do cartão SUS!");

        } else {

            String mensagem = "Diagnóstico do Paciente:";

            for (int i = 0; i < 5; i++) {

                mensagem += " " + pacienteFiltrado.getDiagnosticos()[i] + ",";
            }

            exibirMensagem(mensagem);
        }
    }

    private static void buscarPorNome(ArrayList<Paciente> pacientes) {

        String nome = JOptionPane.showInputDialog("Insira um nome para filtrar!");

        var pacientesFiltrados = pacientes.stream().filter(i -> i.getNome().equalsIgnoreCase(nome)).toList();

        if (pacientesFiltrados.isEmpty()) {

            exibirMensagem("Não há nenhum paciente com esse nome!");

        } else {

            String mensagem = "Diagnósticos do Paciente: ";

            for (var paciente : pacientesFiltrados) {

                for (int i = 0; i < 5; i++) {

                    mensagem += " " + paciente.getDiagnosticos()[i] + ",";
                }
            }

            exibirMensagem(mensagem);
        }
    }

    private static void buscarAno(ArrayList<Paciente> pacientes) {

        var pacientesFiltrados = pacientes.stream().filter(i -> "2000".equals(i.getData().substring(6, 10))).toList();

        if (pacientesFiltrados.isEmpty()) {

            exibirMensagem("Não há nenhum paciente com essa ano de nascimento!");

        } else {

            String mensagem = "";

            for (var paciente : pacientesFiltrados) {

                mensagem += " Nome: " + paciente.getNome()
                        + "\nAno de Nascimento: " + paciente.getData()
                        + "\nGênero: " + paciente.getGenero()
                        + "\nNúmero do cartão SUS: " + paciente.getNumeroSus();
            }

            exibirMensagem(mensagem);
        }
    }

    private static void listarPacientesGenero(ArrayList<Paciente> pacientes) {

        String genero = JOptionPane.showInputDialog("Insira um gênero para filtrar! ('F' para feminino e 'M' para masculino)");

        var pacientesFiltrados = pacientes.stream().filter(i -> i.getGenero().equalsIgnoreCase(genero)).toList();

        if (pacientesFiltrados.isEmpty()) {

            exibirMensagem("Não há nenhum paciente para o gênero filtrado!");

        } else {

            String mensagem = "";

            for (var paciente : pacientesFiltrados) {

                mensagem += " Nome: " + paciente.getNome()
                        + "\nAno de Nascimento: " + paciente.getData()
                        + "\nGênero: " + paciente.getGenero()
                        + "\nNúmero do cartão SUS: " + paciente.getNumeroSus();
            }

            exibirMensagem(mensagem);
        }
    }

    private static void exibirMensagem(String mensagem) {

        JOptionPane.showMessageDialog(null, mensagem);
    }
}