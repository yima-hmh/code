import java.util.Scanner;

//分糖果
public class t13_dp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//取出的糖果数
        //具有递归问题的特征吗?
        //有的,原问题的解求助于子问题
        //用记忆化
        int[] memo = new int[n+1];
        System.out.println(dp(memo,n));
    }
    //这个函数返回多少次

    static int dp(int[]memo,int n){
        //如果手里只有一个,直接返回0
        if(n==1){
            return 0;
        }
        if(memo[n]!=0) return memo[n];
        //如果是奇数
        if((n&1)==1){
            memo[n]=2+Math.min(dp(memo,(n+1)/2),dp(memo,(n-1)/2));
        }
        else memo[n]=1+dp(memo,n/2);
        return memo[n];


        //原做法
        /*//一直能被2整除的情况不用递归,判断是不是2的次方
        int temp=n;
        if(temp%2==0&&temp%4==0&&temp%8==0&&memo[temp]==0){
            int count=0;
            while (temp!=1){
                count++;
                temp/=2;
            }
            memo[n]=count;
        }
        //如果不是的话,就按照这个递推式地推,为什么不对呢
        memo[n]=Math.min(1+dp(memo,n-1),1+dp(memo,n+1));*/
    }
}
