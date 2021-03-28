package algorithms.search;

import java.util.Objects;

public abstract class AState {
    //the attribute of AState:
    private String state;//state="1534" in 8 puzzle
    private int cost;
    private AState cameFrom;

    public AState(String state,int cost,AState cameFrom) {
        this.state = state;
        this.cost=cost;
        this.cameFrom=cameFrom;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        String str1=this.toString();
        String str2=o.toString();
        return Objects.equals(str1,str2);
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
