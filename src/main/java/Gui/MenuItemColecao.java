package Gui;

import entities.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MenuItemColecao extends JFrame {
    JLabel fraseInicio;
    JMenuBar barraMenu = new JMenuBar();

    SistemaColecao sistema = new SistemaColecao();

    public MenuItemColecao(){
        setTitle("Sua Coleção");
        setSize(800,600);
        setLocation(150, 150);
        setResizable(false);
        setBackground(Color.lightGray);

        fraseInicio = new JLabel("Sua Coleção", JLabel.CENTER);
        fraseInicio.setForeground(Color.WHITE);
        fraseInicio.setFont(new Font("Serif", Font.BOLD, 24));

        add(fraseInicio);
        add(new JLabel());

        //Novo menu
        JMenu menuCadastrar = new JMenu("Lista Cadastro");
        JMenuItem menuCadastrarItem = new JMenuItem("Cadastrar Item");
        menuCadastrar.add(menuCadastrarItem);

        JMenuItem menuRemoverItem = new JMenuItem("Remover Item");
        menuCadastrar.add(menuRemoverItem);

        //Novo menu
        JMenu menuTiposItens = new JMenu("Lista de tipos");

        JMenuItem menuPesquisaFilme = new JMenuItem("Pesquisar todos os filmes");
        menuTiposItens.add(menuPesquisaFilme);

        JMenuItem menuPesquisaJogo = new JMenuItem("Pesquisar todos os jogos");
        menuTiposItens.add(menuPesquisaJogo);

        JMenuItem menuPesquisaMusica = new JMenuItem("Pesquisar todas as músicas");
        menuTiposItens.add(menuPesquisaMusica);

        JMenuItem menuPesquisaLiteratura = new JMenuItem("Pesquisar todas as obras literárias");
        menuTiposItens.add(menuPesquisaLiteratura);

        JMenuItem menuPesquisaDiversos = new JMenuItem("Pesquisar todos diversos");
        menuTiposItens.add(menuPesquisaDiversos);

        //Novo menu
        JMenu menuItem = new JMenu("Itens");

        JMenuItem menuPesquisaId = new JMenuItem("Pesquisar por id");
        menuItem.add(menuPesquisaId);

        JMenuItem menuPesquisaNomeItem = new JMenuItem("Pesquisar por nome do item");
        menuItem.add(menuPesquisaNomeItem);

        JMenuItem menuJogosFilmes = new JMenuItem("Filmes e jogos");
        JMenuItem menuPesquisaFaixaEtaria = new JMenuItem("Pesquisar faixa etária");
        menuJogosFilmes.add(menuPesquisaFaixaEtaria);
        menuItem.add(menuJogosFilmes);

        JMenuItem menuPesquisaCondicao = new JMenuItem("Pesquisar por condição");
        menuItem.add(menuPesquisaCondicao);

        JMenuItem menuPesquisaDataAquisicao = new JMenuItem("Pesquisar por uma data de aquisição");
        menuItem.add(menuPesquisaDataAquisicao);

        JMenuItem menuPesquisaEntreDatasAquisicao = new JMenuItem("Pesquisar itens entre duas datas de aquisição");
        menuItem.add(menuPesquisaEntreDatasAquisicao);

        JMenuItem menuPesquisaDataLancamento = new JMenuItem("Pesquisar por uma data de lançamento");
        menuItem.add(menuPesquisaDataLancamento);

        JMenuItem menuPesquisarEntreDatasLancamento = new JMenuItem("Pesquisar itens entre duas datas de lançamento");
        menuItem.add(menuPesquisarEntreDatasLancamento);

        //Adicionando ações
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        menuCadastrarItem.addActionListener(
                (ae) -> {
                    TipoItem [] tipoItens = {TipoItem.FILME, TipoItem.LIVRO, TipoItem.MUSICA, TipoItem.JOGO_ELETRONICO,
                    TipoItem.DIVERSOS};

                    TipoItem opcaoTipoItem = (TipoItem) JOptionPane.showInputDialog(this,
                            "Selecione o tipo do item que deseja cadastrar",
                            "Tipo de item",
                            JOptionPane.QUESTION_MESSAGE, null, tipoItens,
                            tipoItens[0]);
                    //TODO

                    String id = JOptionPane.showInputDialog(this,
                            "Digite o ID do item: ");

                    String nomeItem = JOptionPane.showInputDialog(this,
                            "Digite a descrição/nome do item: ");

                    Condicao[] condicao = {Condicao.LACRADO, Condicao.USADO, Condicao.DANIFICADO};
                    Condicao opcaoCondicao = (Condicao) JOptionPane.showInputDialog(this,
                            "Selecione a CONDIÇÃO/ESTADO do item: ",
                            "Condição",
                            JOptionPane.QUESTION_MESSAGE, null, condicao,
                            condicao[0]);

                    LocalDate dataAquisicao = LocalDate.parse(JOptionPane.showInputDialog(this,
                            "Digite a data de aquisição do item: (dd/mm/aaaa"), fmt1);


                    if(opcaoTipoItem == TipoItem.FILME){
                        String diretor = JOptionPane.showInputDialog(this, "Insira o diretor do filme: ");

                        GeneroFilme[] generoFilme = {GeneroFilme.FICÇÃO, GeneroFilme.INFANTIL, GeneroFilme.AÇÃO,
                        GeneroFilme.ROMANCE, GeneroFilme.TERROR};

                        GeneroFilme opcaoGeneroFilme = (GeneroFilme) JOptionPane.showInputDialog(this,
                                "Selecione o GÊNERO do filme: ",
                                "Gêneros",
                                JOptionPane.QUESTION_MESSAGE, null, generoFilme,
                                generoFilme[0]);

                        String[] faixaEtaria = {"Livre", "+10 Anos", "+12 Anos","+14 anos",
                                "+16 Anos", "+18 Anos"};

                        String opcaoFaixaEtaria = (String) JOptionPane.showInputDialog(this,
                                "Selecione a FAIXA ETÁRIA do filme: ",
                                "Faixa etária",
                                JOptionPane.QUESTION_MESSAGE, null, faixaEtaria,
                                faixaEtaria[0]);
                        FaixaEtaria opcaoFaixaEtariaProcessada;
                        if(opcaoFaixaEtaria == "Livre"){
                            opcaoFaixaEtariaProcessada = FaixaEtaria.LIVRE;
                        } else if(opcaoFaixaEtaria == "+10 Anos"){
                            opcaoFaixaEtariaProcessada = FaixaEtaria.DEZ_ANOS;
                        } else if(opcaoFaixaEtaria == "+12 Anos"){
                            opcaoFaixaEtariaProcessada = FaixaEtaria.DOZE_ANOS;
                        } else if(opcaoFaixaEtaria == "+14 Anos"){
                            opcaoFaixaEtariaProcessada = FaixaEtaria.QUATORZE_ANOS;
                        } else if(opcaoFaixaEtaria == "+16 Anos"){
                            opcaoFaixaEtariaProcessada = FaixaEtaria.DEZESSEIS_ANOS;
                        } else {
                            opcaoFaixaEtariaProcessada = FaixaEtaria.DEZOITO_ANOS;
                        }

                        LocalDate dataLancamento = LocalDate.parse(JOptionPane.showInputDialog(this,
                                "Digite a data de lançamento do filme: (dd/mm/aaaa) "), fmt1);

                        ItemColecao itemElemento = new ItemFilme(opcaoTipoItem, id, nomeItem,
                                opcaoCondicao, dataAquisicao, diretor, opcaoGeneroFilme, dataLancamento,
                                opcaoFaixaEtariaProcessada);

                    } else if(opcaoTipoItem == TipoItem.JOGO_ELETRONICO){
                        GeneroJogo[] generoJogo = {GeneroJogo.FPS, GeneroJogo.AÇÃO, GeneroJogo.TERROR, GeneroJogo.AVENTURA,
                        GeneroJogo.CASUAL};

                        GeneroJogo opcaoGeneroJogo = (GeneroJogo) JOptionPane.showInputDialog(this,
                                "Selecione o GÊNERO do jogo: ",
                                "Gênero",
                                JOptionPane.QUESTION_MESSAGE, null, generoJogo,
                                generoJogo[0]);

                        String plataforma = JOptionPane.showInputDialog(this,
                                "Digite a plataforma do jogo: ");

                        LocalDate dataLancamento = LocalDate.parse(JOptionPane.showInputDialog(this,
                                "Digite a data de lançamento: (dd/mm/aaaa)"), fmt1);

                        String[] faixaEtaria = {"Livre", "+10 Anos", "+12 Anos","+14 anos",
                                "+16 Anos", "+18 Anos"};

                        String opcaoFaixaEtaria = (String) JOptionPane.showInputDialog(this,
                                "Selecione a FAIXA ETÁRIA do filme: ",
                                "Faixa etária",
                                JOptionPane.QUESTION_MESSAGE, null, faixaEtaria,
                                faixaEtaria[0]);
                        FaixaEtaria opcaoFaixaEtariaProcessada;
                        if(opcaoFaixaEtaria == "Livre"){
                            opcaoFaixaEtariaProcessada = FaixaEtaria.LIVRE;
                        } else if(opcaoFaixaEtaria == "+10 Anos"){
                            opcaoFaixaEtariaProcessada = FaixaEtaria.DEZ_ANOS;
                        } else if(opcaoFaixaEtaria == "+12 Anos"){
                            opcaoFaixaEtariaProcessada = FaixaEtaria.DOZE_ANOS;
                        } else if(opcaoFaixaEtaria == "+14 Anos"){
                            opcaoFaixaEtariaProcessada = FaixaEtaria.QUATORZE_ANOS;
                        } else if(opcaoFaixaEtaria == "+16 Anos"){
                            opcaoFaixaEtariaProcessada = FaixaEtaria.DEZESSEIS_ANOS;
                        } else {
                            opcaoFaixaEtariaProcessada = FaixaEtaria.DEZOITO_ANOS;
                        }
                    } else if(opcaoTipoItem == TipoItem.LIVRO){
                        String autor = JOptionPane.showInputDialog(this,
                                "Digite o autor do livro: ");

                        GeneroLiteratura[] generoLiteratura = {GeneroLiteratura.FICÇÃO,
                        GeneroLiteratura.ROMANCE, GeneroLiteratura.AUTOAJUDA, GeneroLiteratura.POLÍTICA};

                        GeneroLiteratura opcaoGeneroLiteratura = (GeneroLiteratura) JOptionPane.showInputDialog(this,
                                "Selecione o GÊNERO da obra: ",
                                "Gênero",
                                JOptionPane.QUESTION_MESSAGE, null, generoLiteratura,
                                generoLiteratura[0]);

                        String editora = JOptionPane.showInputDialog(this,
                                "Digite a editora da obra");
                    } else if(opcaoTipoItem == TipoItem.MUSICA){
                        GeneroMusica[] generoMusica = {GeneroMusica.RAP, GeneroMusica.POP,
                        GeneroMusica.SERTANEJO, GeneroMusica.ROCK};

                        GeneroMusica opcaoGeneroMusica = (GeneroMusica) JOptionPane.showInputDialog(this,
                                "Selecione o GÊNERO do álbum: ",
                                "Gênero",
                                JOptionPane.QUESTION_MESSAGE, null, generoMusica,
                                generoMusica[0]);

                        LocalDate dataLancamento = LocalDate.parse(JOptionPane.showInputDialog(this,
                                "Digite a data de lançamento: (dd/mm/aaaa"), fmt1);
                    } else {
                        ItemColecao itemDiverso = new ItemColecao(opcaoTipoItem, )
                    }

                }
        );

        barraMenu.add(menuCadastrar);
        barraMenu.add(menuItem);
        barraMenu.add(menuTiposItens);

        setJMenuBar(barraMenu);








    }
    public static void main(String[]args){
        JFrame janela = new MenuItemColecao();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
