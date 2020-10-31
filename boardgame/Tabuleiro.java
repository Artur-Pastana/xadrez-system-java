package secao16.boardgame;

import secao16.xadrez.PecaXadrez;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas) {
        if (linhas < 1 || colunas < 1) {
            throw new TabuleiroException(
                    "Erro ao criar Tabuleiro: é necessario que haja pelo menos 1 linha e 1 coluna");
        }

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
    // retirando os set de linhas e colunas, com intuito da programação defensiva
    /*
     * public void setColunas(int colunas) { this.colunas = colunas; } public void
     * setLinhas(int linhas) { this.linhas = linhas; }
     */

    public Peca peca(int linha, int coluna) {
        if (!posicaoExiste(linha, coluna)) {
            throw new TabuleiroException("Posição não existe no Tabuleiro");
        }
        return pecas[linha][coluna];
    }

    // metodo para retornar uma posicao do tabuleiro
    public Peca peca(Posicao posicao) {
        if (!posicaoExiste(posicao)) {
            throw new TabuleiroException("Posição não existe no Tabuleiro");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void colocarPeca(Peca peca, Posicao posicao) {
        if (existeUmaPeca(posicao)) {
            throw new TabuleiroException("já existe uma peça na posição " + posicao);
        }
        this.pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    // metodo para remover uma dada posicao do tabuleiro
    public Peca removerPeca(Posicao posicao) {
        if (!posicaoExiste(posicao)) {//verifica se essa peça existe
            throw new TabuleiroException("Posição não existe no tabuleiro");
        }
        if (peca(posicao) == null) {
            return null;
        }

        Peca aux = peca(posicao);
        aux.posicao = null;
        pecas[posicao.getLinha()][posicao.getColuna()] = null;
        return aux;
    }

    private boolean posicaoExiste(int linha, int coluna) {
        return linha >= 0 && linha < this.linhas && coluna >= 0 && coluna < this.colunas;
    }

    public boolean posicaoExiste(Posicao posicao) {
        return posicaoExiste(posicao.getLinha(), posicao.getColuna());
    }

    public boolean existeUmaPeca(Posicao posicao) {
        if (!posicaoExiste(posicao)) {
            throw new TabuleiroException("Posição não existe no Tabuleiro");
        }
        return peca(posicao) != null;
    }

}
