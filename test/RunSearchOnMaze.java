package algorithms.test;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.SimpleMazeGenerator;
import algorithms.mazeGenerators.*;
import algorithms.search.*;

import java.util.*;

public class RunSearchOnMaze {
    public static void main(String[] args){
        /**** Basic test Unit 1: */
        /*
        IMazeGenerator mg = new SimpleMazeGenerator();
        Maze maze = mg.generate(5, 5);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        maze.Print();
        System.out.println(maze.getPossiblePosition(new Position(1,1)).toString());
        System.out.println(searchableMaze.getStartState().equals(searchableMaze.getStartState()));

        //Basic test Unit 1:
        IMazeGenerator mg = new SimpleMazeGenerator();
        Maze maze = mg.generate(5, 5);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        maze.Print();
        System.out.println(maze.getPossiblePosition(new Position(1,1)).toString());
        System.out.println(searchableMaze.getStartState().equals(searchableMaze.getStartState()));
        */
        /**** Basic test Unit 2: */
        IMazeGenerator mg = new SimpleMazeGenerator();
        Maze maze = mg.generate(3, 3);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        maze.Print();
        ArrayList<AState>arrayList=searchableMaze.getAllPossibleStates(new MazeState("{0,1}",0,null));
        Queue<AState> queue=new PriorityQueue<AState>();
        for (int i = 0; i < arrayList.size(); i++) {
            queue.add(arrayList.get(i));
        }

        AState s=queue.remove();
        System.out.println(s.toString());



    }

}
