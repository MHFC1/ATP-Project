package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator{

    @Override
    public Maze generate(int rows, int columns) {
        int[][]a = new int[rows][columns];
        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                a[i][j] = 0;
            }
        }
        return new Maze(a,new Position(0,0), new Position(rows-1,columns-1));
    }
}
