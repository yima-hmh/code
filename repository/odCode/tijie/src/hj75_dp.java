import java.util.Scanner;

public class hj75_dp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            //输入两个字符串
            String str1=scanner.nextLine();
            String str2=scanner.nextLine();
            //转化为字符数组
            char[] c1 = str1.toCharArray();
            char[] c2 = str2.toCharArray();
            //构建dp数组,初始值就是默认为0的,base case,dp有效值是1-12,dp[i][j]表示到目前位置有多少个连续多少个已经相等了
            int[][]dp=new int[c1.length+1][c2.length+1];
            //现在是求最大值问题,所以需要一个值记录,初始化为0,这是常见套路
            int res=0;
            //状态转移,自底向上迭代
            for (int i = 1; i <= c1.length; i++) {
                for (int j = 1; j <= c2.length; j++) {
                    //逐一比较每个字符, ij初始化为1解决潜在溢出问题
                    if(c1[i-1]==c2[j-1]){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else {
                        dp[i][j]=0;
                    }
                    res=Math.max(dp[i][j],res);
                }
            }
            System.out.println(res);
        }

        //状态转移

        //求最值
    }
}
