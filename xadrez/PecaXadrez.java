package secao16.xadrez;

import secao16.boardgame.Peca;
import secao16.boardgame.Posicao;
import secao16.boardgame.Tabuleiro;

public abstract class PecaXadrez extends Peca {
    
    private Cor cor;
    private int moviCont;

    public PecaXadrez(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro);
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }
    public int getMoviCont() {
        return moviCont;
    }

    public void incrementarMoviCont() {
        this.moviCont++;
    }

    public void decrementarMoviCont() {
        this.moviCont--;
    }

    public XadrezPosicao getXadrezPosicao(){
        return XadrezPosicao.fromPosicao(posicao);
    }

    protected boolean existePecaOponente(Posicao posicao){
        PecaXadrez p = (PecaXadrez) getTabuleiro().peca(posicao);
        return p != null && p.getCor() != this.cor;
    }
}
