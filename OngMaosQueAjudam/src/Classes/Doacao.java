package Classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Doacao {
    private Doador doador;
    private Produto produto;
    private int quantidade;
    private LocalDate data;

    public Doacao(Doador doador, Produto produto, int quantidade){
        this.doador = doador;
        this.produto = produto;
        this.quantidade = quantidade;
        this.data = LocalDate.now();
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDataFormatada() {
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getNomeDoador() {
        if (doador==null) {
            return "Anônimo";
        } else {
            return doador.getNome();
        }
    }
}
