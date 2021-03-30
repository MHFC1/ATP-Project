package algorithms;

import algorithms.mazeGenerators.EmptyMazeGenerator;
import algorithms.mazeGenerators.*;

import java.util.Random;

public class HelloWorld {
    public static void main(String[] args){

        testMazeGenerator(new EmptyMazeGenerator());
        testMazeGenerator(new SimpleMazeGenerator());
        testMazeGenerator(new MyMazeGenerator());
    }
    private static void testMazeGenerator(IMazeGenerator mazeGenerator) {
// prints the time it takes the algorithm to run
        System.out.println(String.format("Maze generation time(ms): %s", mazeGenerator.measureAlgorithmTimeMillis(50/*rows*/,30/*columns*/)));
// generate another maze
        Maze maze = mazeGenerator.generate(50/*rows*/, 30/*columns*/);
// prints the maze
        maze.Print();
// get the maze entrance
        Position startPosition = maze.getStartPosition();
// print the start position
        System.out.println(String.format("Start Position: %s", startPosition)); // format "{row,column}"
// prints the maze exit position
        System.out.println(String.format("Goal Position: %s", maze.getGoalPosition()));
    }

}
