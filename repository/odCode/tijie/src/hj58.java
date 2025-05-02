import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class hj58 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int val=in.nextInt();
        ArrayList<Integer> work=new ArrayList();
        for (int i = 0; i < n; i++) {
            work.add(in.nextInt());
        }
        //首先,排序
        work.sort(Comparator.naturalOrder());
        for (int i = 0; i < val; i++) {
            System.out.print(work.get(i));
        }

    }
}