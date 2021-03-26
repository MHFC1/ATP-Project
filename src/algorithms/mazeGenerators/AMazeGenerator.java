package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator {
    @Override
    public long measureAlgorithmTimeMillis(int rows, int columns) {
        //we save the start time of the method
        long StartTime=System.currentTimeMillis();
        System.out.println("***********************");
        System.out.println(StartTime);
        //we operate the generate method
        generate(rows,columns);
        //we save the end time of the method
        long EndTime=System.currentTimeMillis();
        System.out.println("***********************");
        System.out.println(EndTime);
        return EndTime-StartTime;
    }
}
