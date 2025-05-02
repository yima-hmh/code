import java.util.Scanner;

//矩形相交的面积
public class t24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //读入三个坐标
        int[][] arr = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j]=scanner.nextInt();
            }
        }

        //得想办法获取右上角和左下角坐标[x1,y1],[x2,y2]
        int[][] betterarr=new int[3][4];

        for (int i = 0; i < 3; i++) {
            betterarr[i][0]=arr[i][0]+arr[i][2];//x1....y1不变
            betterarr[i][1]=arr[i][1];
            betterarr[i][2]=arr[i][0];//x2=x1;
            betterarr[i][3]=arr[i][1]-arr[i][3];//y2
        }

        //获取重叠区的长和高
        //右上角坐标最小x-左下角最大x
//        System.out.println(Math.min(betterarr[0][0],Math.min(betterarr[1][0],betterarr[2][0])));
//        System.out.println(Math.max(betterarr[0][2],Math.max(betterarr[1][2],betterarr[2][2])));
        int x=Math.max(0,Math.min(betterarr[0][0],Math.min(betterarr[1][0],betterarr[2][0]))-Math.max(betterarr[0][2],Math.max(betterarr[1][2],betterarr[2][2])));
        //右上角最小y-左下角最大y
        int y=Math.max(0,Math.min(betterarr[0][1],Math.min(betterarr[1][1],betterarr[2][1]))-Math.max(betterarr[0][3],Math.max(betterarr[1][3],betterarr[2][3])));
        // 重叠时的面积
        System.out.println((x*y));

    }
}
