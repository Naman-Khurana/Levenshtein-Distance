import java.util.Arrays;

public class Edit_Distance_Memoization {
    public static int mainFunction(String word1, String word2) {
        int m=word1.length();
        int n = word2.length();
        int[][] dp=new int[m+1][n+1];

        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        return rec(m-1,n-1,word1.toCharArray(),word2.toCharArray(),dp);
    }
    private static int rec(int ind1,int ind2,char[] arr1, char[] arr2,int[][] dp){
        if(dp[ind1+1][ind2+1]!=-1)
            return dp[ind1+1][ind2+1];
        if(ind1<0){
            return ind2 +1;
        }
        if(ind2<0){
            return ind1+1;
        }
        if(arr1[ind1]==arr2[ind2])
            return dp[ind1+1][ind2+1]=0+ rec(ind1-1,ind2-1,arr1,arr2,dp);
        int replace= 1+ rec(ind1-1,ind2-1,arr1,arr2,dp);
        int insert=1+rec(ind1,ind2-1,arr1,arr2,dp);
        int delete=1+rec(ind1-1,ind2,arr1,arr2,dp);
        return dp[ind1+1][ind2+1]=Math.min(replace,Math.min(insert,delete));
    }

    public static void main(String[] args) {
        System.out.println("The no of operations needed to convert Levenshtein to Lavenstaein are : " +  mainFunction("Levenshtein","Lavenstaein"));
        System.out.println("The no of operations needed to convert TryHackMe to TriHackingMe are : " +  mainFunction("TryHackMe","TriHackingMe"));
        System.out.println("The no of operations needed to convert Optimization to Progressive are : " +  mainFunction("Optimization","Progressive"));
        System.out.println("The no of operations needed to convert This is easy to This is easy are : " +  mainFunction("This is easy","This is easy"));
    }
}
