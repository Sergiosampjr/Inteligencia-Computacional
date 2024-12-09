package ai.worlds.vacuum;

import java.util.Arrays;

public class MeuAgenteModeloVacuumAgent extends VacuumAgent {

    private boolean[][] mapa;
    private int x, y;
    private int largura, altura;

    public MeuAgenteModeloVacuumAgent() {
        // Obter dimensões do ambiente (implemente a lógica para obter do simulador)
        largura = obterLargura();
        altura = obterAltura();
        mapa = new boolean[largura][altura];
        x = 0;
        y = 0;
    }

    @Override
    void determineAction() {
        atualizarMapa();
        int[] alvo = encontrarAlvo();
        if (alvo != null) {
            moverPara(alvo[0], alvo[1]);
        } else {
            action = "shut-off";
        }
    }

    // Obtém as dimensões do ambiente (implemente esta função)
    private int obterLargura() { return 20; } // substitua por código para obter do simulador
    private int obterAltura() { return 20; }  // substitua por código para obter do simulador

    void atualizarMapa() {
        if (percept[0] == 1) {
            mapa[x][y] = true; // limpar
        }
    }

    int[] encontrarAlvo() {
        for (int i = 0; i < largura; i++) {
            for (int j = 0; j < altura; j++) {
                if (!mapa[i][j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


    void moverPara(int xAlvo, int yAlvo) {
        if (xAlvo > x && percept[1] == 0) {
            action = "forward";
            x++;
        } else if (xAlvo < x && percept[1] == 0) {
            //Simulador não possui a ação backward.  Implemente lógica de rotação e movimento para frente.
        } else if (yAlvo > y && percept[2] == 0) {
            action = "turn right";
            y++;
        } else if (yAlvo < y && percept[2] == 0) {
            action = "turn left";
            y--;
        } else {
            action = "turn left"; //Tentativa de deslocamento
        }
    }
}