import java.util.ArrayList;
//if n is the length of the string then the number of subsequence will be 2^n//
public class Subsequnce{
    public static void main(String[] args) {
        String s="abcd";
        ArrayList<String>ans=getSubSequence(s);
        System.out.println(ans);

    }
    public static ArrayList getSubSequence(String s){
        //base case 

        if(s.length()==0){
            ArrayList<String>bres=new ArrayList<>();
            bres.add("");
           return bres;
        }

        //faith is that if abc is the string then the function getSubSequence(String s) will give me all the subsequence of "bc"...
        //and after that we will simply add a and "" in the function and return it.
        //ros=rest of string..
        //ssres= result of subseqeunce of substring 
        char ch=s.charAt(0);
        String ros=s.substring(1);
        ArrayList<String>ssres=getSubSequence(ros);
        ArrayList<String>mres=new ArrayList<>();
        for(String rstr:ssres){
            mres.add(""+rstr);
        }
        for(String rstr:ssres){
            mres.add(ch+rstr);
        }
        return mres;
    }
}