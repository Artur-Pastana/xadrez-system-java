package secao16.aplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
        List<PecaXadrez> capturada = new ArrayList<>();

        while (!partidaXadrez.getCheckMate()) {

            try {

                UI.clearScreen();
                //UI.printTabuleiro(partidaXadrez.getPecas());
                UI.printPartida(partidaXadrez, capturada);
                System.out.println();
                System.out.print("origem: ");
                XadrezPosicao origem = UI.lendoPosicaoXadrez(sc);

                boolean[][] possiveisMovimentos = partidaXadrez.possiveisMovimentos(origem);
                UI.clearScreen();
                UI.printTabuleiro(partidaXadrez.getPecas(), possiveisMovimentos);

                System.out.println();
                System.out.print("Destino: ");
                XadrezPosicao destino = UI.lendoPosicaoXadrez(sc);

                PecaXadrez pecaCapturada = partidaXadrez.executarMovimentoXadrez(origem, destino);

                if (pecaCapturada != null ){
                    capturada.add(pecaCapturada);
                }
            } 
            catch (XadrezException xadrezException) {
                System.out.println(xadrezException.getMessage());
                sc.nextLine();
            }
            catch(InputMismatchException inputMismatchException){
                System.out.println(inputMismatchException.getMessage());
                sc.nextLine();
            }

        }//fim do while
        UI.clearScreen();
        UI.printPartida(partidaXadrez, capturada);
        // System.out.println('c'-'a');
    }
}
