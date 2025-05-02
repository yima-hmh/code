import java.util.ArrayList;
import java.util.Scanner;

//构成的正方形数量
public class t16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int zuobiaoshuliang = scanner.nextInt();
        //获取坐标
        ArrayList<int[]> a1 = new ArrayList<>();
        int x=0,y=0;
        for (int i = 0; i < zuobiaoshuliang; i++) {
            x=scanner.nextInt();
            y=scanner.nextInt();
            a1.add(new int[]{x,y});
        }

        //创建一个列表存储所有可能的线段,由两个点组成
        ArrayList<int[]> a2 = new ArrayList<>();
        for (int i = 0; i < zuobiaoshuliang; i++) {
            for (int j = i+1; j <zuobiaoshuliang ; j++) {
                int a=a1.get(i)[0];//第一个坐标的x
                int b=a1.get(i)[1];//第一个坐标的y
                int c=a1.get(j)[0];//第二个坐标的x
                int d=a1.get(j)[1];//第二个坐标的y
                a2.add(new int[]{a,b,c,d});
            }
        }

        //统计满足条件的矩形数量
        int count=0;
        int n=a2.size();//线段数量

        //枚举所有线段对
        //核心思想就是,此题是找能构成正方形的四个点,
        // 所有组成的线段中,按如下顺序找相交垂直对角线
        //对象线
            //没有共同端点
            //中点相同
        //长度相同
        //垂直

        for (int i = 0; i < n; i++) {
            int[] rec1 = a2.get(i);//第一条线段
            int x1=rec1[0],y1=rec1[1],x2=rec1[2],y2=rec1[3];
            for (int j = i+1; j <n ; j++) {
                int[] rec2 = a2.get(j);//第二条线段
                //线段2的两个端点的端点值
                int x3=rec2[0],y3=rec2[1],x4=rec2[2],y4=rec2[3];

                //筛选出没有共同端点的线段
                if((x1==x3&&y1==y3)||(x1==x4&&y1==y4)||(x2==x3&&y2==y3)||(x2==x4&&y2==y4)){
                    continue;
                }

                //没有共同端点,那么是否中点相等
                if((x1+x2!=x3+x4)||(y1+y2!=y3+y4)){
                    continue;
                }

                //长度相等才行,长度不相等直接淘汰
                if(((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1))!=((y4-y3)*(y4-y3)+(x4-x3)*(x4-x3))){
                    continue;
                }

                //筛选出垂直
                if((x2-x1)*(x4-x3)+(y2-y1)*(y4-y3)==0){
                    count++;
                }
            }

        }

        System.out.println(count);
    }
}
