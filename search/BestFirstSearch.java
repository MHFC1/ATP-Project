package algorithms.search;

import java.util.ArrayList;

public class BestFirstSearch extends ASearchingAlgorithm{
    /**
     * The method returns the solution to the problem
     *
     * @param s
     * @return a AState that represent the all phat-the gold path of the solution
     */
    @Override
    public AState search(ISearchable s) {
        return null;
    }

    /**
     * The method returns the number of vertex that the we should visit to find the goal path
     *
     * @return a AState that represent the all phat-the gold path of the solution
     */
    @Override
    public int getNumberofVisitedNodes() {
        return 0;
    }


    /**
     * The method returns the solve to the problem
     *
     * @return a AState that represent the all phat-the gold path of the solution
     */
    //For the Example-I had a searchableMaze
    public Solution solve(ISearchable TheProblem){
    //The GoldPath Structure:
        Solution solution=new Solution();
    //Creating All the Nodes-All the AState,and giving them initial Values:came From=Null,Cost:0
        //ArrayList<AState> All_AState=ISearchable
        return null;
    }
}
