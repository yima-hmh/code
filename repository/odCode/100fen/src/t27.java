import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//"流浪地球"
//这题目起个这样吊吊的名字以为能把自己搞得很难,结果就是一坨狗屎
//简单的模拟过程即可解决
//我们需要不羁编程,先把自己能想到的东西先写下来,然后再调试慢慢优化.
public class t27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int e = scanner.nextInt();
        int[][] shoudong = new int[e][2];
        for (int i = 0; i < e; i++) {
            shoudong[i][0]=scanner.nextInt();//发动机的手动启动时刻
            shoudong[i][1]=scanner.nextInt();//发动机的位置编号
        }

        //模拟启动过程,算出所有火箭的喷涌时间
        int[] huojian=new int[n];
        Arrays.fill(huojian,-1);//将火箭初始时间定为-1
        //初始化
        for (int i = 0; i < e; i++) {
            //发动机的位置编号的启动时刻初始化
            huojian[shoudong[i][1]]=shoudong[i][0];
        }
        //0时刻是一定会有发动机启动的,照样遍历,从这时候开始模拟点火过程
        for (int i = 0; i < n; i++) {
            //i表示时间,最多需要n-1秒所有火箭也就起飞了
            for (int j = 0; j <n ; j++) {
                //碰到手动0时刻启动了
                if(huojian[j]==i){
                    //临界为0,且未启动
                    if(j==0&&huojian[n-1]==-1){
                        huojian[n-1]=huojian[j]+1;
                    }
                    //左边的未启动
                    if(j!=0&&huojian[j-1]==-1){
                        huojian[j-1]=huojian[j]+1;
                    }
                    //临界为n-1
                    if(j==n-1&&huojian[0]==-1){
                        huojian[0]=huojian[j]+1;
                    }
                    //右边的未启动
                    if(j!=n-1&&huojian[j+1]==-1){
                        huojian[j+1]=huojian[j]+1;
                    }
                }
            }
        }
        //寻找火箭中最大值的编号
        int res=0;
        for (int i = 0; i < n; i++) {
            if(huojian[res]<=huojian[i]){
                res=i;
            }
        }
        ArrayList<Integer> bianhao = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(huojian[i]==huojian[res]){
                bianhao.add(i);
            }
        }
        System.out.println(bianhao.size());//最后发射的size
        bianhao.sort(Comparator.naturalOrder());
        for (int i = 0; i < bianhao.size(); i++) {
            System.out.print(bianhao.get(i)+" ");
        }
    }
}
