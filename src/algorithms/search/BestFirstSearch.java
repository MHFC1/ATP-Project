package algorithms.search;

import java.util.ArrayList;
import java.util.*;
public class BestFirstSearch extends ASearchingAlgorithm{
    private int TotalVertex=0;



    public void setTotalVertex(int totalVertex) {
        TotalVertex = totalVertex;
    }

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
    public int getNumberOfNodesEvaluated() {
         return TotalVertex;
    }

    /**
     * The method returns the name of the Algorithm
     *
     * @return a AState that represent the all phat-the gold path of the solution
     */
    @Override
    public String getName() {
        return "BestFirstSearch";
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
        /**Step 1:DefineLists,priorityQueue and add the start State,S to open **/
    //The Open AList:
        Queue<AState> Open=new PriorityQueue<AState>();
        Open.add(TheProblem.getStartState());
    //The Close AStateList:
        Hashtable<String,AState> Close = new Hashtable<>();
     //Initializing the StartAState and The GoalAState
        AState Start_AState=TheProblem.getStartState();
        AState Goal_AState=TheProblem.getGoalState();
        AState S_Successors;
        AState Temp;
     // Initializing the vertex
        int Vertex_count=0;
        /**Step 2:If Open is empty THEN exit **/
        while (Open.isEmpty()!=true){
            Vertex_count++;
            /**Step 3:Take from OPEN the AState S with the low cost and move it to CLOSED-LowerCostInOpen **/
            AState Father_AState= Open.remove();
            Close.put(Father_AState.toString(),Father_AState);
            /**Step 4:If S is the goal AState **/
            if(Father_AState.equals(Goal_AState)) {
                //recurse the solution
                solution.Add_AState(Father_AState);
                while (Father_AState.equals(Start_AState)!=true)
                {
                    Father_AState=Father_AState.getCameFrom();
                    solution.Add_AState(Father_AState);
                }
                solution.setTotalVertx(Vertex_count);
                solution.Reverse();
                this.setTotalVertex(solution.getTotalVertx());
                return solution;
            }
            /**Step 5:Expand AState S By Getting his Successors **/
            ArrayList<AState>Successors_AL=TheProblem.getAllPossibleStates(Father_AState);
            Queue<AState> queue_Successors=new PriorityQueue<AState>();
            for (int i = 0; i < Successors_AL.size(); i++) {
                queue_Successors.add(Successors_AL.get(i));
            }
            /**Step 6:For each Successors **/
            //Initialized Verbal for looping:
            int new_cost=0;
            Iterator<AState> iterator =queue_Successors.iterator();
            while(iterator.hasNext()) {
                S_Successors = iterator.next();
                /**Step 6.1:if S is not in Close continue **/
                if (this.HashTable_IsContained(Close, S_Successors) == false) {
                    /**Step 6.2:if S is not in Open  **/
                    if (this.PriorityQuery_IsContained(Open, S_Successors) == false) {
                        /**Step 6.2.a:apply the cost of arrival to s node  **/
                        //This in THE Basic BFS should be 0
                        new_cost = S_Successors.getCost() + Father_AState.getCost();
                        S_Successors.setCost(new_cost);
                        /**Step 6.2.b:update s parent node to be n  **/
                        S_Successors.setCameFrom(Father_AState);
                        /**Step 6.2.c:add s to open**/
                        Open.add(S_Successors);
                    }
                }
            }

        }

    return solution;

    }
}
