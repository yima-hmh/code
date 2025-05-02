import java.util.Scanner;

// 分披萨,未完成
public class t12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//读取披萨块数量,必定为奇数
        int[] pishas=new int[n];
        //读取披萨块的大小
        for (int i = 0; i < n; i++) {
            pishas[i]=scanner.nextInt();
        }
        System.out.println(maxfuckereat(pishas));
    }
    private static int maxfuckereat(int[]pishas){
        //求最大值题目,你懂的,就是在迭代中找到最大值,动态规划常见操作
        int res=Integer.MIN_VALUE;

        int n=pishas.length;

        //dp[i][j]表示从i到j的吃的最大
        int[][]dp=new int[n][n];
        //data base
        for (int i = 0; i < n; i++) {
            dp[i][i]=pishas[i];
        }

        //计算dp数组
        for (int length=2;length<=n;length++){
            for (int i = 0; i < n; i++) {
                //计算环形数组中的结束位置
                int j=(i+length-1)%n;
                //选择开始或结束位置,计算最大值
//                dp[i][j]=Math.max(dp[(i+2)%n][j],)


            }
        }

        return res;
    }
}