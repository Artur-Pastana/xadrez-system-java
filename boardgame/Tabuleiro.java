package secao16.boardgame;

import secao16.xadrez.PecaXadrez;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas){
        this.linhas = linhas;
        this.colunas = colunas;

        pecas = new Peca[linhas][colunas];
    }

    public int getColunas() {
        return colunas;
    }
    public int getLinhas() {
        return linhas;
    }
    public void setColunas(int colunas) {
        this.colunas = colunas;
    }
    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

    public Peca peca(int linha, int coluna) {
        return pecas[linha][coluna];
    }

    //metodo para retornar uma posicao do tabuleiro
    public Peca peca(Posicao posicao){
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void colocarPeca(Peca peca, Posicao posicao) {
        this.pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }
    
}
