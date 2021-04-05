package algorithms.maze3D;

import algorithms.mazeGenerators.Position;

public class Maze3D {
    private int[][][] mazeStruct;
    private Position3D Start;
    private Position3D Goal;

    public Maze3D(Position3D start, Position3D goal, int[][][] mazeStruct) {
        this.mazeStruct = mazeStruct;
        Start = start;
        Goal = goal;
    }

    public int[][][] getMap(){
        return this.mazeStruct;
    }

    public Position3D getStartPosition(){
        return this.Start;
    }

    public Position3D getGoalPosition(){
        return this.Goal;
    }



    public void Print() {
        int counter =0;
        for (int g = 0; g < this.mazeStruct.length ; g++) {
            if(g==0){
                System.out.println("{");
            }
            for (int i=0;i<this.mazeStruct[g].length;i++) {
                counter =0;
                System.out.print("{ ");
                counter+=2;
                for (int j = 0; j < this.mazeStruct[g][i].length; j++) {
                    if(g == this.Start.getDepthIndex() && i == this.Start.getRowIndex() && j == this.Start.getColumnIndex()){
                        System.out.print("S ");
                        counter +=2;
                    }
                    else if (g == this.Goal.getDepthIndex() && i == this.Goal.getRowIndex() && j == this.Goal.getColumnIndex()){
                        System.out.print("E ");
                        counter+= 2;
                    }
                    else{
                        if(this.mazeStruct[g][i][j] == 1 )
                        {
                            System.out.print("1 ");
                            counter+= 2;
                        }
                        else{
                            System.out.print(this.mazeStruct[g][i][j] + " ");
                            counter += 2;
                        }
                    }

                }
                System.out.print("}");
                counter +=1;
                System.out.println();
            }
            if(g==this.mazeStruct.length-1){
                System.out.println("}");
            }
            else{
                for (int j = 0; j < counter; j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }


    }

}
