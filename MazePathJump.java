import java.util.ArrayList;
//This question is based on getStairspath as well as the previous question getMaze path..
//here you can not just take one step but can jump directly to destination (just like stairs path question)...
//Additionally there is diagonal path as well...whose condition is ms(most step)=dc-sc we will check ki yeh coloumn k bahar toh nhi ja raha ..and we will also check ki yeh row k bahar ja rha ki nhi ms=(dr-sr)...
//It is a good question...
public class MazePathJump {
    public static void main(String[] args) {
        int m=1;
        int n=1;
        ArrayList<String>res=getMazePaths( m, n, 3 , 3);
        System.out.println(res);
    }
    private static ArrayList<String> getMazePaths(int sr,int sc,int dr,int dc){
        //base condition...
        if(sr==dr && sc==dc){
            ArrayList<String>ans=new ArrayList<>();
            ans.add("");
            return ans;
        }

        //vertical paths..
        ArrayList<String>res=new ArrayList<>();
        for(int ms=1;ms<=dc-sc;ms++){
            ArrayList<String>vpaths=getMazePaths(sr, sc+ms, dr, dc);
            for (String v : vpaths) {
                res.add("v"+ms+v);
            }
        }
        //Horizontals paths...
        for(int ms=1;ms<=dr-sr;ms++){
            ArrayList<String>hpaths=getMazePaths(sr+ms, sc, dr, dc);
            for (String h : hpaths) {
                res.add("h"+ms+h);
            }
        }

        //diagonal paths..
        for(int ms=1;ms<=dc-sc && ms<=dr-sr;ms++){
            ArrayList<String>dpaths=getMazePaths(sr+ms, sc+ms, dr, dc);
            for (String d : dpaths) {
                res.add("d"+ms+d);
            }
        }
        return res;
    }

}
