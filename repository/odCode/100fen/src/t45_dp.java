import java.util.Scanner;

//最大报酬
//牛逼,看了01背包问题之后自己用动态规划迁移到本题做出来了
//01背包,状态为2:可选择的物品以及背包容量,
//dp[3][4]表示前3个物品进行选择,当背包容量是4时的最大价值是多少
//选择有放和不放
//dp[i][j]=max(dp[i-1][j],dp[i-1][j-weight[i-1]]]+weight[i])
//data base dp[0][]=0,dp[][0]=0

//此题相似:状态:工作的集合,工作时长 dp表示在目前集合下收获的最大报酬
//dp[i][j]=max(dp[i-1][j-time[i-1]]+time[i],dp[i-1][j])//选择,目前的加入到集合或者不加,决定了此时此刻的状态

public class t45_dp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int canTime = scanner.nextInt();//工作时长
        int works = scanner.nextInt();//待选工作数量
        int[][] arr = new int[works][2];//0存着消耗时长,1存着报酬
        //存进去数据先
        for (int i = 0; i < works; i++) {
            arr[i][0]=scanner.nextInt();//消耗时长
            arr[i][1]=scanner.nextInt();//消耗报酬
        }

        /*
        和01背包问题相似处
        01背包:
        状态:dp[i][j]前i个物品最小的j重量
        每一次都能选择要不要选择第i个物品
        dp[i][j]=min(dp[i-1][j](没选),dp[i-1][j-weight](选了))

         */

        //两个状态:一个是收获的工作报酬,以及工作时长
        //选择:选不选第i个物品
        int[][] dp = new int[works+1][canTime+1];//dp[3][4]表示的是在前3个工作能达到的最大报酬
        //        database
        //dp[0][]=0,没选的时候报酬是0,dp[][0],不工作报酬为0
        for (int i = 0; i <=canTime ; i++) {
            dp[0][canTime]=0;
        }
        for (int i = 0; i <= works; i++) {
            dp[i][0]=0;
        }

        //状态选择,外圈指选择的工作,内圈指所需的时间,针对每份巩固工作,有选和不选的区别,会对报酬有影响
        for (int i = 1; i <= works; i++) {
            //指给你多少劳动时间
            for (int j = 1; j <= canTime; j++) {
                if (j < arr[i - 1][0]) {
                    //如果给的劳动时间小于这份工作所需的时间
                    //不做选择,那么最大报酬就是做前i-1工作有的最大报酬
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i - 1][0]] + arr[i - 1][1]);
            }
        }
        System.out.println(dp[works][canTime]);
        //思路:选择时间最少的;时间一样的选择报酬最大的
        //也就是,符不符合贪心呢?兄弟们,最终的结果中,一定会有时间最少的吗?
        //极限法,有一个工作占满全部时间,但是其报酬是正无穷,是不是可以只选这个
        //所以时间最短的是不行的
        //那么,优先选那些报酬最大的,能在时间内完成的,行不行呢?
        //最终的结果中,会有吗?40分钟内,有一个40分钟赚400的.10分钟赚200的.15分钟赚300的
        //还是不行呀,35分钟内可转到500,如果选了一开始的400,就没有实现最大报酬
        //所以此题是不满足贪心的,想想暴力先


        //遍历所有可能的集合,需要用到回溯,鸡巴的,不会啊
//        int res=0;//一开始的报酬
       /* for (int i = 0; i < works; i++) {
            //如果消耗时长大于工作时长
            if(arr[i][0]>canTime){
                continue;//选择下一个
            }
            //在选了第一个的情况下,遍历
            for (int j = i+1; j < works; j++) {

            }
        }*/

    }
}
