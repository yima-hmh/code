import java.util.Scanner;
//通过软盘拷贝文件
//求最多文件总大小
/*
我没有看出来这是一个01背包问题
背包的容量确定 对应软盘
每个袋子的重量和价值      对应文件的大小
装最多的东西   对应文件的大小最大化
那么回想01背包
两个状态:选择是选或者不选
状态转移方程:
dp[i][j]=max(dp[i-1][j]+dp[i-1][j-size(i-1)]+size(i-1)
 */
public class t10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();//文件数量
        int[] fileSizes=new int[n];
        for (int i = 0; i < n; i++) {
            fileSizes[i]=scanner.nextInt();
        }
        //总大小不会超过1474560字节
        //dp[i][j]表示第i个时第j块时,最多能拷贝的文件总大小
        int total=1474560;
        //这里需要转换一下硬盘块数,因为是根据硬盘块数进行分配的
        int totalKal=1474560/512;
        int[][]dp=new int[n+1][totalKal+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= totalKal; j++) {
                int blocksNeeded = (int) Math.ceil((double)fileSizes[i - 1]/512);
                if(j<blocksNeeded){
                    dp[i][j]=dp[i-1][j];//如果容量不够,就只能搞搞前面的小九九
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-blocksNeeded]+ fileSizes[i-1]);
                }
            }
        }
        System.out.println(dp[n][totalKal]);
    }
}
