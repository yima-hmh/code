import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//高矮个子排队/
public class t14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //标志位检查是否包含非法字符
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=' '&&s.charAt(i)<'0'&&s.charAt(i)>'9'){
                System.out.println("[]");
                return;
            }
        }
        //获得所有小朋友的高矮个子
        String[] strs = s.split(" ");
        ArrayList<Integer> v = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            v.add(Integer.parseInt(strs[i]));
        }

        int n=v.size();
        if(n>=100){
            System.out.println("[]");
            return;
        }

        //调试
        int m1=0,m2=0;

        //根据题目要求调整数字顺序
        for (int i = 0; i < n; i++) {
            //比较到了倒数第二个数
            if(i<=n-2){
                m1=v.get(i);
                m2=v.get(i+1);
                //偶数索引的数字应该尽可能大
                if(i%2==0&&m1<m2){
                    Collections.swap(v,i,i+1);
                }
                //奇数索引的数字应该尽可能小
                else if(i%2==1&&m1>m2){
                    Collections.swap(v,i,i+1);
                }
            }
        }

        //输出结果
        for (int i = 0; i < v.size(); i++) {
            System.out.print(v.get(i)+" ");
        }
    }

}
