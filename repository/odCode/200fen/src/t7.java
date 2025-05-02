import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//计算疫情扩散时间
public class t7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int n=(int)Math.sqrt(split.length);
        int[][] arr = new int[n][n];//地图
        //dfs算法需要记录下来所有为1的坐标,然后上下左右搜索
        Queue<int[]> queue = new LinkedList<>();
        int id=0,count=0;//id用来遍历split,count用来统计0的个数

        //填充地图并且统计未感染区域(0)的数量
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(split[id++]);
                //将第0天感染的全部加入到队列中
                if (arr[i][j] == 1) {
                    // 队列中记一下是第几天感染的
                    queue.add(new int[]{i, j,0});
                }else {
                    count++;
                }
            }
        }
        //如果没有未感染区域或者全是未感染区域
        if(count==0||count==n*n){
            System.out.println(-1);
            return;
        }

        //目标是将整个表扩散需要几步
        //方向数组,上下左右四个方向
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
        int maxDays=0;//返回这个

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int x=poll[0];
            int y=poll[1];
            int day=poll[2];
            maxDays=Math.max(maxDays,day);
            //扩充四个方向
            for (int i = 0; i < 4 ; i++) {
                int curx=x+dir[i][0];
                int cury=y+dir[i][1];
                //判断条件,能不能加入队列就是这么帅
                if(curx>=0&&curx<n&&cury>=0&&cury<n&&arr[curx][cury]==0){
                    queue.add(new int[]{curx,cury,day+1});
                    arr[curx][cury]=1;//这一个地方已经被污染了;
                }
            }
        }
        System.out.println(maxDays);
    }
}
