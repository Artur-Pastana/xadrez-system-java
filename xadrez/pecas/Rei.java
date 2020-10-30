package secao16.xadrez.pecas;

import secao16.boardgame.Tabuleiro;
import secao16.xadrez.Cor;
import secao16.xadrez.PecaXadrez;

public class Rei extends PecaXadrez {

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		//TODO Auto-generated constructor stub
    }
    
    @Override
    public String toString() {
        return "K";
    }
    
}
