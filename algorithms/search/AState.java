package algorithms.search;

import java.util.HashMap;
import java.util.Objects;

public abstract class AState implements  Comparable<AState> {
    //the attribute of AState:
    private String state;//state="1534" in 8 puzzle
    private int cost;
    private AState cameFrom;
    /***Mode 0-White-Unvisited
     * Mode 1-Gray-Visited But not examined
     * Mode 2-Black-Visited and examined
     */
    private int mode;

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public AState(String state, int cost, AState cameFrom) {
        this.state = state;
        this.cost=cost;
        this.cameFrom=cameFrom;
        this.mode=0;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        String str1=this.toString();
        String str2=o.toString();
        return Objects.equals(str1,str2);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * The method returns true if This has Less cost then s
     *
     * @param s-represent an AState
     * @return true if this cost less and equal from o,otherwise return false
     */
    public boolean LowerCost(AState s) {
        return (this.cost<=s.getCost());
    }
    /**
     * The method returns the  if This has Less cost then s
     *
     * @param s-represent an AState
     * @return true if this cost less and equal from o,otherwise return false
     */

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    /**
     * The method Just For The Ordering Function!!!!!!!!!
     *
     * @param s-represent an AState
     * @return true if this cost less and equal from o,otherwise return false
     */
    public int compareTo(AState s) {
        if(this.getCost()>=s.getCost())
        return 1;
        else
            return 0;
    }

    public AState getCameFrom() {
        return cameFrom;
    }

    public void setCameFrom(AState cameFrom) {
        this.cameFrom = cameFrom;
    }
    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AState aState = (AState) o;
        return Double.compare(aState.cost, cost) == 0 && Objects.equals(state, aState.state) && Objects.equals(cameFrom, aState.cameFrom);
    }
    */


    @Override
    public String toString() {
        return this.state;

    }
    /*
    @Override
    public int hashCode() {
        return Objects.hash(state, cost, cameFrom);
    }

     */
}
