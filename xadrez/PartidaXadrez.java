package secao16.xadrez;

import java.awt.Color;

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

    private void iniciarSetup() {
        tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(2, 1));
        tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(0, 4));
        tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.BRANCO), new Posicao(7, 4));
    }
}
