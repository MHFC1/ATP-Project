package algorithms.maze3D;

import algorithms.search.AState;

public class Maze3DState extends AState {

    public Maze3DState(String state, int cost, AState cameFrom) {
        super(state, cost, cameFrom);
    }
}
