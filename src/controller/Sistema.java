package controller;

import java.util.ArrayList;

import model.entities.Produto;
import model.persistence.GerenciadorArquivo;
import view.Console;

public class Sistema {

    static ArrayList<Produto> listaProdutos = ListaProdutos.getListaProdutos();
   
    public static void executarSistema() {

        carregarDadosDoArquivo();

        while (true) {
            
            exibirMenu();
            int op = Console.lerInt("Informe uma opção");
            verificarOpcaoMenu(op);

        }
        
    }

    private static void exibirMenu() {

        System.out.println("\nFábrica Sysyem");
        System.out.println("1) Cadastrar Produto");
        System.out.println("2) Listar todos");
        System.out.println("3) Buscar produto");
        System.out.println("4) Apagar produto");
        System.out.println("5) Atualizar dados de um produto");
        System.out.println("0) Sair");

    }

    private static void verificarOpcaoMenu(int op) {

        switch (op) {
            case 1:
                salvarProduto();
                break;

            case 2:
                listarProdutos();
                break;

            case 3:
                buscarProduto();
                break;

            case 4:
                apagarProduto();
                break;

            case 5:
                atualizarProduto();
                break;

            case 0:
                System.out.println("\nO Sistema foi finalizado...\n");
                System.exit(0);
                break;
        
            default:
                System.out.println("\nOpção inválida. Digite novamente.");
                break;
        }


    }
    
    private static void atualizarProduto() {
        
        try {

            ListaProdutos.verificarListaVazia();
            

            System.out.println("\nInforme o nome do produto que deseja atualizar:");
            String nome = Console.lerString("Nome");

            Produto tempProduto = ListaProdutos.buscarProduto(nome);

            System.out.println("\nProduto Localizado:" +
            tempProduto.exibirDados() + "\nInforme novos dados:\n");

            nome = Console.lerString("Novo nome");
            String descricao = Console.lerString("Nova descrição");
            float preco = Console.lerFloat();

            tempProduto.setNome(nome);
            tempProduto.setDescricao(descricao);
            tempProduto.setPreco(preco);


            GerenciadorArquivo.salvarProdutoNoArquivo(listaProdutos);

            System.out.println("\nProduto atualizado com sucesso:" + 
            tempProduto.exibirDados());
        
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

    }

    private static void carregarDadosDoArquivo() {
        
        try {
            GerenciadorArquivo.criarArquivoSeNaoExistir();
            GerenciadorArquivo.lerArquivo(listaProdutos);
        } catch (Exception e) {
    
            System.out.println(e.getMessage());
        }

    }

    private static void salvarProduto() {

        System.out.println("\nNovo Produto");
        String nome = Console.lerString("Informe o nome do produto");
        String descricao = Console.lerString("Informe uma descrição para o produto");
        float preco = Console.lerFloat("Informe o preco do produto");

        Produto produto = new Produto(nome, descricao, preco);

        try { 
            ListaProdutos.salvarProduto(produto);
            GerenciadorArquivo.salvarProdutoNoArquivo(listaProdutos);
            System.out.println("\nProduto foi salvo no arquivo!");
        
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    private static void listarProdutos() {

        try {
            ListaProdutos.verificarListaVazia();
            
            System.out.println("\nProdutos Cadastrados");
    
            for(Produto tempProduto : listaProdutos) {
    
                System.out.println(tempProduto.exibirDados());
    
            }
            

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        
        
        

    }

    private static void buscarProduto() {

        try {
            ListaProdutos.verificarListaVazia();

            System.out.println("\nBuscar produto por nome.");
            String nome = Console.lerString("Informe o nome");

            Produto tempProduto = ListaProdutos.buscarProduto(nome);

            System.out.println("\nProduto encontrado:" + tempProduto.exibirDados());

        } catch (Exception e){

            System.out.println(e.getMessage());
        }


    }

    private static void apagarProduto() {

        try {
            ListaProdutos.verificarListaVazia();

            System.out.println("\nInforme o nome do produto que deseja apagar:");
            String nome = Console.lerString("Nome");

            Produto tempProduto = ListaProdutos.buscarProduto(nome);

            ListaProdutos.apagarProduto(tempProduto);
            GerenciadorArquivo.salvarProdutoNoArquivo(listaProdutos);

            System.out.println("\nProduto localizado: " + tempProduto.exibirDados());
            
            System.out.println("\nProduto " + tempProduto.getNome() + 
            " apagado com sucesso do arquivo!");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }




}
