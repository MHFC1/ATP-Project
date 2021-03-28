package algorithms.search;

import algorithms.mazeGenerators.Position;

//For example to the problem  state: "{0,0}"
//4: (MazeState)-string "{0,0}",cost=0,camefrom=null
//For example to the problem  state: {0,0}->{0,1}
//4: (MazeState)-string "{0,1}",cost=10,camefrom={0,0}
//For example to the problem  state: {0,0}->{1,1}
//4: (MazeState)-string "{1,1}",cost=15,camefrom={0,0}
public class MazeState extends AState {
    int Row;
    int Column;
    public MazeState(String state, int cost, AState cameFrom) {
        super(state, cost, cameFrom);
        this.Row=Integer.parseInt(state.substring(1,2));
        this.Column=Integer.parseInt(state.substring(3,4));

    }

    public int getRow() {
        return Row;
    }

    public int getColumn() {
        return Column;
    }
}
