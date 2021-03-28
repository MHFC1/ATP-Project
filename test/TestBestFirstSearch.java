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
        AMazeGenerator mg = new SimpleMazeGenerator();
        Maze maze = mg.generate(5, 5);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        ISearchingAlgorithm domain = new BestFirstSearch();
        maze.Print();
        Solution solution = domain.solve(searchableMaze);



    }
}
