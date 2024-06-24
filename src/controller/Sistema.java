package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.entities.Produto;
import model.entities.Funcionario;
import model.entities.Gerente;
import model.entities.Operador;
import model.entities.OrdemProducao;
import model.persistence.GerenciadorArquivoProduto;
import model.persistence.GerenciadorArquivoFuncionario;
import model.persistence.GerenciadorArquivoOrdemProducao;
import view.Console;

public class Sistema {

    static ArrayList<Produto> listaProdutos = ListaProdutos.getListaProdutos();
    static ArrayList<Funcionario> listaFuncionarios = ListaFuncionarios.getListaFuncionarios();
    static ArrayList<OrdemProducao> listaOrdemProducao = ListaOrdemProducao.getListaOrdemProducao();
   
    public static void executarSistema() {
        carregarDadosDoArquivoProduto();
        carregarDadosDoArquivoFuncionario();
        carregarDadosDoArquivoOrdemProducao();
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
        System.out.println("3) Estoque");
        System.out.println("4) Ordem de Produção");
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
        System.out.println("1) Cadastrar Gerente");
        System.out.println("2) Cadastrar Operador");
        System.out.println("3) Listar todos");
        System.out.println("4) Buscar funcionario");
        System.out.println("5) Apagar funcionario");
        System.out.println("6) Atualizar dados de um funcionario");
        System.out.println("0) Voltar\n");
    }

