package entities;

import exception.ItemJaExistenteException;
import exception.ItemNuloException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaColecao {
    private Map<String, ItemColecao> sistema;

    public SistemaColecao(){
        this.sistema = new HashMap<>();
    }

    public void cadastrarItem(ItemColecao itemColecao) throws ItemJaExistenteException {
        if(!verificaExistenciaItem(itemColecao.getId())){
            this.sistema.put(itemColecao.getId(), itemColecao);
        } else {
            throw new ItemJaExistenteException("Esse Item já está cadastrado");
        }

    }

    public void removerItem(String id) throws ItemNuloException {
        if(this.sistema.containsKey(id)){
            this.sistema.remove(id, this.sistema.get(id));
        } else {
            throw new ItemNuloException("Item Inexistente");
        }

    }

    public boolean verificaExistenciaItem(String id){
        if(sistema.containsKey(id) && sistema.get(id) != null){
            return true;

        } else {
            return false;
        }
    }

    public ItemColecao pesquisaItemPorId(String id) throws ItemNuloException {
        if(verificaExistenciaItem(id)){
            return this.sistema.get(id);
        } else{
            throw new ItemNuloException("Item Inexistente");
        }
    }

    public List<ItemFilme> pesquisaItensFilme(){
        List<ItemFilme> listaFilmes = new ArrayList<>();

        for(ItemColecao item : this.sistema.values()){
            if(item.getTipo().equals(TipoItem.FILME)){
                listaFilmes.add((ItemFilme) item);
            }
        }
        return listaFilmes;
    }

    public List<ItemMusica> pesquisaItensMusica(){
        List<ItemMusica> listaMusicas = new ArrayList<>();

        for(ItemColecao item : this.sistema.values()){
            if(item.getTipo().equals(TipoItem.MUSICA)){
                listaMusicas.add((ItemMusica) item);
            }
        }
        return listaMusicas;
    }

    public List<ItemJogo> pesquisaItensJogo(){
        List<ItemJogo> listaJogos = new ArrayList<>();

        for(ItemColecao item : this.sistema.values()){
            if(item.getTipo().equals(TipoItem.JOGO_ELETRONICO)){
                listaJogos.add((ItemJogo) item);
            }
        }
        return listaJogos;
    }

    public List<ItemLiteratura> pesquisaItensLiteratura(){
        List<ItemLiteratura> listaLiteratura = new ArrayList<>();

        for(ItemColecao item : this.sistema.values()){
            if(item.getTipo().equals(TipoItem.LIVRO)){
                listaLiteratura.add((ItemLiteratura) item);
            }
        }
        return listaLiteratura;
    }

    public List<ItemColecao> pesquisaItensDiversos(){
        List<ItemColecao> listaDiversos = new ArrayList<>();

        for(ItemColecao item : this.sistema.values()){
            if(item.getTipo().equals(TipoItem.DIVERSOS)){
                listaDiversos.add(item);
            }
        }
        return listaDiversos;
    }

    public List<ItemColecao> pesquisaJogoEFilmeFaixaEtaria(FaixaEtaria faixaEtaria){
        List<ItemColecao> listaPesquisada = new ArrayList<>();

        List<ItemJogo> listaJogos = pesquisaItensJogo();
        List<ItemFilme> listaFilmes = pesquisaItensFilme();

        for(ItemJogo item : listaJogos){
            if(item.getFaixaEtaria().equals(faixaEtaria)){
                listaPesquisada.add(item);
            }
        }
        for(ItemFilme item : listaFilmes){
            if(item.getFaixaEtaria().equals(faixaEtaria)){
                listaPesquisada.add(item);
            }
        }
        return listaPesquisada;

    }

    public List<ItemColecao> pesquisaItensPorCondicao(Condicao condicao){
        List<ItemColecao> listaCondicao = new ArrayList<>();

        for(ItemColecao item : this.sistema.values()){
            if(item.getCondicao().equals(condicao)){
                listaCondicao.add(item);
            }
        }
        return listaCondicao;
    }

    public List<ItemColecao> pesquisaItensPorDataAquisicao(LocalDate data){
        List<ItemColecao> listaPesquisada = new ArrayList<>();

        for(ItemColecao item : this.sistema.values()){
            if(item.getDataAquisicao().isEqual(data)){
                listaPesquisada.add(item);
            }
        }
        return listaPesquisada;
    }

    public List<ItemColecao> pesquisaItensEntreDatasAquisicao(LocalDate dataInicio, LocalDate dataFim){
        List<ItemColecao> listaPesquisada = new ArrayList<>();

        for(ItemColecao item : this.sistema.values()){
            LocalDate data = item.getDataAquisicao();
            if((data.isBefore(dataFim) || data.isEqual(dataFim)) && (data.isAfter(dataInicio) || data.isEqual(dataInicio))){
                listaPesquisada.add(item);
            }
        }
        return listaPesquisada;
    }

    public List<ItemColecao> pesquisaItensPorDataLancamento(LocalDate data){
        List<ItemColecao> listaPesquisada = new ArrayList<>();

        for(ItemColecao item : this.sistema.values()){
            if(item.getDataLancamento().isEqual(data)){
                listaPesquisada.add(item);
            }
        }
        return listaPesquisada;
    }

    public List<ItemColecao> pesquisaItensEntreDatasLancamento(LocalDate dataInicio, LocalDate dataFim){
        List<ItemColecao> listaPesquisada = new ArrayList<>();

        for(ItemColecao item : this.sistema.values()){
            LocalDate data = item.getDataLancamento();
            if((data.isBefore(dataFim) || data.isEqual(dataFim)) && (data.isAfter(dataInicio) || data.isEqual(dataInicio))){
                listaPesquisada.add(item);
            }
        }
        return listaPesquisada;
    }

    public ItemColecao pesquisaItemPorNomeItem(String nome) throws ItemNuloException {
        for(ItemColecao item : this.sistema.values()){
            if(item.getNomeItem().equals(nome)){
                return item;
            }
        }
        throw new ItemNuloException("Este item não se encontra cadastrado");
    }


}
