package entities;

import java.time.LocalDate;

public class ItemLiteratura extends ItemColecao{
    private String autor;
    private GeneroLiteratura generoLiteratura;
    private String editora;

    public ItemLiteratura(TipoItem tipo, String id, String nomeItem, Condicao condicao,
                          LocalDate dataAquisicao, String autor, GeneroLiteratura genero,
                          String editora) {
        super(tipo, id, nomeItem, condicao, dataAquisicao, null);
        this.autor = autor;
        this.generoLiteratura = genero;
        this.editora = editora;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public GeneroLiteratura getGeneroLiteratura() {
        return generoLiteratura;
    }

    public void setGeneroLiteratura(GeneroLiteratura genero) {
        this.generoLiteratura = genero;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public String toString(){
        this.toString();
        return "Informações sobre a obra:\n" +
                "Gênero: " + getGeneroLiteratura() + "\n" +
                "Autor: " + getAutor() + "\n" +
                "Editora: " + getEditora();
    }

}
