package algorithms.search;
import java.util.ArrayList;

//this interface represent the method that should be in the generic
//problems(3D-Maze,2D-Maze,Graph......)

public interface ISearchable {
    /** The method returns the stat point
     * @return a AState that represent the starting point.
     */
    AState getStartState();

    /** The method searching the state that we can go foreword from the state input
     * @param s -represent the current state
     * @return an ArrayList that include all the state that we can go foreword from the current state
     */
    ArrayList<AState> getAllPossibleStates(AState s);

    /** The method returns the Goal point
     * @return a AState that represent the end point.
     */
    AState getGoalState();




}