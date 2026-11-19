package Classes;

public class Produto{
    private String nome;
    private String categoria;
    private int quantidade;

    public Produto(String nome, String categoria, int quantidade){
        this.nome=nome;
        this.categoria=categoria;
        this.quantidade=quantidade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void exibirProduto(){
        System.out.println("Nome: "+this.nome+
        "\nCategoria: "+this.categoria+
        "\nQuantidade em estoque: "+this.quantidade); 
    }
}