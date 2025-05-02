import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//斗地主顺子
public class t11 {
    static String[] arr={"3","4","5","6","7","8","9","10","J","Q","K","A"};
    //获取牌的索引
    static int getID(String now){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(now)){
                return i;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //读入获取的13张牌
        String[] cards = scanner.nextLine().split(" ");

        //整理好所有的牌,关键一部,整理好牌
        int[]ordercard=new int[arr.length];
        for (String card : cards) {
            int id = getID(card);
            if(id!=-1){
                ordercard[id]++;
            }
        }


        boolean exist=false;//存不存在顺子
        //开始遍历,查看是否有五张连续的牌
        //j自始至终表示增长

        for (int i = 0; i <=arr.length-5; i++) {
            //从i开始,是否有五张连续的牌
            boolean lianxu=true;//假设存在
            List<String> combination = new ArrayList<>();
            for (int j = 0; j <5; j++) {
                if(ordercard[i+j]==0){
                    lianxu=false;
                    break;
                }
            }
            if(lianxu){
                for (int j = 0; j < 20; j++) {
                    if(i+j>=arr.length||ordercard[i+j]==0){
                        break;
                    }
                    ordercard[i+j]--;//对应牌减少一张
                    combination.add(arr[i+j]);
                }
                //打印找到的顺子
                System.out.println(String.join(" ",combination));
                exist=true;
            }
        }
        if(!exist){
            System.out.println("No");
        }
    }
}
