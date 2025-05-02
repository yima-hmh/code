import java.util.Scanner;

//机器人活动区域

//dfs深度优先:一般遍历
public class t5 {
    static int n,m;
    static int[][] arr;
    static boolean[][] vis;

    //四个方向:
    static int[]dx={-1,1,0,0};
    static int[]dy={0,0,-1,1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();//行数
        n = scanner.nextInt();//列数
        vis=new boolean[m][n];
        //处理数据
        arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j]=scanner.nextInt();
            }
        }

        //求可以移动的最大范围
        int res=0;
        //暴力解法
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!vis[i][j]){
                    res=Math.max(res,dfs(i,j));
                }
            }
        }
        System.out.println(res);
    }


    //从某个位置开始的能经过的网格点数目,这是深度优先
    static int dfs(int x,int y){
        vis[x][y]=true;
        int now=1;
        //遍历四个方向的邻居网络
        for (int i = 0; i < 4; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            //检查邻居网络是否在边界内且未被访问
            if(nx>=0&&nx<m&&ny>=0&&ny<n&&!vis[nx][ny]){
                //检查邻居网格和当前网格差值是否小于等于1
                if(Math.abs(arr[nx][ny]-arr[x][y])<=1){
                    now+=dfs(nx,ny);
                }
            }
        }
        return now;
    }

}
