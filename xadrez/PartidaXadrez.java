package secao16.xadrez;

import secao16.boardgame.Posicao;
import secao16.boardgame.Tabuleiro;
import secao16.xadrez.pecas.Rei;
import secao16.xadrez.pecas.Torre;

public class PartidaXadrez {
    private Tabuleiro tabuleiro;

    public PartidaXadrez(){
        this.tabuleiro = new Tabuleiro(8, 8);
        iniciarSetup();
    }

    public PecaXadrez[][] getPecas(){
        PecaXadrez[][] matriz = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];

        for(int i = 0; i < tabuleiro.getLinhas(); i++){
            for(int j = 0; j < tabuleiro.getColunas(); j++){
                matriz[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
            }
        }

        return matriz;
    }

    private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca){

        tabuleiro.colocarPeca(peca, new XadrezPosicao(coluna, linha).toPosicao());
    }

    private void iniciarSetup() {
        tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(2, 1));//inserindo uma peca usando posicao de matriz
        tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(0, 4));

        colocarNovaPeca('e', 2, new Rei(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('b', 5, new Torre(tabuleiro, Cor.BRANCO));//inserindo uma peça usando posicao do tabuleiro
    }
}