    private static void exibirMenuOrdemProducao() {
        System.out.println("\n********* Ordem Produção System *********\n");
        System.out.println("1) Cadastrar Ordem de Produção");
        System.out.println("2) Listar todos");
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

            case 3:
                exibirEstoque();
                break;

            case 4:
                executarMenuOrdemProducao();
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
                salvarGerente();
                break;

            case 2: 
                salvarOperador();
                break;

            case 3:
                listarFuncionarios();
                break;

            case 4:
                buscarFuncionario();
                break;

            case 5:
                apagarFuncionario();
                break;

            case 6:
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

    private static void executarMenuOrdemProducao() {
 
        int op;
        do {
            exibirMenuOrdemProducao();
            op = Console.lerInt("Informe uma opção");
            verificarOpcaoMenuOrdemProducao(op);
        } while (op != 0);
    }

    private static void verificarOpcaoMenuOrdemProducao(int op) {
        switch (op) {
            case 1:
                salvarOrdemProducao();
                break;

            case 2:
                listarOrdemProducao();
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

    private static void carregarDadosDoArquivoProduto() {
        
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
            ListaFuncionarios.getListaFuncionarios() + "\nInforme novos dados:\n");

            nome = Console.lerString("Novo nome");
            float valorHora = Console.lerFloat("Novo valor por hora");
            float horasTrab = Console.lerFloat("Novas horas trabalhadas");
   

            tempFuncionario.setNome(nome);
            tempFuncionario.setHorasTrab(horasTrab);
            tempFuncionario.setValorHora(valorHora);
 
            GerenciadorArquivoFuncionario.salvarFuncionarioNoArquivo(listaFuncionarios);

            System.out.println("\nFuncionário atualizado com sucesso:" + 
            ListaFuncionarios.getListaFuncionarios());
        
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

    private static void salvarGerente() {

        System.out.println("\nNovo Gerente");
        String nome = Console.lerString("Informe o nome do funcionário");
        String setor = Console.lerString("Informe o setor");
        float valorHora = Console.lerFloat("Valor por hora");;
        float horasTrab = Console.lerFloat("Horas trabalhadas");
        float bonus = Console.lerFloat("Informe o bonus anual");
        Gerente gerente = new Gerente(nome, valorHora, horasTrab, setor, bonus);

        try { 
            ListaFuncionarios.salvarFuncionario(gerente);
            GerenciadorArquivoFuncionario.salvarFuncionarioNoArquivo(listaFuncionarios);
            System.out.println("\nGerente foi salvo no arquivo!");
        
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    private static void salvarOperador() {

        System.out.println("\nNovo Operador");
        String nome = Console.lerString("Informe o nome do funcionário");
        String funcao = Console.lerString("Informe a função");
        float valorHora = Console.lerFloat("Valor por hora");;
        float horasTrab = Console.lerFloat("Horas trabalhadas");
        Operador operador = new Operador(nome, valorHora, horasTrab, funcao);

        try { 
            ListaFuncionarios.salvarFuncionario(operador);
            GerenciadorArquivoFuncionario.salvarFuncionarioNoArquivo(listaFuncionarios);
            System.out.println("\nOperador foi salvo no arquivo!");
        
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    private static void listarFuncionarios() {

        try {
            ListaFuncionarios.verificarListaVazia();
            
            System.out.println("\nFuncionários Cadastrados\n");
    
            for (Funcionario tempFuncionario : listaFuncionarios) {
                System.out.println(tempFuncionario);
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

    private static void salvarOrdemProducao() {
        try {
            ListaProdutos.verificarListaVazia();
            
            System.out.println("\nProdutos Cadastrados");

            for (Produto tempProduto : ListaProdutos.getListaProdutos()) {
                System.out.println(tempProduto.exibirDados());
            }
 
            Produto tempProduto = null;
            while (tempProduto == null) {
                String nome = Console.lerString("Selecione o produto pelo nome: ");
                try {
                    tempProduto = ListaProdutos.buscarProduto(nome);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
    
            int quantidade = 0;
            while (quantidade <= 0) {
                quantidade = Console.lerInt("Selecione a quantidade produzida: ");
                if (quantidade <= 0) {
                    System.out.println("Quantidade inválida. Deve ser um número inteiro positivo e diferente de 0.");
                }
            }
    
            OrdemProducao ordemProducao = new OrdemProducao(tempProduto, quantidade);
            ListaOrdemProducao.salvarOrdemProducao(ordemProducao);
            
            try {
                GerenciadorArquivoOrdemProducao.salvarOrdemProducaoNoArquivo(ListaOrdemProducao.getListaOrdemProducao());
                System.out.println("\nOrdem de produção foi salva no arquivo!");
            } catch (Exception e) {
                System.out.println("Erro ao salvar a ordem de produção no arquivo: " + e.getMessage());
            }
    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void carregarDadosDoArquivoOrdemProducao() {
        
        try {
            GerenciadorArquivoOrdemProducao.criarArquivoSeNaoExistir();
            GerenciadorArquivoOrdemProducao.lerArquivo(listaOrdemProducao);
        } catch (Exception e) {
    
            System.out.println(e.getMessage());
        }

    }


    private static void listarOrdemProducao() {

        try {
            ListaOrdemProducao.verificarOrdemProduçãoVazia();
            
            System.out.println("\nOrdem de produção registradas");
    
            for(OrdemProducao tempOrdemProducao : listaOrdemProducao) {
                System.out.println(tempOrdemProducao.exibirDados());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

private static void exibirEstoque() {
    try {
        Map<Produto, Integer> mapaEstoque = GerenciadorArquivoOrdemProducao.filtrarListaOrdemProducao(listaOrdemProducao);

        System.out.println("\n*************** Estoque ***************\n");
        Map<String, Integer> estoqueAgrupado = new HashMap<>();

        for (Map.Entry<Produto, Integer> entry : mapaEstoque.entrySet()) {
            Produto produto = entry.getKey();
            Integer quantidade = entry.getValue();
            String nomeProduto = produto.getNome();

            if (estoqueAgrupado.containsKey(nomeProduto)) {
                int quantidadeAtualizada = estoqueAgrupado.get(nomeProduto) + quantidade;
                estoqueAgrupado.put(nomeProduto, quantidadeAtualizada);
            } else {
                estoqueAgrupado.put(nomeProduto, quantidade);
            }
        }

        for (Map.Entry<String, Integer> entry : estoqueAgrupado.entrySet()) {
            System.out.println("Produto=" + entry.getKey() + ", Quantidade=" + entry.getValue());
        }

    } catch (Exception e) {
        System.out.println("Erro ao exibir o estoque: " + e.getMessage());
    }
}

}

