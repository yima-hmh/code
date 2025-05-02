import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class hj85 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //我将用动态规划解决此题
        String str=in.nextLine();
        System.out.println(GetMax(str));
    }

    static int GetMax(String str){
        //最值问题
        int res=1;

        char[] s= str.toCharArray();
        //dp[i][j]表示i到j是不是回文,赋值默认是false,长度从1到s.length

        boolean [][] dp=new boolean[s.length][s.length];
        //需要初始话base case,对角线上的都是回文
        for (int i = 0; i <s.length; i++) {
            dp[i][i]=true;
        }
        //自底向上遍历所有,填好这个二维数组,i和j的取值只要确定能够遍历完就行了
        for(int r=1; r<s.length;r++){
            for(int l=0;l<r;l++){
                if(s[l]==s[r]&&(r-l<2||dp[l+1][r-1]==true)){
                    dp[l][r]=true;
                    res=Math.max(r-l+1,res);
                }
            }
        }
        return res;
    }
}