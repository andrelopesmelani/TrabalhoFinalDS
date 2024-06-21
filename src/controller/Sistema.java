package controller;

import java.util.ArrayList;

import model.entities.Produto;
import model.entities.Funcionario;
import model.persistence.GerenciadorArquivoProduto;
import model.persistence.GerenciadorArquivoFuncionario;
import view.Console;

public class Sistema {

    static ArrayList<Produto> listaProdutos = ListaProdutos.getListaProdutos();
    static ArrayList<Funcionario> listaFuncionarios = ListaFuncionarios.getListaFuncionarios();
   
    public static void executarSistema() {

        carregarDadosDoArquivo();

        while (true) {
            
            exibirMenu();
            int op = Console.lerInt("Informe uma opção");
            verificarOpcaoMenuPrincipal(op);

        }
        
    }

    private static void exibirMenu() {
        System.out.println("\n********* Fábrica System *********\n");
        System.out.println("1) Produtos");
        System.out.println("2) Funcionários");
        System.out.println("0) Sair\n");
    }

    private static void exibirMenuProduto() {
        System.out.println("\n********* Produto System *********\n");
        System.out.println("1) Cadastrar Produto");
        System.out.println("2) Listar todos");
        System.out.println("3) Buscar produto");
        System.out.println("4) Apagar produto");
        System.out.println("5) Atualizar dados de um produto");
        System.out.println("0) Voltar\n");
    }

    private static void exibirMenuFuncionario() {
        System.out.println("\n********* Funcionario System *********\n");
        System.out.println("1) Cadastrar Funcionário");
        System.out.println("2) Listar todos");
        System.out.println("3) Buscar funcionario");
        System.out.println("4) Apagar funcionario");
        System.out.println("5) Atualizar dados de um funcionario");
        System.out.println("0) Voltar\n");
    }


    private static void verificarOpcaoMenuPrincipal(int op) {
        switch (op) {
            case 1:
                executarMenuProduto();
                break;

            case 2:
                executarMenuFuncionario();
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

    private static void executarMenuProduto() {
        int op;
        do {
            exibirMenuProduto();
            op = Console.lerInt("Informe uma opção");
            verificarOpcaoMenuProduto(op);
        } while (op != 0);
    }

    private static void verificarOpcaoMenuProduto(int op) {
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
                System.out.println("Voltando ao menu principal...");
                break;

            default:
                System.out.println("\nOpção inválida. Digite novamente.");
                break;
        }
    }

    private static void executarMenuFuncionario() {
        int op;
        do {
            exibirMenuFuncionario();
            op = Console.lerInt("Informe uma opção");
            verificarOpcaoMenuFuncionario(op);
        } while (op != 0);
    }

    private static void verificarOpcaoMenuFuncionario(int op) {
        switch (op) {
            case 1:
                salvarFuncionario();
                break;

            case 2:
                listarFuncionarios();
                break;

            case 3:
                buscarFuncionario();
                break;

            case 4:
                apagarFuncionario();
                break;

            case 5:
                atualizarFuncionario();
                break;  


            case 0:
                System.out.println("Voltando ao menu principal...");
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


            GerenciadorArquivoProduto.salvarProdutoNoArquivo(listaProdutos);

            System.out.println("\nProduto atualizado com sucesso:" + 
            tempProduto.exibirDados());
        
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

    }

    private static void carregarDadosDoArquivo() {
        
        try {
            GerenciadorArquivoProduto.criarArquivoSeNaoExistir();
            GerenciadorArquivoProduto.lerArquivo(listaProdutos);
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
            GerenciadorArquivoProduto.salvarProdutoNoArquivo(listaProdutos);
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
            GerenciadorArquivoProduto.salvarProdutoNoArquivo(listaProdutos);

            System.out.println("\nProduto localizado: " + tempProduto.exibirDados());
            
            System.out.println("\nProduto " + tempProduto.getNome() + 
            " apagado com sucesso do arquivo!");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }


    
    private static void atualizarFuncionario() {
        
        try {

            ListaFuncionarios.verificarListaVazia();
            

            System.out.println("\nInforme o nome do funcionário que deseja atualizar:");
            String nome = Console.lerString("Nome");

            Funcionario tempFuncionario = ListaFuncionarios.buscarFuncionario(nome);

            System.out.println("\nFuncionario Localizado:" +
            tempFuncionario.exibirDados() + "\nInforme novos dados:\n");

            nome = Console.lerString("Novo nome");
            String cargo = Console.lerString("Novo cargo");
   

            tempFuncionario.setNome(nome);
            tempFuncionario.setCargo(cargo);
 
            GerenciadorArquivoFuncionario.salvarFuncionarioNoArquivo(listaFuncionarios);

            System.out.println("\nFuncionário atualizado com sucesso:" + 
            tempFuncionario.exibirDados());
        
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

    }

    private static void carregarDadosDoArquivoFuncionario() {
        
        try {
            GerenciadorArquivoFuncionario.criarArquivoSeNaoExistir();
            GerenciadorArquivoFuncionario.lerArquivo(listaFuncionarios);
        } catch (Exception e) {
    
            System.out.println(e.getMessage());
        }

    }

    private static void salvarFuncionario() {

        System.out.println("\nNovo Funcionario");
        String nome = Console.lerString("Informe o nome do funcionário");
        String cargo = Console.lerString("Informe o cargo do funcionário");

        Funcionario funcionario = new Funcionario(nome, cargo);

        try { 
            ListaFuncionarios.salvarFuncionario(funcionario);
            GerenciadorArquivoFuncionario.salvarFuncionarioNoArquivo(listaFuncionarios);
            System.out.println("\nFuncionario foi salvo no arquivo!");
        
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    private static void listarFuncionarios() {

        try {
            ListaFuncionarios.verificarListaVazia();
            
            System.out.println("\nFuncionários Cadastrados");
    
            for(Funcionario tempFuncionario : listaFuncionarios) {
    
                System.out.println(tempFuncionario.exibirDados());
    
            }
            

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        
        
        

    }

    private static void buscarFuncionario() {

        try {
            ListaFuncionarios.verificarListaVazia();

            System.out.println("\nBuscar funcionário por nome.");
            String nome = Console.lerString("Informe o nome");

            Funcionario tempFuncionario = ListaFuncionarios.buscarFuncionario(nome);

            System.out.println("\nFuncionário encontrado:" + tempFuncionario.exibirDados());

        } catch (Exception e){

            System.out.println(e.getMessage());
        }


    }

    private static void apagarFuncionario() {

        try {
            ListaFuncionarios.verificarListaVazia();

            System.out.println("\nInforme o nome do funcionário que deseja apagar:");
            String nome = Console.lerString("Nome");

            Funcionario tempFuncionario = ListaFuncionarios.buscarFuncionario(nome);

            ListaFuncionarios.apagarFuncionario(tempFuncionario);
            GerenciadorArquivoFuncionario.salvarFuncionarioNoArquivo(listaFuncionarios);

            System.out.println("\nFuncionario localizado: " + tempFuncionario.exibirDados());
            
            System.out.println("\nFuncionario " + tempFuncionario.getNome() + 
            " apagado com sucesso do arquivo!");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }




}
