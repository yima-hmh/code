import java.util.Scanner;

/*
we are a team

鸡巴并查集的题目
find函数:效率操作
merge函数:联通两个结点

 */
public class t21WeAreATeam {
    static int[] f;
    //查找x的团队的根节点
    static int find(int x){
        //根节点没有父结点,其指针指向自己
        while (f[x]!=x){
            f[x]=f[f[x]];
            x=f[x];
        }
        return f[x];
    }
    //合并两个结点
    static void merge(int x,int y){
        f[find(x)]=find(y);//将y的根节点连接到x的根节点上,从此就有了关系
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();//n个人
        int m=scanner.nextInt();//m条信息
        //检查n和m的合法性
        if(n<1||n>100000||m<1||m>100000){
            System.out.println("NULL");
            return;
        }

        //初始化并查集,f[i]表示第i个人所在的团队
        f=new int[n+1];
        for (int i = 1; i < n; i++) {
            //一开始的时候,所有人都是一颗单独的子树
            f[i]=i;
        }

        //开始处理每条信息
        for (int i = 0; i < m; i++) {
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            int c=scanner.nextInt();
            //检查abc的合法性
            if (a<1||a>n||b<1||b>n){
                System.out.println("da pian zi");
                continue;
            }
            if(c==0){
                //表示a和c有关系
                merge(f[a],f[b]);
            }else if(c==1){
                //需要判断是否在同一个队伍中,在同一个队伍中有一个特点,那就是有同一个根节点
                if(find(f[a])==find(f[b])){
                    System.out.println("We are a fuking team");
                }else{
                    System.out.println("We are not a team");
                }
            }else {
                System.out.println("da pian zi");
            }
        }
        scanner.close();
    }
}
