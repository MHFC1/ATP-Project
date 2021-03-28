package algorithms.search;
import algorithms.GraphExample.WeightedGraph;
import java.util.ArrayList;
import java.util.Map;

public class SearchableWeightedGraph implements ISearchable {
     WeightedGraph graph;

    public SearchableWeightedGraph(WeightedGraph graph) {
        this.graph = graph;
    }

    /**
     * The method returns the stat point
     *
     * @return a AState that represent the starting point.
     */
    @Override
    public AState getStartState() {
        return new WeightedGraphState(String.valueOf(graph.getStartPosition()),0,null);
    }

    /**
     * The method searching the state that we can go foreword from the state input
     *
     * @param s -represent the current state
     * @return an ArrayList that include all the state that we can go foreword from the current state
     */
    @Override
    public ArrayList<AState> getAllPossibleStates(AState s) {
        Map<Integer, String> map=graph.getAllPosition(Integer.parseInt(s.toString()));
        return null;

    }

    /**
     * The method returns the Goal point
     *
     * @return a AState that represent the end point.
     */
    @Override
    public AState getGoalState() {
        return new WeightedGraphState( "4",0,null);
    }
}
