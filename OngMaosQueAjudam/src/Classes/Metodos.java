package Classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Metodos{
    static Scanner sc=new Scanner(System.in);
    static ArrayList<Produto> produtos=new ArrayList<Produto>();
    static ArrayList<Familia> familias=new ArrayList<Familia>();
    static ArrayList<Doacao> doacoes=new ArrayList<Doacao>();
    static ArrayList<Entrega> entregas=new ArrayList<Entrega>();
    static ArrayList<Doador> doadores=new ArrayList<Doador>();

    public static boolean soTemLetras(String palavra){
        for(int i=0;i<palavra.length();i++){
            if (Character.isDigit(palavra.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    public static boolean soTemNumeros(String palavra){
        for (int i=0;i<palavra.length();i++){
            if (!Character.isDigit(palavra.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static void limparBuffer(){
        System.out.print("-> Pressione ENTER para continuar...");
        sc.nextLine();
    }
    public static void limparTerminal() {
        try {
            new ProcessBuilder("cmd", "/c", "cls")
                .inheritIO()
                .start()
                .waitFor();
        } catch (Exception e) {
            System.out.println("Erro ao limpar o terminal.");
        }
    }
    public static void exibirMenu() {
        System.out.println("\n\t====== MENU PRINCIPAL ======");
        System.out.println("=> Usuário: Administrador\n");
        System.out.println("\t1 - Famílias");
        System.out.println("\t2 - Produtos e Estoque");
        System.out.println("\t3 - Doações Recebidas");
        System.out.println("\t4 - Entregas de Cestas");
        System.out.println("\t0 - Sair");
        System.out.print("\tEscolha uma opção: ");
    }
    public static void menuFamilias() {
    String opcao;
    do {
        System.out.println("\n\t====== FAMÍLIAS ======");
        System.out.println("\t1 - Cadastrar família");
        System.out.println("\t2 - Listar famílias");
        System.out.println("\t3 - Buscar família por CPF");
        System.out.println("\t4 - Editar família");
        System.out.println("\t5 - Desligar família");
        System.out.println("\t0 - Voltar");
        System.out.print("\tEscolha uma opção: ");
        opcao = sc.nextLine();
        limparTerminal();

        switch (opcao) {
            case "1":
                cadastrarFamilia();
                limparTerminal();
                break;
            case "2":
                listarFamilias();
                limparTerminal();
                break;
            case "3":
                procurarFamilia();
                limparTerminal();
                break;
            case "4":
                editarFamilia();
                limparTerminal();
                break;
            case "5":
                desligarFamilia();
                limparTerminal();
                break;
            case "0":
                break;
            default:
                System.out.println("Opção inválida!");
        }
    } while (!opcao.equals("0"));
}
    public static void menuProdutos() {
        String opcao;
        do {
            System.out.println("\n\t====== PRODUTOS E ESTOQUE ======");
            System.out.println("\t1 - Cadastrar produto");
            System.out.println("\t2 - Consultar estoque");
            System.out.println("\t3 - Listar por categoria");
            System.out.println("\t0 - Voltar");
            System.out.print("\tEscolha uma opção: ");
            opcao = sc.nextLine();
            limparTerminal();

            switch (opcao) {
                case "1":
                    cadastrarProduto();
                    limparTerminal();
                    break;
                case "2":
                    listarProdutos();
                    limparTerminal();
                    break;
                case "3":
                    listarPorCategoria();
                    limparTerminal();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (!opcao.equals("0"));
    }
    public static void menuDoacoes() {
        String opcao;
        do {
            System.out.println("\n\t====== DOAÇÕES RECEBIDAS ======");
            System.out.println("\t1 - Registrar doação");
            System.out.println("\t2 - Listar doações");
            System.out.println("\t0 - Voltar");
            System.out.print("\tEscolha uma opção: ");
            opcao = sc.nextLine();
            limparTerminal();

            switch (opcao) {
                case "1":
                    registrarDoacao();
                    limparTerminal();
                    break;
                case "2":
                    listarDoacao();
                    limparTerminal();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (!opcao.equals("0"));
    }
    public static void menuEntregas() {
        String opcao;
        do {
            System.out.println("\n\t====== ENTREGAS DE CESTAS ======");
            System.out.println("\t1 - Registrar entrega");
            System.out.println("\t2 - Listar entregas");
            System.out.println("\t0 - Voltar");
            System.out.print("\tEscolha uma opção: ");
            opcao = sc.nextLine();
            limparTerminal();

            switch (opcao) {
                case "1":
                    registrarEntrega();
                    limparTerminal();
                    break;
                case "2":
                    listarEntregas();
                    limparTerminal();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (!opcao.equals("0"));
    }
    public static Familia buscarCpf(String cpf){
        for (Familia familia : familias) {
            if (familia.getCpf().equalsIgnoreCase(cpf)) {
                return familia;
            }
        }
        return null;
    }
    public static Produto buscarProduto(String nome){
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }
    public static Boolean Login(){
        Usuario adminUsuario=new Usuario("Administrador", "admin", "1234");
        int tentativas=0, maxTentativas=3;

        System.out.println("\t====== LOGIN ======\n");

        while (tentativas<maxTentativas) {
            System.out.print("Digite o Usuário: ");
            String login = sc.nextLine();
            System.out.print("Digite a Senha: ");
            String senha = sc.nextLine();

            if (senha.equals(adminUsuario.getSenha())&&login.equals(adminUsuario.getLogin())) {
                System.out.println("\t=> Login realizado <=");
                return true;
            }
            tentativas++;
            System.out.println("\tUsuário ou Senha incorreto(s)!\nTentativas restantes: "+ (maxTentativas - tentativas));
        }
        return false;
    }

    public static void cadastrarProduto(){
        String nome="";
        Boolean nomevalido=false;
        
        System.out.println("\t====== CADASTRAR PRODUTO ======");

        do{
            try{
                System.out.print("\nNome: ");
                nome=sc.nextLine();
                if (nome.isBlank()) {
                    throw new IllegalArgumentException("Erro! Nome está vazio.");
                }
                if (soTemLetras(nome)) {
                    throw new IllegalArgumentException("Erro! Nome só deve conter letras.");
                }
                for (Produto produto : produtos) {
                   if (nome.equalsIgnoreCase(produto.getNome())) {
                        throw new IllegalArgumentException("Produto já existente!");
                    }
                }
                
                nomevalido=true;
            }catch( IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }while(!nomevalido);

        String categoria="";

        System.out.println("\nCategoria:");
        System.out.println("\t1 - Grãos e Cereais");
        System.out.println("\t2 - Massas");
        System.out.println("\t3 - Enlatados");
        System.out.println("\t4 - Óleos e Temperos");
        System.out.println("\t5 - Higiene");
        System.out.println("\t6 - Limpeza");

        do{
            System.out.print("\n=> ");
            String opc=sc.nextLine();

            switch (opc) {
                case "1": 
                    categoria="Grãos e cereais"; 
                    break;
                case "2": 
                    categoria="Massas"; 
                    break;
                case "3": 
                    categoria="Enlatados"; 
                    break;
                case "4": 
                    categoria="Óleos e temperos"; 
                    break;
                case "5": 
                    categoria="Higiene"; 
                    break;
                case "6": 
                    categoria="Limpeza"; 
                    break;
                default: 
                System.out.println("Erro! Escolha um número da lista.");
            }
        }while (categoria.isEmpty());

        int quantidade=0;
        boolean quantidadevalida=false;
        do{
            try{
                    System.out.println("\nQuantidade de estoque: ");
                    quantidade=Integer.parseInt(sc.nextLine());

                    if (quantidade<0) {
                        throw new IllegalArgumentException("Erro! Quantidade não pode ser negativa.");
                    }
                    
                    quantidadevalida=true;
                }catch(NumberFormatException e){
                    System.out.println("Erro! Digite apenas números.");
                }catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
        }while (!quantidadevalida);

        produtos.add(new Produto(nome, categoria, quantidade));

        System.out.println("\t=> Produto Cadastrado <=");
        limparBuffer();
        limparTerminal();
    }
    public static void listarProdutos(){
        System.out.println("\t====== PRODUTOS ======");
        int i=0;

        if (produtos.isEmpty()) {
            System.out.println("\n\tNenhum produto cadastrado.");
            return;
        }
        for (Produto produto : produtos) {
            System.out.printf("\n\t=> Produto %d <=\n", i+1);
            produto.exibirProduto();
            i++;
        }
        limparBuffer();
        limparTerminal();
    }
    public static void listarPorCategoria(){
        System.out.println("\t====== PRODUTOS POR CATEGORIA ======");

        if (produtos.isEmpty()) {
            System.out.println("\n\tNenhum produto cadastrado.");
            limparBuffer();
            limparTerminal();
            return;
        }

        String categoria="";

        System.out.println("\nCategoria:");
        System.out.println("\t1 - Grãos e Cereais");
        System.out.println("\t2 - Massas");
        System.out.println("\t3 - Enlatados");
        System.out.println("\t4 - Óleos e Temperos");
        System.out.println("\t5 - Higiene");
        System.out.println("\t6 - Limpeza");

        do{
            System.out.print("\n=> ");
            String opc=sc.nextLine();

            switch (opc) {
                case "1":
                    categoria = "Grãos e cereais";
                    break;
                case "2":
                    categoria = "Massas";
                    break;
                case "3":
                    categoria = "Enlatados";
                    break;
                case "4":
                    categoria = "Óleos e temperos";
                    break;
                case "5":
                    categoria = "Higiene";
                    break;
                case "6":
                    categoria = "Limpeza";
                    break;
                default:
                    System.out.println("Erro! Escolha um número da lista.");
            }
        }while (categoria.isEmpty());

        int encontrados=0;

        System.out.println("\n\t=> "+categoria+" <=");
        for (Produto produto : produtos) {
            if (produto.getCategoria().equalsIgnoreCase(categoria)) {
                encontrados++;
                System.out.printf("\n\t=> Produto %d <=\n", encontrados);
                produto.exibirProduto();
            }
        }

        if (encontrados==0) {
            System.out.println("\n\tNenhum produto nessa categoria.");
        }
        limparBuffer();
        limparTerminal();
    }
    public static void cadastrarFamilia(){
        System.out.println("\t====== CADASTRAR FAMÍLIA ======");

        String nome="";
        boolean nomevalido=false;

        do{
            try{
                System.out.print("Nome do Responsável: ");
                nome=sc.nextLine();

                if (nome.isBlank()) {
                    throw new IllegalArgumentException("Erro! Nome está vazio.");
                }
                if (soTemLetras(nome)) {
                    throw new IllegalArgumentException("Erro! Nome só deve conter letras.");
                }
                nomevalido=true;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }while (!nomevalido);

        String cpf="";
        boolean cpfvalido=false;

        do{
            try {
                System.out.print("CPF: ");
                cpf=sc.nextLine();

                if (cpf.isBlank()) {
                    throw new IllegalArgumentException("Erro! CPF está vazio.");
                }
                if (!soTemNumeros(cpf)) {
                    throw new IllegalArgumentException("Erro! CPF só deve conter números.");
                }
                if (cpf.length()!=11) {
                    throw new IllegalArgumentException("Erro! CPF deve conter 11 dígitos.");
                }
                for (Familia familia : familias) {
                    if (cpf.equalsIgnoreCase(familia.getCpf())) {
                        throw new IllegalArgumentException("CPF já existente!");
                    }
                }
                cpfvalido=true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }while(!cpfvalido);

        int numeroPessoas=0;
        boolean numeroPessoasvalido=false;
        
        
        do{
            try {
                System.out.print("Número de residentes: ");
                numeroPessoas=Integer.parseInt(sc.nextLine());

                if (numeroPessoas<=0) {
                    throw new IllegalArgumentException("Erro! Residentes não podem ser negativos ou zerados.");
                }
                numeroPessoasvalido=true;
            }catch(NumberFormatException e){
                System.out.println("Erro! Digite apenas números.");
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }while (!numeroPessoasvalido);

        double rendaMensal=0.0;
        boolean rendaMensalvalido=false;

        do{
            try{
                System.out.print("Renda Mensal: ");
                rendaMensal=Double.parseDouble(sc.nextLine());

                if (rendaMensal<=0) {
                    throw new IllegalArgumentException("Erro! Renda não pode ser negativa ou zerada.");
                }
                
                rendaMensalvalido=true;
            }catch(NumberFormatException e){
                System.out.println("Erro! Digite apenas números.");
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }while(!rendaMensalvalido);

        boolean ativa=false;
        double rendaPorPessoa = rendaMensal/numeroPessoas;

        if (rendaPorPessoa>810.50) {
            System.out.println("Família inapta ao benefício! | Renda familiar acima de meio salário.");
        }else{
            ativa=true;
            familias.add(new Familia(nome, cpf, rendaMensal, numeroPessoas, ativa));
            System.out.println("\t=> Família Cadastrada <=\n");
        }
        limparBuffer();
        limparTerminal();
    }
    public static void listarFamilias(){
        System.out.println("\t====== FAMÍLIAS ======");
        
        if (familias.isEmpty()) {
            System.out.println("\n\tNenhuma família cadastrada.");
            return;
        }
        for (Familia familia : familias) {
            familia.exibirFamilia();
        }
        limparBuffer();
        limparTerminal();
    }
    public static void procurarFamilia(){
        System.out.println("\t====== BUSCA ======\n");
        String cpf="";
        boolean cpfvalido=false;

        do{
            try {
                System.out.print("CPF do Responsável: ");
                cpf=sc.nextLine();

                if (cpf.isBlank()) {
                    throw new IllegalArgumentException("Erro! CPF está vazio.");
                }
                if (!soTemNumeros(cpf)) {
                    throw new IllegalArgumentException("Erro! CPF só deve conter números.");
                }
                if (cpf.length()!=11) {
                    throw new IllegalArgumentException("Erro! CPF deve conter 11 dígitos.");
                }
                cpfvalido=true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }while(!cpfvalido);
        
        Familia familia=buscarCpf(cpf);

        if (familia==null) {
            System.out.println("CPF não encontrado!");
        }else{
            System.out.println("\t=> Dados da Família <=");
            familia.exibirFamilia();
        }
        limparBuffer();
        limparTerminal();
    }
    public static void desligarFamilia(){
        System.out.println("\t====== DESLIGAR ======\n");
        String cpf="";
        boolean cpfvalido=false;

        do{
            try {
                System.out.print("CPF do Responsável: ");
                cpf=sc.nextLine();

                if (cpf.isBlank()) {
                    throw new IllegalArgumentException("Erro! CPF está vazio.");
                }
                if (!soTemNumeros(cpf)) {
                    throw new IllegalArgumentException("Erro! CPF só deve conter números.");
                }
                if (cpf.length()!=11) {
                    throw new IllegalArgumentException("Erro! CPF deve conter 11 dígitos.");
                }
                cpfvalido=true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }while(!cpfvalido);
        
        Familia familia=buscarCpf(cpf);

        if (familia==null) {
            System.out.println("CPF não encontrado!");
        }else if (!familia.isAtiva()) {
            System.out.println("Esta família já está desligada.");
        }else{
            System.out.println("\t=> Dados da Família <=");
            familia.exibirFamilia();

            String desligar = "";
            System.out.println("\nDesligar Família?\n[1] Sim | [2] Não");

            do {
                System.out.print("-> ");
                desligar=sc.nextLine();

                if (!desligar.equals("1")&&!desligar.equals("2")) {
                    System.out.println("Erro! Digite 1 ou 2.");
                }
            }while(!desligar.equals("1") && !desligar.equals("2"));

            if (desligar.equals("1")) {
                familia.setAtiva(false);
                System.out.println("\t=> Família Desligada <=");
            } else {
                System.out.println("\t=> Nenhuma alteração feita <=");
            }
        }
        limparBuffer();
        limparTerminal();
    } 
    public static void editarFamilia(){
        System.out.println("\t====== EDITAR ======\n");
        String cpf="";
        boolean cpfvalido=false;

        do{
            try {
                System.out.print("CPF do Responsável: ");
                cpf=sc.nextLine();

                if (cpf.isBlank()) {
                    throw new IllegalArgumentException("Erro! CPF está vazio.");
                }
                if (!soTemNumeros(cpf)) {
                    throw new IllegalArgumentException("Erro! CPF só deve conter números.");
                }
                if (cpf.length()!=11) {
                    throw new IllegalArgumentException("Erro! CPF deve conter 11 dígitos.");
                }
                cpfvalido=true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }while(!cpfvalido);

        Familia familia=buscarCpf(cpf);

        if (familia==null) {
            System.out.println("CPF não encontrado!");
        }else if(!familia.isAtiva()){
            System.out.println("Esta família está desligada e não pode ser editada.");
        }else{
            System.out.println("\t=> Dados da Família <=");
            familia.exibirFamilia();

            String opcao;
            do{
                System.out.println("\nO que deseja editar?");
                System.out.println("\t1 - Nome do responsável");
                System.out.println("\t2 - Número de residentes");
                System.out.println("\t3 - Renda mensal");
                System.out.println("\t0 - Voltar");
                System.out.print("-> ");
                opcao=sc.nextLine();

                switch (opcao) {
                    case "1":
                        String nome="";
                        boolean nomevalido=false;

                        do{
                            try{
                                System.out.print("Novo nome do Responsável: ");
                                nome=sc.nextLine();

                                if (nome.isBlank()) {
                                    throw new IllegalArgumentException("Erro! Nome está vazio.");
                                }
                                if (soTemLetras(nome)) {
                                    throw new IllegalArgumentException("Erro! Nome só deve conter letras.");
                                }
                                nomevalido=true;
                            }catch(IllegalArgumentException e){
                                System.out.println(e.getMessage());
                            }
                        }while(!nomevalido);
                        familia.setNome(nome);
                        System.out.println("\t=> Nome atualizado <=");
                        break;
                    case "2":
                        int numeroPessoas=0;
                        boolean numeroPessoasvalido=false;

                        do{
                            try {
                                System.out.print("Novo número de residentes: ");
                                numeroPessoas=Integer.parseInt(sc.nextLine());

                                if (numeroPessoas<=0) {
                                    throw new IllegalArgumentException("Erro! Residentes não podem ser negativos ou zerados.");
                                }
                                numeroPessoasvalido=true;
                            }catch(NumberFormatException e){
                                System.out.println("Erro! Digite apenas números.");
                            }catch(IllegalArgumentException e){
                                System.out.println(e.getMessage());
                            }
                        }while(!numeroPessoasvalido);

                        if (familia.getRendaMensal()/numeroPessoas>810.50) {
                            System.out.println("Alteração não realizada! | Renda por pessoa acima de meio salário.");
                        }else{
                            familia.setNumeroPessoas(numeroPessoas);
                            System.out.println("\t=> Residentes atualizados <=");
                        }
                        break;
                    case "3":
                        double rendaMensal=0.0;
                        boolean rendaMensalvalido=false;

                        do{
                            try{
                                System.out.print("Nova renda mensal: ");
                                rendaMensal=Double.parseDouble(sc.nextLine());

                                if (rendaMensal<=0) {
                                    throw new IllegalArgumentException("Erro! Renda não pode ser negativa ou zerada.");
                                }
                                rendaMensalvalido=true;
                            }catch(NumberFormatException e){
                                System.out.println("Erro! Digite apenas números.");
                            }catch(IllegalArgumentException e){
                                System.out.println(e.getMessage());
                            }
                        }while(!rendaMensalvalido);

                        if (rendaMensal/familia.getNumeroPessoas()>810.50) {
                            System.out.println("Alteração não realizada! | Renda por pessoa acima de meio salário.");
                        }else{
                            familia.setRendaMensal(rendaMensal);
                            System.out.println("\t=> Renda atualizada <=");
                        }
                        break;
                    case "0":
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            }while(!opcao.equals("0"));
        }
        limparBuffer();
        limparTerminal();
    }
    public static void registrarDoacao(){
        System.out.println("\t====== REGISTRAR DOAÇÃO ======\n");

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado. Cadastre um produto antes.");
            limparBuffer();
            return;
        }

        String nome="";
        boolean nomevalido=false;

        do{
            try{
                System.out.print("Nome do Produto: ");
                nome=sc.nextLine();

                if (nome.isBlank()) {
                    throw new IllegalArgumentException("Erro! Nome está vazio.");
                }
                if (soTemLetras(nome)) {
                    throw new IllegalArgumentException("Erro! Nome não pode conter números.");
                }
                nomevalido=true;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }while(!nomevalido);

        Produto produto=buscarProduto(nome);

        if (produto==null) {
            System.out.println("Produto não encontrado! Produto deve ser cadastrado.");
        }else{
            System.out.println("\t=> Dados do Produto <=");
            produto.exibirProduto();

            int quantidade=0;
            boolean quantidadevalida=false;

            do{
                try{
                    System.out.print("\nQuantidade para Doação: ");
                    quantidade=Integer.parseInt(sc.nextLine());

                    if(quantidade<=0){
                        throw new IllegalArgumentException("Erro! Quantidade deve ser maior que zero.");
                    }
                    quantidadevalida=true;
                }catch(NumberFormatException e){
                    System.out.println("Erro! Digite apenas números.");
                }catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }while(!quantidadevalida);

            Doador doador=null;
            String opcao="";

            System.out.println("\nO doador deseja ser identificado?");
            System.out.println("[1] Sim | [2] Não");

            do{
                System.out.print("-> ");
                opcao=sc.nextLine();

                if (!opcao.equals("1")&&!opcao.equals("2")) {
                    System.out.println("Erro! Digite 1 ou 2.");
                }
            }while(!opcao.equals("1")&&!opcao.equals("2"));

            if (opcao.equals("1")) {
                String nomeDoador="";
                boolean nomeDoadorvalido=false;

                do{
                    try{
                        System.out.print("Nome do Doador: ");
                        nomeDoador=sc.nextLine();

                        if (nomeDoador.isBlank()) {
                            throw new IllegalArgumentException("Erro! Nome está vazio.");
                        }
                        if (soTemLetras(nomeDoador)) {
                            throw new IllegalArgumentException("Erro! Nome só deve conter letras.");
                        }
                        nomeDoadorvalido=true;
                    }catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }while(!nomeDoadorvalido);

                String contato="";
                boolean contatovalido=false;

                do{
                    try{
                        System.out.print("Contato: ");
                        contato=sc.nextLine();

                        if (contato.isBlank()) {
                            throw new IllegalArgumentException("Erro! Contato está vazio.");
                        }
                        contatovalido=true;
                    }catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }while(!contatovalido);

                doador=new Doador(nomeDoador, contato);
            }

            produto.setQuantidade(produto.getQuantidade()+quantidade);
            doacoes.add(new Doacao(doador, produto, quantidade));
            System.out.println("\t=> Doação Registrada <=");
        }
        limparBuffer();
        limparTerminal();
    }
    public static void listarDoacao(){
        System.out.println("\t====== LISTA ======");

        if (doacoes.isEmpty()) {
            System.out.println("\t=> Nenhuma Doação registrada.");
            limparBuffer();
            limparTerminal();
            return;
        }
        for (Doacao doacao : doacoes) {
            System.out.println("\nData: "+doacao.getDataFormatada());
            System.out.println("Doador: "+doacao.getNomeDoador());
            System.out.println("Item: "+doacao.getProduto().getNome());
            System.out.println("Quantidade Doada: "+doacao.getQuantidade());
            System.out.println("Categoria: "+doacao.getProduto().getCategoria());
        }
        limparBuffer();
        limparTerminal();
    }
    public static boolean jaRecebeuCesta(Familia familia){
        for (Entrega entrega : entregas) {
            if (entrega.getFamilia().getCpf().equals(familia.getCpf())) {
                return true;
            }
        }
        return false;
    }
    public static void registrarEntrega(){
        System.out.println("\t====== REGISTRAR ENTREGA ======");

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado. Cadastre um produto antes.");
            limparBuffer();
            limparTerminal();
            return;
        }

        String cpf="";
        boolean cpfvalido=false;

        do{
            try {
                System.out.print("CPF do Responsável: ");
                cpf=sc.nextLine();

                if (cpf.isBlank()) {
                    throw new IllegalArgumentException("Erro! CPF está vazio.");
                }
                if (!soTemNumeros(cpf)) {
                    throw new IllegalArgumentException("Erro! CPF só deve conter números.");
                }
                if (cpf.length()!=11) {
                    throw new IllegalArgumentException("Erro! CPF deve conter 11 dígitos.");
                }
                cpfvalido=true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }while(!cpfvalido);

        Familia familia=buscarCpf(cpf);

        if (familia==null) {
            System.out.println("CPF não encontrado!");
        }else if(!familia.isAtiva()){
            System.out.println("Esta família está desligada e não pode receber cestas.");
        }else if(jaRecebeuCesta(familia)){
            System.out.println("Esta família já recebeu a cesta!");
        }else{
            System.out.println("\t=> Dados da Família <=");
            familia.exibirFamilia();

            int itensEntregues=0;
            String opcao="";

            do{
                System.out.println("\n\t=> Adicionar Produtos <=\n");

                String nomeProduto="";
                boolean nomeProdutovalido=false;

                do{
                    try{
                        System.out.print("Nome do Produto: ");
                        nomeProduto=sc.nextLine();

                        if (nomeProduto.isBlank()) {
                            throw new IllegalArgumentException("Erro! Nome está vazio.");
                        }
                        if (soTemLetras(nomeProduto)) {
                            throw new IllegalArgumentException("Erro! Nome não pode conter números.");
                        }
                        nomeProdutovalido=true;
                    }catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }while(!nomeProdutovalido);

                Produto produto=buscarProduto(nomeProduto);

                if (produto==null) {
                    System.out.println("Produto não encontrado! Produto deve ser cadastrado.");
                }else if(produto.getQuantidade()==0){
                    System.out.println("Produto sem estoque!");
                }else{
                    System.out.println("\t=> Dados do Produto <=");
                    produto.exibirProduto();

                    int quantidade=0;
                    boolean quantidadevalida=false;

                    do{
                        try{
                            System.out.print("\nQuantidade para Entrega: ");
                            quantidade=Integer.parseInt(sc.nextLine());

                            if (quantidade<=0) {
                                throw new IllegalArgumentException("Erro! Quantidade deve ser maior que zero.");
                            }
                            if (quantidade>produto.getQuantidade()) {
                                throw new IllegalArgumentException("Erro! Estoque insuficiente. Disponível: "+produto.getQuantidade());
                            }
                            quantidadevalida=true;
                        }catch(NumberFormatException e){
                            System.out.println("Erro! Digite apenas números.");
                        }catch(IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }
                    }while(!quantidadevalida);

                    produto.setQuantidade(produto.getQuantidade()-quantidade);
                    entregas.add(new Entrega(familia, produto, quantidade));
                    itensEntregues++;
                    System.out.println("\t=> Item adicionado à cesta <=");
                }

                System.out.println("\nAdicionar outro produto?\n[1] Sim | [2] Não");
                do{
                    System.out.print("-> ");
                    opcao=sc.nextLine();

                    if (!opcao.equals("1") && !opcao.equals("2")) {
                        System.out.println("Erro! Digite 1 ou 2.");
                    }
                }while(!opcao.equals("1") && !opcao.equals("2"));

            }while(opcao.equals("1"));

            if (itensEntregues>0) {
                System.out.println("\t=> Entrega Registrada <=");
            }else{
                System.out.println("\t=> Nenhum item registrado. Entrega cancelada. <=");
            }
        }
        limparBuffer();
        limparTerminal();
    }
    public static void listarEntregas(){
        System.out.println("\t====== LISTA DE ENTREGAS ======");

        if (entregas.isEmpty()) {
            System.out.println("\n\t=> Nenhuma Entrega registrada.");
            limparBuffer();
            limparTerminal();
            return;
        }
        for (Familia familia : familias) {
            boolean lista=false;

            for (Entrega entrega : entregas) {
                if (entrega.getFamilia().getCpf().equals(familia.getCpf())) {
                    if (!lista) {
                        System.out.println("\nData: "+entrega.getDataFormatada());
                        System.out.println("Responsável: "+familia.getNome());
                        System.out.println("CPF: "+familia.getCpf());
                        System.out.println("Itens:");
                        lista=true;
                    }
                    System.out.println("\t- "+entrega.getProduto().getNome()+
                    " ("+entrega.getProduto().getCategoria()+"): "+entrega.getQuantidade());
                }
            }
        }
        limparBuffer();
        limparTerminal();
    }
}