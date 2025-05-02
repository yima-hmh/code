import java.util.*;

//第k个排列,回溯算法
public class t10 {
    public static ArrayList<String> res=new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//从1到n的整数,进行排列
        int k = scanner.nextInt();//返回第k个数就行
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(n,track);
        System.out.println(res.get(k-1));
    }


    //回溯算法先把其全排列全部求出来
    private static void backTrack(int n,LinkedList<Integer> track){
        //临界条件
        if(track.size()==n){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < track.size(); i++) {
                sb.append(track.get(i));
            }
//            System.out.println(sb.toString());
            res.add(sb.toString());
            return;
        }
        //路径记录已经走过的数据
        for (int i = 1; i <= n; i++) {
            //选择列表隐化,路径中没有的就是选择
            if(track.contains(i))
                continue;
            //路径,树枝
            track.add(i);
            backTrack(n,track);
            track.removeLast();
        }
    }
}
