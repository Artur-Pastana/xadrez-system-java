package secao16.xadrez.pecas;

import secao16.boardgame.Tabuleiro;
import secao16.xadrez.Cor;
import secao16.xadrez.PecaXadrez;

public class Torre extends PecaXadrez {

    public Torre(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }

    @Override
    public String toString() {
        return "R";
    }


    
}
