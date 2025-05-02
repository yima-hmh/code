import java.util.*;

//boss的收入
/*
使用bfs
what presure make you?
 */
public class t2bossIn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//关系的总数量
        long[]fa=new long[100010];//记录每个分销的上级分销ID
        long[]money=new long[100010];//记录每个分销的收入
        Arrays.fill(fa,-1);
        List<Integer> in = new ArrayList<>(Collections.nCopies(100010, 0));//分销被定义成上级的次数
        HashSet<Integer> st = new HashSet<>();//分销ID
        for (int i = 0; i < n; i++) {
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            int z=scanner.nextInt();
            st.add(x);
            st.add(y);
            in.set(y,in.get(y)+1);//记录y被定义为上级的次数
            fa[x]=y;
            money[x]=z;
        }


        Queue<Integer> queue = new LinkedList<>();
        //找出第一个id没有下级分销的,也就是没有被当作过上级分销的ID
        for (Integer x : st) {
            if(in.get(x)==0){
                queue.offer(x);
            }
        }
        long ans=0;//boss收入
        int x=0;//boss ID


        //BFS从叶子结点往上收总有一个结点变得没有下游结点,加入到队列当中
        while (!queue.isEmpty()){
            x=queue.poll();
            ans=money[x];
            int y=(int) fa[x];//获取分销的上级ID
            if(y==-1) continue;
            //上级分销的下级数量减1
            in.set(y,in.get(y)-1);
            if(in.get(y)==0){
                queue.offer(y);
            }
            money[y]+=money[x]/100*15;
        }
        System.out.println(x+" "+ans);
    }
}
