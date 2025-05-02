import java.util.Scanner;

//补种胡杨:滑动窗口法
/*
题目描述
近些年来，我国防沙治沙取得显著成果。某沙漠新种植N棵胡杨(编号1-N)，排成一排。一个月后，有M棵胡杨未能成活。
现可补种胡杨K棵，请问如何补种(只能补种，不能新种)，可以得到最多的连续胡杨树?
输入描述
N 总种植数量
M 未成活胡杨数量
M 个空格分隔的数，按编号从小到大排列
K 最多可以补种的数量
其中:
1<=N<=100000
1<=M<=N
0<=K<=M
输出描述
最多的连续胡杨棵树
示例1
输入
5
2
2 4
1
输出
3
说明
补种到2或4结果一样，最多的连续胡杨棵树都是3

 */
public class t5 {
    //连续的胡杨树意味着它们在编号上是连续的，没有间断。
    //我们的目标是最大化连续胡杨树的数量，这意味着我们需要尽可能地将补种的胡杨树放在能够形成最大连续区域的位置。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //总种植数量
        int N=scanner.nextInt();
        //未成活胡杨数量
        int M=scanner.nextInt();
        //哪个位置死了数
        int[] dead=new int[M];
        int[] tree=new int[N];
        for (int i = 0; i < M; i++) {
            dead[i]=scanner.nextInt();
            tree[dead[i]-1]=1;//记录死的树为1
        }
        //可以补种的数量
        //滑动窗口大小是i-j+1;
        //不断更新大小就可以了
        int K=scanner.nextInt();

        int tot=0,res=0,j=0;
        for (int i = 0; i < N; i++) {
            tot+=tree[i];
            while (tot>K){
                tot-=tree[j];
                j+=1;
            }
            if(i-j+1>res) res=i-j+1;//这个是无论如何都会执行的,在没有触及边界之前,存了最大长度.
        }
        System.out.println(res);
    }
}
