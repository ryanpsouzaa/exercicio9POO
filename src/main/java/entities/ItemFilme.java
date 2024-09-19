package entities;

import java.time.LocalDate;

public class ItemFilme extends ItemColecao{
    private String diretor;
    private GeneroFilme generoFilme;
    private FaixaEtaria faixaEtaria;

    public ItemFilme(TipoItem tipo, String id, String nomeItem, Condicao condicao,
                     LocalDate dataAquisicao, String diretor, GeneroFilme generoFilme,
                     LocalDate dataLancamento, FaixaEtaria faixaEtaria) {
        super(tipo, id, nomeItem, condicao, dataAquisicao, dataLancamento);
        this.diretor = diretor;
        this.generoFilme = generoFilme;
        this.faixaEtaria = faixaEtaria;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public GeneroFilme getGeneroFilme() {
        return generoFilme;
    }

    public void setGeneroFilme(GeneroFilme generoFilme) {
        this.generoFilme = generoFilme;
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
        return "\n" +
                "Informações sobre o filme:\n" +
                "Data de lançamento: " + getDataLancamento() + "\n" +
                "Diretor: " + getDiretor() + "\n" +
                "Gênero: " + getGeneroFilme() + "\n" +
                "Faixa etária: " + getFaixaEtaria();
    }
}
