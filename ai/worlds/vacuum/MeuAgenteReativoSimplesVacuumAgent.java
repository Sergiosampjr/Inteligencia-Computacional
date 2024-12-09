package ai.worlds.vacuum;

public class MeuAgenteReativoSimplesVacuumAgent extends VacuumAgent {

    @Override
    void determineAction() {
        if (percept[0] == 1) { // Há sujeira?
            action = "suck";
        } else if (percept[1] == 0) { // Caminho livre à frente?
            action = "forward";
        } else if (percept[2] == 0) { // Caminho livre à direita?
            action = "turn right";
        } else {
            action = "turn left"; // Virar à esquerda se estiver bloqueado
        }
    }
}