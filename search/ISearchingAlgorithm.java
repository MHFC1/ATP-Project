package algorithms.search;

public interface ISearchingAlgorithm {
    /** The method returns the solution to the problem
     * @return a AState that represent the all phat-the gold path of the solution
     */
    AState search(ISearchable s);

    /** The method returns the number of vertex that the we should visit to find the goal path
     * @return a AState that represent the all phat-the gold path of the solution
     */
    int getNumberofVisitedNodes();

}
