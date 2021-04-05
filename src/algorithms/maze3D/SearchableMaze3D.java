package algorithms.maze3D;

import algorithms.search.AState;
import algorithms.search.ISearchable;

import java.util.ArrayList;
import java.util.Hashtable;

public class SearchableMaze3D implements ISearchable {
    @Override
    public AState getStartState() {
        return null;
    }

    @Override
    public ArrayList<AState> getAllPossibleStates(AState s) {
        return null;
    }

    @Override
    public AState getGoalState() {
        return null;
    }

    @Override
    public ArrayList<AState> getAllInitialState() {
        return null;
    }

    @Override
    public ArrayList<AState> getAllPossible_AStates(AState s, Hashtable<String, AState> vBlack_State) {
        return null;
    }
}
