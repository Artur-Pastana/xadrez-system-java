package secao16.aplication;

import secao16.boardgame.Posicao;
import secao16.boardgame.Tabuleiro;
import secao16.xadrez.PartidaXadrez;
import secao16.xadrez.pecas.Rei;

public class Programa {
    public static void main(String[] args) {

        PartidaXadrez partidaXadrez = new PartidaXadrez();

        UI.printTabuleiro(partidaXadrez.getPecas());
        
        
    }
}
