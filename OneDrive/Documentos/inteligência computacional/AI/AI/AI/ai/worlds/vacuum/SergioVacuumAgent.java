package ai.worlds.vacuum;

import java.util.Vector;

public class SergioVacuumAgent extends VacuumAgent{
String[] situacoes = {"Situacao1","Situacao2","Situacao3","situacao4"};
	String[] acoes = {"Acao1", "Acao2", "Acao3","acao4"};
	String rotacao = "rotacao";
	
	public void determineAction()
    {
	Vector p = (Vector) percept;
	if (p.elementAt(1) == "dirt"){
		action = "suck";
	}
	else if(situacoes[3] == "bump" && situacoes[1] == "bump"){
		action = "shut-off";
	}
	else if (p.elementAt(2) == "home") {
	    action = "forward";
		situacoes[0] = situacoes[1];
		situacoes[1] = situacoes[2];
		situacoes[2] = situacoes[3];
		situacoes[3] = "home";	
	}
	else if (p.elementAt(0) == "bump") {
		if(rotacao == "turn left"){
			action = "turn right";
		}
		else if(rotacao == "turn right"){
			action = "turn left";
		}
		else{
			action = "turn left";
		}
		situacoes[0] = situacoes[1];
		situacoes[1] = situacoes[2];
		situacoes[2] = situacoes[3];
		situacoes[3] = "bump";
		acoes[0] = acoes[1];
		acoes[1] = acoes[2];
		acoes[2] = acoes[3];
		acoes[3] = action;
		
	}
	else if(acoes[3] == "forward" && acoes[2] == "turn right" && acoes[1] == "forward" && acoes[0] != "turn right"){
		action = "turn right";
		rotacao = action;
		situacoes[0] = situacoes[1];
		situacoes[1] = situacoes[2];
		situacoes[2] = situacoes[3];
		situacoes[3] = "clean";
		acoes[0] = acoes[1];
		acoes[1] = acoes[2];
		acoes[2] = acoes[3];
		acoes[3] = action;
	}
	else if(acoes[3] == "forward" && acoes[2] == "turn left" && acoes[1] == "forward" && acoes[0] != "turn left"){
		action = "turn left";
		rotacao = action;
		situacoes[0] = situacoes[1];
		situacoes[1] = situacoes[2];
		situacoes[2] = situacoes[3];
		situacoes[3] = "clean";
		acoes[0] = acoes[1];
		acoes[1] = acoes[2];
		acoes[2] = acoes[3];
		acoes[3] = action;
	}

	else {
	    action = "forward";
		situacoes[0] = situacoes[1];
		situacoes[1] = situacoes[2];
		situacoes[2] = situacoes[3];
		situacoes[3] = "clean";
		acoes[0] = acoes[1];
		acoes[1] = acoes[2];
		acoes[2] = acoes[3];
		acoes[3] = action;

	}
    }
	
}