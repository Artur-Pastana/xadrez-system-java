package secao16.aplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import secao16.boardgame.Posicao;
import secao16.boardgame.Tabuleiro;
import secao16.xadrez.PartidaXadrez;
import secao16.xadrez.PecaXadrez;
import secao16.xadrez.XadrezException;
import secao16.xadrez.XadrezPosicao;
import secao16.xadrez.pecas.Rei;

public class Programa {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PartidaXadrez partidaXadrez = new PartidaXadrez();
        System.out.println();

        while (true) {

            try {

                UI.clearScreen();
                UI.printTabuleiro(partidaXadrez.getPecas());
                System.out.println();
                System.out.print("origem: ");
                XadrezPosicao origem = UI.lendoPosicaoXadrez(sc);

                System.out.println();
                System.out.print("Destino: ");
                XadrezPosicao destino = UI.lendoPosicaoXadrez(sc);

                PecaXadrez pecaCapturada = partidaXadrez.executarMovimentoXadrez(origem, destino);
            } 
            catch (XadrezException xadrezException) {
                System.out.println(xadrezException.getMessage());
                sc.nextLine();
            }
            catch(InputMismatchException inputMismatchException){
                System.out.println(inputMismatchException.getMessage());
                sc.nextLine();
            }

        }
        // System.out.println('c'-'a');
    }
}
