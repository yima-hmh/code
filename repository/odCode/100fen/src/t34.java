import java.util.ArrayList;
import java.util.Scanner;

//数组拼接
/*
题目描述
现在有多组整数数组，需要将它们合并成一个新的数组。合并规则，从每个数组里按顺序取出固定长度的内容合并到新的数组中，取完的内容会删除掉，如果该行不足固定
长度或者已经为空，则直接取出剩余部分的内容放到新的数组中，继续下一行。
输入描述
第一行是每次读取的固定长度，0<长度<10
第二行是整数数组的数目，0<数目<1000
第3-n行是需要合并的数组， 不同的 数组用回车换行分隔，数组内部用逗号分隔，最大不超过100个元素。
输出描述
输出一个新的数组，用逗号分隔。
示例 1
输入
3
2
2,5,6,7,9,5,7
1,7,4,3,4

输出
2,5,6,1,7,4,7,9,5,3,4,7

说明
1、获得长度3和数组数目2。
2、先遍历第一行，获得2,5,6;
3、再遍历第二行，获得1,7,4;
4、再循环回到第一行，获得7,9,5;
5、再遍历第二行，获得3,4;
6、再回到第一行，获得7，按顺序拼接成最终结果。
 */
public class t34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k=scanner.nextInt();
        int n=scanner.nextInt();
        scanner.nextLine();
        //处理得到所有的数据
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(",");
            ArrayList<Integer> job = new ArrayList<>();
            for (int j = 0; j < split.length; j++) {
                job.add(Integer.parseInt(split[j]));
            }
            list.add(job);
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!list.isEmpty()){
            //每次进行list.size轮的遍历
            for (int i = 0; i < list.size(); i++) {
                //添加k个
                if(!list.get(i).isEmpty()){
                    //循环k次,取k个头数
                    for (int j = 0; j < k&&!list.get(i).isEmpty(); j++) {
                        res.add(list.get(i).get(0));
                        list.get(i).remove(0);
                    }
                }
            }
            //检查list,有空的就去掉,确保遍历的时候都是非空集合
            list.removeIf(ArrayList::isEmpty);
        }

        //输出
        for (int i = 0; i < res.size(); i++) {
            if(i<res.size()-1){
                System.out.print(res.get(i)+",");
            }else
            System.out.println(res.get(i));
        }
    }
}
