package entities;

import java.time.LocalDate;

public class ItemJogo extends ItemColecao{
    private GeneroJogo generoJogo;
    private String plataforma;
    private FaixaEtaria faixaEtaria;

    public ItemJogo(TipoItem tipo, String id, String nomeItem,
                    Condicao condicao, LocalDate dataAquisicao,
                    GeneroJogo generoJogo, LocalDate dataLancamento, String plataforma,
                    FaixaEtaria faixaEtaria) {
        super(tipo, id, nomeItem, condicao, dataAquisicao, dataLancamento);
        this.generoJogo = generoJogo;
        this.plataforma = plataforma;
        this.faixaEtaria = faixaEtaria;
    }



    public GeneroJogo getGeneroJogo() {
        return generoJogo;
    }

    public void setGeneroJogo(GeneroJogo generoJogo) {
        this.generoJogo = generoJogo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public FaixaEtaria getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(FaixaEtaria faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    @Override
    public String toString(){
        this.toString();
        return "Informações sobre o jogo:\n" +
                "Gênero: " + getGeneroJogo() + "\n" +
                "Plataforma: " + getPlataforma() + "\n" +
                "Data de lançamento: " + getDataLancamento() + "\n" +
                "Faixa etária: " + getFaixaEtaria();
    }

}
