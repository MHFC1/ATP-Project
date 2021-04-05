package algorithms.test;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.SimpleMazeGenerator;
import algorithms.mazeGenerators.*;
import algorithms.search.*;
import java.util.ArrayList;
public class TestBestFirstSearch {
    public static void main(String[] args) {
        /**** Basic test Unit 1: */
        AMazeGenerator mg = new MyMazeGenerator();
        Maze maze = mg.generate(500, 500);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        ISearchingAlgorithm domain = new DepthFirstSearch();
        maze.Print();
        Solution solution = domain.solve(searchableMaze);
       System.out.println(solution.getSolutionPath().toString());
       System.out.println(solution.getTotalVertx());
        //System.out.println(solution.getSolutionPath().size());


    }
}
