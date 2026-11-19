package Classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Entrega {
    private Familia familia;
    private Produto produto;
    private int quantidade;
    private LocalDate data;

    public Entrega(Familia familia, Produto produto, int quantidade){
        this.familia = familia;
        this.produto = produto;
        this.quantidade = quantidade;
        this.data = LocalDate.now();
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
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
}