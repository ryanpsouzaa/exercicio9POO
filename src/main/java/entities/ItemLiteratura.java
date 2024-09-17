package entities;

import java.time.LocalDate;

public class ItemLiteratura extends ItemColecao{
    public enum GeneroLiteratura{
        FICCAO_CIENTIFICA, ROMANCE, AUTOAJUDA, POLITICA
    }
    private String autor;
    private GeneroLiteratura genero;
    private String editora;

    public ItemLiteratura(TipoItem tipo, String id, String nomeItem, Condicao condicao, LocalDate dataAquisicao, String autor, GeneroLiteratura genero, String editora) {
        super(tipo, id, nomeItem, condicao, dataAquisicao);
        this.autor = autor;
        this.genero = genero;
        this.editora = editora;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public GeneroLiteratura getGenero() {
        return genero;
    }

    public void setGenero(GeneroLiteratura genero) {
        this.genero = genero;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public String toString(){

    }
}
