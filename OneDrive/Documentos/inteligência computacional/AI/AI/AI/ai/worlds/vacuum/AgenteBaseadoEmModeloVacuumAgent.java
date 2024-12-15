import java.util.*;

public class AgenteBaseadoEmModeloVacuumAgent extends VacuumAgent {

    private boolean[][] mundo;
    private int x, y;
    private int maxX, maxY; 

    public AgenteBaseadoEmModeloVacuumAgent() {
       
        maxX = getWorldWidth();
        maxY = getWorldHeight();
        mundo = new boolean[maxX][maxY];
    }

    @Override
    void determineAction() {
        if (percept[0] == 1) { 
            action = "suck";
            mundo[x][y] = true; 
        } else {
            
            int melhorX = -1, melhorY = -1;
            int menorDistancia = Integer.MAX_VALUE;
            for (int i = 0; i < maxX; i++) {
                for (int j = 0; j < maxY; j++) {
                    if (!mundo[i][j]) { 
                        int distancia = Math.abs(x - i) + Math.abs(y - j);
                        if (distancia < menorDistancia) {
                            menorDistancia = distancia;
                            melhorX = i;
                            melhorY = j;
                        }
                    }
                }
            }
             
            action = calcularMovimento(melhorX, melhorY);

        }
    }

    private String calcularMovimento(int destinoX, int destinoY){
        if (destinoX > x){
            return "forward";
        } else if (destinoX < x){
            return "backward"; //Assumindo que o simulador tenha a ação backward. Se não tiver, ajuste para rotacionar e ir para frente
        } else if (destinoY > y){
            return "turn right"; // Assumindo que +Y é direita. Ajuste de acordo com a sua convenção.
        } else{
            return "turn left";
        }

    }


    private int getWorldWidth(){
       
        return 10; //Substitua por lógica real
    }

    private int getWorldHeight(){
       
        return 10; //Substitua por lógica real
    }
}