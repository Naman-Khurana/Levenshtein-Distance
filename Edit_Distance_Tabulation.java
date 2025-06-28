public class Edit_Distance_Tabulation {
    private static int tabulation(String s1,String s2){
        char[] str1=s1.toCharArray();
        char[] str2=s2.toCharArray();
        int m=str1.length;
        int n=str2.length;
        int[][] dp =new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=i;

        }
        for(int j=0;j<=n;j++){
            dp[0][j]=j;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1[i-1]==str2[j-1]){
                    dp[i][j]=0 + dp[i-1][j-1];

                }else{
                    dp[i][j]=1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }

        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        System.out.println("The no of operations needed to convert Levenshtein to Lavenstaein are : " +  tabulation("Levenshtein","Lavenstaein"));
        System.out.println("The no of operations needed to convert TryHackMe to TriHackingMe are : " +  tabulation("TryHackMe","TriHackingMe"));
        System.out.println("The no of operations needed to convert Optimization to Progressive are : " +  tabulation("Optimization","Progressive"));
        System.out.println("The no of operations needed to convert This is easy to This is easy are : " +  tabulation("This is easy","This is easy"));
    }
}
