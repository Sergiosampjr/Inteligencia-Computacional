import java.util.*;

public class AgenteReativoSimplesVacuumAgent extends VacuumAgent {

    @Override
    void determineAction() {
        if (percept[0] == 1) { 
            action = "suck";
        } else {
            action = "forward";
        }
    }
}
