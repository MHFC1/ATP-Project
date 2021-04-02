package algorithms.search;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    ArrayList<AState> TheGoldPath;
    int TotalVertx;
    public Solution() {
        this.TheGoldPath = new ArrayList<AState>();
        TotalVertx=0;
    }
    public void Add_AState(AState s){
        this.TheGoldPath.add(s);
    }
    public void RemoveAState(AState s){
        this.TheGoldPath.remove(s);
    }
    public ArrayList<AState>getSolutionPath(){
        return TheGoldPath;
    }

    public int getTotalVertx() {
        return TotalVertx;
    }

    public void setTotalVertx(int totalVertx) {
        TotalVertx = totalVertx;
    }
    public void Reverse(){
        Collections.reverse(this.TheGoldPath);

    }

}
