package secao16.xadrez;

import secao16.boardgame.Peca;
import secao16.boardgame.Posicao;
import secao16.boardgame.Tabuleiro;

public abstract class PecaXadrez extends Peca {
    
    private Cor cor;

    public PecaXadrez(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro);
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }

    protected boolean existePecaOponente(Posicao posicao){
        PecaXadrez p = (PecaXadrez) getTabuleiro().peca(posicao);
        return p != null && p.getCor() != this.cor;
    }

}
