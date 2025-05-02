import java.util.Scanner;
//贪心的商人
//为什么能用贪心?
//能够赚的时候就allin
//item就是全部投入的
/*
题目描述
商人经营一家店铺，有number种商品，
由于仓库限制每件商品的最大持有数量是item[index]
每种商品的价格是item-price[item_index][day]
通过对商品的买进和卖出获取利润
请给出商人在days天内能获取的最大的利润
注：同一件商品可以反复买进和卖出
输入描述
3 第一行输入商品的数量number
3 第二行输入商品售货天数 days
4 5 6 第三行输入仓库限制每件商品的最大持有数量是item[index]
1 2 3 第一件商品每天的价格
4 3 2 第二件商品每天的价格
1 5 3 第三件商品每天的价格
输出描述
输出商人在这段时间内的最大利润
例如：32
 */
public class t35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();//商品的数量
        int days = scanner.nextInt();//商品售货天数
        //每件商品的最大持有数量
        int[] item = new int[number];
        for (int i = 0; i < number; i++) {
            item[i] = scanner.nextInt();
        }
        //每种商品每天的价格
        int[][] dayPrice = new int[number][days];
        for (int j = 0; j < number; j++) {
            for (int i = 0; i < days; i++) {
                dayPrice[j][i] = scanner.nextInt();
            }
        }
        /*
        此题如果要用动态规划来做
        dp[days][k][]
        */
        //用贪心
        int sum=0;
        //外面是指有那么多个商品都要算一次
        for (int i = 0; i < number; i++) {
            for (int j = 1; j < days; j++) {
                int diff=dayPrice[i][j]-dayPrice[i][j-1];
                //如果越来越贵
                if(diff>0){
                    //买入赚差价
                    sum+=item[i]*diff;
                }
            }
        }
        System.out.println(sum);

    }
}