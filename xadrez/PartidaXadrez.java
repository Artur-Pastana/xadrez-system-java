package secao16.xadrez;

import secao16.boardgame.Peca;
import secao16.boardgame.Posicao;
import secao16.boardgame.Tabuleiro;
import secao16.xadrez.pecas.Rei;
import secao16.xadrez.pecas.Torre;

public class PartidaXadrez {

    private int turno;
    private Cor jogadorAtual;
    private Tabuleiro tabuleiro;

    public int getTurno() {
        return turno;
    }
    public Cor getJogadorAtual() {
        return jogadorAtual;
    }

    public PartidaXadrez() {
        this.tabuleiro = new Tabuleiro(8, 8);
        this.turno = 1;
        this.jogadorAtual = Cor.BRANCO;
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

    public boolean[][] possiveisMovimentos(XadrezPosicao origemPosicao) {
        Posicao posicao = origemPosicao.toPosicao();
        validarPosicaoOrigem(posicao);

        return tabuleiro.peca(posicao).movimentosPossiveis();
    }

    public PecaXadrez executarMovimentoXadrez(XadrezPosicao posicaoOrigem, XadrezPosicao posicaoDestino) {
        Posicao origem = posicaoOrigem.toPosicao();
        Posicao destino = posicaoDestino.toPosicao();
        validarPosicaoOrigem(origem);
        validarPosicaoDestino(origem, destino);
        
        Peca pecaCapturada = fazerMovimento(origem, destino);
        proximoturno();
        return (PecaXadrez) pecaCapturada;
    }

    private void validarPosicaoOrigem(Posicao posicao) {
        if (!tabuleiro.existeUmaPeca(posicao)) {
            throw new XadrezException("Não existe peça na posição de origem");
        }
        if (this.jogadorAtual != ((PecaXadrez)tabuleiro.peca(posicao)).getCor()) {
           throw new XadrezException("A peça escolhida não é sua"); 
        }
        if (!tabuleiro.peca(posicao).existeAlgumMovimentoPossivel()) {
            throw new XadrezException("não existe movimentos para a peça escolhida!");
        }
    }
    
    private void validarPosicaoDestino(Posicao origem, Posicao destino) {
        if (!tabuleiro.peca(origem).moviPossivel(destino)) {
            throw new XadrezException("a peça escolhida não pode mover-se pra posição de destino");
        }
    }

    private void proximoturno() {
        this.turno++;
        this.jogadorAtual = (this.jogadorAtual == Cor.BRANCO ? Cor.PRETO: Cor.BRANCO);
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
