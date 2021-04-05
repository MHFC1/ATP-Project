package algorithms.test;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.search.AState;
import algorithms.search.MazeState;
import algorithms.search.SearchableMaze;

import java.util.*;

public class Test_General {
    public static void main(String[] args) {
        /*
        Vector<AState> vBlack_State = new Vector<AState>();
        vBlack_State.add(new MazeState(5,6,15,null));
        AState s=new MazeState(5,6,0,new MazeState(5,8,15,null));
        System.out.println(vBlack_State.contains(s));

         */
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze = mg.generate(5, 5);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        maze.Print();
    }
}
