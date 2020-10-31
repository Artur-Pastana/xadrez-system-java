package secao16.aplication;

import java.util.Scanner;

import secao16.boardgame.Posicao;
import secao16.boardgame.Tabuleiro;
import secao16.xadrez.PartidaXadrez;
import secao16.xadrez.PecaXadrez;
import secao16.xadrez.XadrezPosicao;
import secao16.xadrez.pecas.Rei;

public class Programa {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PartidaXadrez partidaXadrez = new PartidaXadrez();
        System.out.println();

        while (true) {
            UI.printTabuleiro(partidaXadrez.getPecas());
            System.out.println();
            System.out.print("origem: ");
            XadrezPosicao origem = UI.lendoPosicaoXadrez(sc);

            System.out.println();
            System.out.print("Destino: ");
            XadrezPosicao destino = UI.lendoPosicaoXadrez(sc);

            PecaXadrez pecaCapturada = partidaXadrez.executarMovimentoXadrez(origem, destino);
            

        }

        

        // System.out.println('c'-'a');

    }
}
