import java.util.*;
public class GenerateString {
    public static void main(String[] args) {
        List<String> ans=generateString(4);
        System.out.println(ans);
    }
    public static List<String> generateString(int N) {
        List<String> ans = new ArrayList<>();
        helper("", N, ans);
        return ans;
    }
    private static void helper(String s, int n, List<String> ans) {
        if (s.length() == n) {
            ans.add(s);
            return;
        }
        // If the last character of the string is '1', we can only append '0'.
        if (s.length() == 0 || s.charAt(s.length() - 1) == '0') {
            helper(s + '0', n, ans);
            helper(s + '1', n, ans);
        } else {
            helper(s + '0', n, ans);
        }
    }

}




