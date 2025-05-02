import java.util.*;

//树状结构查询
//用dfs层次遍历就可以了
//如何建立一颗哈希树
public class t8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();//一共有n个结点
        scanner.nextLine();
        HashMap<String, ArrayList<String>> hm = new HashMap<>();

        //使用哈希表建树
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            if(!hm.containsKey(s[1])){
                ArrayList<String> arr = new ArrayList<>();
                arr.add(s[0]);
                hm.put(s[1],arr);
            }
            else hm.get(s[1]).add(s[0]);
        }
        //使用dfs排序
        LinkedList<String> queue = new LinkedList<>();
        queue.add(scanner.nextLine());//开始的元素

        ArrayList<String> res = new ArrayList<>();

        //简单的dfs
        while(!queue.isEmpty()){
            String poll = queue.poll();
            if(hm.containsKey(poll)){
                for (String s : hm.get(poll)) {
                    res.add(s);
                    queue.offer(s);
                }
            }
        }

        //将结果按字典排序输出
        res.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
        return;
    }
}
