package questao_1;

import javax.swing.*;
import java.util.ArrayList;

public class PrincipalLivro {
    public static void main(String[] args) {

        ArrayList<Livro> livros = new ArrayList<>();
        int opcao;

        do {
            opcao = escolherOpcao();

            if (opcao == 1) {
                cadastrarLivro(livros);
            } else if (opcao == 2) {
                localizarLivroIsbn(livros);
            } else if (opcao == 3) {
                buscarPorUsuario(livros);
            } else if (opcao == 4) {
                buscarAno(livros);
            } else if (opcao == 5) {
                listarLivrosGenero(livros);
            }

        } while (opcao != 6);
    }

    private static Integer escolherOpcao() {

        String opcoes = "1 - Cadastrar Livro.\n" +
                "2 - Localizar livro pelo código ISBN.\n" +
                "3 - Filtrar livros por nome.\n" +
                "4 - Listar todos os livros do ano de 2020.\n" +
                "5 - Listar livros por gênero.\n" +
                "6 - Sair";

        return Integer.parseInt(JOptionPane.showInputDialog(opcoes));
    }

    private static void cadastrarLivro(ArrayList<Livro> livros) {

        Livro _livro = new Livro();

        _livro.setTitulo(JOptionPane.showInputDialog("Insira o título do livro!"));
        _livro.setAutor(JOptionPane.showInputDialog("Insira o autor do livro!"));
        _livro.setAnoPublicacao(Integer.parseInt(JOptionPane.showInputDialog("Insira o ano de publicação do livro!")));
        _livro.setGenero(JOptionPane.showInputDialog("Insira o gênero do livro!"));
        _livro.setCodigoIsbn(JOptionPane.showInputDialog("Insira o código ISBN!"));

        if (_livro.getCodigoIsbn() == null || "".equalsIgnoreCase(_livro.getCodigoIsbn()) || _livro.getCodigoIsbn().length() != 13) {
            do {
                _livro.setCodigoIsbn(JOptionPane.showInputDialog("Insira o código ISBN!"));

            } while (_livro.getCodigoIsbn() == null || "".equalsIgnoreCase(_livro.getCodigoIsbn()) || _livro.getCodigoIsbn().length() != 13);
        }

        for (int i = 0; i < 5; i++) {
            _livro.getPessoas()[i] = JOptionPane.showInputDialog("Insira a pessoa que pegou emprestado o livro!");
        }

        livros.add(_livro);
    }

    private static void localizarLivroIsbn(ArrayList<Livro> livros) {

        String codigoIsbn = JOptionPane.showInputDialog("Insira um código para filtrar.");

        var livroFiltrado = livros.stream().filter(i -> i.getCodigoIsbn().equalsIgnoreCase(codigoIsbn)).findFirst().orElse(null);

        if (livroFiltrado == null) {

            exibirMensagem("Não há nenhum livro com esse código ISBN!");

        } else {

            String mensagem = "Pessoas que pegaram o livro:";

            for (int i = 0; i < 5; i++) {

                mensagem += " " + livroFiltrado.getPessoas()[i] + ",";
            }

            exibirMensagem(mensagem);
        }
    }

    private static void buscarPorUsuario(ArrayList<Livro> livros) {

        String pessoa = JOptionPane.showInputDialog("Insira um nome para filtrar!");

        String mensagem = "Livros pegos emprestado: ";

        for (var livro : livros) {

            for (int i = 0; i < 5; i++) {

                if (livro.getPessoas()[i].contains(pessoa)) {

                    mensagem += " " + livro.getTitulo() + ",";
                }
            }
        }

        exibirMensagem(mensagem);
    }

    private static void buscarAno(ArrayList<Livro> livros) {

        var livrosFiltrados = livros.stream().filter(i -> i.getAnoPublicacao() == 2020).toList();

        if (livrosFiltrados.isEmpty()) {

            exibirMensagem("Não há nenhum livro com essa ano cadastrado!");

        } else {

            String mensagem = "";

            for (var livro : livrosFiltrados) {

                mensagem += " Título: " + livro.getTitulo()
                        + "\nAno de Publicação: " + livro.getAnoPublicacao()
                        + "\nAutor: " + livro.getAutor()
                        + "\nGênero: " + livro.getGenero()
                        + "\nISBN: " + livro.getCodigoIsbn();
            }

            exibirMensagem(mensagem);
        }
    }

    private static void listarLivrosGenero(ArrayList<Livro> livros) {

        String genero = JOptionPane.showInputDialog("Insira um gênero para filtrar!");

        var livrosFiltrados = livros.stream().filter(i -> i.getGenero().equalsIgnoreCase(genero)).toList();

        if (livrosFiltrados.isEmpty()) {

            exibirMensagem("Não há nenhum livro para o gênero selecionados!");

        } else {

            String mensagem = "";

            for (var livro : livrosFiltrados) {

                mensagem += " Título: " + livro.getTitulo()
                        + "\nAno de Publicação: " + livro.getAnoPublicacao()
                        + "\nAutor: " + livro.getAutor()
                        + "\nGênero: " + livro.getGenero()
                        + "\nISBN: " + livro.getCodigoIsbn();
            }

            exibirMensagem(mensagem);
        }
    }

    private static void exibirMensagem(String mensagem) {

        JOptionPane.showMessageDialog(null, mensagem);
    }
}
