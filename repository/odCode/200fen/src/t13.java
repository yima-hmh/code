import java.util.Scanner;

//学生方阵
public class t13 {
    private static int maxCount = 0;
    //只计水平,垂直,对角线,反对角线上的长度,待会但凡有重复的都不计数
    private static final int[][] dir = new int[][]{{0,1},{1,0},{1,1},{1,-1}};//这个设置也很重要,都是正向延申的

    private static boolean isOk(int x, int y, int n, int m) {
        if (x >= 0 && x < n && y >= 0 && y < m) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//矩阵的行数
        int m = scanner.nextInt();//矩阵的列数
        scanner.nextLine();
        //用0表示妹子,1表示男孩
        int[][] map = new int[n][m];//map表示了矩阵中男女学生的数量
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(",");
            for (int j = 0; j < m; j++) {
                if (split[j].equals("M")) {
                    map[i][j] = 1;
                }
            }
        }
        scanner.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]==0)continue;
                //碰到一个男学生.进入判断其上下左右的情况
                for (int k = 0; k < 4; k++) {

                    //充当了访问没访问的作用
                    //这样做的目的是为了防止重复计数。如果前一个位置也是男生，那么当前位置的男生已经被计算过，因此不需要再次计数。我们只对从女生到男生的转变或者矩阵边缘的起始位置的男生进行计数。
                    int prex=i-dir[k][0];
                    int prey=j-dir[k][1];
                    if(isOk(prex,prey,n,m)&&map[prex][prey]==1){
                        continue;
                    }

                    int count=1;
                    int curx=i+dir[k][0];
                    int cury=i+dir[k][1];
                    while (isOk(curx,cury,n,m)&&map[curx][cury]==1){
                        count++;
                        curx+=dir[k][0];
                        cury+=dir[k][1];
                    }
                    maxCount=Math.max(maxCount,count);
                }
            }
        }
        System.out.println(maxCount);
    }
}
