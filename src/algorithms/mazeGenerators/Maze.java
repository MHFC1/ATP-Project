package algorithms.mazeGenerators;

public class Maze implements IMaze {
    private int [][] mazeStruct;
    private Position Start;
    private Position Goal;


    public Maze(int[][] mazeStruct, Position start, Position goal) {
        this.mazeStruct = mazeStruct;
        this.Start = start;
        this.Goal = goal;
    }

    public Position getStartPosition() {
        return this.Start;
    }

    @Override
    public Position getGoalPosition() {
        return this.Goal;
    }

    @Override
    public void Print() {
        for (int i=0;i<this.mazeStruct.length;i++) {
            System.out.print("{ ");
            for (int j = 0; j < this.mazeStruct[0].length; j++) {
                if(i == this.Start.getRowIndex() && j == this.Start.getColumnIndex()){
                    System.out.print("S ");
                }
                else if (i == this.Goal.getRowIndex() && j == this.Goal.getColumnIndex()){
                    System.out.print("E ");
                }
                else{
                    if(this.mazeStruct[i][j] == 1 )
                    {
                        System.out.print("1 ");
                    }
                    else{
                        System.out.print(this.mazeStruct[i][j] + " ");
                    }
                }

            }
            System.out.print("}");
            System.out.println();
        }
    }
}
