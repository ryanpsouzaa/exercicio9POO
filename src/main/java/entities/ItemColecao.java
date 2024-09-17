package entities;

import java.time.LocalDate;
import java.util.Objects;

public class ItemColecao {
    private TipoItem tipo;
    private String id;
    private String nomeItem;
    private Condicao condicao;
    private LocalDate dataAquisicao;

    public ItemColecao(){
        this(null, "", "", null, null);
    }

    public ItemColecao(TipoItem tipo, String id, String nomeItem, Condicao condicao, LocalDate dataAquisicao) {
        this.tipo = tipo;
        this.id = id;
        this.nomeItem = nomeItem;
        this.condicao = condicao;
        this.dataAquisicao = dataAquisicao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Condicao getCondicao() {
        return condicao;
    }

    public void setCondicao(Condicao condicao) {
        this.condicao = condicao;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String getNomeItem(){
        return this.nomeItem;
    }

    public void setNomeItem(String novoNome){
        this.nomeItem = novoNome;
    }

    public TipoItem getTipo(){
        return this.tipo;
    }

    public void setTipo(TipoItem tipo){
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemColecao that = (ItemColecao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Nome do item: " + getNomeItem() + ", Condição: " + getCondicao() +
                ", Data da aquisição: " + getDataAquisicao();
    }
}
