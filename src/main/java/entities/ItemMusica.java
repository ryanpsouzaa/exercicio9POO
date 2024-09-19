package entities;

import java.time.LocalDate;

public class ItemMusica extends ItemColecao{
    private GeneroMusica generoMusica;

    public ItemMusica(TipoItem tipo, String id, String nomeItem,
                      Condicao condicao, LocalDate dataAquisicao,
                      LocalDate dataLancamento, GeneroMusica generoMusica) {
        super(tipo, id, nomeItem, condicao, dataAquisicao, dataLancamento);
        this.generoMusica = generoMusica;
    }

    public GeneroMusica getGeneroMusica() {
        return generoMusica;
    }

    public void setGeneroMusica(GeneroMusica generoMusica) {
        this.generoMusica = generoMusica;
    }

    @Override
    public String toString(){
        this.toString();
        return "Informações sobre o álbum:\n" +
                "Gênero: " + getGeneroMusica() + "\n" +
                "Data de lançamento: " + getDataLancamento();
    }
}
