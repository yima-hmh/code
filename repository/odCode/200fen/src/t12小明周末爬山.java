import java.util.LinkedList;
import java.util.Scanner;

//小明周末爬山
public class t12小明周末爬山 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();//地图的行
        int n = scanner.nextInt();//地图的列
        int k = scanner.nextInt();//每次爬山或下山高度差的最大值

        int[][] ditu = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ditu[i][j] = scanner.nextInt();
            }
        }

        int[] result = bfs(m, n, k, ditu);
        System.out.println(result[0] + " " + result[1]);
    }

    static int[] bfs(int m, int n, int k, int[][] ditu) {
        //经典上下左右
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        //记录已经访问过的位置
        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]> queue = new LinkedList<>();
        //queue中三个数表示x,y,以及step
        queue.offer(new int[]{0, 0, 0});//左上角开始bfs
        visited[0][0] = true;
        int highestPeak = 0;
        int shortestSteps = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int steps = poll[2];
            int currentHeight = ditu[x][y];
            // 如果到达更高的峰或到达同样高度的峰但步数更小
            if (currentHeight > highestPeak || (currentHeight == highestPeak && steps < shortestSteps)) {
                highestPeak = currentHeight;
                shortestSteps = steps;
            }

            for (int i = 0; i < 4; i++) {
                int curx = x + dir[i][0];
                int cury = y + dir[i][1];
                //疯狂叠甲:坐标不越界,高度差不超过k,没有访问过
                //为什么要没有访问过呢我请问
                //乃是因为访问过的都将加入到队列中进行它附近的bfs
                //所以已经访问过得就不要再重新加入到队列中了
                if (curx >= 0 && curx < m && cury >= 0 && cury < n && Math.abs(currentHeight - ditu[curx][cury] ) <= k && visited[curx][cury] == false) {
                    visited[curx][cury] = true;
                    queue.offer(new int[]{curx, cury, steps+1});
                }
            }
        }
        return new int[]{highestPeak, shortestSteps};
    }
}
