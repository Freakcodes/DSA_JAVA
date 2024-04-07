import java.lang.reflect.Array;
import java.util.ArrayList;

public class MazePath {
    public static void main(String[] args) {
        int m=1;
        int n=1;
        ArrayList<String>res=getMazePaths( m, n, 4 , 4);
        System.out.println(res);

    }
    private static ArrayList<String> getMazePaths(int sr,int sc,int dr,int dc){
        if(sr==dc && sc==dc){
            ArrayList<String> bres=new ArrayList<>();
            bres.add("");
            return bres;
        }
        else if(sr>dr || sc>dc){
            ArrayList<String> bres=new ArrayList<>();
            return bres;
        }

        ArrayList<String> hpath =getMazePaths(sr+1, sc, dr, dc);
        ArrayList<String> vpath=getMazePaths(sr, sc+1, dr, dc);
        ArrayList<String>fres=new ArrayList<>();
        for(String p:hpath){
            fres.add("h"+p);
        }
        for(String p:vpath){
            fres.add("v"+p);
        }
        return fres;
    }

}
