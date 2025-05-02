import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//跳格子三
public class t9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//格子数量
//        n++;
        int[] scores=new int[n];
        for (int i = 0; i < n; i++) {
            scores[i]=scanner.nextInt();
        }
        //最大步长
        int step=scanner.nextInt();
        //好像是一道很简单的动态规划啊
        int[]dp=new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);

        //base case
        dp[0]=0;

        //遍历所有可能的步长,返回最大的那个
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <step&&j<i; j++) {
                dp[i]= Math.max(dp[i-j-1]+scores[i-1],dp[i]);
            }
        }

        System.out.println(dp[n]);
    }
}
