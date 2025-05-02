import java.util.ArrayList;
import java.util.Scanner;
//跳房子:索引和对应的步数组合
//两步到最后一格
//做这道题是2024年9月29日半夜2:16分,心绪不宁,撸了一管,对着过去的荒唐,然后用得到的宁静继续做题
//今天必须把这剩下的那么几道题全部做完.
/*
题目描述
跳房子，也叫跳飞机，是一种世界性的儿童游戏。
游戏参与者需要分多个回合按顺序跳到第1格直到房子的最后一格。跳房子的过程中，可以向前跳，也可以向后跳。
假设房子的总格数是count，小红每回合可能连续跳的步数都放在数组steps中，请问数组中是否有一种步数的组合，可以让小红两个回合跳到最后一格?如果有，请输出索
引和最小的步数组合。
注意:数组中的步数可以重复，但数组中的元素不能重复使用。提供的数据保证存在满足题目要求的组合，且索引和最小的步数组合是唯一的。
输入描述
第一行输入为每回合可能连续跳的步数，它是int整数数组类型。实际字符串中整数与逗号间可能存在空格。
第二行输入为房子总格数count，它是int整数类型。
输出描述
返回索引和最小的满足要求的步数组合(顺序保持steps中原有顺序)
补充说明
count<=1000，0<=steps.length<=5000，-100000000<=steps[i]<=100000000
示例1
输入
[1,4,5,2,2]
7
输出
[5.2]


示例2
输入
[-1,2,4,9,6]
8
输出
[-1,9]
说明
此样例有多种组合满足两回合跳到最后，譬如:[-1,9]，[2,6]，其中[-1,9]的索引和为0+3=3,[2,6]的索引和为1+4=5，所以索引和最小的步数组合[-1,9]
 */
public class t36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] needDeal = scanner.nextLine().replace("[", "").replace("]", "").split(",");
        int n = needDeal.length;
        //获取所有的steps
        int[] steps = new int[n];
        for (int i = 0; i < n; i++) {
            steps[i] = Integer.parseInt(needDeal[i]);
        }

        //获取总格数
        int total = scanner.nextInt();

        //获取所有最小的
        /*
        不能不记录索引和最小,第一个答案索引和不一定是最小的,譬如0+9和2+3,当然是后一种比较小,所以需要记录索引
         */
        ArrayList<Integer> res = new ArrayList<>();
        //表示从i开始遍历
        //从小到大遍历,符合条件的时候,索引和一定是最小的呀
//        boolean need = true;
        int indexSum=Integer.MAX_VALUE;//索引和最小
        for (int i = 0; i < n; i++) {
            if (total - steps[i] <= 0) continue;
            //从后一个遍历,便保证了不会取到一个取过的数
            for (int j = i+1; j < n; j++) {
                if (steps[i] + steps[j] == total) {
                    if(i+j<indexSum){
                        indexSum=i+j;//寻找索引最小和
                        res.add(0,steps[i]);//修改两个位置的值
                        res.add(1,steps[j]);
                        break;//j要最小的嘛,所以j再加也没意义
                    }
                }
            }
        }
        if(res.size()==2){
            System.out.println("["+res.get(0)+","+res.get(1)+"]");
        }else System.out.println("ERROR");
    }
}
