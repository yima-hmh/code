import java.util.Scanner;

//光伏场地建设规划
public class t17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chang=scanner.nextInt();
        int kuan=scanner.nextInt();
        int bianchang=scanner.nextInt();
        int power=scanner.nextInt();
        //读入发电量矩阵数组
        int[][] arr=new int[chang][kuan];
        for (int i = 0; i < chang; i++) {
            for (int j = 0; j < kuan; j++) {
               arr[i][j]=scanner.nextInt();
            }
        }

        //算总数问题,你懂的
        int count=0;
        //遍历所有可能的电站位置,满足条件的,count++
        //建设正方形电站的边长是起始点
        int sum=0;
        for (int i = 0; i <=chang-bianchang ; i++) {
            for (int j = 0; j <=kuan-bianchang ; j++) {
                sum=0;
                //计算电站区域内的总发电量
                for (int k = 0; k <bianchang ; k++) {
                    for (int l = 0; l < bianchang; l++) {
                        sum+=arr[i+k][j+l];
                    }
                }
                if(sum>=power) count++;
            }
        }
        System.out.println(count);
    }

}
