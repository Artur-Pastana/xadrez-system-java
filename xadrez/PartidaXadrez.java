package secao16.xadrez;

import secao16.boardgame.Peca;
import secao16.boardgame.Posicao;
import secao16.boardgame.Tabuleiro;
import secao16.xadrez.pecas.Rei;
import secao16.xadrez.pecas.Torre;

public class PartidaXadrez {
    private Tabuleiro tabuleiro;

    public PartidaXadrez() {
        this.tabuleiro = new Tabuleiro(8, 8);
        iniciarSetup();
    }

    public PecaXadrez[][] getPecas() {
        PecaXadrez[][] matriz = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];

        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for (int j = 0; j < tabuleiro.getColunas(); j++) {
                matriz[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
            }
        }

        return matriz;
    }

    public PecaXadrez executarMovimentoXadrez(XadrezPosicao posicaoOrigem, XadrezPosicao posicaoDestino) {
        Posicao origem = posicaoOrigem.toPosicao();
        Posicao destino = posicaoDestino.toPosicao();

        validarPosicaoOrigem(origem);
        Peca pecaCapturada = fazerMovimento(origem, destino);
        return (PecaXadrez) pecaCapturada;
    }

    private void validarPosicaoOrigem(Posicao posicao) {
        if (!tabuleiro.existeUmaPeca(posicao)) {
            throw new XadrezException("Não existe peça na posição de origem");
        }
    }

    private Peca fazerMovimento(Posicao origem, Posicao destino) {
        Peca p = tabuleiro.removerPeca(origem);
        Peca pecaCapturada = tabuleiro.removerPeca(destino);

        tabuleiro.colocarPeca(p, destino);
        return pecaCapturada;
    }

    private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca) {

        tabuleiro.colocarPeca(peca, new XadrezPosicao(coluna, linha).toPosicao());
    }

    private void iniciarSetup() {
        colocarNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

        colocarNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
        /*
         * tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(2, 1));//
         * inserindo uma peca usando posica // de matriz tabuleiro.colocarPeca(new
         * Rei(tabuleiro, Cor.PRETO), new Posicao(0, 4));
         * 
         * colocarNovaPeca('e', 2, new Rei(tabuleiro, Cor.BRANCO)); colocarNovaPeca('b',
         * 5, new Torre(tabuleiro, Cor.BRANCO));// inserindo uma peça usando posicao do
         * tabuleiro
         */
    }
}
