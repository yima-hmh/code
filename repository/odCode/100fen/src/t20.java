import java.util.Scanner;

//计算面积
//计算面积,傻逼题目,垃圾华为连他妈题意都表述不清楚
//还他妈把自己当作中国的救世主呢,吃屎吧
//不是斜的,永远平行于x轴的意思,草泥马的我还以为是斜的,废物题
public class t20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//一共n个点
        int e = scanner.nextInt();//x的坐标一直到e
        //初始化存储绘图指令的数组,并添加起点(0,0)
        int[][] arr = new int[n + 2][2];
        arr[0][0] = 0;
        arr[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            arr[i][0]=x;
            arr[i][1]=y;
        }
        //添加终点
        arr[n+1][0]=e;
        arr[n+1][1]=0;

        //计算面积
        int m=arr.length;//一直到n+1
        int y=0;//当前纵坐标偏移
        long res=0;//保存面积
        for (int i = 1; i < m; i++) {
            int dx = arr[i][0];
            int dy = arr[i][1];
            //计算面积
            res+=(long)Math.abs(y)*(dx-arr[i-1][0]);
            y+=dy;
        }
        System.out.println(res);
    }
}
