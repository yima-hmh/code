import java.util.Scanner;
/*
判断是否有连续张牌的和等于m的倍数,也就是可以整除m
一个很自然的想法,那就是获取所有可能的子数组,判断其和是否是m的倍数

应该建立的条件反射
1.利用前缀和来获取任意子数组的和
 */
public class t23数字游戏 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();//后续的牌数
        int m=scanner.nextInt();//m代表发给小明牌上的数字
        int[]arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=scanner.nextInt();
        }


        int[] arrPreSum = new int[n + 1];

        for (int i = 1; i <= n ; i++) {
            arrPreSum[i]=arrPreSum[i-1]+arr[i-1];
            for (int j = 0; j < i; j++) {
                int sum=arrPreSum[i]-arrPreSum[j];
                if(sum%m==0){
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);

    }
}
