import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//计算某个网格的信号
public class t6 {
    public static void main(String[] args) {
        //处理输入
        Scanner scanner = new Scanner(System.in);
        //行
        int n = scanner.nextInt();
        //列
        int m= scanner.nextInt();
        int[][] arr = new int[n][m];//这个存情况
        int[][] dis = new int[n][m];//这个存信号值
        Queue<int[]> queue = new LinkedList<>();

        //dfs需要起点,也就是信号值,在这里信号值只有一个,减去最短路径即可,此题简单
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
                if (arr[i][j] > 0) {
                    queue.offer(new int[]{i, j});//信号源加入队列
                    dis[i][j] = arr[i][j];//初始化信号源的信号值
                }
            }
        }

        //要计算的某个网格的值
        //需要通过信号值,计算出所有位置的信号值,然后返回x,y的
        int ex = scanner.nextInt();
        int ey = scanner.nextInt();

        //方向数组,上下左右四个方向
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        //信号源只有一个,障碍物有0个或者多个
        /*
        良心的平静才是最重要的
        尽管平静久了就会渴望喧嚣
        但其确实是最重要的
         */

        //使用bfs来传播信号
        while (!queue.isEmpty()) {
            //这里没有统计队列的长度,无法计算最短路径,但是此题只需要确保能够遍历完所有的结点就可以了,就像二叉树的层序遍历,也不需要统计队列的长度,只有那些要求统计最短路径的,需要队列长度
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                //检查边界
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                //检查阻隔物品
                if (arr[nx][ny] == -1) continue;

                int ndis = dis[x][y] - 1;
                if (ndis > 0 && dis[nx][ny] < ndis) {
                    //更新信号值
                    dis[nx][ny] = ndis;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        System.out.println(dis[ex][ey]);
    }
}
