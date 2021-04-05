package algorithms.test;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.SimpleMazeGenerator;
import algorithms.mazeGenerators.*;
import algorithms.search.*;
import java.util.ArrayList;
public class TestDFS {
    public static void main(String[] args) {
        /**** Basic test Unit 1: */
        AMazeGenerator mg = new MyMazeGenerator();
        Maze maze = mg.generate(999, 999);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        ISearchingAlgorithm domain = new BestFirstSearch();
        maze.Print();
        long StartTime=System.currentTimeMillis();
        //we operate the generate method
        Solution solution = domain.solve(searchableMaze);
        //we save the end time of the method
        long EndTime=System.currentTimeMillis();
        System.out.println(solution.getSolutionPath().toString());
        System.out.println(solution.getTotalVertx());
        System.out.println(maze.getGoalPosition());
        System.out.println("sssssssssssssssssssss");
        System.out.println(EndTime-StartTime);

    }
}
