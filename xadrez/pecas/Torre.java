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
    /*a torre pode se mover na vertical quantas casa quiser e na horizontal quantas casas quiser
    Enquanto houver casa livre
    ou enquanto houver uma peça adversária, no caso ela pode capturar a peça adversária
    */

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        return mat;
    }

    
}
