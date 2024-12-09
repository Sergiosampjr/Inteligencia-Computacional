/* This method uses the percept (stored in the Vector percept) and state values to determine
the agents next action. The member variable action is assigned a string (either "suck", "forward",
"turn left", "turn right", or "shut-off") to indicate the agent's next action */
// My Vacuum Agent package ai.worlds.vacuum;
import java.util.*;
class MyVacuumAgent extends VacuumAgent
{
// declare any state variables here

    /**
	 * Determine the next action to be performed.
	 */
    public void determineAction()
    {
	int i = (int)Math.floor(Math.random()*5);
	switch (i) {
	    case 0: action = "forward"; break;
	    case 1: action = "turn right"; break;
	    case 2: action = "turn left"; break;
	    case 3: action = "shut-off"; break;
	    case 4: action = "suck";
	}
    }
}



