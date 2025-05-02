import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Scanner;

/*
似乎是01背包问题
客户预算=背包总容量
售价和获得的条数=分重量和收获
最多条数=总量最大
 */
public class yunduanxin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();//用户预算
        scanner.nextLine();
        String[] s = scanner.nextLine().split(" ");
        int[]size=new int[s.length];
        for (int i = 0; i < s.length; i++) {
            size[i]=Integer.parseInt(s[i]);
        }
        //dp[5][6]表示在预算为6的情况下,在5种商品种获得的最大收益
        int[][] dp = new int[s.length+1][M+1];
        //base case默认
        //状态转移

        //i表示商品数,顺便也是商品的代价
        for (int i = 1; i <= s.length; i++) {
            //j表示客户预算
            for (int j = 1; j <= M; j++) {
                if(j<i){
                    //预算不足,没法选,收获的就是上一个商品的收获
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-i]+size[i-1]);
                }
            }
        }
        System.out.println(dp[s.length][M]);
    }
}
