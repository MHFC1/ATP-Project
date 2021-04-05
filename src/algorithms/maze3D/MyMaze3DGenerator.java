package algorithms.maze3D;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MyMaze3DGenerator extends AMaze3DGenerator {

    private ArrayList<Position3D> neighbors;
    private int z;
    private int x;
    private int y;
    private Stack<Position3D> stack = new Stack<>();
    private Random rand = new Random();
    private int[][][] maze;

    @Override
    public Maze3D generate(int depth, int row, int column) {
        neighbors = new ArrayList<>();
        int indicatorFinder = 0; //he will find the indicator that will tell us to put the ending point where the maze generation is (somewhat) close to the end
        maze = StartingMaze(depth,row,column);
        int indicator = (int)((depth*row*column)/2.2); // this variable will give us a close estimate to when the maze is close to the end where things get complicated
        stack.push(new Position3D(0,0,0));
        while (!stack.empty()) {
            Position3D currentCell = stack.pop();
            if (validNextCell(currentCell)) {
                maze[currentCell.getDepthIndex()][currentCell.getRowIndex()][currentCell.getColumnIndex()] = 0;
                indicatorFinder++;
                if(indicatorFinder == indicator ){
                    z = currentCell.getDepthIndex();
                    x = currentCell.getRowIndex(); // x will represent the row index of the end of the maze
                    y = currentCell.getColumnIndex(); // y will represent the col index of the end of the maze
                    indicator = 0;
                }
                locateNeighbors(currentCell);
                randomlyAddCellsToTheStack();
            }

        }
        return new Maze3D(new Position3D(0,0,0), new Position3D(z,x, y),maze);
    }

    private int[][][] StartingMaze(int depth, int rows, int columns){ //make the maze start with all the walls up.
        int[][][]maze = new int[depth][rows][columns];
        for (int i=0;i<maze.length;i++) {
            for (int j = 0; j < maze[i].length; j++) {
                for (int k = 0; k < maze[i][j].length; k++) {
                    maze[i][j][k] = 1;
                }
            }
        }
        return maze;
    }

    private boolean validNextCell(Position3D cellPos) { //check if the cell has continuity to keep going or are we at a dead end (to not break walls we dont need to break) the number 3 is the key here because if there is more than 3 visited neighbors no matter which direction we take we will make a passage which is larger then a single line which will destroy the concept of a small(line) passage in the maze.
        int visitedNeighbors = 0;
        for (int row = cellPos.getRowIndex()-1; row < cellPos.getRowIndex()+2; row++) {
            for (int col = cellPos.getColumnIndex()-1; col < cellPos.getColumnIndex()+2; col++) {
                if (validCellNOdepth(row, col) && !sameCell(cellPos, row, col) && maze[cellPos.getDepthIndex()][row][col] == 0) {
                    visitedNeighbors++;
                }
            }
        }
        return (visitedNeighbors < 3) && maze[cellPos.getDepthIndex()][cellPos.getRowIndex()][cellPos.getColumnIndex()] != 0;
    }

    private void randomlyAddCellsToTheStack() { //randomly add cells from the list to the stack
        int index;
        while (!neighbors.isEmpty()) {
            index = rand.nextInt(neighbors.size());
            stack.push(neighbors.remove(index));
        }
    }

    private void locateNeighbors(Position3D cellPos) { //finding valid neighbors and adding them to the list
        for (int row = cellPos.getRowIndex()-1; row < cellPos.getRowIndex()+2; row++) {
            for (int col = cellPos.getColumnIndex()-1; col < cellPos.getColumnIndex()+2; col++) {
                if(sameCell(cellPos,row,col)) {
                    for (int depth = cellPos.getDepthIndex()-1; depth < cellPos.getDepthIndex()+2; depth++) {
                        if(validCell(depth,row, col) && !sameCell3D(cellPos,depth,row,col) &&  !isPointACorner(cellPos,row,col)) {
                            neighbors.add(new Position3D(depth,row, col));
                        }
                    }
                }
                if (validCell(cellPos.getDepthIndex(),row, col) && !isPointACorner(cellPos,row, col) && !sameCell(cellPos, row, col)) {
                    neighbors.add(new Position3D(cellPos.getDepthIndex(),row, col));
                }
            }
        }
    }


    private Boolean sameCell(Position3D cellPos, int row, int col) { //check if the current cell is the same cell we started looking neighboors for.
        if(row == cellPos.getRowIndex() && col == cellPos.getColumnIndex()){
            return true;
        }
        else{
            return false;
        }
    }

    private Boolean sameCell3D(Position3D cellPos,int depth ,int row, int col) { //check if the current cell is the same cell we started looking neighboors for.
        if(depth == cellPos.getDepthIndex() && row == cellPos.getRowIndex() && col == cellPos.getColumnIndex()){
            return true;
        }
        else{
            return false;
        }
    }

    private Boolean isPointACorner(Position3D cellPos, int row, int col) { //check if the current cell is a corner neighbor of the cell we starting looking from.
        if(row != cellPos.getRowIndex() && col != cellPos.getColumnIndex()){
            return true;
        }
        else{
            return false;
        }
    }

    private Boolean validCell(int depth, int row, int col) { //check if the cell is a valid cell inside the maze.
        if(depth >= 0 && row >= 0 && col >= 0 && depth < this.maze.length && row < this.maze[0].length && col < this.maze[0][0].length && this.maze[depth][row][col] != 0){
            return true;
        }
        else{
            return false;
        }
    }
    private Boolean validCellNOdepth(int row, int col) { //check if the cell is a valid cell inside the maze.
        if( row >= 0 && col >= 0 && row < this.maze[0].length && col < this.maze[0][0].length){
            return true;
        }
        else{
            return false;
        }
    }

    private Boolean validCellDepth(int depth, int row, int col) { //check if the cell is a valid cell inside the maze.
        if(row >= 0 && col >= 0 && row < this.maze[0].length && col < this.maze[0][0].length && this.maze[depth][row][col] != 0){
            return true;
        }
        else{
            return false;
        }
    }
}
/* private boolean validNextCell(Position3D cellPos) { 3DDD  //check if the cell has continuity to keep going or are we at a dead end (to not break walls we dont need to break) the number 3 is the key here because if there is more than 3 visited neighbors no matter which direction we take we will make a passage which is larger then a single line which will destroy the concept of a small(line) passage in the maze.
        int visitedNeighbors = 0;
            for (int row = cellPos.getRowIndex()-1; row < cellPos.getRowIndex()+2; row++) {
                for (int col = cellPos.getColumnIndex()-1; col < cellPos.getColumnIndex()+2; col++) {
                    if(sameCell(cellPos,row,col)) {
                        for (int depth = cellPos.getDepthIndex()-1; depth < cellPos.getDepthIndex()+2; depth++) {
                            if(validCell(depth,row, col) && !sameCell3D(cellPos,depth,row,col) &&  maze[depth][row][col] == 0) {
                                visitedNeighbors++;
                            }
                        }
                    }
                    if (validCell(cellPos.getDepthIndex(), row, col) && !sameCell(cellPos, row, col) && maze[cellPos.getDepthIndex()][row][col] == 0) {
                        visitedNeighbors++;
                    }
                }
            }
        return (visitedNeighbors < 5) && maze[cellPos.getDepthIndex()][cellPos.getRowIndex()][cellPos.getColumnIndex()] != 0;
    }*/