package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.Map;

public class SearchableMaze implements ISearchable {
    Maze maze;

    public SearchableMaze(Maze maze) {
        this.maze = maze;
    }

    /**
     * The method returns the stat point
     *
     * @return a AState that represent the starting point.
     */
    @Override
    public AState getStartState() {
        return new MazeState(this.maze.getStartPosition().toString(),0,null);
    }

    /**
     * The method searching the state that we can go foreword from the state input
     *
     * @param s -represent the current state
     * @return an ArrayList that include all the state that we can go foreword from the current state
     */
    @Override
    public ArrayList<AState> getAllPossibleStates(AState s) {
        ArrayList<AState> output=new ArrayList<AState>();
        int row=((MazeState)s).getRow();
        int column=((MazeState)s).getColumn();
        Position p=new Position(row,column);
        Map<Position,Integer > map=maze.getPossiblePosition(p);
        for (Position i : map.keySet()) {
            output.add(new MazeState(i.toString(),map.get(i),s));
        }
        return output;

    }

    /**
     * The method returns the Goal point
     *
     * @return a AState that represent the end point.
     */
    @Override
    public AState getGoalState() {
        return new MazeState(this.maze.getGoalPosition().toString(),0,null);
    }
    /**
     * The method returns the all initial State-We convert each cell in the matrix to an -AState-(Adaptation)
     *Dont Include the StartState!!!!!!!!!!
     * To the whole AStates we giving them initial Values:came From=Null,Cost:0
     * @return ArrayList<AState>-Each cell,its an AState-Dont Include the StartState!!!!!!!!!!
     */
    //**Note : To verify between 2 AState-Using an equals Function!
    public ArrayList<AState> getAllInitialState() {
        ArrayList<AState> output=new ArrayList<AState>();
        int row=this.maze.GetRow();
        int column=this.maze.GetColumn();
        AState StartState=this.getStartState();
        AState NewState;
        Position CurPosition;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                    CurPosition=new Position(i,j);
                    NewState=new MazeState(CurPosition.toString(),0,null);
                    //Just to ensure that im dont creat the StartState
                    if ((NewState.equals(StartState)==false))
                    output.add(NewState);
            }

        }
        return output;
    }
}
