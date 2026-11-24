package Classes;

public class Familia {
    private String nome;
    private String cpf;
    private double rendaMensal;
    private int numeroPessoas;
    private boolean ativa;

    public Familia(String nome, String cpf, double rendaMensal, int numeroPessoas, boolean ativa){
        this.nome = nome;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        this.numeroPessoas = numeroPessoas;
        this.ativa = ativa;
    }

    public String getNome() { 
        return nome; 

    }
    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public String getCpf() { 
        return cpf; 

    }
    public void setCpf(String cpf) { 
        this.cpf = cpf; 
    }

    public double getRendaMensal() { 
        return rendaMensal; 

    }
    public void setRendaMensal(double rendaMensal) { 
        this.rendaMensal = rendaMensal; 
    }

    public int getNumeroPessoas() { 
        return numeroPessoas; 

    }
    public void setNumeroPessoas(int numeroPessoas) { 
        this.numeroPessoas = numeroPessoas; 
    }

    public boolean isAtiva() { 
        return ativa; 
    }
    public void setAtiva(boolean ativa) { 
        this.ativa = ativa; 
    }

    public double getRendaPorPessoa() {
        return rendaMensal / numeroPessoas;
    }
    public void exibirFamilia(){
        System.out.println("\nNome Responsável: "+this.nome+
        "\nCPF: "+this.cpf+
        "\nResidentes: "+this.numeroPessoas+
        "\nRenda Mensal: "+getRendaPorPessoa());
        System.out.print("Ativo: ");
        if(ativa==true){
        System.out.println("Sim");
        }else{
            System.out.println("Não");
        }
    }
}