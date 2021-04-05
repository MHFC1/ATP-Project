package algorithms.maze3D;

public interface IMazeGenerator3D {
    Maze3D generate(int Depth, int row, int column);
    long measureAlgorithmTimeMillis(int depth, int row, int column);
}
