package algorithms.test;

public class HelloWorld {
    public static void main(String[] args){
        String S="{1000,1000}";
        int start_index=1;
        int break_index=S.indexOf(",");
        int end_index=S.length()-1;
        String Row=S.substring(start_index,break_index);
        String Column=S.substring(break_index+1,end_index);
        System.out.println("Row:"+Row);
        System.out.println("Column:"+Column);
    }
}
