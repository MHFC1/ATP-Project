package algorithms;

import algorithms.maze3D.AMaze3DGenerator;
import algorithms.maze3D.Maze3D;
import algorithms.maze3D.MyMaze3DGenerator;
import algorithms.maze3D.Position3D;
import algorithms.mazeGenerators.EmptyMazeGenerator;
import algorithms.mazeGenerators.*;

import java.util.Random;

public class HelloWorld {
    public static void main(String[] args){
//    int[][][] map3d = {{{0,0,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,0},{1,1,1,1,0}},
//                    {{0,0,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,0},{1,1,1,1,0}}};
//    Position3D start = new Position3D(0,0,0);
//    Position3D end = new Position3D(1,4,4);
//
//    Maze3D maze = new Maze3D(start,end,map3d);
//    maze.Print();
//        testMazeGenerator(new EmptyMazeGenerator());
//        testMazeGenerator(new SimpleMazeGenerator());
//        testMazeGenerator(new MyMazeGenerator());
        MyMaze3DGenerator mazelol = new MyMaze3DGenerator();
        long time = mazelol.measureAlgorithmTimeMillis(500,500,500);
        System.out.println(time/1000);

//        Maze3D map3d = mazelol.generate(450,450,450);

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
