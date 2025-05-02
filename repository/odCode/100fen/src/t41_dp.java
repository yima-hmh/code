import java.util.Arrays;
import java.util.Scanner;
//找终点
/*
题目描述
给定一个正整数数组，设为nums，最大为100个成员，求从第一个成员开始，正好走到数组最后一个成员，所使用的最少步骤数。要求:
1、第一步必须从第一元素开始，且1<=第一步的步长<len/2;(len为数组的长度，需要自行解析)。
2、从第二步开始，只能以所在成员的数字走相应的步数，不能多也不能少,如果目标不可达返回-1，只输出最少的步骤数量。
3、只能向数组的尾部走，不能往回走。
输入描述
由正整数组成的数组，以空格分隔， 数组长度 小于100，请自行解析数据数量。
输出描述
正整数，表示最少的步数，如果不存在输出-1

示例1
输入
7 5 9 4 2 6 8 3 5 4 3 9
输出
2
说明
第一步:第一个可选步长选择2，从第一个成员7开始走2步，到达9;第二步:从9开始，经过自身数字9对应的9个成员到最后。


示例2
输入
1 2 3 7 1 5 9 3 2 1
输出
-1
 */
public class t41_dp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ////获取数组
        String[] strings = scanner.nextLine().split(" ");
        int n = strings.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(strings[i]);
        }
        //降低时间复杂度,走到某个位置能不能走到最后,用一个表记录
        //动态规划得了,遍历所有状态,然后写状态转移方程
        int[] dp = new int[n];//dp的定义是到每个位置i的最小步数
        Arrays.fill(dp,Integer.MAX_VALUE);
        //初始化data base
        for (int i = 1; i < n/2; i++) {
            dp[i]=1;
        }
        dp[0]=0;
        //写状态转移方程
        for (int i = 1; i < n ; i++) {
            if(i+arr[i]>=n){
                continue;
            }
            //状态转移方程
            //这里的选择是选择用,还是不该点跳
            dp[i+arr[i]]=Math.min(dp[i+arr[i]],dp[i]+1);
        }
        if(dp[n-1]==Integer.MAX_VALUE){
            System.out.println(-1);
        }else System.out.println(dp[n-1]);

        /*
        --------------------------------------         暴力解法
        //一开始走几步,能达到最小值
        int min_bushu=Integer.MAX_VALUE;
        boolean reach=false;
        for (int i = 1; i < n/2; i++) {
            int bushu=1;//初始化时走了
            reach=false;
            for (int j = i+arr[i]; j < n; j+=arr[j]) {
                bushu++;
                //如果有一个时刻相等,说明到最后了
                if(arr[j]==arr[n-1]){
                    reach=true;//如果能达到最后一个
                    break;
                }
            }
            //如果可达,说明开始时这个i是可以的,比较存最小部署
            if(reach){
                min_bushu=Math.min(min_bushu,bushu);
            }
        }
        if(min_bushu==Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(min_bushu);
        */

    }
}
