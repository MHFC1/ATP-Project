package algorithms.test;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.SimpleMazeGenerator;
import algorithms.mazeGenerators.*;
import algorithms.search.*;

import java.util.*;

public class RunSearchOnMaze {

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
        /*
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

        */
        public static void main(String[] args) {
            IMazeGenerator mg = new MyMazeGenerator();
            Maze maze = mg.generate(200, 200);
            maze.Print();
            SearchableMaze searchableMaze = new SearchableMaze(maze);
            solveProblem(searchableMaze, new BreadthFirstSearch());
            solveProblem(searchableMaze, new BestFirstSearch());
            solveProblem(searchableMaze, new DepthFirstSearch());
        }
        private static void solveProblem(ISearchable domain, ISearchingAlgorithm
        searcher) {
//Solve a searching problem with a searcher
            long StartTime=System.currentTimeMillis();
            //we operate the generate method
            Solution solution = searcher.solve(domain);
            //we save the end time of the method
            long EndTime=System.currentTimeMillis();
            System.out.println("Time:" +(EndTime-StartTime));
            System.out.println(String.format("'%s' algorithm - nodes evaluated:%s", searcher.getName(), searcher.getNumberOfNodesEvaluated()));

//Printing Solution Path
                    System.out.println("Solution path:");
            ArrayList<AState> solutionPath = solution.getSolutionPath();
            System.out.println("goal : "  + domain.getGoalState());
            for (int i = 0; i < solutionPath.size(); i++) {
                System.out.println(String.format("%s.%s",i,solutionPath.get(i)));

            }
        }

    }

