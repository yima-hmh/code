import java.util.*;

//报数游戏
//模拟题
public class t3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //获取输入的整数参数m
        int m = scanner.nextInt();
        if(m<=1||m>=100){
            System.out.println("ERROR");
            return;
        }
        //100个人排队是吧,那我就用队列模仿这个过程好了
        //100个人围成一圈，每个人有一个编码编号从一开始到一百。他们从一开始依次 报数 ，报道M的人自动退出圈圈，然后下一个人接着从1开始报数一直到剩余人数小于M。
        //请问最后剩余人在原先的编码为多少？

        //队列模拟编号
        ArrayDeque<Integer> human = new ArrayDeque<>();
        for (int i = 0; i < 100; i++) {
            human.add(i+1);
        }

        while(human.size()>m-1){
            for (int i = 0; i < m-1; i++) {
                //m个人对头出
                Integer poll = human.poll();//队头出
                human.add(poll);//队尾进
            }
            //第m个元素出队列
            human.poll();
        }
        ArrayList<Integer> arrayList = new ArrayList<>(human);
        Collections.sort(arrayList);
        for (int i = 0; i <m - 1; i++) {
            if(i!=m-2){
                System.out.print(arrayList.get(i)+",");
            }
            else System.out.println(arrayList.get(i));
        }
    }
}
