import Classes.Metodos;
import java.util.Scanner;

public class App {
    static Scanner sc=new Scanner(System.in);
    Metodos m=new Metodos();
    public static void main(String[] args) throws Exception {
        
        if (!Metodos.Login()) {
            System.out.println("Acesso negado. Programa encerrado.");
            return;
        }
        Metodos.limparBuffer();

        String opcao;
        do {
            Metodos.exibirMenu();
            opcao=sc.nextLine();

            switch (opcao) {
                case "1":
                    Metodos.menuFamilias();
                    break;
                case "2":
                    Metodos.menuProdutos();
                    break;
                case "3":
                    Metodos.menuDoacoes();
                    break;
                case "4":
                    Metodos.menuEntregas();
                    break;
                case "0":
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }while(!opcao.equals("0"));
    }
}