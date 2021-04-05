package algorithms.maze3D;

public abstract class AMaze3DGenerator implements IMazeGenerator3D {
    @Override
    public long measureAlgorithmTimeMillis(int depth, int row, int column) {
        //we save the start time of the method
        long StartTime=System.currentTimeMillis();
        System.out.println("***********************");
        System.out.println(StartTime);
        //we operate the generate method
        generate(depth,row,column);
        //we save the end time of the method
        long EndTime=System.currentTimeMillis();
        System.out.println("***********************");
        System.out.println(EndTime);
        return EndTime-StartTime;
    }
}
