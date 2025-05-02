import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class hj40 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int yinwen=0,kongge=0,shuzi=0,qita=0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if((chars[i]>='a'&&chars[i]<='z')||(chars[i]>='A'&&chars[i]<='Z')){
                yinwen++;
            }
            else if(chars[i]>='0'&&chars[i]<='9') shuzi++;
            else if(chars[i]==' ') kongge++;
        }
        qita=chars.length-kongge-yinwen-shuzi;
        System.out.println(yinwen);
        System.out.println(kongge);
        System.out.println(shuzi);
        System.out.println(qita);
    }
}