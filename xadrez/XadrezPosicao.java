package secao16.xadrez;

import secao16.boardgame.Posicao;

public class XadrezPosicao {
    private char coluna;
    private int linha;

    public XadrezPosicao(char coluna, int linha){
        if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
            throw new XadrezException("Erro ao instanciar xadrezPosicao: valores validos são de 1 até 8");
        }
        this.coluna = coluna;
        this.linha = linha;
    }

    public char getColuna() {
        return coluna;
    }
    public int getLinha() {
        return linha;
    }

    //matri-linha = 8 - xadrez.linha
    //matriz-coluna = 'a'-'a' -> xadrez.coluna - 'a'

    protected Posicao toPosicao(){
        return new Posicao(8 - linha, coluna - 'a');
    }

    protected static XadrezPosicao fromPosicao(Posicao posicao){
        return new XadrezPosicao((char)('a' - posicao.getColuna()), 8 - posicao.getLinha());
    }

    @Override
    public String toString() {
        return ""+this.coluna + this.linha;
    }
}
